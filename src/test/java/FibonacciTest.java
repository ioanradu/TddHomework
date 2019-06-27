import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FibonacciTest {
    @Parameterized.Parameters
    public static Collection<Integer[]> parameters() {
        return Arrays.asList(new Integer[][]{
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
                {7, 13},
                {8, 21},
                {9, 34},
                {10, 55}
        });
    }

    @Parameterized.Parameter(0)
    public int index;
    @Parameterized.Parameter(1)
    public int value;

    @Test
    public void testFibonacciRecursiveParametrized() throws NegativeNumberException {
        assertEquals(value, Fibonacci.computeRecursive(index));
    }

    @Test
    public void testFibonacciNonRecursiveParametrized() throws NegativeNumberException {
        assertEquals(value, Fibonacci.computeNonRecursive(index));
    }

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
