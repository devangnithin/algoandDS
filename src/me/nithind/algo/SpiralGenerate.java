package me.nithind.algo;

/**
 * Created by devangn on 08-01-17.
 */

/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

        For example,
        Given n = 3,

        You should return the following matrix:
        [
        [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]
        ]*/
public class SpiralGenerate {

    public int[][] generateMatrix(int n) {
        int cur = 0;
        int tot = n*n;
        int[][] result = new int[n][n];
        int val = 1;


        int curI = 0;
        int curJ = 0;
        while (cur < tot) {
            int iI = curI;
            int jJ = curJ;
            for(int j=jJ; j<result[0].length-curJ && cur < tot; j++) {
                result[iI][j] = val++;
                jJ = j;
                cur++;
            }

            for (int i=iI+1; i<result.length-curI && cur < tot; i++) {
                result[i][jJ] = val++;
                iI = i;
                cur++;
            }

            for (int j=jJ-1; j>=curJ && cur < tot; j--) {
                result[iI][j] = val++;
                jJ=j;
                cur++;
            }

            for (int i=iI-1; i>=curI+1+curI && cur < tot; i--) {
                result[i][jJ] = val++;
                cur++;
            }
            curI++;
            curJ++;
        }
        return result;
    }

    private void print(int[][]  a) {
        System.out.println("-----------");
        for (int i =0; i<a.length; i++) {
            for (int j = 0; j<a.length ; j++) {
                System.out.print(a[i][j]+ "  ");
            }
            System.out.println("");
        }
        System.out.println("-----------");
    }


    public static void main(String args[]) {
        int n = 3;
        SpiralGenerate s = new SpiralGenerate();
        int[][]  a = s.generateMatrix(n);
        s.print(a);
    }
}
