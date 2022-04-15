package DataStructures;

public class Factorial{

    int calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();

        } else if (n == 0 || n == 1) {
             return n;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    int calculateFactorialOneLiner(int n) {
        return (n == 0 || n == 1) ? n : n * calculateFactorialOneLiner( n - 1);
    }

    public static void main(String[] args){

        Factorial test = new Factorial();
        System.out.println(test.calculateFactorial(5));

        System.out.println(test.calculateFactorialOneLiner(5));

    }
}