package vererbung_periodensystem;

import java.util.ArrayList;

/**
 * Created by Lars on 20.02.2015.
 */
public class Periodensystem {
    ArrayList<Element> elements = new ArrayList<Element>();


    public Periodensystem(){
    }

    public void addElement(Element e){
        if (this.elements.isEmpty()){
            this.elements.add(e);
        }
        else if(!this.hasElement(e.getOrdnungszahl())) {
            this.elements.add(e);
        }
    }

    public boolean hasElement(int oz){
        boolean found = false;
        if (this.elements.isEmpty()){
            return found;
        }

        for (Element item : elements){
            if (item.getOrdnungszahl() == oz){
                found = true;
            }
        }
        return found;
    }

    public Element getElement(int oz){
        if (!this.elements.isEmpty()){
            for (Element item : elements)
                if (item.getOrdnungszahl() == oz){
                    return item;
                }
        }
        return null;
    }

    public ArrayList<Element> getAllMetalls(){
        ArrayList<Element> metals = new ArrayList<Element>();
        for (Element item : elements){
            if (item instanceof Metall){
                if (!((Metall) item).isHalbmetall()){
                    metals.add(item);
                }
            }
        }
        return metals;
    }

    public static void main(String[] args) {
        Periodensystem system = new Periodensystem();
        Element e1 = new Element("Wasserstoff","H",1,3,'K',true);
        Element e2 = new Element("Helium","He",2,3,'K',true);
        Element e3 = new Metall("Natrium","Na",11,1,'M',true,false, 21 * Math.pow(10,6));
        Element e4 = new Metall("Eisen","Fe",26,1,'N',false,false,10.02 * Math.pow(10,6));
        Element e5 = new Metall("Germanium","Ge",32,1,'N',false,true, 1.45);
        Element e6 = new Element("Brom","Br",35,2,'N',true);
        Element e7 = new Metall("Tellur","Te",52,1,'O',true,true,0.005);
        Element e8 = new Metall("Gold","Au",79,1,'P',true, false, 44.0 * Math.pow(10,6));
        system.addElement(e1);
        system.addElement(e2);
        system.addElement(e3);
        system.addElement(e4);
        system.addElement(e5);
        system.addElement(e6);
        system.addElement(e7);
        system.addElement(e8);


        System.out.printf("| Symbol | Name         | OZ | Schale | Aggreg. | H/N | Halbm. | Leitfähigkeit \n");
        System.out.println("------------------------------------------------------------------------------");
        for (Element el : system.elements){
            System.out.println(el.toString());
        }
        System.out.println("\n\n");

        System.out.printf("| Symbol | Name         | OZ | Schale | Aggreg. | H/N | Halbm. | Leitfähigkeit \n");
        System.out.println("------------------------------------------------------------------------------");
        for (Element el : system.getAllMetalls()){
            System.out.println(el.toString());
        }

        System.out.println("\n\n");

        System.out.printf("| Symbol | Name         | OZ | Schale | Aggreg. | H/N | Halbm. | Leitfähigkeit \n");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(system.getElement(79).toString());
    }
}
