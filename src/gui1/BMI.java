package gui1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Lars on 13.05.2015.
 */
public class BMI implements ActionListener {

    JFrame f;
    JTextField gewicht = new JTextField("", 10);
    JTextField groesse = new JTextField("", 10);
    JButton berechne = new JButton("berechne");
    JTextField bmi = new JTextField("", 10);
    JTextField klassifikation = new JTextField("", 15);
    JRadioButton radio = new JRadioButton("männlich");
    JRadioButton radio2 = new JRadioButton("weiblich");

    public BMI(){
        this.f = new JFrame();
        f.setLayout(new GridLayout(6,1));

        JPanel row1 = new JPanel();
        row1.add(new JLabel("Gewicht in kg: "));
        row1.add(gewicht);
        f.add(row1);

        JPanel row2 = new JPanel();
        row2.add((new JLabel("Groesse in m ")));
        row2.add(groesse);
        f.add(row2);

        JPanel row3 = new JPanel();
        ButtonGroup group = new ButtonGroup();
        group.add(radio);
        group.add(radio2);
        row3.add(radio);
        row3.add(radio2);
        f.add(row3);

        JPanel row4 = new JPanel();
        berechne.addActionListener(this);
        row4.add(berechne);
        f.add(row4);

        JPanel row5 = new JPanel();
        row5.add(new JLabel("BMI: "));
        row5.add(bmi);
        f.add(row5);

        JPanel row6 = new JPanel();
        row6.add(klassifikation);
        f.add(row6);
        f.pack();
        f.setTitle("Body-Mass-Index");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void calculate(){
        double gewicht = Double.parseDouble(this.gewicht.getText());
        double größe = Double.parseDouble(this.groesse.getText());
        int geschlecht;
        if (radio.isEnabled()){
            geschlecht = 1;
        } else {
            geschlecht = 2;
        }

        double myBmi = gewicht / (Math.pow(größe, 2));
        String klasse;

        if (geschlecht == 1){
            if (myBmi < 20){
                klasse = "Untergewicht";
            }
            else if (myBmi >= 20 && myBmi < 25){
                klasse = "Normalgewicht";
            }
            else if (myBmi >= 25 && myBmi < 30){
                klasse = "Übergewicht";
            }
            else if (myBmi >= 30 && myBmi < 40){
                klasse = "Land-Wal";
            }
            else {
                klasse = "Y u eat so much!?";
            }
        }
        else {
            if (myBmi < 19){
                klasse = "Untergewicht";
            }
            else if (myBmi >= 19 && myBmi < 25){
                klasse = "Normalgewicht";
            }
            else if (myBmi >= 24 && myBmi < 30){
                klasse = "Übergewicht";
            }
            else if (myBmi >= 30 && myBmi < 40){
                klasse = "Land-Wal";
            }
            else {
                klasse = "Y u eat so much!?";
            }
        }
        bmi.setText(String.valueOf(round(myBmi,5)));
        klassifikation.setText(klasse);

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void main(String[] args) {
        BMI rechner = new BMI();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == berechne) {
            this.calculate();
        } else {
            System.exit(0);
        }

    }
}


