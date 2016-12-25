package me.nithind.algo;

/**
 * Created by devangn on 22-12-2016.
 */
public class CountingInversions {
    public void start () {

        //int[] A = {6, 5, 4, 3, 2, 1};
        int[] A = {2, 1, 3, 4, 5, 6};
        this.bruteForce(A);

    }

    private void bruteForce(int[] A) {
        int count=0;
        System.out.println("Brute force complexity O(n^2)");
        for (int i=0; i<A.length-1; i++){
            for (int j=i+1; j<A.length; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        System.out.println("Brute force value = "+ count);
    }
}
