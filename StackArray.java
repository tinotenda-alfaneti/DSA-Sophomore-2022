
/**Implement a stack using an array */
public class StackArray {
    
    int[] stack = {0};
    int top = -1;
    int size = 0;

    /**Constructor
     * @param stack The array to be converted to an array
     */
    public StackArray(int[] stack) {
        this.stack = stack;
        top = stack.length - 1;
        size = stack.length;

    }

    /**Constructor to use when no argument is passed
     */
    public StackArray() {
    }

    /**Method to add an element to the stack
     * @param e the element to the added to the stack
     */
    void push(int e) {
        if (top == stack.length - 1) helper(); // increasing the stack size when it is full
        top++;
        stack[top] = e;
        size++;

    }

    /**Method to remove an element from the stack
     * @return the value of the element that was removed
     */
    int pop() throws IllegalStateException {
        if (size == 0) throw new IllegalStateException("Stack is Empty");
        int removed = stack[top];
        stack[top] = 0;
        top--;
        size--;
        return removed;
    }

    /**Method to check if the stack is empty or not
     * @return true or false depending on whether the stack is empty  or not
     */
    boolean isEmpty() {
        return size == 0;
    }

    /**Method to check the element at the top of the stack
     * @return the value of the first element in the stack
     */
    int peek() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("Stack is Empty"); 
        return stack[0];
    }
    
    /**Helper method to increase the size of the stack */
    private void helper() {
        int[] newStack = new int[2*stack.length]; // multiplying the stack length by 2

        for(int i = 0; i<stack.length; i++) { // copying the elements to the new stacks
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    @Override
    public String toString() {
        String stringRep = "";
        for(int i=0; i<size; i++) {
            if (i == (size -1)) stringRep += stack[i];
            else stringRep += (stack[i] + ",");
        }
        return "{" + stringRep + "}";
    }

    /** TESTING */
    public static void main(String[] args) {
        StackArray testStack = new StackArray();
        testStack.push(5);
        testStack.push(15);
        testStack.pop();
        System.out.println(testStack);
    }

}
