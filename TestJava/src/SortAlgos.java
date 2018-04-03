
/**
 * @author eamisem
 *
 */
public class SortAlgos {

	public static int maxSize = 10000;

	public static void main(String[] args) {

		/*int[] a = new int[maxSize];
		for (int i = 0; i < maxSize; i++)
			a[i] = (int) (java.lang.Math.random() * (maxSize - 1));
		for (int i = 0; i < maxSize; i++)
			System.out.println("====" + a[i]);
		long startTime = System.currentTimeMillis();
		bubbleSort(a);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("bubble time =" + elapsedTime);

		startTime = System.currentTimeMillis();
		selectionSort(a);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("selection time =" + elapsedTime);

		startTime = System.currentTimeMillis();
		insertionSort(a);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("insertion time =" + elapsedTime);*/

		// shell sort

		/*int maxSize = 10; // array size
		ArraySh arr;
		arr = new ArraySh(maxSize); // create the array
		for (int j = 0; j < maxSize; j++) // fill array with
		{ // random numbers
			long n = (int) (java.lang.Math.random() * 99);
			arr.insert(n);
		}
		arr.display(); // display unsorted array
		arr.shellSort(); // shell sort the array
		arr.display(); // display sorted array
*/		
		//MyQuickSort sorter = new MyQuickSort();
		//int[] input = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		/*sorter.sort(input);
		for (int i : input) {
			System.out.print(i);
			System.out.print(" ");
		}*/

		//MyMergeSort ms = new MyMergeSort(input);
		
		int arr[] ={1,4,6,17,18,19};
		itBinary(arr, 4);
	
	}

	/**
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i >= 1; i--) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int tem = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tem;
				}
			}
		}
		System.out.println("===after bubble sort sort======");
		/*
		 * for (int i = 0; i < maxSize; i++) System.out.println("====" + a[i]);
		 */
	}

	/**
	 * @param a
	 */
	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length - 1; j++) {
				if (a[i] > a[j]) {
					int tem = a[i];
					a[i] = a[j];
					a[j] = tem;
				}
			}
		}
		System.out.println("===after selection sort sort======");
		/*
		 * for (int i = 0; i < maxSize; i++) System.out.println("====" + a[i]);
		 */
	}

	/**
	 * @param a
	 */
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int o = a[i];
			int index = i;

			while (index > 0 && a[index] < a[index - 1]) {
				a[i] = a[i - 1];
				a[i - 1] = o;
				index--;
			}
		}
		System.out.println("===after insertion sort======");
		/*
		 * for (int i = 0; i < maxSize; i++) System.out.println("====" + a[i]);
		 */
	}
	
	 public static void itBinary(int arr[],int find){
	    	int middle=0,st=0,end=arr.length;
	    	middle = (st+end)/2;
	    	while(find!= arr[middle] && middle!=1) {
	    		if(arr[middle] >find) {
	    			st = middle+1;
	    			middle = (st+end)/2;
	    			
	    		}else {
	    			end = middle-1;
	    			middle =(st+end)/2;
	    		}
	    	}
	    	if(find== arr[middle]) {
	    		System.out.println("element found at index" + middle);
	    	}else{
	    		System.out.println("element not found");
	    	}
	    	
	    }

}

// shellSort.java
// demonstrates shell sort
// to run this program: C>java ShellSortApp
// --------------------------------------------------------------
class ArraySh {
	private long[] theArray; // ref to array theArray
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArraySh(int max) // constructor
	{
		theArray = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		theArray[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
		System.out.print("A=");
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(theArray[j] + " "); // display it
		System.out.println("");
	}

	// --------------------------------------------------------------
	public void shellSort() {
		int inner, outer;
		long temp;
		int h = 1; // find initial value of h
		while (h <= nElems / 3)
			h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
		while (h > 0) // decreasing h, until h=1
		{
			// h-sort the file
			for (outer = h; outer < nElems; outer++) {
				temp = theArray[outer];
				inner = outer;
				// one subpass (eg 0, 4, 8)
				while (inner > h - 1 && theArray[inner - h] >= temp) {
					theArray[inner] = theArray[inner - h];
					inner -= h;
					theArray[inner] = temp;
				} // end for
				h = (h - 1) / 3; // decrease h
			} // end while(h>0)
		} // end shellSort()
			// --------------------------------------------------------------
	} // end class ArraySh
		////////////////////////////////////////////////////////////////
}

class MyQuickSort {
    
    private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}



class MyMergeSort {
	int numbers[];
	int helper[];
	
	 public MyMergeSort(int el[]){
		 numbers = el;	
		 int length = el.length-1;
		 helper = new int[el.length];
	     doMergeSort(0, length);
	     for(int i=0; i<=length;i++){
		    	System.out.println(numbers[i]);
		    	}
	    }
	    public void doMergeSort(int low,int high) {
	    	
	    	if(low< high) {
	    		int middle = low+(high-low)/2;
	    		doMergeSort(low, middle);
	    		doMergeSort( middle+1, high);
	    		mergeParts(low,middle,high);
	    	}
	    	
	    }
	    public void mergeParts(int low,int middle,int high){

            // Copy both parts into the helper array
            for (int i = low; i <= high; i++) {
                    helper[i] = numbers[i];
            }

            int i = low;
            int j = middle + 1;
            int k = low;
            // Copy the smallest values from either the left or the right side back
            // to the original array
            while (i <= middle && j <= high) {
                    if (helper[i] <= helper[j]) {
                            numbers[k] = helper[i];
                            i++;
                    } else {
                            numbers[k] = helper[j];
                            j++;
                    }
                    k++;
            }
            // Copy the rest of the left side of the array into the target array
            while (i <= middle) {
                    numbers[k] = helper[i];
                    k++;
                    i++;
            }
}
	    
}
