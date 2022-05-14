/* Suppose you have a stack S containing n elements and a queue Q 
that is initially empty. Describe how you can use Q to scan S to see if it 
contains a certain element x, with the additional constraint that your 
algorithm must return the el- ements back to S in their original order. You 
may only use S, Q, and a constant number of other primitive variables. */
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Question4{
    public boolean CheckElement(Stack<Integer> S, int k){
        Queue<Integer> Q = new LinkedList<>();

        int x = 0;
        int y = 0;
        
        if(S.peek() == k) return true;

        while(!S.isEmpty()){
           int removed = S.pop();
           y++;
           if (removed == k) {
               S.push(removed);
               x = --y;
               break;
           }
            Q.add(removed);
        }
        
        if(x != 0){
            S = helper(S, Q, x);
            System.out.println(x);
            for(int i = 0; i<x; i++){
                Q.add(S.pop());
            }
            S = helper(S, Q, x);
            System.out.println(S);
            return true;

        }
        System.out.println(S);
        return false;


    }
    Stack<Integer> helper(Stack<Integer> S, Queue<Integer> Q, int i){
        for(int x = 0; x< i; x++){
            S.push(Q.remove());
        }
        return S;

    }

public static void main(String [] args){
    Question4 answer = new Question4();
    Stack<Integer> S = new Stack<>();
    S.push(1);S.push(2);S.push(3);S.push(4);S.push(5);S.push(6);S.push(7);
    int X = 6;
    System.out.println(answer.CheckElement(S, X));

    }
}