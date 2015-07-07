package rmi.chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by Lars on 23.06.2015.
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {
    ArrayList<ChatClientInterface> clients = new ArrayList<ChatClientInterface>();

    protected ChatServer() throws RemoteException {
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Naming.rebind("chatserver", new ChatServer());
            System.out.println("ChatServer als Server registriert!");
        } catch (MalformedURLException | RemoteException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void register(ChatClientInterface client) throws RemoteException {
        for (ChatClientInterface oldclient : clients){
            oldclient.message(client.getUser() + " has logged in");
        }
        clients.add(client);

    }

    @Override
    public void unregister(ChatClientInterface client) throws RemoteException {
        clients.remove(client);
        for (ChatClientInterface oldclient : clients){
            oldclient.message(client.getUser() + " has logged off");
        }

    }

    @Override
    public void post(String user, String message) throws RemoteException {
      for (ChatClientInterface client : clients){
          client.message(user, message);
      }
    }
}
