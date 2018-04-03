package dsExcercise;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		ls.insertFirst(1);
		ls.insertFirst(2);
		ls.insertLast(3);
		ls.insertLast(4);
		ls.insertFirst(5);
		ls.insertFirst(6);
		ls.insertFirst(7);
		ls.insertLast(8);
		ls.insertLast(9);
		ls.traverse();
		System.out.println("After delete");
		
		ls.reverseInChunks(3);
		ls.traverse();
	}
}

// Linked List Class
class LinkedList {
	Node head = new Node(0); // head of list

	/* Node Class */
	class Node {
		int data;
		Node next;

		// Constructor to create a new node
		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void insertLast(int data) {
		Node n = new Node(data);
		Node temp = head;
		// System.out.println("head-->" + head + " " + head.next);
		// System.out.println("temp-->" + temp + " " + temp.next);
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = n;
		// System.out.println("head-->" + head + " " + head.next);
		// System.out.println("temp-->" + temp + " " + temp.next);
	}

	public void insertFirst(int data) {
		Node n = new Node(data);
		if (head.next != null) {
			n.next = head.next;
			head.next = n;
		} else {
			head.next = n;
		}
	}

	public void delete(int data) {
		Node tmp = head.next;
		Node pre = head;
		while (tmp != null) {
			if (tmp.data == data) {
				pre.next = tmp.next;
				break;
			}
			pre = tmp;
			tmp = tmp.next;
		}

	}

	public void traverse() {
		Node tmp = head.next;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}

	public void reverse() {
		Node temp = head.next;
		Node pre = null;
		Node current = head.next;
		while (temp != null) {
			current.next = pre;
			pre = temp.next;
			temp.next = current;

		}
	}

	public void reverseInChunks(int a) {
		   Node prev = null;
	        Node current = head;
	        Node next = null;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        head = prev;
	}
	public void removeDuplicate() {
		Node pre = null;
		Node current = head;
		while(current!= null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
			}
			current = current.next;
		}
	}
	Node sortedMerge(Node a, Node b) 
    {
		Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;
 
        /* Pick either a or b, and recur */
        if (a.data <= b.data) 
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        } 
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
 
    }
	
	public Node getMiddle(Node hd) {
		Node slowptr = hd;
		Node fastptr = hd.next;
		
		while(fastptr!= null) {
			fastptr = fastptr.next;
			if(fastptr != null) {
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}
			return slowptr;
		}
		
}