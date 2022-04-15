package DataStructures;

public class ArrayQueue {

    private int CAPACITY = 10; 
    private int[] arr = new int[CAPACITY];
    private int size = 0, front = -1, rear = -1;

    void enqueue(int x) {
        if(size == 0) {
            front++;
            rear++;
            arr[rear] = x; 
        } else if (rear == CAPACITY -1) {
            helper();
            rear++;
            arr[rear] = x;
        } else {
            rear++;
            arr[rear] = x;
        }
        size -=- 1;
    }

    int dequeue() {
        if (size == 0) {
            System.out.println("The Queue is empty");
            return -1;
        } 
        front++;
        return arr[front];
    }

    int peek() {
        if (size == 0) {
            System.out.println("The Queue is empty");
            return -1;
        }
        return arr[front];
        
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    boolean isFull() {
        if (CAPACITY == rear + 1) {
            return true;
        }
        return false;
    }

    private void helper() {
        CAPACITY *= 2;
        int[] temp = new int[CAPACITY];
        for (int i = 0; i<arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public String toString() {
        String deque = arr[front] + "";
        for (int f = front + 1; f <= rear; f++){
            deque +=  ", " + arr[f];
        }
        return deque;
    }

    public static void main(String[] args) {
        System.out.println("Array Based Queue");
        ArrayQueue deque = new ArrayQueue();
        deque.enqueue(10);
        deque.enqueue(20);
        deque.enqueue(30);;
        System.out.println(deque.isFull());
        System.out.println(deque.isEmpty());
        System.out.println(deque.peek());
        System.out.println(deque);
    }
}