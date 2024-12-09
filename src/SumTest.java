import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SumTest {

    // Test cases for Task 3: SumOfDigits
    @Test
    public void testSumOfDigits() {
        Sum calculator = new Sum();

        assertEquals(15, calculator.sum(12345)); // Sum of digits of 12345
        assertEquals(6, calculator.sum(6)); // Single-digit number
        assertEquals(10, calculator.sum(-55)); // Handle negative numbers
        assertEquals(0, calculator.sum(0)); // Zero case
        assertEquals(27, calculator.sum(999)); // All digits same
        assertEquals(45, calculator.sum(123456789)); // Large number
        assertEquals(19, calculator.sum(199)); // Mixed digits
        assertEquals(1, calculator.sum(1000)); // Includes zero digits
        assertEquals(27, calculator.sum(-999)); // Negative number with large digits
        assertEquals(36, calculator.sum(9999)); // Edge case with four same digits
    }
}
