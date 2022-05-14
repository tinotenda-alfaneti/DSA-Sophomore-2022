/**C - 6.20 Suppose you have three nonempty stacks R, S, and T. Describe a 
sequence of operations that results in S storing all elements originally in T 
below all of S’s original elements, with both sets of those elements in their 
original order. The final configuration for R should be the same as its 
original configuration. For example, if R = (1,2,3), S = (4,5), and T = (6,7,8,9), 
when ordered from bottom to top, then the final configuration should have 
R = (1, 2, 3) and S = (6, 7, 8, 9, 4, 5).  */

import java.util.Stack;

public class Question1 {

    public static Stack<Integer> shiftElements(Stack<Integer> R, Stack<Integer> S, Stack<Integer> T) {
     
        int lenS = S.size();
        int lenT = T.size();
    
        for(int i = 0; i<lenS; i++) {
            R.push(S.pop());
        }

        for (int i = 0; i<lenT; i++) {
            R.push(T.pop());
        }

        for (int i = 0; i<(lenT+lenS); i++) {
            S.push(R.pop());
        }

        return S;

    }

    public static void main(String[] args) {
        Stack<Integer> R = new Stack<>();
        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();
        R.push(1); R.push(2); R.push(3);
        S.push(4); S.push(5);
        T.push(6);T.push(7);T.push(8);T.push(9);

        System.out.println(shiftElements(R,S,T));
        
    }


}