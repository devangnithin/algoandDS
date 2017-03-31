package me.nithind.impl.redblack;

import java.util.Random;
import java.util.TreeSet;

public class RedBlackSetRunner {


    public static void main(String[] args) {
        int n = 10000;
        char l = 'N';

        int searchSuccess = 0;


        Random insertRand = new Random(0);
        Random searchRand = new Random(1);


        if (l == 'N') {
            RedBlackSet RB = new RedBlackSet();

            for (int i = 0; i < n; i++) {
                int x = insertRand.nextInt(2 * n) + 1;
                RB.insert(x);
            }

            System.out.println("Size from custom RB set is " + RB.size());


            for (int i = n + 1; i < 2 * n; i++) {
                int x = searchRand.nextInt(2 * n) + 1;
                if (RB.search(x)) {
                    searchSuccess++;
                    //System.out.println("Found " + x);
                } else {
                    //System.out.println("Not Found " + x);
                }
            }
        } else {
            TreeSet<Integer> TS = new TreeSet<Integer>();
            for (int i = 0; i < n; i++) {
                int x = insertRand.nextInt(2 * n) + 1;
                TS.add(x);
            }

            System.out.println("Size from library Tree is " + TS.size());

            for (int i = 0; i < n; i++) {
                int x = searchRand.nextInt(2 * n) + 1;
                if (TS.contains(x)) {
                    searchSuccess++;
                    //System.out.println("Found " + x);
                } else {
                    //System.out.println("Not Found " + x);
                }
            }
        }
        if (n != 0) {
            System.out.println("% of search success " + (searchSuccess / n) * 100);
        }

    }


}


