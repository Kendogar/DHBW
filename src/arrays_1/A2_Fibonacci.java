package arrays_1;

import java.util.Arrays;

/**
 * Created by Lars on 29.01.2015.
 */
public class A2_Fibonacci {
    public static void main(String[] args) {
        int fibs = 40;
        int array [] = new int[fibs];
        for (int i = 0; i < array.length; i++){
            array[i] = fibonacci(i+1);
        }
        System.out.println(Arrays.toString(array));
    }

    public static int fibonacci(int i){
        if (i == 1){
            return 1;
        }
        else if (i > 1){
            return (fibonacci(i - 1) + fibonacci(i - 2));
        }
        else  {
            return 0;
        }
    }
}
