package me.nithind.ds;

/**
 * Created by devangn on 21-12-2016.
 */
public class List {
    private int X;
    private List next;

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
        next = null;
    }

    public List getNext() {
        return next;
    }

    public void setNext(List next) {
        this.next = next;
    }
}
