public class HeapNode {
    private HeapNode left_child;
    private HeapNode right_child;
    private HeapNode parent;
    private Comparable data;


    public HeapNode(){
        left_child = null;
        right_child = null;
        data = null;
        parent = null;
    }

    public HeapNode(Comparable data) {
        this.data = data;
        left_child = null;
        right_child = null;
        parent = null;
    }

    public HeapNode(Comparable data, HeapNode left_child, HeapNode right_child, HeapNode parent) {
        this.data = data;
        this.left_child = left_child;
        this.right_child = right_child;
        this.parent = parent;
    }

    public HeapNode getLeftChild() {
        return left_child;
    }

    public HeapNode getRightChild() {
        return right_child;
    }

    public Comparable getData() {
        return data;
    }

    public HeapNode getParent() {
        return parent;
    }

    public void setLeftChild(HeapNode left_child) {
        this.left_child = left_child;
    }

    public void setRightChild(HeapNode right_child) {
        this.right_child = right_child;
    }

    public void setData(Comparable data) {
        this.data = data;
    }

    public void setParent(HeapNode parent) {
        this.parent = parent;
    }
}
