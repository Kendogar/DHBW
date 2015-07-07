package theoinf;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Lars on 29.05.2015.
 */
public class Sortieren_benchmark {
    Integer[] sorted, inverseSorted, random;
    long randomComparisons = 0;
    long randomMovements = 0;
    long sortedComparisons = 0;
    long sortedMovements = 0;
    long inverseSortedComparisons = 0;
    long inverseSortedMovements = 0;
    long randomTime, sortedTime, inverseSortedTime;

    public Sortieren_benchmark(int size){
        sorted = new Integer[size];
        inverseSorted = new Integer[size];
        random = new Integer[size];
        for (int i = 0; i < size; i++){
            //Generating the numbers and populating arrays
            int toAdd = (int) (Math.random()*100000);
            sorted[i] = toAdd;
            inverseSorted[i] = toAdd;
        }
        //Pre-sorting arrays
        Arrays.sort(sorted);
        Arrays.sort(inverseSorted, Collections.reverseOrder());
    }

    public void bubblesort(){

        //Sorting random array
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < 10; j++){
            for (int i = 0; i < random.length; i++){
                //Generating the numbers and populating random array
                int toAdd = (int) (Math.random()*100000);
                random[i] = toAdd;
            }
            int count = 1;
            while (count != 0){
                int temp;
                count = 0;
                for (int i = 0; i < random.length-1; i++){
                    randomComparisons++;
                    if (random[i+1] < random[i]){
                        randomMovements++;
                        temp = random[i];
                        random[i] = random[i+1];
                        random[i+1] = temp;
                        count++;
                    }
                }
            }
        }
        long endTime   = System.currentTimeMillis();
        randomTime = (endTime - startTime)/10;
        randomMovements = randomMovements / 10;
        randomComparisons = randomComparisons / 10;
        System.out.printf("Size of Arrays: %d\n\n",random.length);
        System.out.printf("Random Array Results:\nNumber of comparisons: %d, number of movements: %d, time taken in ms: %d\n", randomComparisons, randomMovements, randomTime);

        //sorting sorted array
        startTime = System.currentTimeMillis();
        int count = 1;
        while (count != 0){
            int temp;
            count = 0;
            for (int i = 0; i < sorted.length-1; i++){
                sortedComparisons++;
                if (sorted[i+1] < sorted[i]){
                    sortedMovements++;
                    temp = sorted[i];
                    sorted[i] = sorted[i+1];
                    sorted[i+1] = temp;
                    count++;
                }
            }
        }
        endTime   = System.currentTimeMillis();
        sortedTime = endTime - startTime;
        System.out.printf("Sorted Array Results:\nNumber of comparisons: %d, number of movements: %d, time taken in ms: %d\n", sortedComparisons, sortedMovements, sortedTime);

        //sorting inverseSorted array
        startTime = System.currentTimeMillis();
        count = 1;
        while (count != 0){
            int temp;
            count = 0;
            for (int i = 0; i < inverseSorted.length-1; i++){
                inverseSortedComparisons++;
                if (inverseSorted[i+1] < inverseSorted[i]){
                    inverseSortedMovements++;
                    temp = inverseSorted[i];
                    inverseSorted[i] = inverseSorted[i+1];
                    inverseSorted[i+1] = temp;
                    count++;
                }
            }
        }
        endTime   = System.currentTimeMillis();
        inverseSortedTime = endTime - startTime;
        System.out.printf("InverseSortd Array Results:\nNumber of comparisons: %d, number of movements: %d, time taken in ms: %d\n", inverseSortedComparisons, inverseSortedMovements, inverseSortedTime);
    }



    public static void main(String[] args) {
        Sortieren_benchmark bench1000 = new Sortieren_benchmark(1000);
        bench1000.bubblesort();
        Sortieren_benchmark bench10000 = new Sortieren_benchmark(10000);
        bench10000.bubblesort();
        Sortieren_benchmark bench100000 = new Sortieren_benchmark(100000);
        bench100000.bubblesort();
    }

}
