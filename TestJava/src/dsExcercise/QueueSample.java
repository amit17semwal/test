package dsExcercise;

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
//Java program to reverse a Queue
import java.util.LinkedList;
import java.util.Stack;

//Java program to reverse a queue
class Queue_reverse {
	
	static Queue<Integer> queue;

	// Utility function to print the queue
	static void Print()
	{
		while (!queue.isEmpty()) {
			System.out.print( queue.peek() + ", ");
			queue.remove();
		}
	}

	// Function to reverse the queue
	static void reversequeue(Queue<Integer> q)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		int item  = q.poll();
		reverse(item, q, queue);
		queue.add(item);
		q = queue;
		
	/*	
		while (!queue.isEmpty()) {
			stack.add(queue.peek());
			queue.remove();
		}
		while (!stack.isEmpty()) {
			queue.add(stack.peek());
			stack.pop();
		}*/
	}
	
	static void reverse(int i, Queue<Integer> q ,Queue<Integer> t) {
		if(q.size()==1) {
			t.add(q.poll());
		}else{
		int no = q.poll();
		reverse(no,q,t);
		t.add(no);
		}
	}

	// Driver code
	public static void main(String args[])
	{
		
	}
}
//This code is contributed by Sumit Ghosh



public class QueueSample {

	// Method to find page faults using FIFO
	static int pageFaults(int pages[], int n, int capacity) {
		// To represent set of current pages. We use
		// an unordered_set so that we quickly check
		// if a page is present in set or not
		HashSet<Integer> s = new HashSet<>(capacity);

		// To store the pages in FIFO manner
		Queue<Integer> indexes = new LinkedList();

		// Start from initial page
		int page_faults = 0;
		for (int i = 0; i < n; i++) {
			// Check if the set can hold more pages
			if (s.size() < capacity) {
				// Insert it into set if not present
				// already which represents page fault
				if (!s.contains(pages[i])) {
					s.add(pages[i]);

					// increment page fault
					page_faults++;

					// Push the current page into the queue
					indexes.add(pages[i]);
				}
			}

			// If the set is full then need to perform FIFO
			// i.e. remove the first page of the queue from
			// set and queue both and insert the current page
			else {
				// Check if current page is not already
				// present in the set
				if (!s.contains(pages[i])) {
					// Pop the first page from the queue
					int val = indexes.peek();

					indexes.poll();

					// Remove the indexes page
					s.remove(val);

					// insert the current page
					s.add(pages[i]);

					// push the current page into
					// the queue
					indexes.add(pages[i]);

					// Increment page faults
					page_faults++;
				}
			}
		}

		return page_faults;
	}

	public static void main(String[] args) {
		/*
		 * Queue1 q = new Queue1(); q.enqueue(8); q.enqueue(7); q.enqueue(9);
		 * q.enqueue(2);
		 * 
		 * q.traverse(); System.out.println("removed element " +q.dequeue());
		 * System.out.println("Add 15");
		 * 
		 * q.enqueue(15); System.out.println("Traverse"); q.traverse();
		 * System.out.println("removed element " +q.dequeue());
		 
		int pages[] = { 7, 0, 1, 1, 0, 3, 0, 4, 2, 3, 0, 3, 2 };

		int capacity = 4;
		System.out.println(pageFaults(pages, pages.length, capacity));
		*/
	Queue<Integer> queue = new LinkedList();
	
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.add(70);
		queue.add(80);
		queue.add(90);
		queue.add(100);
		Queue_reverse.reversequeue(queue);
		
		System.out.println(queue);

	}
}

class LinkList1 {
	Node head = null;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public void add(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
		} else {
			Node tmp = head;
			Node pre = head;
			while (tmp != null) {
				pre = tmp;
				tmp = tmp.next;
			}
			pre.next = n;
		}
	}

	public int remove() {
		if (head == null) {
			System.out.println("Nothing to remove");
			return 0;
		}

		Node tmp = head;
		Node next = tmp.next;
		head = next;
		int re = tmp.data;
		tmp.next = null;
		return re;
	}

	void traverse() {
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
}

class Queue1 {
	int front;
	int rear;
	LinkList1 ls = null;

	public Queue1() {
		front = -1;
		rear = -1;
		ls = new LinkList1();
	}

	public void enqueue(int data) {
		ls.add(data);
	}

	public int dequeue() {
		return ls.remove();
	}

	public void traverse() {
		ls.traverse();
	}
}