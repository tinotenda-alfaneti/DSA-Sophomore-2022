package Algorithms;

public class SelectionSort {

    private int[] arr = new int[10];

    public void sort(int[] arrToSort) {
        arr = arrToSort;

        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            int minVal = arr[i];
            int minIndex = i;

            // Looking for the minimum value in the array
            for (int j = minIndex + 1; j<len; j++) {
                if(arr[j] < minVal) {
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            // Swapping
            int temp = arr[i];
            arr[i] = minVal;
            arr[minIndex] = temp;
        }
    }

    @Override
    public String toString() {
        String res = "{";
        for(int num : arr) {
            res += " " + num;
        }
        return res + " }";
    }

    public static void main(String[] args) {
        int[] myArr = {9, 7, 8, 6, 5, 4, 3, 2, 1};

        SelectionSort arrayTest = new SelectionSort();
        arrayTest.sort(myArr);
        System.out.println(arrayTest);
    }
    
}
