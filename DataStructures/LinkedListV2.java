package DataStructures;

public class LinkedListV2<T> {

    Node<T> head;
    Node<T> tail; // keeping track of the last element
    int numItems = 0;

    // -------- nested class for Nonde implementation ------
    class Node<T> {
        T val;
        Node next;

        /** Contructor method
         * @param val the value for the Node
         * @param next the next Node*/
        public Node(T val, Node next) {
            this.val = val;
            this.next = next; 
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
        if (head == null) return null;
        return tail;
    }

    Node<T> getHead() {
        if (head == null) return null;
        return head;

    }

    void addFirst(T element) {
        head = new Node<> (element, head);
        if (size() == 2) tail = head.next;
        numItems++;
    }

    void addLast(T element) {
        Node<T> newNode = new Node<>(element);

        if (size() < 2) {
            head.next = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }

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

    public static void main(String[] args) {
        LinkedListV2<Integer> myList = new LinkedListV2<>();
        myList.addFirst(10);
        myList.addLast(20);
        myList.addFirst(5);
        myList.addLast(25);
        myList.addLast(30);
        myList.addFirst(1);

        System.out.println(myList);
        System.out.println("Tail: " +myList.getTail().val);
        System.out.println("Head: " + myList.getHead().val);

    }
}

