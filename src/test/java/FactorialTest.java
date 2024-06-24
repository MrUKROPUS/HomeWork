import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.factorial(0), 1, "Факториал нуля должен быть равен 1");
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Factorial.factorial(1), 1, "Факториал единицы должен быть равен 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(Factorial.factorial(5), 120, "Факториал пяти должен быть равен 120");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        Factorial.factorial(-1);
    }

    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(Factorial.factorial(10), 3628800, "Факториал десяти должен быть равен 3628800");
    }
}
