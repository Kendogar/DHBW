package periodensystem_musterlösung;

/**
 * Created by Lars on 21.02.2015.
 */
public class Periodensystem {
    Element[] system = new Element[118];

    /**
     * So lange noch frei Plätze da sind, wird das Element e an der
     * nächsten freien Stelle eingefügt.
     */
    public void addElement(Element e) {
        int frei = 0;
        while ((frei < system.length) && (system[frei] != null)) {
            if (system[frei].getOrdnungszahl() == e.getOrdnungszahl())
                return;
            frei++;
        }
        if (frei < system.length) {
            system[frei] = e;
        }
    }

    /**
     * Prüft, ob es ein Element mit der übergebenen Ordnungszahl oz
     * im Periodensystem gibt.
     */
    public boolean hasElement(int oz) {
        int i = 0;
        while ((i < system.length) && (system[i] != null)) {
            if (system[i].getOrdnungszahl() == oz)
                return true;
            i++;
        }
        return false;
    }

    /**
     * Liefert das Element mit der Ordnungszahl oz, falls nicht vorhanden null
     */
    public Element getElement(int oz) {
        int i = 0;
        while ((i < system.length) && (system[i] != null)) {
            if (system[i].getOrdnungszahl() == oz)
                return system[i];
            i++;
        }
        return null;
    }

    /**
     * Liefert alle Metalle
     */
    public Element[] getMetalls() {
        int metalle = 0;
        int i = 0;
        while ((i < system.length) && (system[i] != null)) {
            if (system[i] instanceof Metall)
                if (! ((Metall) system[i]).isHalbmetall())
                    metalle++;
            i++;
        }
        Element[] erg = new Element[metalle];
        int j = 0;
        i = 0;
        while ((i < system.length) && (system[i] != null)) {
            if (system[i] instanceof Metall)
                if (! ((Metall) system[i]).isHalbmetall()) {
                    erg[j] = system[i];
                    j++;
                }
            i++;
        }
        return erg;
    }

    public static void main(String[] args) {
        Periodensystem ps = new Periodensystem();
        ps.addElement(new Element("Wasserstoff", "H", 1, 'K', Element.GASFOERMIG, true));
        ps.addElement(new Element("Helium", "He", 2, 'K', Element.GASFOERMIG, true));
        ps.addElement(new Metall("Natrium", "Na", 11, 'M', Element.FEST, true, false, 21e6));
        ps.addElement(new Metall("Eisen", "Fe", 26, 'N', Element.FEST,
                false, false, 10.02e6));
        ps.addElement(new Metall("Germanium", "Ge", 32, 'N', Element.FEST,
                false, true, 1.45));
        ps.addElement(new Element("Brom", "Br", 35, 'N', Element.FLUESSIG, true));
        ps.addElement(new Metall("Tellur", "Te", 52, 'O', Element.FEST, true, true, 0.005));
        ps.addElement(new Metall("Gold", "Au", 79, 'P', Element.FEST, false, false, 44e6));
        for (Element e : ps.system)
            if (e != null)
                System.out.println(e);
        System.out.println("\nMetalle:");
        for (Element e : ps.getMetalls())
            System.out.println(e);
        System.out.println("\nDas Element #79:");
        System.out.println(ps.getElement(79));
    }
}