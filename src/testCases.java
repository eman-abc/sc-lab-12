import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testCases {

    // Test cases for Task 1: Recursive Binary Search
    @Test
    public void testRecursiveBinarySearch() {
        RecursiveBinarySearch binarySearch = new RecursiveBinarySearch();

        assertEquals(2, binarySearch.binarySearchRecursive(new int[]{2, 5, 8, 10, 15}, 8)); // Find 8 in the array
        assertEquals(0, binarySearch.binarySearchRecursive(new int[]{1, 3, 5, 7, 9}, 1)); // Target is the first element
        assertEquals(-1, binarySearch.binarySearchRecursive(new int[]{11, 22, 33, 44}, 5)); // Target not found
        assertEquals(4, binarySearch.binarySearchRecursive(new int[]{10, 20, 30, 40, 50}, 50)); // Target is the last element
        assertEquals(3, binarySearch.binarySearchRecursive(new int[]{3, 5, 7, 9, 11}, 9)); // Middle element
        assertThrows(IllegalArgumentException.class, 
            () -> binarySearch.binarySearchRecursive(null, 5)); // Handle null array
        assertThrows(IllegalArgumentException.class, 
            () -> binarySearch.binarySearchRecursive(new int[]{}, 5)); // Handle empty array
        assertEquals(-1, binarySearch.binarySearchRecursive(new int[]{4, 8, 15, 16, 23, 42}, 21)); // Non-existent target
        assertEquals(2, binarySearch.binarySearchRecursive(new int[]{0, 2, 4, 6, 8}, 4)); // Even numbers
        assertEquals(0, binarySearch.binarySearchRecursive(new int[]{-10, -5, 0, 5, 10}, -10)); // Handle negative numbers
    }

    // Test cases for Task 1: Recursive Binary Search (For Strings)
    @Test
    public void testBinarySearchRecursiveForStrings() {
        RecursiveBinarySearch binarySearch = new RecursiveBinarySearch();

        assertEquals(1, binarySearch.binarySearchRecursive(new String[]{"apple", "banana", "cherry"}, "banana")); // Middle element
        assertEquals(0, binarySearch.binarySearchRecursive(new String[]{"dog", "elephant", "zebra"}, "dog")); // Target at the start
        assertEquals(2, binarySearch.binarySearchRecursive(new String[]{"car", "plane", "train"}, "train")); // Target at the end
        assertEquals(-1, binarySearch.binarySearchRecursive(new String[]{"cat", "dog", "mouse"}, "bird")); // Target not in array
        assertThrows(IllegalArgumentException.class, 
            () -> binarySearch.binarySearchRecursive(null, "test")); // Null array
        assertThrows(IllegalArgumentException.class, 
            () -> binarySearch.binarySearchRecursive(new String[]{}, "test")); // Empty array
        assertEquals(0, binarySearch.binarySearchRecursive(new String[]{"apple", "banana"}, "apple")); // Only two elements
        assertEquals(-1, binarySearch.binarySearchRecursive(new String[]{"ant", "bee", "cat"}, "dog")); // Non-existent string
        assertEquals(3, binarySearch.binarySearchRecursive(new String[]{"ant", "bee", "cat", "dog"}, "dog")); // Last element in sorted array
    }

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
