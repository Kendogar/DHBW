package rmi.chat;

import rmi.timeservice.TimeServerInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Lars on 23.06.2015.
 */
public class ChatClient extends UnicastRemoteObject implements ChatClientInterface, ActionListener {
    JButton exitChat = new JButton("Exit");
    JTextField userName = new JTextField("Name Eingeben");
    JButton confirmName = new JButton("Confirm");
    JButton sendMessage = new JButton("Send");
    JTextPane textPane = new JTextPane();
    JTextField inputField = new JTextField("Text Eingeben");
    String username;
    ChatServerInterface server;


    protected ChatClient() throws RemoteException {
        JFrame chatwindow = new JFrame();
        chatwindow.setSize(800,800);
        chatwindow.setLayout(new GridLayout(3, 1));
        JPanel username = new JPanel();
        username.add(userName);
        username.add(confirmName);
        confirmName.addActionListener(this);
        username.add(exitChat);
        exitChat.addActionListener(this);
        chatwindow.add(username);
        JPanel textfield = new JPanel();
        textfield.add(textPane);
        chatwindow.add(textfield);
        JPanel text = new JPanel();
        text.add(inputField);
        text.add(sendMessage);
        sendMessage.addActionListener(this);
        chatwindow.add(text);
        chatwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chatwindow.setVisible(true);

        try {
            String url = "//127.0.0.1/chatserver";
            server = (ChatServerInterface) Naming.lookup(url);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void message(String message) throws RemoteException {
        textPane.setText(textPane.getText().concat(System.lineSeparator()+ message));
    }

    @Override
    public void message(String user, String message) throws RemoteException {
        textPane.setText(textPane.getText().concat(System.lineSeparator()+ user + ": "  +message));
    }

    @Override
    public String getUser() throws RemoteException {
        return username;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmName) {
            username = userName.getText();
            try {
                server.register(this);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == sendMessage) {
            try {
                server.post(username, inputField.getText());
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        } else {
            try {
                server.unregister(this);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
            System.exit(0);
        }
    }

    public static void main(String[] args) throws RemoteException {
        ChatClient datChat = new ChatClient();

    }


}
