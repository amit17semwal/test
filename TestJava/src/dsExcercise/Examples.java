package dsExcercise;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.Arrays;

public class Examples {

	static void arrRotation(int arr[], int n) {
		int arr2[] = new int[arr.length];
		if (n > arr.length)
			return;
		int start = n;
		int i = 0;
		for (; start < arr.length; i++, start++) {
			arr2[i] = arr[start];
		}
		for (int j = 0; j < n; j++, i++) {
			arr2[i] = arr[j];
		}

		for (i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i] + ",");
		}
	}

	public static void main(String[] args) throws IOException {
		
		File myMissingHostsFile = new File("ab.txt");
		String missingNodes[] = {"a","b","c"};
		 try (Writer writer = Files.newBufferedWriter(myMissingHostsFile.toPath()))
	        {
	          
	                for (String host : missingNodes)
	                {
	                    writer.write(host);
	                    writer.write(",");
	                }
	                writer.write(System.lineSeparator());
	        }
		
		int ints[] = {5,2,1,58,200}; 
		int m = Arrays.stream(ints)
		          .reduce(Integer.MAX_VALUE, Integer::min);
		
		System.out.println(m);
		/*
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// arrRotation(a, 2);
		System.out.println("Cyclic rotate");
		cyclicRotate(a, 3);
		System.out.println("Cyclic rotate2");
		cyclicRotate2(a, 3);*/
	}
	

	static void cyclicRotate(int arr[], int n) {

		int arr2[] = new int[arr.length];
		if (n > arr.length)
			return;
		int start = n;
		int i = n;
		int j = 0;
		for (; i < arr.length; j++, i++) {
			arr2[i] = arr[j];
		}
		i = 0;
		for (; j < arr.length; j++, i++) {
			arr2[i] = arr[j];
		}

		for (i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i] + ",");
		}

	}

	static void cyclicRotate2(int arr[], int n) {
		int length = arr.length;
		for (int i = 0; i < n; i++) {
			// int temp = arr[length];
			for (int j = 0; j < length; j++) {
				arr[j] = arr[(j + 1) % length];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ",");
		}
	}

	static void serchInCycleArr(int arr[], int n) {
		int length = arr.length;
		for (int i = 0; i < n; i++) {
			// int temp = arr[length];
			for (int j = 0; j < length; j++) {
				arr[j] = arr[(j + 1) % length];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ",");
		}
	}

	static void seperateZeroAndOne(int a[]) {
		int temp=a[0];
		for (int i = 1; i < a.length; i++) {
			if(temp == 0 && a[i] == 0) {
				temp = a[i];
				continue;
			}
			//else if(temp == 1 a)
		}
	}
}
