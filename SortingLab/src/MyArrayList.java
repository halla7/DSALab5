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
                    System.out.println("Swapped" + i + ", " + j);
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

    public void sort() {
        recursiveQuickSort(0, count - 1);
    }
    public void recursiveQuickSort(int low, int high) {
        int i = low;
        int j = high;
        Comparable pivot = array[low + (high - low)/ 2];

        while ( i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                Comparable temp = array[i];     // swap
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if ( low < j) {
            recursiveQuickSort(low, j);
        } else if (i < high){
            recursiveQuickSort(i, high);
        }
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

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < count; i++) {
            bucket[(int) array[i]]++;
        }
        int out = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[(int) i]; j++) {
                array[out++] = i;

            }
        }


        return array;
    }


    public int getMaxValue() {
        return maxValue;
    }

    public String padWithZeroes(String input, int total) {
        String zeroes = "";
        for (int i = 0; i < total; i++) {
            zeroes += "0";
        }
        String output = zeroes + input;
        return output;
    }

//    public Comparable[] radixSort() {
//        String max = Integer.toString(maxValue);
//        String[] strarray = new String[count];
//
//        int maxLength = max.length();
//        for (int i = 0; i < count; i++) {
//            String current = Integer.toString((int) array[i]);
//            if (current.length() != maxLength) {
//                // pad with zeroes
//                int totalZeroes = maxLength - current.length();
//                padWithZeroes(current, totalZeroes);
//            }
//        }
//
//        return array;
//    }

    public boolean insertionSort(){
        int sorted=0,min=0,max=0;
        Comparable mid,ckvalue;

        while (sorted<array.length-1 && array[sorted+1]!=null) {
            ckvalue=array[sorted+1];
//          mid = array[sorted % 2];
            for (int i=sorted; i>=0; i--) {
                if (ckvalue.compareTo(array[i]) < 0) {
//            		System.out.println("Placing "+ckvalue+" in the correct spot");
                    while (i>0 && ckvalue.compareTo(array[i-1]) < 0) {
                        i--;
                    }
                    for (int j=i; j<=sorted+1; j++) {
                        mid=array[j];
                        array[j]=ckvalue;
                        ckvalue=mid;
                    }
//           		System.out.print("Sorted area is now: ");
//            		for (int k=0; k<=sorted; k++)
//            			System.out.print(array[k]+" ");
//           		System.out.println(".");
//            		sorted=array.length;
                    break;
                }
            }
            sorted++;
        }

        return true;
    }

    public void radixSort() {
        int i = (int) array[0];
        int m = (int) array[0];
        int exp = 1;
        int size = array.length;
        int[] b = new int[10];

        for (i = 1; i < size; i++) {
            if ((int) array[i] > m) {
                m = (int) array[i];
            }
        }
        while (m / exp > 0) {
            int[] bucket = new int[10];

            for (i = 0; i < size; i++) {
                bucket[((int) array[i] / exp) % 10]++;
            }
            for (i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (i = size - 1; i >= 0; i--) {
                b[--bucket[((int) array[i] / exp) % 10]] = (int) array[i];
            }
            for (i = 0; i < size; i++) {
                array[i] = b[i];
            }
            exp = exp * 10;
        }
    }
    public boolean quickSort() {
        int sorted=0,pivot=0,newpivot=0,storeindex=0;
        Comparable swap,ckvalue;

        System.out.print("Array to be sorted is now: ");
        for (int k=0; k<array.length; k++)
            System.out.print(array[k]+" ");
        System.out.println(".");

        for (int i=0; i<array.length; i++) {
            pivot=i;
            ckvalue=array[pivot];
            storeindex=pivot+1;
//			System.out.println("Pivot ="+ckvalue);
            for (int j=pivot+1; j<array.length; j++) {
                if (ckvalue.compareTo(array[j]) > 0) {
//        			System.out.println("1:Need to swap "+array[storeindex]+" and "+array[j]);
                    swap=array[storeindex];
                    array[storeindex]=array[j];
                    array[j]=swap;
                    storeindex++;
                }

            }

            if (storeindex>0){
                swap=array[storeindex-1];
                array[storeindex-1]=ckvalue;
                array[pivot]=swap;
            }
            for (int k=0; k<=pivot; k++) {
                newpivot=k;
                ckvalue=array[newpivot];
                storeindex=newpivot+1;
//    			System.out.println("Pivot ="+ckvalue);
                for (int l=newpivot+1; l<=pivot; l++) {
                    if (ckvalue.compareTo(array[l]) > 0) {
//            			System.out.println("2:Need to swap "+array[storeindex]+" and "+array[l]);
                        swap=array[storeindex];
                        array[storeindex]=array[l];
                        array[l]=swap;
                        storeindex++;
                    }
                }
                if (storeindex>0){
                    swap=array[storeindex-1];
                    array[storeindex-1]=ckvalue;
                    array[newpivot]=swap;
                }
            }
            System.out.print("Sorted area is now: ");
            for (int k=0; k<=pivot; k++)
                System.out.print(array[k]+" ");
            System.out.println(".");
        }

        return true;
    }
}

