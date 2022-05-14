/**Alice has three array-based stacks, A, B, and C, such that A has 
capacity 100, B has capacity 5, and C has capacity 3. Initially, A is full, and B 
and C are empty. Unfortunately, the person who programmed the class for 
these stacks made the push and pop methods private. The only method 
Alice can use is a static method, dump(S, T ), which transfers (by iteratively 
applying the private pop and push methods) elements from stack S to stack 
T until either S becomes empty or T becomes full. So, for example, starting 
from our initial configuration and performing dump(A,C) results in A now 
holding 97 elements and C holding 3. Describe a sequence of dump 
operations that starts from the initial configuration and results in B holding
4 elements at the end. */

/**
 * First Step dump(A, B) A = 95, B = 5
 * Second Step dump(B, C) B = 2, C= 3
 * Third Step dump(A, C) A = 98, C= 0
 * Fourth Step dump(B, C) B = 0, C = 2
 * Fifth Step dump(A, B) A = 93, B = 5
 * Sixth Step dump(B, C) B = 4, C = 3
 */


public class Question2 {

    public static void main(String[] args) {
        System.out.println("DONE");
    }
    
}
