/**
 * Created by spencers1 on 11/15/2017.
 */

public interface MyList {


    boolean add(int index, Comparable t);

    boolean add(Comparable o);

    boolean clear();

    boolean contains(Comparable o);

    Comparable get(int index);

    int indexOf(Comparable o);

    boolean isEmpty();

    Comparable remove(int index);

    Comparable remove(Comparable o);

    boolean set(int index, Comparable element);

    int size();

    MyList subList(int fromIndex, int toIndex);

    Comparable[] toArray();

    boolean swap(int position1, int position2);

    boolean shift(int positions);


}