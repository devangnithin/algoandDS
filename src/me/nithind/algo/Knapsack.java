package me.nithind.algo;

import java.util.Arrays;

/**
 * Created by nithin on 6/5/17.
 */
public class Knapsack {

    private void traceBack(int[][] A, int weight[], int value[]) {
        int j = A[0].length - 1;
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i][j] == A[i - 1][j]) {
                continue;
            } else {
                System.out.println("Weight = " + weight[i] + " and value = " + value[i]);
                j = j - weight[i];
            }
        }

    }

    private int solve(int value[], int weight[], int size) {

        int[][] A = new int[weight.length][size + 1];
        //Arrays.fill(A, 0);

        for (int i = 1; i < weight.length; i++) {
            for (int curValue = 1; curValue <= size; curValue++) {

                if (weight[i] > curValue) {
                    A[i][curValue] = A[i - 1][curValue];
                    continue;
                }

                A[i][curValue] = max(value[i] + A[i - 1][curValue - weight[i]], A[i - 1][curValue]);
            }

        }
        traceBack(A, weight, value);
        return A[weight.length - 1][size];
    }

    int max(int a, int b) {
        return (a > b) ? a : b;

    }


    public static void main(String[] args) {
        /*int[] value = {0, 14, 8, 10, 12};
        int[] weight = {0, 3, 5, 6, 4};
        int knapsacksize = 18;*/
        int[] value = {0, 1, 4, 5, 7};
        int[] weight = {0, 1, 3, 4, 5};
        int knapsacksize = 7;

        Knapsack k = new Knapsack();

        System.out.println("optimal solution is " + k.solve(value, weight, knapsacksize));
    }
}
