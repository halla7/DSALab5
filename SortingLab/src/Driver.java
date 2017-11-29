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
        int max = 1000000;

        for (int i = 0; i < 500; i++) {
            list.add(r.nextInt((max - min) + 1) + min);
        }
        long start = System.currentTimeMillis();
        System.out.println(start);
        list.radixSort();
        long end = System.currentTimeMillis();
        System.out.println(end);
        long total = end - start;
        System.out.println("Total time: " + total + " ms");
        list2 = list;

//        System.out.println();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        for (int i = 0; i < 100; i++) {
            System.out.println(list.get(i));
        }


    }
}
