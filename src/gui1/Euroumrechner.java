package gui1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Lars on 13.05.2015.
 */
public class Euroumrechner implements ActionListener {

    JFrame f;
    JButton toDM = new JButton("EUR -> DM");
    JButton toEUR = new JButton("DM -> EUR");
    JButton cancel = new JButton("Abbrechen");
    JTextField textfield = new JTextField("Bitte Betrag eingeben.");

    public Euroumrechner(){
        this.f = new JFrame();
        f.setLayout(new GridLayout(2,2));
        JPanel eingabe = new JPanel();
        eingabe.add(textfield);
        f.add(eingabe);
        JPanel buttons = new JPanel();
        buttons.add(toDM);
        toDM.addActionListener(this);
        buttons.add(toEUR);
        toEUR.addActionListener(this);
        buttons.add(cancel);
        cancel.addActionListener(this);
        f.add(buttons);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Euroumrechner euro = new Euroumrechner();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toDM) {
            this.toDm();
        } else if (e.getSource() == toEUR) {
            this.toEur();
        } else {
            System.exit(0);
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void toEur(){
        System.out.println(textfield.getText());
        try {
            double temp = Double.parseDouble(textfield.getText());
            String eur =String.valueOf(round(temp * 1.95583,2));
            textfield.setText(eur+ " Eur");
        } catch (Exception e){
            textfield.setText("Wrong input, faggot");
        }


    }
    public void toDm(){
        System.out.println(textfield.getText());
        try {
            double temp = Double.parseDouble(textfield.getText());
            String dm =String.valueOf(round(temp / 1.95583, 2));
            textfield.setText(dm+ " DM");
        } catch (Exception e){
            textfield.setText("Wrong input, faggot");
        }


    }
}


