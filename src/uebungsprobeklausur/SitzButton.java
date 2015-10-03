package uebungsprobeklausur;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fsinn on 01/10/15.
 */
public class SitzButton extends JButton {
    private Sitz sitz;

    public SitzButton(Sitz s){
        super(s.toString());
        this.sitz = s;
        this.setColorFromStatus();
    }

    public Sitz getSitz() {
        return sitz;
    }

    public void setSitz(Sitz sitz) {
        this.sitz = sitz;
    }

    public void setColorFromStatus() {
        if(sitz.getStatus() == Buchungsstatus.FREI){
            this.setBackground(Color.WHITE);
            this.setEnabled(true);
        }
        if(sitz.getStatus() == Buchungsstatus.PENDING){
            this.setBackground(Color.RED);
            this.setEnabled(true);
        }
        if(sitz.getStatus() == Buchungsstatus.GEBUCHT){
            this.setBackground(Color.WHITE);
            this.setEnabled(false);
        }
    }

}