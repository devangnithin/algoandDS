package me.nithind.algo;

/**
 * Created by devangn on 22-12-2016.
 */
public class MergeSort {

    //static int count = 0;

    public void start() {
        //int[] A = {1, 2, 3 , 4, 6, 5};
        //int[] A = {6, 5, 4 , 3, 2, 1};
        int[] A = {3, 2, 1};
        int[] result = mergesort(A);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
        //System.out.println("Split inv = "+count);
    }

    public int[] mergesort(int[] A) {
        int count = 0;
        if (A.length == 1) return A;
        int[] A1 = new int[A.length / 2];
        int[] A2 = new int[A.length - A1.length];
        System.arraycopy(A, 0, A1, 0, A1.length);
        System.arraycopy(A, A.length / 2, A2, 0, A2.length);
        A1 = mergesort(A1);
        A2 = mergesort(A2);
        int[] AF = new int[A.length];
        int i = 0, j = 0, k = 0;
        while (i < A1.length && j < A2.length) {
            if (A1[i] < A2[j]) {
                AF[k++] = A1[i++];
                //if (i > j) count++;
            } else {
                //count++;
                AF[k++] = A2[j++];
                if (j != i) count++;
            }
        }
        while (i < A1.length) {
            AF[k++] = A1[i++];
        }
        while (j < A2.length) {
            AF[k++] = A2[j++];
        }
        System.out.println("C = " + count);
        return AF;

    }
}
