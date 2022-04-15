package DataStructures;

/**
 The stack abstract data type implementation using linked list.
 This is achieved by using the removing first and adding on head primary methods of
 a linked list. Having a reference to the tail is this case is redundant, since all primary
 methods can be achieved by leveraging on the head node.
 */

// Stack generic class
public class Stack<T> {

    Node top;
    int size=0;

    // nested class to implement the Node
    private class Node {
        T value;
        Node next;
        
        // constructors for the Node class
        Node(T val, Node nxt) {
            this.value = val;
            this.next = nxt;
        }
        Node (T val) {
            this(val, null);
        }
    }

    /**Constructor for the stack class */
    public Stack(T value){
        top = new Node(value);
        // incrementing the size on initialization since the class is initialised with value
        size++;

    }

    /**popping method 
     * @return The value of the removed node
    */
    T pop() {
        if (size < 1) return null;
        else {
            Node oldTop = top;
            top = top.next;
            size--;
            return oldTop.value;
        }  
    }

    /**@param val The value to be pushed/inserted into the stack
     */
    void push(T val) {
        Node newTop = new Node(val, top);
        top = newTop;
        size++;
    }

    /**Method to check if the stack is empty
     * @return true if the stack is empty
     */
    boolean empty() {
        if (size < 1) return true;
        else{
            return false;
        }
    }

    /**Accessing the value at the top of the stack
     * @return the value on the top node
     */
    T peek() {
        if (size < 1) return null;
        else {
            return top.value;
        }
    }

    /**Searching for the presence of given value in the stack
     * @param val The value to be searched
     * @return the position of the value and -1 if not found
     */

    int search(T val) {
        Node curr = top;
        int pos = 0;
        while (curr != null) {
            if(curr.value.equals(val)) return pos;
            curr = curr.next;
            pos++;
        }
        return -1;
    }

    public static void main(String[] args){
        Stack<Integer> test = new Stack<>(10);
        test.push(5);
        System.out.println(test.peek());
        System.out.println(test.search(10));
    }

}