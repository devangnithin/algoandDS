package me.nithind.ds;

public class BinaryTree
{
    private int x;
    private BinaryTree l;
    private BinaryTree r;

    public BinaryTree(int x) {
        this.x = x;
    }

    public BinaryTree() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public BinaryTree getL() {
        return l;
    }

    public void setL(BinaryTree l) {
        this.l = l;
    }

    public BinaryTree getR() {
        return r;
    }

    public void setR(BinaryTree r) {
        this.r = r;
    }
}
