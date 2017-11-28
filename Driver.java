/**
 * Created by halla7 on 11/15/2017.
 */
import java.lang.reflect.Array;
import java.util.Random;
public class Driver {

    public static void main(String[] args){

        Random randomNumbers = new Random();
        MyArrayList myList = new MyArrayList();
        for (int i = 0; i < 300; i++) {
            myList.add(randomNumbers.nextInt(500));
        }

        System.out.println(System.currentTimeMillis());
//        System.out.print("Array before: ");
//        for (int i=0; i<myList.size(); i++)
//        	System.out.print(myList.get(i)+" ");
//        System.out.println(".");
//        System.out.println(myList.insertionSort());
        System.out.println(myList.quickSort());
        
//        System.out.print("Array after: ");
//        for (int i=0; i<myList.size(); i++)
//        	System.out.print(myList.get(i)+" ");
//        System.out.println(".");
        System.out.println(System.currentTimeMillis());

    }
}
