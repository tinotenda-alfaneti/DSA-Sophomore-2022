/** Describe in detail an algorithm for reversing a singly linked list L 
using only a constant amount of additional space. */
import java.util.LinkedList;

public class Question5 {

    public static LinkedList<Integer> reverseList(LinkedList<Integer> head){
        int left = 0;
        int right = head.size() - 1;
        while(left < right){

            int temp = head.get(left);
            head.set(left , head.get(right));
            head.set(right, temp);
            left++;right--;
            

        }

        return head;

    }
    public static void main(String[] args) {

        LinkedList<Integer> head = new LinkedList<>();
        head.add(1); head.add(2);head.add(3);head.add(4);
        System.out.println(head);
        System.out.println(Question5.reverseList(head));
    }
    
}
