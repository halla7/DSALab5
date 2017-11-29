
public interface MyHeap {
    public HeapNode makeHeap(Comparable value);
    public boolean isEmpty();
    public boolean insert(Comparable value);
    public boolean deleteMin();
    public boolean decreaseKey(HeapNode key, Comparable updateValue);
    public boolean delete(HeapNode del);
    public Heap union(Heap heap);
    public Comparable findMin();
}
