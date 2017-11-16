/**
 * Created by spencers1 on 11/15/2017.
 */
public class Driver {

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        list.add(12);
        list.add(3);
        list.add(23);
        list.add(18);
        list.add(4);
        list.add(50);
        list.add(26);
        list.add(45);

        list.bubbleSort();

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
