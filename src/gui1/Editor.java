package gui1;

import io.TextFile;

import javax.management.remote.JMXConnectionNotification;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Lars on 13.05.2015.
 */
public class Editor implements ActionListener {
    JFrame editor;
    JMenuItem neu = new JMenuItem("Neu...");
    JMenuItem öffnen = new JMenuItem("Öffnen...");
    JMenuItem speichern = new JMenuItem("Speichern");
    JMenuItem beenden = new JMenuItem("Beenden");
    JEditorPane textArea = new JEditorPane();
    File editorFile;

    public Editor(){
        editor = new JFrame();
        editor.setTitle("Editor");
        JMenuBar menubar = new JMenuBar();
        JMenu datei = new JMenu("Datei");
        JMenu bearbeiten = new JMenu("Bearbeiten");
        neu.setMnemonic('N');
        neu.addActionListener(this);
        datei.add(neu);
        öffnen.addActionListener(this);
        datei.add(öffnen);
        JMenuItem schließen = new JMenuItem("Schließen...");
        datei.add(schließen);
        datei.addSeparator();
        speichern.addActionListener(this);
        datei.add(speichern);
        JMenuItem speichern_unter = new JMenuItem("Speichern unter...");
        datei.add(speichern_unter);
        JMenuItem website = new JMenuItem("Als Webseite speichern...");
        datei.add(website);
        JMenuItem suchen = new JMenuItem("Suchen...");
        datei.add(suchen);
        datei.addSeparator();
        JMenuItem versionen = new JMenuItem("Versionen...");
        datei.add(versionen);
        datei.addSeparator();
        JMenuItem webseitenvorschau = new JMenuItem("Webseitenvorschau");
        datei.add(webseitenvorschau);
        datei.addSeparator();
        JMenuItem einrichten = new JMenuItem("Seite einrichten...");
        datei.add(einrichten);
        JMenuItem seitenansicht = new JMenuItem("Seitenansicht");
        datei.add(seitenansicht);
        JMenuItem drucken = new JMenuItem("Drucken...");
        datei.add(drucken);
        datei.addSeparator();
        JMenu senden = new JMenu("Senden an...");
        datei.add(senden);
        JMenuItem email1 = new JMenuItem("E-Mail-Empfänger");
        senden.add(email1);
        JMenuItem email2 = new JMenuItem("E-Mail-Empfänger (zur Überarbeitung)...");
        senden.add(email2);
        JMenuItem email3 = new JMenuItem("E-Mail-Empfänger (als Anlage)...");
        senden.add(email3);
        JMenuItem verteiler = new JMenuItem("Verteilerempfänger...");
        senden.add(verteiler);
        JMenuItem online = new JMenuItem("Onlinebesprechungswat");
        senden.add(online);
        JMenuItem exchange = new JMenuItem("Exchange-Ordner...");
        senden.add(exchange);
        JMenuItem fax = new JMenuItem("Fax-Empfänger...");
        senden.add(fax);
        senden.addSeparator();
        JMenuItem powerpoint = new JMenuItem("Microsoft Powerpoint");
        senden.add(powerpoint);
        JMenuItem eigenschaften = new JMenuItem("Eigenschaften");
        datei.add(eigenschaften);
        datei.addSeparator();
        beenden.addActionListener(this);
        datei.add(beenden);
//        JMenuItem = new JMenuItem();
//        JMenuItem = new JMenuItem();
//        JMenuItem = new JMenuItem();
        menubar.add(datei);
        JMenuItem rückgängig = new JMenuItem("Rückgängig: nicht möglich");
        bearbeiten.add(rückgängig);
        JMenuItem widerholen = new JMenuItem("Wiederholen: nicht möglich");
        bearbeiten.add(widerholen);
        bearbeiten.addSeparator();
        JMenuItem ausschneiden = new JMenuItem("Ausschneiden");
        bearbeiten.add(ausschneiden);
        JMenuItem kopieren = new JMenuItem("Kopieren");
        bearbeiten.add(kopieren);
        JMenuItem office = new JMenuItem("Office-Zwischenablage");
        bearbeiten.add(office);
        bearbeiten.addSeparator();
        JMenuItem einfügen = new JMenuItem("Einfügen");
        bearbeiten.add(einfügen);
        JMenuItem inhalt = new JMenuItem("Inhalt einfügen");
        bearbeiten.add(inhalt);
        JMenuItem hyperlink = new JMenuItem("Als Hyperlink einfügen");
        bearbeiten.add(hyperlink);
        bearbeiten.addSeparator();
        JMenuItem löschen = new JMenuItem("Löschen");
        bearbeiten.add(löschen);
        JMenuItem markieren = new JMenuItem("Alles markieren");
        bearbeiten.add(markieren);
        bearbeiten.addSeparator();
        JMenuItem suche = new JMenuItem("Suchen...");
        bearbeiten.add(suche);
        JMenuItem ersetzen = new JMenuItem("Ersetzen...");
        bearbeiten.add(ersetzen);
        JMenuItem gehezu = new JMenuItem("Gehe zu...");
        bearbeiten.add(gehezu);
        bearbeiten.addSeparator();
        JMenuItem verknüpfung = new JMenuItem("Verknüpfungen...");
        bearbeiten.add(verknüpfung);
        JMenuItem objekt = new JMenuItem("Objekt");
        bearbeiten.add(objekt);
        menubar.add(bearbeiten);
        editor.setJMenuBar(menubar);
        JScrollPane datPane = new JScrollPane(textArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        editor.add(datPane);
        editor.setSize(600, 400);
        editor.setTitle("Dat Edit0r");
        editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editor.setVisible(true);

    }

    public void open() throws IOException {
        JFileChooser fc = new JFileChooser();

        int state = fc.showOpenDialog(null);

        if (state == JFileChooser.APPROVE_OPTION){
            editorFile = fc.getSelectedFile();
            TextFile savedText = new TextFile(fc.getSelectedFile());
            savedText.read();
            String textToAdd = "";
            String text[] = savedText.getLines();
            for (String line : text) {
                textToAdd = textToAdd.concat(line + "\n");
            }
            textArea.setText(textToAdd);
        }
    }

    public void save() throws IOException {
        try {
            FileWriter fw = new FileWriter(editorFile, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(textArea.getText());
            bw.flush();
        } catch (IOException e1){
            System.out.println("exception");
            e1.getMessage();
        }
    }

    public void close(){
        int messageType = JOptionPane.QUESTION_MESSAGE;
        String[] options = {"Ja", "Nein"};
        int code = JOptionPane.showOptionDialog(editor,
                "Wirklich beenden?",
                "Option Dialog Box", 0, messageType,
                null, options, "Nein");
        switch (code){
            case 0: System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Editor edit = new Editor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == neu){
            textArea.setText("");
        }
        else if (e.getSource() == öffnen){
            try {
                open();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource() == speichern){
            try {
                this.save();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else {
            this.close();
        }
    }
}
