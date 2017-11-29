import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by spencers1 on 11/13/2017.
 */
public class Heap implements MyHeap {

    HeapNode root;
    int count;
    @Override
    public HeapNode makeHeap(Comparable value) {
        root = new HeapNode(value);
        count++;
        return root;
    }

    public boolean contains(Comparable data) {
        HeapNode temp = root;
        temp = convertToList();
        boolean found = false;
        while (temp != null && found == false) {
            if (temp.getData().compareTo(data) == 0) {
                found = true;
            }
            temp = temp.getRightChild();
        }
        return found;
    }

    public int getSize() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public HeapNode convertToList() {
        if (root == null) {
            return null;
        } else {
            HeapNode currentNode = root;
            while (currentNode != null) {
                if (currentNode.getLeftChild() != null) {
                    if (currentNode.getRightChild() != null) {
                        HeapNode next = currentNode.getLeftChild();
                        while (next.getRightChild() != null) {
                            next = next.getRightChild();
                        }
                        next.setRightChild(currentNode.getRightChild());
                    }
                    currentNode.setRightChild(currentNode.getLeftChild());
                    currentNode.setLeftChild(null);
                }
                currentNode = currentNode.getRightChild();
            }
            return root;

        }
    }
    @Override
    public boolean insert(Comparable value) {
        boolean inserted = false;
        if (root == null) {
            this.makeHeap(value);
            return true;
        }
//        if (contains(value)) {
//            return inserted;
//        }
        int valueAfterInsert = count + 1;
        String binaryString = Integer.toBinaryString(valueAfterInsert);
        if (binaryString.length() > 1) {
            binaryString = binaryString.substring(1);
        }
        HeapNode currentNode = root;
        for (int i = 0; i < binaryString.length() - 1; i++) {
            char token = binaryString.charAt(i);
            int tokenValue = Character.getNumericValue(token);
            if (tokenValue == 0) {
                currentNode = currentNode.getLeftChild();
            } else if (tokenValue == 1) {
                currentNode = currentNode.getRightChild();
            }
        }
        char last = binaryString.charAt(binaryString.length() -1);

        int convertedChar = Character.getNumericValue(last);
        if (convertedChar == 0) {
            currentNode.setLeftChild(new HeapNode(value, null, null, currentNode));
            currentNode = currentNode.getLeftChild();
            inserted = true;
            count++;
        } else if (convertedChar == 1) {

            currentNode.setRightChild(new HeapNode(value, null, null, currentNode));
            currentNode = currentNode.getRightChild();
            count++;
            inserted = true;
        }

        rearrange(currentNode);

        return inserted;
    }

    public void rearrange(HeapNode currentNode) {
        boolean sorted = false;
        Comparable temp;
        if (currentNode.getData().compareTo(currentNode.getParent().getLeftChild().getData()) == 0) {
            // do left child
            while (!sorted) {
                if (currentNode.getParent()!= null && currentNode.getData().compareTo(currentNode.getParent().getData()) < 0) {
                    temp = currentNode.getParent().getData();
                    currentNode.getParent().setData(currentNode.getData());
                    currentNode.setData(temp);

                    currentNode = currentNode.getParent();
                } else {
                    sorted = true;
                }
            }
        } else if (currentNode.getData().compareTo(currentNode.getParent().getRightChild().getData()) == 0) {
            // do right child
            while (!sorted) {
                if (currentNode.getParent() != null && currentNode.getData().compareTo(currentNode.getParent().getData()) < 0) {
                    temp = currentNode.getParent().getData();
                    currentNode.getParent().setData(currentNode.getData());
                    currentNode.setData(temp);
                    currentNode = currentNode.getParent();
                } else {
                    sorted = true;
                }
            }
        }
    }

    @Override
    public boolean deleteMin() {
        if (root == null) {
            return false;
        } else {
            String binaryString = Integer.toBinaryString(count);
            binaryString = binaryString.substring(1);
            HeapNode currentNode = getLastNode();
            swapData(root, currentNode);
            HeapNode parent = currentNode.getParent();
            char last = binaryString.charAt(binaryString.length() -1);
            int lastValue = Character.getNumericValue(last);
            if (lastValue == 0) {
                parent.setLeftChild(null);
                count--;
            } else if (lastValue == 1) {
                parent.setRightChild(null);
                count--;
            }
//            currentNode = parent;
//            rearrange(currentNode);
            currentNode = getRoot();
            HeapNode smallest = getSmallestChild(currentNode);
            while (currentNode != null && smallest != null) {
                smallest = getSmallestChild(currentNode);
                if (smallest != null && smallest.getData().compareTo(currentNode.getData()) < 0) {
                    swapData(smallest, currentNode);
                }
                currentNode = smallest;
            }
            return true;
        }

    }

