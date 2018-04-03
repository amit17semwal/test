import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author eamisem
 *
 */
public class Recursion {
	static int size;
	static int count;
	static char[] arrChar = new char[100];
	static int nDisks = 4;
//merger
	private static int[] theArray ={5,2,8,11,23,65,70,25,22,76}; ; // ref to array theArray
	private static int nElems;
	public static void main(String[] args) throws IOException {
		/*
		 * int a,b; a = tringle(5); System.out.println("trin no is :" + a); b =
		 * facto(5); System.out.println("facto no is :" + b);
		 */

		// anagram
		/*
		 * System.out.print("Enter a word: "); String input = getString(); size
		 * = input.length(); count = 0; for (int j = 0; j < size; j++)
		 * arrChar[j] = input.charAt(j); doAnagram(size);
		 */
		// Binary search
		// find(17);
		// Tower of hanio
		// doTowers(nDisks, 'A', 'B', 'C');
		// merge sort
		/*int[] arrayA = { 23, 47, 81, 95 };
		int[] arrayB = { 7, 14, 39, 55, 62, 74 };
		int[] arrayC = new int[10];
		merge(arrayA, 4, arrayB, 6, arrayC);
		display(arrayC, 10);*/
		int[] workSpace  = {5,2,8,11,23,65,70,25,22,76}; 
		nElems=workSpace.length;
		recMergeSort(workSpace, 0, nElems-1);
		for(int i : theArray) {
			System.out.println(i);
		}
	}

	public static int tringle(int n) {

		if (n == 1) {
			return 1;
		} else {
			return (n + tringle(n - 1));
		}
	}

	public static int facto(int n) {

		if (n == 1) {
			return 1;
		} else {
			return (n * facto(n - 1));
		}
	}

	public static void doAnagram(int newSize) {
		if (newSize == 1) // if too small,
			return; // go no further
		for (int j = 0; j < newSize; j++) // for each position,
		{
			doAnagram(newSize - 1); // anagram remaining
			if (newSize == 2) // if innermost,
				displayWord(); // display it
			rotate(newSize); // rotate word
		}
	}

	// rotate left all chars from position to end
	public static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		char temp = arrChar[position]; // save first letter
		for (j = position + 1; j < size; j++) // shift others left
			arrChar[j - 1] = arrChar[j];
		arrChar[j - 1] = temp; // put first on right
	}

	// -----------------------------------------------------------
	public static void displayWord() {
		if (count < 99)
			System.out.print(" ");
		if (count < 9)
			System.out.print(" ");
		System.out.print(++count + " ");
		for (int j = 0; j < size; j++)
			System.out.print(arrChar[j]);
		System.out.print(" ");
		System.out.flush();
		if (count % 6 == 0)
			System.out.println("");
	}

	// -----------------------------------------------------------
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	// -------------------------------------------------------------

	public static int find(int item) {
		int a[] = { 2, 4, 5, 6, 7, 8, 11, 12, 14, 16, 17 };

		return recBinary(a, item, 0, a.length - 1);
	}

	public static int recBinary(int a[], int item, int lower, int upper) {
		int curIn = (lower + upper) / 2;
		if (a[curIn] == item) {
			System.out.println("Item found at index" + curIn);
			return curIn;
		}
		if (a[curIn] > item) {
			recBinary(a, item, lower, curIn);
		} else {
			recBinary(a, item, curIn, upper);
		}
		System.out.println("Item not found");
		return -1;
	}

	// tower of hanoi problem
	public static void doTowers(int topN, char from, char inter, char to) {
		if (topN == 1)
			System.out.println("Disk 1 from " + from + " to " + to);
		else {
			doTowers(topN - 1, from, to, inter); // from-->inter
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			doTowers(topN - 1, inter, from, to); // inter-->to
		}
	}

	public static void recMergeSort(int[] workSpace, int upperBound, int lowerBound) {

		if (lowerBound == upperBound) // if range is 1,
			return; // no use sorting
		else { // find midpoint
			int mid = (lowerBound + upperBound) / 2;
			// sort low half
			recMergeSort(workSpace, lowerBound, mid);
			// sort high half
			recMergeSort(workSpace, mid + 1, upperBound);
			// merge them
			mergeR(workSpace, lowerBound, mid + 1, upperBound);
		} // end else
	} // end recMergeSort()

	static void mergeR(int[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0; // workspace index
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1; // # of items
		while (lowPtr <= mid && highPtr <= upperBound)
			if (theArray[lowPtr] < theArray[highPtr])
				workSpace[j++] = theArray[lowPtr++];
			else
				workSpace[j++] = theArray[highPtr++];
		while (lowPtr <= mid)
			workSpace[j++] = theArray[lowPtr++];
		while (highPtr <= upperBound)
			workSpace[j++] = theArray[highPtr++];
		for (j = 0; j < n; j++)
			theArray[lowerBound + j] = workSpace[j];
	} // end merge()

	public static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
		int aDex = 0, bDex = 0, cDex = 0;
		while (aDex < sizeA && bDex < sizeB) // neither array empty
			if (arrayA[aDex] < arrayB[bDex])
				arrayC[cDex++] = arrayA[aDex++];
			else
				arrayC[cDex++] = arrayB[bDex++];
		while (aDex < sizeA) // arrayB is empty,
			arrayC[cDex++] = arrayA[aDex++]; // but arrayA isn’t
		while (bDex < sizeB) // arrayA is empty,
			arrayC[cDex++] = arrayB[bDex++]; // but arrayB isn’t
	} // end merge()
		// -----------------------------------------------------------
		// display array

	public static void display(int[] theArray, int size) {
		for (int j = 0; j < size; j++)
			System.out.print(theArray[j] + " ");
		System.out.println("");
	}
}