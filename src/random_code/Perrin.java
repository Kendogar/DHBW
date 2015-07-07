package random_code;

/**
 * Created by Lars on 22.03.2015.
 */
public class Perrin {

    public static void perrincalc(int i){
        int p0 = 3;
        int p1 = 0;
        int p2 = 2;

        if (i == 0){
            System.out.println(p0);
        }
        if (i == 1){
            System.out.println(p1);
        }
        if (i == 2){
            System.out.println(p2);
        }

        int m = 2;
        for (int n = i; i>2; i--){
            m = p0 + p1;
            p0 = p1;
            p1 = p2;
            p2 = m;
        }
        System.out.println(m);
    }
    public static void main(String[] args) {
        perrincalc(11);
    }
}
