package DataStructures;

public class LinkedList<T> {
    Node<T> head;
	int numItems = 0;

	// -------- nested class for Node implementation ------
	class Node<T> {
		T val;
		Node next;

		/** Contructor method
		 * @param val the value for the Node
		 * @param next the next Node*/
		public Node(T val, Node next) {
			this.val = val;
			this.next = next;
			numItems++; 
		}

		public Node(T val) {
			this(val, null);
		}

		public Node() {} 
	}

	// size of the linkedlist
	int size() {
		return numItems;
	}

	// checking if the linked list is empty
	boolean isEmpty() {
		return numItems == 0;
	}

	// getting the tail
	Node<T> getTail() {
		Node<T> tail = new Node<>();
		if (head == null) return null;
		Node<T> curr = head;
		while (curr != null) {
			if (curr.next == null) {
				tail = curr;
				break;
			}
			curr = curr.next;
		}
		return tail;
	}

	Node<T> getHead() {
		if (head == null) return null;
		return head;

	}

	void add(T element) {
		head = new Node<> (element, head);
		numItems++;
	}

	@Override
	public String toString() {
		String rep = "";
		Node<T> curr = head;
		while(curr != null) {
			if(curr.next == null) rep += curr.val;
			else rep += curr.val + ",";
			curr = curr.next;
		}

		return rep;
	}
    
}
