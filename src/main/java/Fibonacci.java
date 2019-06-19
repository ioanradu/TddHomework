import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {

        int index = 8;
        System.out.print("Non Recursively Fibonacci Series of " + index + " numbers is: ");

        long start = System.currentTimeMillis();
        computeNonRecursive(index);
        //double result = computeNonRecursive(index);
        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("f(" + index + ") = " + " : time = " + (end - start) + "ms");

        System.out.println();
        System.out.print("Recursively Fibonacci Series of " + index + " numbers is: ");

        for (int i = 0; i < index; i++) {
            System.out.print(computeRecursive(i) + " ");
        }

        start = System.currentTimeMillis();
        double result = computeRecursive(index);
        end = System.currentTimeMillis();

        System.out.println();
        System.out.println("f(" + index + ") = " + result + " : time = " + (end - start) + "ms");

    }

    public static void computeNonRecursive(int n) {
        int previousNumber = 0;
        int nextNumber = 1;
        int i = 1;
        while (i <= n) {
            System.out.print(previousNumber + " ");
            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
            i++;
        }
    }

    public static int computeRecursive(int n) {
        if (n < 2) {
            return n;
        } else {
            return computeRecursive(n - 1) + computeRecursive(n - 2);
        }
    }

}
