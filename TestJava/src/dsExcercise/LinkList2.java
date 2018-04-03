package dsExcercise;

class LinkList {
	Node head;

	public LinkList() {
		head = new Node();
	}

	static class Node {
		int data;
		Node next;

		Node() {
		}

		Node(int d) {
			data = d;
		}
	}

	public void insertLast(int d) {
		Node node = new Node(d);
		Node temp = head;
		if (head.next == null) {
			head.next = node;
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public void insertFirst(int d) {
		Node node = new Node(d);
		Node temp = head.next;
		if (head.next == null) {
			head.next = node;
		} else {
			head.next = node;
			node.next = temp;
		}
	}

	public void traverse() {
		Node tmp = head.next;
		while (tmp != null) {
			System.out.print(tmp.data + "-->");
			tmp = tmp.next;
		}
	}

	public void reverse() {
		Node pre = null;
		Node next = null;
		Node current = head.next;
		if (current == null)
			System.out.println("List is empty");
		while (current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		head.next = pre;
	}

	public void reverseInChunks(int k) {
		Node pre = null;
		Node next = null;
		Node current = head.next;
		int count = 0;
		if (current == null)
			System.out.println("List is empty");
		while (current != null) {
			if (count % k != 0) {
				next = current.next;
				current.next = pre;
				pre = current;
				current = next;
			}
			current = current.next;
			count++;
		}
		head.next = pre;
	}

}
// Java program to reverse a doubly linked list

class DLinkedList {

	static Node head;

	static class Node {

		int data;
		Node next, prev;

		Node(int d) {
			data = d;
			next = prev = null;
		}
	}
	
	
	public void reverse() {
		Node current = head.next;
		Node next = current.next;
		Node pre = head.prev;
		
		while(current!= null) {
			current.next = pre;
			current.prev = next;
			
		}
	}
}

public class LinkList2 {
	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.insertLast(1);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(5);
		list.insertFirst(7);
		list.insertFirst(6);
		list.traverse();
		System.out.println("after reverse");
		list.reverse();
		list.traverse();
		System.out.println("after reverse 2");
		list.reverseInChunks(3);
		list.traverse();

	}
}