    public void swapData(HeapNode first, HeapNode second) {
        Comparable temp = first.getData();
        first.setData(second.getData());
        second.setData(temp);
    }
    public HeapNode getSmallestChild(HeapNode node) {
        HeapNode smallest = null;
        if (node.getLeftChild() != null && node.getRightChild() != null) {
            //compare the two
            if (node.getLeftChild().getData().compareTo(node.getRightChild().getData()) < 0) {
                smallest = node.getLeftChild();
            } else if (node.getLeftChild().getData().compareTo(node.getRightChild().getData()) > 0) {
                smallest = node.getRightChild();
            }
        } else if (node.getLeftChild() == null && node.getRightChild() != null) {
            // do right
            smallest = node.getRightChild();
        } else if (node.getRightChild() == null && node.getLeftChild() != null) {
            // do left
            smallest = node.getLeftChild();
        } else {
            // done
            smallest = null;
        }

        return smallest;


    }
    @Override
    public boolean decreaseKey(HeapNode key, Comparable updateValue) {
        if (updateValue.compareTo(key.getData()) > 0) {
            System.out.println("Input key must be less than existing key.");
            return false;
        } else if (updateValue.compareTo(key.getData()) == 0) {
            return true;
        } else {
            key.setData(updateValue);

            rearrange(key);
            return true;
        }
    }

    @Override
    public boolean delete(HeapNode del) {

        String binaryString = Integer.toBinaryString(count);
        binaryString = binaryString.substring(1);
        HeapNode currentNode = getLastNode();

        swapData(del, currentNode);
        HeapNode parent = currentNode.getParent();
        char last = binaryString.charAt(binaryString.length() -1);
        int lastValue = Character.getNumericValue(last);
        if (lastValue == 0) {
            parent.setLeftChild(null);
            count--;
        } else if (lastValue == 1) {
            parent.setRightChild(null);
            count--;
        }
        currentNode = del;
        boolean done = false;
        while (!done) {
            if (currentNode.getData().compareTo(currentNode.getLeftChild().getData()) > 0) {
                swapData(currentNode, currentNode.getLeftChild());
            } else if (currentNode.getData().compareTo(currentNode.getRightChild().getData()) > 0) {
                swapData(currentNode, currentNode.getRightChild());
            } else {
                done = true;
            }
        }

        return true;
    }

    public HeapNode getLastNode() {
        String binaryString = Integer.toBinaryString(count);
        binaryString = binaryString.substring(1);
        HeapNode currentNode = root;
        for (int i = 0; i < binaryString.length(); i++) {
            char token = binaryString.charAt(i);
            int tokenValue = Character.getNumericValue(token);
            if (tokenValue == 0) {
                currentNode = currentNode.getLeftChild();
            } else if (tokenValue == 1) {
                currentNode = currentNode.getRightChild();
            }
        }

        return currentNode;
    }
    @Override
    public Heap union(Heap heap) {
        HeapNode firstRoot;
        HeapNode currentNode;
        HeapNode secondRoot;
        firstRoot = this.convertToList();
        secondRoot = heap.convertToList();
        currentNode = firstRoot;
        Heap createdHeap = new Heap();
        while (currentNode != null) {
            createdHeap.insert(currentNode.getData());
            currentNode = currentNode.getRightChild();
        }
        currentNode = secondRoot;                 // change to second list
        while (currentNode != null) {
            createdHeap.insert(currentNode.getData());
            currentNode = currentNode.getRightChild();
        }

        return createdHeap;
    }

    @Override
    public Comparable findMin() {
        return root.getData();
    }

    public void printHeap() {
        Queue<HeapNode> currentLevel = new LinkedList<HeapNode>();
        Queue<HeapNode> nextLevel = new LinkedList<HeapNode>();

        currentLevel.add(root);
        System.out.println("---------------------------");
        while (!currentLevel.isEmpty()) {
            Iterator<HeapNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                HeapNode currentNode = iter.next();
                if (currentNode.getLeftChild() != null) {
                    nextLevel.add(currentNode.getLeftChild());
                }
                if (currentNode.getRightChild() != null) {
                    nextLevel.add(currentNode.getRightChild());
                }
                System.out.print(currentNode.getData() + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<HeapNode>();
        }
        System.out.println("---------------------------");
    }

    public HeapNode getRoot() {
        return root;
    }
}
