/**
 * Created by halla7 on 11/15/2017.
 */
public class MyArrayList implements MyList <Comparable> {
    //test
    private int count;
    private Comparable myItem;
    private Comparable[] array;


    public MyArrayList() {
        array = (Comparable[]) new Comparable[300];
        count = 0;
    }
    public boolean add(int index, Comparable t) {
        int i = index;
        if (i < 0 || i > count+1) {
            throw new
                    IndexOutOfBoundsException(index + " < 0 or >= " + count);
        }
        if (count == array.length) {
            doubleSize();
            array[index] = t;
            count++;
        }
        else {
            array[index] = t;
            count++;
        }
        return false;
    }
    public void doubleSize() {
        array = (Comparable[]) new Comparable[array.length * 2];
    }
    public boolean add(Comparable t) {
        if(count == array.length) {
            doubleSize();
            array[count] = t;
        } else {
            array[count] = t;
        }
        count++;
        return false;
    }


    public boolean clear() {


        Comparable[] empty = (Comparable[]) new Object[0];
        array = empty;
        return false;
    }


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


    public Comparable get(int index) {
        if(index < 0 || index > count+1) {
            myItem = null;
            throw new
                    IndexOutOfBoundsException(index + " < 0 or >= " + count);


        } else {
            myItem = array[index];
        }


        return myItem;
    }


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


    public boolean isEmpty() {
        boolean flag = false;
        if (count == 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


    public Comparable remove(int index) {
        if (index < 0 || index > count+1) {
            throw new
                    IndexOutOfBoundsException(index + " < 0 or >= " + count);
        } else {
            array[index] = null;
            count--;
        }
        return null;
    }


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


    public boolean set(int index, Comparable element) {
        if(index < 1 || index > count+1) {
            throw new
                    IndexOutOfBoundsException(index + " < 0 or >= " + count);
        } else {
            array[index] = element;
        }


        return false;
    }


    public int size() {
        return count;
    }


    public MyList subList(int fromIndex, int toIndex) {
        MyArrayList newList = new MyArrayList();
        if (fromIndex < 0 || fromIndex > count+1) {
            throw new
                    IndexOutOfBoundsException(fromIndex + " < 0 or >= " + count);
        }
        if (toIndex < 0 || toIndex > count+1) {
            throw new
                    IndexOutOfBoundsException(toIndex + " < 0 or >= " + count);
        } else {
            for(int i = fromIndex; i < toIndex; i++) {
                newList.add(i, array[i]);
            }
        }
        return newList;
    }


    public Comparable[] toArray() {
        return array;
    }


    public boolean swap(int position1, int position2) {
//        if(position1 < 1 || position1 > array.length || position2 < 1 || position1 < array.length) {
//            throw new
//                    IndexOutOfBoundsException(position1 + " < 0 or >= " + count);
//        }
//        else {
            Comparable item1 = array[position1];
            Comparable item2 = array[position2];
            array[position1] = item2;
            array[position2] = item1;
            return true;
        }
//        return false;
//    }


    public boolean shift(int positions) {
        Comparable[] temp = (Comparable[]) new Comparable[count];
        for(int i = 0; i < count; i++) {
            temp[i + positions] = array[i];
        }
        array = temp;
        return false;
    }


    public Comparable[] bubbleSort() {
        boolean swapped = false;
        for (int i = 0; i < count; i++) {
            Comparable x = (Comparable) array[i];
            Comparable y = (Comparable) array[i + 1];
            if (x.compareTo(y) > 0) {
                swap(i, i + 1);
            }


        }


        return null;
    }

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
