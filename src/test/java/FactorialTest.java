import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0), "Факториал нуля должен быть равен 1");
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, Factorial.factorial(1), "Факториал единицы должен быть равен 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, Factorial.factorial(5), "Факториал пяти должен быть равен 120");
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-1);
        });
        assertEquals("Факториал не определен для отрицательных чисел.", exception.getMessage());
    }

    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(3628800, Factorial.factorial(10), "Факториал десяти должен быть равен 3628800");
    }
}
