import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void testFibonacciNumberWithIndex3() throws NegativeNumberException {
        assertEquals(2, Fibonacci.computeRecursive(3));
    }

    @Test
    public void testFibonacciNumberWithIndex5() throws NegativeNumberException {
        assertEquals(5, Fibonacci.computeRecursive(5));
    }

    @Test
    public void testFibonacciNumberWithIndex8() throws NegativeNumberException {
        assertEquals(21, Fibonacci.computeRecursive(8));
    }

    @Test
    public void testNonRecursiveFibonacciNumberWithIndex3() throws NegativeNumberException {
        assertEquals(2, Fibonacci.computeNonRecursive(3));
    }

    @Test
    public void testNonRecursiveFibonacciNumberWithIndex5() throws NegativeNumberException {
        assertEquals(5, Fibonacci.computeNonRecursive(5));
    }

    @Test
    public void testNonRecursiveFibonacciNumberWithIndex8() throws NegativeNumberException {
        assertEquals(21, Fibonacci.computeNonRecursive(8));
    }

    @Test(expected = NegativeNumberException.class)
    public void testIfTheNumberGivenIsGreaterOrEqualThan0OnRecursiveMethod() throws NegativeNumberException {
        Fibonacci.computeRecursive(-1);
    }

    @Test(expected = NegativeNumberException.class)
    public void testIfTheNumberGivenIsGreaterOrEqualThan0OnNonRecursiveMethod() throws NegativeNumberException {
        Fibonacci.computeNonRecursive(-2);
    }
}
