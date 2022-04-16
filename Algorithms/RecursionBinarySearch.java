public class RecursionBinarySearch {


    boolean binarySearch(int[] nums, int target, int low, int high) {

        // Base case
        if (low >= high) return false;

        // Recursive case
        else {
            int mid = (low + high)/2;
            if(target == nums[mid]) return true;
            else if (target < nums[mid]) return binarySearch(nums, target, low, mid -1);
            else return binarySearch(nums, target, mid + 1, high);
        }
    }

    boolean binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length);
    }
    
    public static void main(String[] args) {
        System.out.println("Binary Search");
        int[] arr = {1, 2, 3, 4, 5, 6};
        RecursionBinarySearch test = new RecursionBinarySearch();
        System.out.println(test.binarySearch(arr, 0));
    }
}
