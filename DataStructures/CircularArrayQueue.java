package DataStructures;

public class CircularArrayQueue {

    int size = 0, front = -1, rear = -1;
    int[] que;
    
    // constructor that initializes the queue size
    public CircularArrayQueue(int capacity) {
        que = new int[capacity];
    }

    /**Adding to the queue
     * @param e Number to add to the queue
      */
    void enqueue(int e) throws IllegalStateException {
        if (size == que.length) throw new IllegalStateException("Queue is full");
        rear = (rear + 1) % que.length;
        if (size == 0) {
            que[rear] = e;
            front = (front + 1) % que.length;
        } else {
            que[rear] = e;
        } 
        size++;
    }

    /**Removing an element in the queue
     * @return the element that was removed
     */

    int dequeue() throws IllegalStateException {
        if (size == 0) throw new IllegalStateException("Queue is Empty");
        int removed = que[front];
        front = (front + 1) % que.length;
        size--;
        return removed;

    }

    public String toString() {
        String strQue = "";
        for (int i = 0; i < que.length; i++){
            if (i == que.length - 1){
                strQue += que[i];
                continue;
            }
            strQue +=  que[i] + ", ";
        }
        return strQue;
    }

    public static void main(String[] args) {
        System.out.println("Circular Array Queue");
        CircularArrayQueue testQueue = new CircularArrayQueue(4);
        testQueue.enqueue(1);
        testQueue.enqueue(2);
        testQueue.enqueue(3);
        testQueue.enqueue(4);
        System.out.println(testQueue.dequeue());
        testQueue.enqueue(5);
        System.out.println(testQueue);

    }
}