package me.nithind.impl.redblack;

/**
 * Created by devangn on 3/26/2017.
 */
public class RedBlackNode {
    public enum nodeColor {RED, BLACK};
    public Integer value;
    public nodeColor color;
    public RedBlackNode left;
    public RedBlackNode right;
    public  RedBlackNode parent;

    public RedBlackNode(Integer value, nodeColor color, RedBlackNode left, RedBlackNode right, RedBlackNode parent) {
        this.color = color;
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

