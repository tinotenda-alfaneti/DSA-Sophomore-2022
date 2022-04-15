package Algorithms;

public class BubbleSort {

    private int[] arrayToSort = new int[10];

    void sort(int[] arr) {

        arrayToSort = arr;
        int n = arr.length -1;

        for (int i = 0; i < n - 1; i++) { // This will repeat n-1 times
            for (int j = 0; j < n - i; j++) { // this will repeat n-2 times
                if (arrayToSort[j] > arrayToSort[j+1]) swap(arrayToSort, j, j+1); // ---------- O(1)
            }
        }

        // Therefore the time complexity is O((n-1)x(n-2)) = O(n^2)

    }

    private void swap(int[] array, int first, int last) {
        int temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }
    
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < arrayToSort.length; i++) {
            res += " " + arrayToSort[i];
        }
        return "{" + res + " }";
    }
    public static void main(String[] args) {
        int[] testArray = {10,2,0,7,8,3,4,5};
        BubbleSort testSort = new BubbleSort();
        testSort.sort(testArray);
        System.out.println(testSort);
    }
}
