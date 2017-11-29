/**
 * Created by spencers1 on 11/15/2017.
 */
import java.util.Random;
public class Driver {

    public static void main(String[] args) {
        Random r = new Random();
        MyArrayList list = new MyArrayList();
        MyArrayList list2 = new MyArrayList();
        int min = 0;
        int max = 100;

        for (int i = 0; i < 50; i++) {
            list.add(r.nextInt((max - min) + 1) + min);
        }
        long start = System.currentTimeMillis();
        System.out.println(start);
        list.heapSort();
        long end = System.currentTimeMillis();
        System.out.println(end);
        list2 = list;

//        System.out.println();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        for (int i = 0; i < 100; i++) {
            System.out.println(list.get(i));
        }



//        list.add(12);
//        list.add(3);
//        list.add(23);
//        list.add(18);
//        list.add(4);
//        list.add(26);
//        list.add(45);
//        list.add(20);
//        list.heapSort();
//        System.out.println(list.padWithZeroes("123", 5));
//        h.insert(12);
//        h.insert(3);
//        h.insert(23);
//        h.insert(18);
//        h.insert(4);
//        h.insert(26);
//        h.insert(45);
//        h.insert(20);
//
//        h.printHeap();
//        h.deleteMin();
//        h.printHeap();
//        System.out.println(h.findMin());
//        h.deleteMin();
//        h.printHeap();
//        System.out.println(h.findMin());
//        h.deleteMin();
//        h.printHeap();
//        System.out.println(h.findMin());
//        h.deleteMin();
//        h.printHeap();
//        System.out.println(h.findMin());
//        h.insert(20);
//        h.insert(3);
//        h.insert(17);
//        h.insert(30);
//        h.insert(48);
//        h.insert(5);
//        h.insert(15);
//        h.insert(24);
//        h.printHeap();
//        h.deleteMin();
//        h.printHeap();
//        h.deleteMin();
//        h.printHeap();
//        h.deleteMin();
//        h.printHeap();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
    }
}
