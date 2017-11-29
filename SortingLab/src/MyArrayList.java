/**
 * Created by spencers1 on 11/15/2017.
 */
public class MyArrayList implements MyList<Comparable> {
    //test
    private int count;
    private Comparable myItem;
    private Comparable[] array;
    private Comparable[] helper;
    private int maxValue;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (Comparable[]) new Comparable[10];
        count = 0;
    }
    @Override
    public boolean add(int index, Comparable t) {
        int i = index;
        if (i < 1 || i > count) {
            throw new
                    IndexOutOfBoundsException(index + " < 0 or >= " + count);
        }
        if (count == array.length) {
            array = resize();
            array[index] = t;
            count++;
        }
        else {
            array[index] = t;
            count++;
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public void doubleSize() {
        array = (Comparable[]) new Comparable[array.length * 2];
    }

    public Comparable[] resize() {
        Comparable[] newArray = new Comparable[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        return array;
    }
    @Override
    public boolean add(Comparable t) {
        if(count == array.length) {
            array = resize();
            array[count] = t;
            if (t.compareTo(maxValue) > 0) {
                maxValue = (int) t;
            }
        } else {
            array[count] = t;
            if (t.compareTo(maxValue) > 0) {
                maxValue = (int) t;
            }
        }
        count++;
        return false;
    }

    @Override
    public boolean clear() {

        @SuppressWarnings("unchecked")
        Comparable[] empty = (Comparable[]) new Object[0];
        array = empty;
        return false;
    }

    @Override
    public boolean contains(Comparable t) {
        boolean flag = false;
        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(t)) {
                flag = true;
            }
            else {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public Comparable get(int index) {
        if(index < 0 || index > count) {
            myItem = null;
            throw new
                    IndexOutOfBoundsException(index + " < 0 or >= " + count);

        } else {
            myItem = array[index];
        }

        return myItem;
    }

    @Override
    public int indexOf(Comparable t) {
        int returnValue = 0;
        for(int i = 0; i < count; i++) {
            if(array[i].equals(t)) {
                returnValue = i;
            } else {
                returnValue = -1;
            }
        }

        return returnValue;
    }

    @Override
    public boolean isEmpty() {
        boolean flag = false;
        if (count == 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public Comparable remove(int index) {
        if (index < 0 || index > count) {
            throw new
                    IndexOutOfBoundsException(index + " < 0 or >= " + count);
        } else {
            array[index] = null;
            count--;
        }
        return null;
    }

    @Override
    public Comparable remove(Comparable o) {
        for(int i = 0; i < count; i++) {
            if(array[i].equals(o)) {
                array[i] = null;
                count--;
                i = count;
            }
        }
        return null;
    }

    @Override
    public boolean set(int index, Comparable element) {
        if(index < 1 || index > count) {
            throw new
                    IndexOutOfBoundsException(index + " < 0 or >= " + count);
        } else {
            array[index] = element;
        }

        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public MyList subList(int fromIndex, int toIndex) {
        MyArrayList newList = new MyArrayList();
        if (fromIndex < 1 || fromIndex > count) {
            throw new
                    IndexOutOfBoundsException(fromIndex + " < 0 or >= " + count);
        }
        if (toIndex < 1 || toIndex > count) {
            throw new
                    IndexOutOfBoundsException(toIndex + " < 0 or >= " + count);
        } else {
            for(int i = fromIndex; i < toIndex; i++) {
                newList.add(i, array[i]);
            }
        }
        return newList;
    }

    @Override
    public Comparable[] toArray() {
        return array;
    }

    @Override
    public boolean swap(int position1, int position2) {
        Comparable item1 = array[position1];
        Comparable item2 = array[position2];
        array[position1] = item2;
        array[position2] = item1;

        return true;
    }
//        if(position1 < 0 || position1 > array.length || position2 < 0 || position1 < array.length) {
//            throw new
//                    IndexOutOfBoundsException(position1 + " < 0 or >= " + count);
//        }
//        else {
//            Comparable item1 = array[position1];
//            Comparable item2 = array[position2];
//            array[position1] = item2;
//            array[position2] = item1;
//        }
//        return false;
//    }

    @Override
    public boolean shift(int positions) {
        Comparable[] temp = (Comparable[]) new Comparable[count];
        for(int i = 0; i < count; i++) {
            temp[i + positions] = array[i];
        }
        array = temp;
        return false;
    }

    public Comparable[] bubbleSort() {
        for (int i = 0; i < size(); i++) {
            for (int j = 1; j < size(); j++) {
                if (get(j-1).compareTo(array[j]) > 0) {
                    swap(j - 1, j);
                }
            }
        }

        return array;
    }

    private void merge(int lower, int middle, int higher) {
        for ( int i = lower; i <= higher; i++) {
            helper[i] = array[i];
        }

        int i = lower;
        int j = middle + 1;
        int current = lower;

        while (i <= middle && j <= higher) {
            if (helper[i].compareTo(helper[j]) < 0) {
                array[current] = helper[i];
                i++;
            } else {
                array[current] = helper[j];
                j++;
            }
            current++;
        }
        while (i <= middle) {
            array[current] = helper[i];
            current++;
            i++;
        }

    }

    private void doMerge(int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            doMerge(left, middle);
            doMerge(middle + 1, right);
            merge(left, middle, right);

        }
    }

    public void mergeSort() {
        this.helper = new Comparable[count];
        doMerge(0, count - 1);
    }
    public Comparable[] iterQuickSort() {
        int pivotIndex = size() - 1;
        int leftIndex = 0;
        int rightIndex = pivotIndex - 1;
        boolean sorted = false;
        if (array == null || size() == 0) {
            return array;
        }
        while (!sorted) {
            if (get(leftIndex).compareTo(rightIndex) < 0) {
                rightIndex--;
                sorted = false;
            } else if (get(rightIndex).compareTo(leftIndex) > 0){
                leftIndex++;
            } else {
                swap(leftIndex, rightIndex);
            }
            if (get(leftIndex).compareTo(get(rightIndex)) >= 0) {
                pivotIndex = leftIndex;
            }

        }

        return array;
    }


    public Comparable[] heapSort() {
        Heap heap = new Heap();
        Comparable[] temp = new Comparable[count];
        for (int i = 0; i < count; i++) {
            heap.insert(array[i]);
        }
        heap.printHeap();

        for (int i = 0; i < count; i++) {
            if (heap.getSize() == 1) {
                temp[i] = heap.getRoot().getData();
            } else {
                temp[i] = heap.getRoot().getData();
                heap.deleteMin();
            }
        }
        array = temp;
//        for (int i = 0; i < count - 1; i++) {
//            array[i] = heap.getRoot().getData();
//            heap.deleteMin();
//        }
        return array;
    }

    public Comparable[] bucketSort() {
        int[] bucket = new int[maxValue + 1];

        for (int i = 0; i < array.length; i++) {


        }


        return array;
    }
    public String padWithZeroes(String input, int total) {
        String zeroes = "";
        for (int i = 0; i < total; i++) {
            zeroes += "0";
        }
        String output = zeroes + input;
        return output;
    }
    public Comparable[] radixSort() {
        String max = Integer.toString(maxValue);
        String[] strarray = new String[count];

        int maxLength = max.length();
        for (int i = 0; i < count; i++) {
            String current = Integer.toString((int) array[i]);
            if (current.length() != maxLength) {
                // pad with zeroes
                int totalZeroes = maxLength - current.length();
                padWithZeroes(current, totalZeroes);
            }
        }

        return array;
    }
}

