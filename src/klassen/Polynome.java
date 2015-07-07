package klassen;

import java.util.Arrays;

/**
 * Created by Lars on 05.02.2015.
 */
public class Polynome {
    private double a, b, c, x;

    public Polynome(double a, double b, double c){
        this.setA(a);
        this.setB(b);
        this.setC(c);
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double funktionswert(double x){
        this.setX(x);
        return  a*Math.pow(x,2) + b*x + c;
    }

    public String toString(){
        String erg = String.format("Polynom: %.1fx^2 + %.1fx + %.1f", a, b, c);
        return erg;
    }

    public Polynome addition(Polynome second){
        Polynome pnew = new Polynome(this.getA()+second.getA(), this.getB()+second.getB(), this.getC()+second.getC());
        return pnew;
    }

    public Polynome multiplikation(double skalar){
        Polynome pnew = new Polynome(this.getA()*skalar, this.getB()*skalar, this.getC()*skalar);
        return pnew;
    }

    public double[] nullstellen(){
        double a, b, c, x1, x2;
        a = this.getA();
        b = this.getB();
        c = this.getC();

        if ((Math.pow(b,2)-(4*a*c)) < 0){
            double array_erg[] = new double[0];
            return array_erg;
        }
        else {
            x1 = (-b + Math.sqrt((Math.pow(b,2)-(4*a*c)))) / 2*a;
            x2 = (-b - Math.sqrt((Math.pow(b,2)-(4*a*c)))) / 2*a;


            if (x1 == x2){
                double array_erg[] = {x1};
                return array_erg;
            }
            else {
                double array_erg[] = {x1, x2};
                return array_erg;
            }
        }


    }


    public static void main(String[] args) {
        Polynome p1 = new Polynome(4.0, 6.7, 7.0);
        Polynome p2 = new Polynome(2.0, 3.0, -2.0);
        System.out.println("ToString - " + p1.toString());
        System.out.println("Funktionswert - " + p1.funktionswert(2));
        System.out.println("Addition - " + p1.addition(p2).toString());
        System.out.println("Multiplikation - " + p1.multiplikation(3).toString());
        System.out.println("Nullstellen: " + Arrays.toString(p2.nullstellen()));
    }

}
