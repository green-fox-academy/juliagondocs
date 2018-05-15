import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void testFibonacci () {
        assertTrue(Fibonacci.fibonacci(10)== (float) 55);
    }
}