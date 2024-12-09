import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExpressionParserTest {

    // Test cases for Task 2: ExpressionParser
    @Test
    public void testExpressionParser() {
        ExpressionParser parser = new ExpressionParser();

        assertEquals(17, parser.evaluateExpression("8 + 3 * 3"), 0.001); // Simple expression
        assertEquals(22, parser.evaluateExpression("(5 + 6) * 2"), 0.001); // Parentheses handling
        assertEquals(6.5, parser.evaluateExpression("8 / 2 + 2.5"), 0.001); // Floating-point division
        assertEquals(27, parser.evaluateExpression("3 * (4 + 5)"), 0.001); // Nested operations
        assertThrows(IllegalArgumentException.class, 
            () -> parser.evaluateExpression("(2 + 5")); // Unbalanced parentheses
        assertEquals(-1, parser.evaluateExpression("5 - 6"), 0.001); // Negative result
        assertEquals(9.0, parser.evaluateExpression("3 + 2 * 5 - 4"), 0.001); // Mixed operators
        assertEquals(2.5, parser.evaluateExpression("10 / 4"), 0.001); // Division with a fraction
        assertEquals(16, parser.evaluateExpression("2 * 4 * 2"), 0.001); // Multiplication chain
        assertEquals(0, parser.evaluateExpression("10 - 10"), 0.001); // Zero result
    }
}
