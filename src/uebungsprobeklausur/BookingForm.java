package uebungsprobeklausur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Lars Krakhecke on 01.10.2015.
 */
public class BookingForm extends JFrame {
    private Flug flug;
    private JLabel zeit;
    ArrayList<SitzButton> sitzbuttons = new ArrayList<>();

    public BookingForm(Flug flug) {
        this.flug = flug;
        drawFrame();

    }

    private void drawFrame() {
        JFrame frame = new JFrame("Buchung fuer Flug "+flug.getName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(5, 2, 10, 10));
        top.add(new JLabel("Fluggesellschaft"));
        top.add(new JLabel(flug.getAirline().getName() + flug.getAirline().getCode()));
        top.add(new JLabel("Von"));
        top.add(new JLabel(flug.getFrom().getName() + flug.getFrom().getCode()));
        top.add(new JLabel("Nach"));
        top.add(new JLabel(flug.getTo().getName() + flug.getTo().getCode()));
        top.add(new JLabel("Freie Plätze"));
        top.add(new JLabel(String.valueOf(flug.freiePlaetze())));
        top.add(new JLabel("Zeit"));
        zeit = new JLabel(Calendar.getInstance().getTime().toString());
        top.add(zeit);
        frame.add(top, BorderLayout.NORTH);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    zeit.setText(Calendar.getInstance().getTime().toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SitzButton self = (SitzButton) e.getSource();
                if (self.getSitz().getStatus() == Buchungsstatus.FREI) {
                    self.getSitz().setStatus(Buchungsstatus.PENDING);
                    self.setColorFromStatus();
                } else if (self.getSitz().getStatus() == Buchungsstatus.PENDING){
                    self.getSitz().setStatus(Buchungsstatus.FREI);
                    self.setColorFromStatus();
                }
            }
        };
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(flug.getRows(), flug.getSeats()));
        for (int i = 0; i < flug.getRows(); i++) {
            for (int j = 0; j < flug.getSeats(); j++) {
                SitzButton sb = new SitzButton(flug.getAllSeats()[i][j]);
                sb.addActionListener(al);
                sitzbuttons.add(sb);
                middle.add(sb);
            }
        }
        frame.add(middle, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1, 2));

        JButton buchen = new JButton("Buchen");
        buchen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (SitzButton datButton : sitzbuttons) {
                    if (datButton.getSitz().getStatus() == Buchungsstatus.PENDING) {
                        datButton.getSitz().setStatus(Buchungsstatus.GEBUCHT);
                        datButton.setColorFromStatus();
                        datButton.setEnabled(false);
                    }
                }
            }
        });
        bottom.add(buchen);

        JButton verwerfen = new JButton("Verwerfen");
        verwerfen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (SitzButton datButton : sitzbuttons) {
                    if (datButton.getSitz().getStatus() == Buchungsstatus.PENDING) {
                        datButton.getSitz().setStatus(Buchungsstatus.FREI);
                        datButton.setColorFromStatus();
                    }
                }
            }
        });
        bottom.add(verwerfen);

        frame.add(bottom, BorderLayout.SOUTH);

        frame.setSize(500, 600);
        frame.setVisible(true);
    }
}
