// SumOfDigits.java
public class Sum {
    public int sum(int number) {
        // Handle negative numbers
        if (number < 0) number = -number;

        // Base case
        if (number == 0) return 0;

        // Recursive case
        return (number % 10) + sum(number / 10);
    }
}
