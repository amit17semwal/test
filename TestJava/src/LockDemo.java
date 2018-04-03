import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemo {
	public static void main(String[] args) {

		int ar[] = { 4, 2, 1, 8 };
		// rotateArr(ar, 3);
		// rotateClockwise(ar, 2);
		// System.out.println(rotateClockwise(ar));
		// System.out.println(findDiffSum(ar));

		/*
		 * int k = 3, n = 4; int arr[][] = { { 1, 3, 5, 7 }, { 2, 4, 6, 8 }, {
		 * 0, 9, 10, 11 } }; mergeSortArray(arr, k, n);
		 */

		listDemo ls = new listDemo();
		ls.insertFirst(10);
		ls.insertFirst(20);
		ls.insertFirst(15);
		ls.insertFirst(30);
		ls.insertFirst(40);
		System.out.println("list data with duplicates--");
		System.out.println(ls);
	
	
		
		ls.sortList();
		/*
		 * ls.reverseList(); ls2.reverseList(); System.out.println(ls);
		 * System.out.println(ls2);
		 */
	}

	public static void rotateArr(int arr[], int num) {

		for (int i = 0; i < arr.length; i = i + num) {
			for (int j = i, k = i + num - 1; j < k && k < arr.length; j++, k--) {
				int temp = arr[j];
				arr[j] = arr[k];
				arr[k] = temp;
			}
		}

		for (int i : arr) {
			System.out.println(i);
		}
	}

	static boolean findElement(int arr[], int a, int start, int end) {
		int mid = (start + end) / 2;
		if (arr[mid] == a) {
			return true;
		} else {
			findElement(arr, a, start, mid);
		}

		return true;
	}

	static int findPivot(int arr[]) {

		if (arr[0] < arr[arr.length - 1]) {
			return -1;
		}
		for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
			if (arr[i] <= arr[j]) {
				return j;
			}
		}
		return -1;
	}

	static int findDiffSum(int a[]) {

		int size = a.length - 1;
		int sum = 0;
		for (int i = 0; i <= size; i++) {
			System.out.print("-" + Math.abs(a[i] - a[(i + 1) % size]));
			sum += Math.abs(a[i] - a[(i + 1) % size]);
		}
		System.out.println();
		return sum;
	}

	public static int rotateClockwise(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int pre = sum;
			sum = 0;
			for (int j = 0, k = i; j < arr.length; j++, k++) {
				if (k >= arr.length - 1) {
					k = 0;
				}
				sum += (arr[k] * j);
			}
			if (pre >= sum) {
				sum = pre;
			}
		}
		return sum;
	}

	public static void mergeSortArray(int arr[][], int k, int n) {
		int[] sortArr = new int[k * n];
		for (int aa = 0; aa < k * n; aa++) {
			sortArr[aa] = 999;
		}
		int pre[];
		// int i = 0,j=0,l=0;
		for (int i = 0; i < k; i++) {
			int[] tmp = new int[k * n];
			System.arraycopy(sortArr, 0, tmp, 0, sortArr.length);
			int[] tmp1 = arr[i];
			int b = 0, d = 0, p = 0;
			while (b < tmp1.length && d < sortArr.length) {
				if (tmp1[b] < tmp[d]) {
					sortArr[p++] = tmp1[b++];
				} else {
					sortArr[p++] = tmp[d++];
				}
			}
		}

		for (int i : sortArr) {
			System.out.println(i + "-");
		}
	}

}

class listDemo {
	Node head = null;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void insertLast(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			return;
		}
		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = n;
	}

	public void insertFirst(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			return;
		}
		n.next = head;
		head = n;
	}

	public boolean searchData(int data) {
		return search(head, data);

	}

	private boolean search(Node n, int data) {
		if (n == null)
			return false;
		if (n.data == data)
			return true;
		return search(n.next, data);
	}

	public void reverseList() {
		listDemo ls2 = new listDemo();
		Node tmp = head;
		if (head == null)
			return;
		while (tmp.next != null) {
			ls2.insertFirst(tmp.data);
			tmp = tmp.next;
		}
		ls2.insertFirst(tmp.data);

		this.head = ls2.head;
	}

	@Override
	public String toString() {
		Node tmp = head;
		String str = "-";
		if (head == null)
			return null;
		while (tmp.next != null) {
			str += tmp.data + "-";
			tmp = tmp.next;
		}
		str += tmp.data;
		return str;
	}

	public void removeDuplicate() {
		Node tmp = head;
		if (head == null)
			return;
		while (tmp != null && tmp.next != null) {
			if (tmp.data == tmp.next.data)
				tmp.next = tmp.next.next;
			tmp = tmp.next;
		}
	}
	
	public void sortList() {
		Node current = head;
		Node sorted = null;
		if (head == null)
			return;

		while (current != null && current.next != null) {
			if (sorted == null) {
				sorted = current;
				current = current.next;
			}
			Node tmp2 = sorted;
			Node pre = current;
			while (tmp2.next != null && tmp2.data < current.data) {
				pre = tmp2;
				tmp2 = tmp2.next;

			}
			if (tmp2.next == null) {
				tmp2.next = current;
			} else {
				pre.next = current;
				current.next = tmp2;
			}
		}
			while (sorted.next != null) {
				System.out.println(sorted.data +"-");
			}
	}
}
