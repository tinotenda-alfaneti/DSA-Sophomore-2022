package DataStructures;

public class Queue<T> {

    class Node {
        T val;
        Node next;

        Node(T val) {
            this.val = val;
            this.next = null;
        }

        Node() {
            this(null);
        }
    }

    int size = 0;
    Node first;
    Node last;

    void enque(T val) {
        Node newNode = new Node(val);
        if(size == 0){
            
            last = newNode;
            first = last;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    T deque() {
        if(size == 0) return null;

        T value = first.val;
        first = first.next;
        size--;
        return value;
    }

    T peek() {
        if(size == 0) return null;
        return first.val;
    }

    public static void main(String[] args) {
        Queue<Integer> testQueue = new Queue<>();
        testQueue.enque(10);
        System.out.println(testQueue.deque());
    }
}