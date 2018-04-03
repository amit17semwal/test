package dsExcercise;

import java.util.Arrays;

public class AlgoTest {
	public static void main(String[] args) {
		// int i[] = { 1, 2, 3, 4, 5, 6, 7 };
		AlgoTest rotate = new AlgoTest();
		System.out.println(Integer.MIN_VALUE);
		/*
		 * int i[] = new int[200000];
		 * 
		 * for (int j = 0; j < 200000; j++) { i[j] = j; }
		 * 
		 * long s = System.currentTimeMillis(); rotate(i, 2, i.length); long e =
		 * System.currentTimeMillis() - s; System.out.println("1----" + e);
		 * 
		 * s = System.currentTimeMillis();
		 * 
		 * rotate.leftRotate(i, 2, i.length); // rotate.printArray(i, i.length);
		 * e = System.currentTimeMillis() - s; System.out.println("2----" + e);
		 * 
		 * s = System.currentTimeMillis(); rotate.leftRotate2(i, 2, i.length);
		 * // rotate.printArray(i, i.length); e = System.currentTimeMillis() -
		 * s; System.out.println("2----" + e);
		 */
		/*
		 * Input: arr[] = [1, 2, 3, 4, 5, 6, 7] d = 2 Output: arr[] = [3, 4, 5,
		 * 6, 7, 1, 2]
		 */

		// [-1, 2, -3, 4, 5, 6, -7, 8, 9],
		// [9, -7, 8, -3, 5, -1, 2, 4, 6]

		// int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		// int n = arr.length;
		// rearrange(arr,n);
		int arr[] = {10, 5, 3, 9, 2};

		int n = arr.length;
		//rearrange(arr, n);
	//	reverseArray(arr, n);
	//	sortArrayInWaveForm(arr, n);
		sortArrayAbsDiff(arr,n,7);
		System.out.println("Array after rearranging: ");
		printArray(arr, n);
		
		
	}

	static void rotate(int ar[], int d, int n) {

		int ar1[] = new int[ar.length];
		int j = 0;
		for (int i = d; i < ar.length; i++, j++) {
			ar1[j] = ar[i];
		}
		for (int i = 0; i < d; i++, j++) {
			ar1[j] = ar[i];
		}
	}

	void leftRotate(int arr[], int d, int n) {
		int i;
		for (i = 0; i < d; i++)
			leftRotatebyOne(arr, n);
	}

	void leftRotatebyOne(int arr[], int n) {
		int i, temp;
		temp = arr[0];
		for (i = 0; i < n - 1; i++)
			arr[i] = arr[i + 1];
		arr[i] = temp;
	}

	/* utility function to print an array */
	static void printArray(int arr[], int size) {
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	/* Function to left rotate arr[] of siz n by d */
	void leftRotate2(int arr[], int d, int n) {
		int i, j, k, temp;
		for (i = 0; i < gcd(d, n); i++) {
			/* move i-th values of blocks */
			temp = arr[i];
			j = i;
			while (1 != 0) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	/* UTILITY FUNCTIONS */

	/* Fuction to get gcd of a and b */
	int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	static void rearrange(Integer arr[], int n) {

		// The following few lines are similar to partition
		// process of QuickSort. The idea is to consider 0
		// as pivot and divide the array around it.
		int i = -1, temp = 0;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		System.out.println("all items " + arr);
		for (int k : arr)
			System.out.print(k + " ,");
		// Now all positive numbers are at end and negative numbers at
		// the beginning of array. Initialize indexes for starting point
		// of positive and negative numbers to be swapped
		int pos = i + 1, neg = 0;

		// Increment the negative index by 2 and positive index by 1, i.e.,
		// swap every alternate negative number with next positive number
		while (pos < n && neg < pos && arr[neg] < 0) {
			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg += 2;
		}
	}

	static void reverseArray(int arr[], int n) {
		int temp = 0;
		for (int i = 0, j = n-1; i < j; i++, j--) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
	static void sortArrayInWaveForm(int arr[], int n) {
		int temp = 0;
		int index = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				index++;
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
	}
	
	static void sortArrayAbsDiff(int arr[], int n, int x) 
	{
		int tempDiff = Math.abs(arr[0]-x);
		int temp = arr[0];
		int index = -1;
		for (int i = 1; i < n; i++) {
			if (Math.abs(arr[i] -x) <= tempDiff) {
				index++;
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				
				tempDiff = 
						Math.abs(arr[index]-x);
				
			}
		}
	}
}
