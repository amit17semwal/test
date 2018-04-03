
public class SortingAlgo2 {
	public static void  main(String ar[])
	{
	    // Array of items on which search will
	    // be conducted.
	    int arr[] =  {10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
	                  24, 33, 35, 42, 47};
	    int n = arr.length;
	 
	    int x = 24; // Element to be searched
	    int index = interpolationSearch(arr, n, x);
	 
	    // If element was found
	    if (index != -1)
	        System.out.println("Element found at index "+ index);
	    else
	    	 System.out.println("Element not found.");
	}
	
	static	int  interpolationSearch(int arr[], int n, int x)
	{
	    // Find indexes of two corners
	    int lo = 0, hi = (n - 1);
	 
	    // Since array is sorted, an element present
	    // in array must be in range defined by corner
	    while (lo <= hi && x >= arr[lo] && x <= arr[hi])
	    {
	        // Probing the position with keeping
	        // uniform distribution in mind.
	        int pos =lo + ((x-arr[lo])*(hi-lo) / (arr[hi]-arr[lo])) ;
	 
	        // Condition of target found
	        if (arr[pos] == x)
	            return pos;
	 
	        // If x is larger, x is in upper part
	        if (arr[pos] < x)
	            lo = pos + 1;
	 
	        // If x is smaller, x is in lower part
	        else
	            hi = pos - 1;
	    }
	    return -1;
	}
	
	static void inserSort(int a[]) {
		int length = a.length;
		if(length==1) {
			System.out.println("already sorted");
			return;
		}
		for(int i =1; i<length;i++) {
			int key = a[i];
			int j = i-1;
			while(j>=0 && a[j]>key) {
			 a[j] =a[i];
			 a[j] = key;
			 j=j-1;
			}
		}
	}
}
