package me.nithind.impl.redblack;

import me.nithind.impl.redblack.RedBlackNode.nodeColor;

/**
 * Created by devangn on 3/26/2017.
 */
public class RedBlackSet {
    public RedBlackNode root;

    /*
        Search program start
     */
    public boolean search(int x) {
        return search(root, x);
    }

    private boolean search(RedBlackNode B, int x) {
        if (B == null) {
            return false;
        }
        if (B.value == x) {
            return true;
        }

        if (x < B.value) {
            return search(B.left, x);
        }
        return search(B.right, x);

    }

    /*
        Search program end
     */

    /*
        size program start
     */
    public int size() {
        return inOrder(this.root);
    }
    /*
        size program end
     */

    /*
    height program start
     */
    public int height() {
        return height(root);
    }
    private int height(RedBlackNode T) {
        if (T == null)
            return -1;
        else {
            int lheight = height(T.left);
            int rheight = height(T.right);

            if (lheight > rheight)
                return (lheight + 1);
            else return (rheight + 1);
        }
    }
    /*
    height program start
     */

    public int inOrder() {
        return inOrder(this.root);

    }

    public int inOrder(RedBlackNode T) {
        if (T == null) return 0;

        /*
             1
           2    3
         */
        int count = 1;

        count = count + inOrder(T.left);
        //System.out.print("-" + T.value + "-");
        return count + inOrder(T.right);
    }

    public boolean insert(int x) {

        RedBlackNode current = new RedBlackNode(x, nodeColor.RED, null, null, null);

        //case 1
        if (this.root == null) {
            this.root = current;
            this.root.color = nodeColor.BLACK;
            return true;
        }

        RedBlackNode temp = this.root;
        boolean foundPos = false;

            /* Tracing position starts*/
        while (!foundPos) {
            while (x < temp.value) {
                if (temp.left == null) {
                    foundPos = true;
                    break;
                } else {
                    temp = temp.left;
                }
            }

            while (x > temp.value) {
                if (temp.right == null) {
                    foundPos = true;
                    break;
                } else {
                    temp = temp.right;
                }
            }
            if (x == temp.value) { //To make it a set we are not allowing duplicates
                //System.out.println("Duplicate "+x);
                return false;
            }
        }
            /*tracing position ends*/

        if (x < temp.value) {
            temp.left = current;
            current.parent = temp;
        } else {
            temp.right = current;
            current.parent = temp;
        }
        reset(current);
        return true;
    }

    private void reset(RedBlackNode current) {
        //case 1
        if (current.parent == null) {
            current.color = nodeColor.BLACK;
            return;
        }
        //case 2
        else if (current.parent.color == nodeColor.BLACK) { //valid tree
            return;
        }
        //case 3 uncle black
        RedBlackNode parent = current.parent;
        RedBlackNode uncle = (parent.parent.left == current.parent) ? current.parent.parent.right : current.parent.parent.left;
        RedBlackNode grand = parent.parent;


        if (parent.color == nodeColor.RED && (uncle != null && uncle.color == nodeColor.RED)) { //null indicates black
            while(current.parent!= null && current.parent.parent != null) {
                case3ReColor(current);
                current = current.parent.parent;
            }
            //reset(current.parent.parent);
            return;
        } else if (parent.color == nodeColor.RED && (uncle == null || uncle.color == nodeColor.BLACK)) { //uncle red
            //left left case
            if (current.parent.parent.left != null && current.parent.parent.left.left == current) {
                rightRotate(current.parent.parent);
                //swap colo p and g
                nodeColor parNC = current.parent.color;
                nodeColor grandNC = (grand != null) ? grand.color : nodeColor.BLACK;
                current.parent.color = grandNC;
                if (grand != null) {
                    grand.color = parNC;
                }
            }
            //left right case
            else if (current.parent.parent.left != null && current.parent.parent.left.right == current) {
                leftRotate(current.parent);

                current = current.left;
                rightRotate(current.parent.parent);
                //swap colo p and g
                nodeColor parNC = current.parent.color;
                nodeColor grandNC = (grand != null) ? grand.color : nodeColor.BLACK;
                current.parent.color = grandNC;
                if (grand != null) {
                    grand.color = parNC;
                }
            }
            //right right case
            else if (current.parent.parent.right != null && current.parent.parent.right.right == current) {

                leftRotate(current.parent.parent);
                //swap colo p and g
                nodeColor parNC = current.parent.color;
                nodeColor grandNC = (grand != null) ? grand.color : nodeColor.BLACK;
                current.parent.color = grandNC;
                if (grand != null) {
                    grand.color = parNC;
                }

            } else if (current.parent.parent.right != null && current.parent.parent.right.left == current) { //right left case
                rightRotate(current.parent);

                current = current.right;
                leftRotate(current.parent.parent);
                //swap colo p and g
                nodeColor parNC = current.parent.color;
                nodeColor grandNC = (grand != null) ? grand.color : nodeColor.BLACK;
                current.parent.color = grandNC;
                if (grand != null) {
                    grand.color = parNC;
                }

            }

        }
    }

    private void rightRotate(RedBlackNode axis) {
        RedBlackNode current = axis;//current shud become right of left
        RedBlackNode parent = axis.parent; //shud become parent of left
        RedBlackNode left = axis.left; //shud become parent
        RedBlackNode leftRight = axis.left.right; //shud become left to current

        left.parent = parent;
        if (axis != root) {
            if (axis.parent.right == axis) {
                parent.right = left;
            } else {
                parent.left = left;
            }
        }

        axis.parent = left;
        left.right = axis;
        axis.left = leftRight;
        if (left.parent == null) {
            root = left;
        }
    }

    private void leftRotate(RedBlackNode axis) {
        RedBlackNode parent = axis.parent; //shud become parent of right
        //axis left remains
        RedBlackNode right = axis.right; //shud become parent of axis
        RedBlackNode rightLeft = axis.right.left; //shud become right of axis
        //right of right remains


        right.parent = parent;
        //parent.right

        if (axis != root) {

            if (axis.parent.left == axis) {
                parent.left = right;
            } else {
                parent.right = right;
            }
        }

        axis.parent = right;
        right.left = axis;

        axis.right = rightLeft;
        if (axis == root) {
            root = right;
        }

    }

    private void case3ReColor(RedBlackNode current) {
        if(current.parent == null || current.parent.parent == null) {
            return;
        }

        try {
            RedBlackNode parent = current.parent;
            RedBlackNode gradFather = current.parent.parent;
            RedBlackNode uncle = (parent.parent.left == current.parent) ? current.parent.parent.right : current.parent.parent.left;

            parent.color = nodeColor.BLACK;
            uncle.color = nodeColor.BLACK;
            gradFather.color = nodeColor.RED;
            return;
        }
        catch (Exception e) {
            return;
        }
    }
}
