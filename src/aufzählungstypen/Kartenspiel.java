package aufzählungstypen;

import java.util.*;

/**
 * Created by Lars on 09.06.2015.
 */
public class Kartenspiel {
    ArrayList<Spielkarte> datStapel = new ArrayList<Spielkarte>();

    public Kartenspiel(){
        for (Farbe wat : Farbe.values()){
            for (Kartenwert dat : Kartenwert.values()){
                datStapel.add(new Spielkarte(wat.getName(), (dat.name().substring(0,1))+ dat.name().substring(1).toLowerCase()));
            }
        }
    }

    public void ausgabe(){
        for (Spielkarte k : datStapel){
            System.out.println(k.toString());
        }
    }

    public void shuffle(){
        Collections.shuffle(datStapel);
    }

    public void sort(){
        Collections.sort(datStapel);
    }

    public Spielkarte get(){
        Spielkarte top = datStapel.get(datStapel.size()-1);
        datStapel.remove(datStapel.size()-1);
        return top;
    }

    public ArrayList<Spielkarte> all(){
        return datStapel;
    }
}
