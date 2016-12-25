package me.nithind.algo;

/**
 * Created by devangn on 21-12-2016.
 */
public class Kaedance {

    public int maxSubArray(int[] A) {
        int global_max = A[0];
        int cur_max = A[0];
        for (int i = 1; i < A.length; i++) {
            cur_max = this.max(cur_max + A[i], A[i]);
            global_max = this.max(cur_max, global_max);
        }
        return global_max;
    }

    private int max(int a, int b) {
        //System.out.print("for " + a + ">" + b+" ");
        if (a > b) {
            System.out.println(a);
            return a;
        }
        System.out.println(b);
        return b;
    }
}
