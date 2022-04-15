package DataStructures;

/**Implementing a queue using stacks */

import java.util.Stack;

public class QueueStack {

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();


    void enqueue(int e) {
        pushStack.push(e);
    }

    void transfer() {
        while(!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }

    int dequeue() {
        if(popStack.isEmpty()) transfer();
        return popStack.pop();
    }

    public static void main(String[] args) {
        QueueStack Q = new QueueStack();
        Q.enqueue(9);
        Q.enqueue(10);
        Q.enqueue(11);
        Q.enqueue(12);
        System.out.println(Q.dequeue());

    }

}