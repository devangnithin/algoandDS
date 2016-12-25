package me.nithind.impl;

import me.nithind.ds.List;

/**
 * Created by devangn on 21-12-2016.
 */
public class ListImpl {
    static List head = null;


    public void start () {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        reverse();
        print();
    }
    public void add(int x) {
        List l = new List();
        l.setX(x);
        if (head == null) {
            head = l;
            return;
        }
        List temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(l);
    }

    public void reverse () {
        List temp = head;
        reverse(head);
        temp.setNext(null);

    }

    public void reverse (List l) {
        if (head == null) {
            return;
        }

        List cur = l;
        l = l.getNext();

        if (l.getNext() == null) {
            l.setNext(cur);
            cur = l;
            head = cur;
            return;
        }
        reverse(l);
        l.setNext(cur);
    }

    public void addFront (int x) {
        List l = new List();
        l.setX(x);
        l.setNext(head);
        head = l;
    }

    public void print() {
        List temp = head;
        do {
            System.out.print(temp.getX() + "-->");
            temp = temp.getNext();
        }while (temp != null);
        System.out.println("END");
    }
}
