package me.nithind.impl;

import me.nithind.ds.BinaryTree;

/**
 * Created by devangn on 20-12-2016.
 * <p>
 * This program builds a tree and finds the length of subtree which is within thr provided range of A, B
 * 25
 * /  \
 * 19    37
 * / \   /
 * 12   22 29
 * /        \
 * 4         30
 */
public class BinaryTreeImpl {

    public void start() {
        //BinaryTree B = this.buildTree();

        //System.out.println(solution(25, 38, B));
        BinaryTree B = null;
        B = this.add(B, 2);
        this.add(B, 3);
        this.add(B, 1);
        inOrder(B);

        BinaryTree searchResult = search(B, 3);
        System.out.println("");
        if (searchResult == null) {
            System.out.println("No result found");
        }
        else {
            System.out.println(searchResult.getX());
        }
    }

    public void inOrder(BinaryTree T) {
        if (T == null) return;

        /*
             1
           2    3
         */

        inOrder(T.getL());
        System.out.print("-" + T.getX() + "-");
        inOrder(T.getR());
        return;

    }

    public int solution(int A, int B, BinaryTree T) {
        if (T == null) {
            return 0;
        }
        if (T.getL() == null && T.getR() == null) {
            if (T.getX() < A || T.getX() > B) {
                return 0;
            }
            return 1;
        }
        int lValue = solution(A, B, T.getL());
        int rValue = solution(A, B, T.getR());

        if (lValue > 0 && rValue > 0) {
            if (T.getX() >= A || T.getX() <= B) {
                return 1 + lValue + rValue;
            } else return lValue + rValue;
        }

        if (T.getL() != null && lValue == 0) {
            if (rValue > 0) {
                return rValue;
            }
        }
        if (T.getR() != null && rValue == 0) {
            if (lValue > 0) return lValue;
            return lValue;
        }

        if (lValue > 0) {
            if (T.getX() < A || T.getX() > B) return 0 + lValue;
            return 1 + lValue;
        }
        if (T.getX() < A || T.getX() > B) return 0 + rValue;
        return 1 + rValue;
    }


    private BinaryTree search(BinaryTree B, int x) {
        if (B == null || B.getX() == x) {
            return B;
        }

        if (x < B.getX()) {
            return search(B.getL(), x);
        }
        return search(B.getR(), x);

    }

    private BinaryTree add(BinaryTree BN, int x) {
        if (BN == null) {
            BN = new BinaryTree(x);
            return BN;
        }

        if (x < BN.getX()) {
            if (BN.getL() == null) {
                BN.setL(new BinaryTree(x));
                return BN;
            }
            add(BN.getL(), x);
        } else {
            if (BN.getR() == null) {
                BN.setR(new BinaryTree(x));
                return BN;
            }
            add(BN.getR(), x);
        }
        return BN;
    }

    private BinaryTree buildTree() {
        BinaryTree T25 = new BinaryTree();
        BinaryTree T19 = new BinaryTree();
        BinaryTree T12 = new BinaryTree();
        BinaryTree T4 = new BinaryTree();
        BinaryTree T22 = new BinaryTree();
        BinaryTree T23 = new BinaryTree();
        BinaryTree T37 = new BinaryTree();
        BinaryTree T29 = new BinaryTree();
        BinaryTree T30 = new BinaryTree();

        T25.setX(25);
        T25.setL(T19);
        T25.setR(T37);

        T19.setX(19);
        T19.setL(T12);
        T19.setR(T22);

        T12.setX(12);
        T12.setL(T4);
        T12.setR(null);

        T4.setX(4);
        T4.setL(null);
        T4.setR(null);

        T22.setX(22);
        T22.setL(null);
        T22.setR(T23);

        T23.setX(23);
        T23.setL(null);
        T23.setR(null);

        T37.setX(37);
        T37.setL(T29);
        T37.setR(null);

        T29.setX(29);
        T29.setL(null);
        T29.setR(T30);

        T30.setX(30);
        T30.setL(null);
        T30.setR(null);

        return T25;
    }
}




