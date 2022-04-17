package DataStructures;

public class DoublyLinkedList<T> {
	/** Nested class to represent the a node that is a value and the next node */
	private class Node<T> {
		private Node<T> next;
		private Node<T> prev;
		private T val;

		/**Constructor
		 * @param next The node to be the next
		 * @param prev The node to be the previous
		 * @param val the value of the node
		 */
		public Node(Node<T> next, Node<T> prev, T val) {
			this.val = val;
			this.next = next;
			this.prev = prev;
		}

		/**Constructor when only one parameter is passed using method overloading
		 * @param val the value of the node
		*/
		public Node(T val) {
			this(null, null, val); // calls the constructor that takes three parameters
		}


		/**Getter method for the value of a node
		 * @return the value of the node
		 */
		public T getVal() {
			return val;
		}

		/**Getter method for the next node
		 * @return the node next to the current node
		 */
		public Node<T> getNext() {
			return next;
		}

		/**Getter method for the previous node
		 * @return the node previous to the current
		 */
		public Node<T> getPrev() {
			return prev;
		}

		/**Modifier method to set tge next node
		 * @param nxt the node to be set to next of the current node
		 */
		public void setNext(Node<T> nxt) {
			next = nxt;
		}

		/**Modifier method to update the previous node
		 * @param prv the node to be set to previous node
		 */
		public void setPrev(Node<T> prv) {
			prev = prv;
		}
	}
	// initializing the dummy nodes
	Node<T> header;
	Node<T> trailer;
	int size = 0;

	/**Constructor of the doubly linked list class */
	public DoublyLinkedList() {

		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer); // updating the next node

	}

	/**Method to add a node between two node
	 * @param first the node to the left 
	 * @param second the node to the right
	 * @param val the value to be inserted between the two
	 */
	private void addBetween(Node<T> first, Node<T> second, T element) {

		Node<T> newNode = new Node<>(second, first, element); // creating the node with the given value
		first.setNext(newNode);
		second.setPrev(newNode);
		size++; // increasing the size
	}

	/**Method to remove a node
	 * @param node the node that is to be removed
	 * @return the value of the removed node
	 */
	private T remove(Node<T> node) {

		Node<T> first = node.getPrev(); 
		Node<T> second = node.getNext();

		// connecting the previous and the next of the given node
		first.setNext(second); 
		second.setPrev(first);
		size--;
		return node.getVal();
	}

	/**Metohsd for adding an item at the first position
	 * @param element the item to be added
	 */
	public void addFirst(T element) {
		addBetween(header, header.getNext(), element); // calling the addBetween method with the dummy node and the first element
	}

	/**Method to add at the end position
	 * @param element the element to be added at the last position
	 */
	public void addLast(T element) {
		addBetween(trailer.getPrev(), trailer, element); // calling addBetween with the element before the trailer node and the trailer
	}

	/**Method to remove the last item
	 * @return The value of the removed node
	 */
	public T removeLast() {

		if (isEmpty()) return null;
		return remove(trailer.getPrev());

	}

	/**Method to remove the first item
	 * @returm the value of the removed node
	 */
	public T removeFirst() {
		if (isEmpty()) return null;
		return remove(header.getNext());
	}

	/**Method to get the size of the list
	 * @return the number of  elements in the list
	 */
	public int size() {
		return size;
	}

	/**Method to test if the list is empty or not
	 * @return true is the list is empty and false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**Method to get the value of the first node
	 * @return the value of the first node
	 */
	public T first() {
		if(isEmpty()) return null;
		return header.getNext().getVal();
	}

	/**Method to get the last element in the list
	 * @return the value of the last node
	 */
	public T last() {
		if(isEmpty()) return null;
		return trailer.getPrev().getVal();
	}

	@Override
	public String toString(){
		Node<T> curr = header.getNext();
		String rep = "[";
		int i = size;

		while (i > 0) {

			if (i - 1 == 0) rep += curr.getVal(); 
			else rep += curr.getVal() + ", ";
			curr = curr.getNext();
			i--;

		}
		return rep + "]";
	}
}


