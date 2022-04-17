package Algorithms;

public class RecursionPalindrome {

    public static boolean isPalindrome(String word) {

        // Base cases
        if (word == null) return false;
        if (word.length() <= 1) return true;
        
        String first = word.substring(0,1).toLowerCase();
        String last = word.substring(word.length() - 1, word.length()).toLowerCase();

        if (!first.equals(last)) return false; // --------- O(1)

        // Recursive case

        else return isPalindrome(word.substring(1, word.length()-1)); // will repeat n/2 times

        // Time complexity - O(n) 

    }



    public static void main(String[] args) {
        

        System.out.println(isPalindrome("madam"));

        System.out.println(isPalindrome("refer"));

        System.out.println(isPalindrome("Racecar"));
    }
}