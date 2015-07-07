package theoinf;

/**
 * Created by Lars on 21.05.2015.
 */
public class Hashtable_benchmark {
    long[] hashtable;
    int maxNumberSize, collisioncounter, method, tablesize, runs;
    double fillPercentage;
    int accesscount = 0;

    public Hashtable_benchmark(int tablesize, int maxNumberSize, int method, int runs, double fillPercentage){
        hashtable = new long[tablesize];
        this.fillPercentage = fillPercentage;
        this.maxNumberSize = maxNumberSize;
        this.collisioncounter = 0;
        this.tablesize = tablesize;

        switch (method){
            case 1:
                this.linear(runs);
                break;
            case 2:
                this.square(runs);
                break;
            default:
                System.out.println("wrong method index");
                break;
        }
    }

    public void linear(int runs){
        for (int temp = 0; temp < runs; temp++){
            for (int j = 0; j < hashtable.length;j++){
                hashtable[j] = -1;
            }
            for (int i = 0; i < (tablesize*fillPercentage); i++){
                int tempCollisionCount = 0;
                accesscount++;
                long toAdd = Math.round((Math.random()*maxNumberSize));
                int position = (int) toAdd%tablesize;
                if (hashtable[position] != -1){
                    int newPosition = position;
                    while (hashtable[newPosition] != -1){
                        collisioncounter++;
                        tempCollisionCount++;
                        newPosition = position + tempCollisionCount;
                        while (newPosition >= tablesize){
                            newPosition = newPosition - tablesize;
                        }
                    }
                    hashtable[newPosition] = toAdd;
                }
                else {
                    hashtable[position] = toAdd;
                }
            }
        }
        System.out.println((collisioncounter/runs) + " collisions, linear method " + fillPercentage*100+"% filled" );
    }

    public void square(int runs){
        for (int temp = 0; temp < runs; temp++){
            for (int j = 0; j < hashtable.length;j++){
                hashtable[j] = -1;
            }
            for (int i = 0; i < (tablesize*fillPercentage); i++){
                int tempCollisionCount = 0;
                accesscount++;
                long toAdd = Math.round((Math.random()*maxNumberSize));
                int position = (int) toAdd%tablesize;
                if (hashtable[position] != -1){
                    int newPosition = position;
                    while (hashtable[newPosition] != -1){
                        collisioncounter++;
                        tempCollisionCount++;
                        newPosition = position + (int) Math.pow(tempCollisionCount, 2);
                        while (newPosition >= tablesize){
                            newPosition = newPosition - tablesize;
                        }
                    }
                    hashtable[newPosition] = toAdd;
                }
                else {
                    hashtable[position] = toAdd;
                }
            }
        }
        System.out.println((collisioncounter/runs) + " collisions, square method, " + fillPercentage*100+"% filled" );
    }

    public static void main(String[] args) {
        Hashtable_benchmark bench = new Hashtable_benchmark(8191, 1000000, 1, 2000, 0.5);
        Hashtable_benchmark bench2 = new Hashtable_benchmark(8191, 1000000, 2, 2000, 0.5);
        Hashtable_benchmark bench3 = new Hashtable_benchmark(8191, 1000000, 1, 2000, 0.9);
        Hashtable_benchmark bench4 = new Hashtable_benchmark(8191, 1000000, 2, 2000, 0.9);
        Hashtable_benchmark bench5 = new Hashtable_benchmark(8191, 1000000, 1, 2000, 0.95);
        Hashtable_benchmark bench6 = new Hashtable_benchmark(8191, 1000000, 2, 2000, 0.95);
        Hashtable_benchmark bench7 = new Hashtable_benchmark(8191, 1000000, 1, 2000, 1.0);
        Hashtable_benchmark bench8 = new Hashtable_benchmark(8191, 1000000, 2, 2000, 1.0);
    }
}
