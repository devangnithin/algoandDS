package me.nithind.algo;

/**
 * Created by devangn on 12-01-17.
 */
public class NoOfBinTree {
    public int numTrees(int n) {
        if (n<2) return n;
        return 0;

    }

    public static void main(String args[]) {
        int n = 3;
        NoOfBinTree b = new NoOfBinTree();
        System.out.println(b.numTrees(3));
    }
}