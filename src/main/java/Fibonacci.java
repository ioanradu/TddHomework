public class Fibonacci {
    public static void main(String[] args) throws NegativeNumberException {

        int index = 5;
        System.out.print("Non Recursively Fibonacci Series of " + index + " numbers is: ");

        long start = System.currentTimeMillis();

        double result = computeNonRecursive(index);
        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("f(" + index + ") = " + result + " : time = " + (end - start) + "ms");

        System.out.println();
        System.out.print("Recursively Fibonacci Series of " + index + " numbers is: ");

        /*for (int i = 0; i < index; i++) {
            System.out.print(computeRecursive(i) + " ");
        }*/

        start = System.currentTimeMillis();
        result = computeRecursive(index);
        end = System.currentTimeMillis();

        System.out.println();
        System.out.println("f(" + index + ") = " + result + " : time = " + (end - start) + "ms");

    }

    public static int computeNonRecursive(int n) throws NegativeNumberException {
        if (n < 0) {
            throw new NegativeNumberException("The negative numbers are not allowed!");
        }

        int sum = 0;

        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        int previousNumber = 0;
        int nextNumber = 1;
        int i = 1;
        while (i < n) {
            sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
            i++;
        }
        return sum;

    }

    public static int computeRecursive(int n) throws NegativeNumberException {
        if (n < 0) {
            throw new NegativeNumberException("The negative numbers are not allowed!");
        }
        if (n < 2) {
            return n;
        } else {
            return computeRecursive(n - 1) + computeRecursive(n - 2);
        }
    }
}
