package gui1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Lars on 26.05.2015.
 */
public class ZahlenRatespiel implements ActionListener {
    JFrame f;
    JTextField name = new JTextField("", 20);
    JTextField zahl = new JTextField("", 10);
    JButton neu= new JButton("Neues Spiel");
    JButton ok = new JButton("ok");
    JButton best = new JButton("Bester");
    JButton exit = new JButton("exit");
    JTextField status = new JTextField("", 30);
    int aktuelleZahl = 0;
    int aktuelleVersuche = 0;
    int zielZahl =(int) (Math.random()*1000);
    String spielername, howIsIt;

    public ZahlenRatespiel(){
        this.f = new JFrame();
        f.setLayout(new GridLayout(4,1));

        JPanel row1 = new JPanel();
        row1.add(new JLabel("Spielername "));
        row1.add(name);
        f.add(row1);

        JPanel row2 = new JPanel();
        row2.add((new JLabel("Zahl zwischen 1 und 1000 eingeben ")));
        row2.add(zahl);
        f.add(row2);

        JPanel row3 = new JPanel();
        row3.add(neu);
        neu.addActionListener(this);
        row3.add(ok);
        ok.addActionListener(this);
        row3.add(best);
        best.addActionListener(this);
        row3.add(exit);
        exit.addActionListener(this);
        f.add(row3);

        JPanel row4 = new JPanel();
        row4.add(status);
        f.add(row4);

        f.pack();
        f.setTitle("Zahlen-Ratespiel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void gewonnen(){
        try {
            File test = new File("Zahlenspiel.txt");
            test.createNewFile();

            FileWriter fw = new FileWriter(test, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String sep = System.lineSeparator();
            bw.write(aktuelleVersuche + " versuche von: "+spielername+"\n");
            bw.flush();
        } catch (IOException e1){
            System.out.println("exception");
            e1.getMessage();
        }
    }

    public void bestPlayer(){
        String player = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("Zahlenspiel.txt"));
            ArrayList<String> playedGames = new ArrayList<String>();
            while(br.ready()){
                playedGames.add(br.readLine());
            }
            br.close();
            int best = Integer.MAX_VALUE;
            for (int i = 0; i<playedGames.size();i++) {
                if (Integer.valueOf(playedGames.get(i).substring(0, playedGames.get(i).indexOf(" "))) < best) {
                    best = Integer.valueOf(playedGames.get(i).substring(0, playedGames.get(i).indexOf(" ")));
                    player = playedGames.get(i).substring(playedGames.get(i).indexOf(":")+1,playedGames.get(i).length());
                }
            }
            status.setText(player + " ist bester Spieler mit " + best + " Versuchen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == neu) {
            name.setText("");
            zahl.setText("");
            status.setText("");
            aktuelleVersuche = 0;
            aktuelleZahl = 0;
            int zielZahl =(int) (Math.random()*1000);

        } else if (e.getSource() == ok){
            spielername = name.getText();
            aktuelleVersuche++;
            aktuelleZahl = Integer.parseInt(zahl.getText());
            if (aktuelleZahl < zielZahl){
                howIsIt = "zu niedrig!";
            }
            else if (aktuelleZahl > zielZahl){
                howIsIt = "zu hoch!";
            }
            else {
                howIsIt = "passt genau! Gewonnen!";
                this.gewonnen();
            }
            status.setText("Versuch Nr. " + aktuelleVersuche +": " + aktuelleZahl + " " + howIsIt);

        } else if (e.getSource() == best){
            this.bestPlayer();
        } else{
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        ZahlenRatespiel lelspiel = new ZahlenRatespiel();
    }
}
