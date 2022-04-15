package Algorithms;


public class QuickSort{

    private int[] arr = new int[10];

    void sort(int[] a, int start, int end) {

        arr = a;

        // Base case
        if(start >= end) return;
        
        // recursive call
        int pInx = partition(arr, start, end); // ---------- O(n)
        sort(arr, start, pInx - 1); // ------------ O(log n)
        sort(arr, pInx + 1, end); // ---------- O(log n)

        // Totol runtime complexity = O(n x log n) = O(n log n)
        // Space complexity = O(1) It's doing the sorting in place
    }

    void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private int partition(int[] arr, int s, int e) {

        int pivot = arr[e];
        int pInt = s;
        for(int i = s; i < e; i++) { // ----------- O(n)
            if(arr[i] <= pivot) {

                swap(arr, pInt, i); //------------- O(1)
    
                pInt++; // --------------- O(1)
            }
        }
        swap(arr, pInt, e);
        return pInt;   
    }

    private void swap(int[] array, int first, int last) {

        int temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res += " " + arr[i];
        }
        return "{" + res + " }";
    }

    public static void main(String[] args) {
        int[] testArray = {10,2,0,7,8,3,4,5};
        QuickSort testSort = new QuickSort();
        testSort.sort(testArray);
        System.out.println(testSort);
    }
}