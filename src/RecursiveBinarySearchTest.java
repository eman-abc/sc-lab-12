import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecursiveBinarySearchTest {

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
}
