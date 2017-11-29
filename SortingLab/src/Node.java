/**
 * Created by spencers1 on 11/1/2017.
 */
public class Node {

    public Comparable data;
    private int depth;
    public int height;
    private Node left;
    private Node right;
    private Node parent;
    private int balanceFactor;

    public Node(Comparable n) {
        this.data = (Comparable) n;
        balanceFactor = 0;
        left = null;
        right = null;
        parent = null;
    }


    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node input) {
        parent = input;
    }

    public int getBalanceFactor() {
        return this.balanceFactor;
    }

    public void setBalanceFactor(int input) {
        balanceFactor = input;
    }

    public void setDepth(int input) {
        depth = input;
    }

    public int getDepth() {
        return this.depth;
    }
    //    public void setHeight(int value) {
//        height = value;
//    }
//
//    public int getHeight() {
//        return this.height;
//    }
    public Node getLeft() {
        return this.left;
    }

    public void setRight(Node n) {
        right = n;
    }

    public void setLeft(Node n) {
        left = n;
    }

    public Node getRight() {
        return this.right;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int value) {
        height = value;
    }

    public void setData(Comparable value) {
        data = value;
    }

    public Comparable getData() {
        return this.data;
    }

//    public int getBalance() {
//        return (getLeft().getHeight() - getRight().getHeight());
//    }


}
