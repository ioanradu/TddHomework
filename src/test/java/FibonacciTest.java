import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    private Fibonacci fibonacci;

    @Before
    public void init(){
        fibonacci = new Fibonacci();
    }

    @Test
    public void testTheFirstThreeFibonacciNumbers(){
        assertEquals(2, fibonacci.computeRecursive(3));
    }

    @Test
    public void testTheFirstFiveFibonacciNumbers(){
        assertEquals(5, fibonacci.computeRecursive(5));
    }

    @Test
    public void testTheFirstEightFibonacciNumbers(){
        assertEquals(21, fibonacci.computeRecursive(8));
    }


}
