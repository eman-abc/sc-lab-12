import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecursiveBinarySearch binarySearch = new RecursiveBinarySearch();
        ExpressionParser expressionParser = new ExpressionParser();
        Sum sumCalculator = new Sum();

        while (true) {
            System.out.println("\n--- Recursion Program (Lab 12) ---");
            System.out.println("1. Recursive Binary Search (Integers)");
            System.out.println("2. Recursive Binary Search (Strings)");
            System.out.println("3. Evaluate Mathematical Expression");
            System.out.println("4. Calculate Sum of Digits");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Recursive Binary Search (Integers)
                    System.out.println("\n--- Recursive Binary Search (Integers) ---");
                    System.out.print("Enter the array elements (comma-separated): ");
                    String inputArray = scanner.nextLine();
                    int[] intArray = parseIntArray(inputArray);

                    System.out.print("Enter the target value: ");
                    int targetInt = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    try {
                        int result = binarySearch.binarySearchRecursive(intArray, targetInt);
                        if (result != -1) {
                            System.out.println("Target found at index: " + result);
                        } else {
                            System.out.println("Target not found.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2: // Recursive Binary Search (Strings)
                    System.out.println("\n--- Recursive Binary Search (Strings) ---");
                    System.out.print("Enter the array elements (comma-separated): ");
                    String[] strArray = parseStringArray(scanner.nextLine());

                    System.out.print("Enter the target value: ");
                    String targetStr = scanner.nextLine();

                    try {
                        int result = binarySearch.binarySearchRecursive(strArray, targetStr);
                        if (result != -1) {
                            System.out.println("Target found at index: " + result);
                        } else {
                            System.out.println("Target not found.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3: // Evaluate Mathematical Expression
                    System.out.println("\n--- Evaluate Mathematical Expression ---");
                    System.out.print("Enter a mathematical expression: ");
                    String expression = scanner.nextLine();

                    try {
                        double result = expressionParser.evaluateExpression(expression);
                        System.out.println("Result: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4: // Calculate Sum of Digits
                    System.out.println("\n--- Calculate Sum of Digits ---");
                    System.out.print("Enter a number: ");
                    int number = scanner.nextInt();

                    int sumResult = sumCalculator.sum(number);
                    System.out.println("Sum of digits: " + sumResult);
                    break;

                case 5: // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper method to parse a comma-separated string into an int array
    private static int[] parseIntArray(String input) {
        String[] parts = input.split(",");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i].trim());
        }
        return array;
    }

    // Helper method to parse a comma-separated string into a String array
    private static String[] parseStringArray(String input) {
        return input.split(",");
    }
}
