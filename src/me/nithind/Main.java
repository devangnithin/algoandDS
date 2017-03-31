package me.nithind;

import me.nithind.impl.redblack.RedBlackSet;

import java.util.Random;

public class Main {

    /*public static void main(String[] args) {
        BinaryTreeImpl BTImpl = new BinaryTreeImpl();
        BTImpl.start();

        *//*Kaedance k = new Kaedance();
        int[] A = {-4, 15, -6, 18, 2, -20};
        System.out.println("Max sub array addition " + k.maxSubArray(A));

        System.out.println("----------LIST -----------");
        ListImpl list = new ListImpl();
        list.start();*//*

        *//*CountingInversions countingInversions = new CountingInversions();
        countingInversions.start();*//*

        *//*MergeSort mergeSort = new MergeSort();
        mergeSort.start();*//*
        *//*MatricMultiplication matricMultiplication = new MatricMultiplication();
        matricMultiplication.start();*//*
    }*/

    public static void main(String[] args) {
        RedBlackSet RB = new RedBlackSet();
        for (int i = 1; i<100; i++) {

            Random rand = new Random();

            int  n = rand.nextInt(1000) + 1;
            //System.out.println("x value " +i);
            RB.insert(i);
        }

        RB.inOrder();


        //for (int i = 10; i> 0; i--) {
        /*RB.insert(7);
        RB.insert(3);
        RB.insert(4);
        RB.insert(9);
        RB.insert(5);
        RB.insert(10);
        RB.insert(11);
        RB.insert(0);*/
        //}
    }


}


