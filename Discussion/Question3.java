/** Show how to use a stack S and a queue Q to generate all possible 
subsets of an n-element set T non recursively.  */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.Arrays;

public class Question3 {


    public static void generateSubsets() {
        ArrayList<Integer> T = new ArrayList<>();
        ArrayList<int[]> subsets = new ArrayList<>();

        T.add(1); T.add(2); T.add(7); T.add(3);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        int fast = 1;
        int slow = 0;
        while(slow < (T.size() - 1)){
            int[] temp = new int[2];
            if(fast >= (T.size()-1)){
                temp[0] = T.get(slow);
                temp[1] = T.get(fast);
                slow +=1;
                fast = slow + 1;
                
            }
            else{
                temp[0] = T.get(slow);
                temp[1] = T.get(fast);
                fast+=1;

            }
                subsets.add(temp);

        }

        for(int[] arry : subsets){
            fast = 1;
            while(fast < (T.size())){
                int temp = 0;
                fast = T.indexOf(arry[arry.length - 1]) + 1;


            }

        }

        
        for (int[] i : subsets) {
            System.out.println(Arrays.toString(i));
        }

    }
    public static void main(String[] args) {
        Question3.generateSubsets();
    }  
    
}
