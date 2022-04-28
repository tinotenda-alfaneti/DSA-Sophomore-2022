package Algorithms;

public class InsertionSort {

    int[] array;

    public void sort(int[] arrToSort) {
        array = arrToSort;

        int len = array.length;

        for (int i = 1; i < len; i++) {
            int j = i;
            while(j > 0 && array[j] < array[j - 1]) {
                int temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }
    @Override
    public String toString() {
        String res = "{";
        for(int num : array) {
            res += " " + num;
        }
        return res + " }";
    }
    public static void main(String[] args) {
        int[] myArr = {9, 7, 8, 6, 5, 4, 3, 2, 1};

        InsertionSort arrayTest = new InsertionSort();
        arrayTest.sort(myArr);
        System.out.println(arrayTest);
    }


    
}
