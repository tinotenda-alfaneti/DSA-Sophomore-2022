/** Let B be an array of size n ≥ 6 containing integers from 1 to n−5 inclusive, five
of which are repeated. Describe an algorithm for finding the five integers in B
that are repeated. 

Algorithm/Pseudocode
Step 1: Input array arr, initialize n := length of arr, num = -1, res
Step 2: for (i := 1 to n)
    if arr(i - 1) = arr(i) then  num = arr(i)
Step 3: for (i := 1 to n)
    if arr(i) = num then add to res
Step 4: return res


*/

public class FindDuplicate {

    public static void getDuplicates(int[] arr) {
        int n = arr.length;
        int dup = -1;

        int count = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count += 1;
                    dup = arr[i];
                }
            }
        }

        System.out.println("The number " + dup + " is duplicated "  + count + " times");
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,6,3,3,5};
        getDuplicates(arr);
    }
    
}
