/**
 * Created by halla7 on 11/15/2017.
 */
import java.util.Random;
public class Driver {

    public static void main(String[] args){

        Random randomNumbers = new Random();
        MyArrayList myList = new MyArrayList();
        for (int i = 0; i < 5; i++) {
            myList.add(randomNumbers.nextInt(100));
        }

        System.out.println(myList.insertionSort());

    }
}
