package threads;

/**
 * Created by Lars on 16.06.2015.
 */
public class ampelphase {
    String name;
    boolean red;
    boolean yellow;
    boolean green;
    int duration;
    int next;

    public ampelphase(String name, boolean red, boolean yellow, boolean green, int duration, int next){
        this.name = name;
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.duration = duration;
        this.next = next;
    }
}
