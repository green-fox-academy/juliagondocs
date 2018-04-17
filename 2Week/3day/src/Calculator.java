import java.util.Scanner;


public class Calculator {
    public static void main(String... args) {
        // Create a simple calculator application which reads the parameters from the prompt
        // and prints the result to the prompt.
        // It should support the following operations,
        // create a method named "calculate()":
        // +, -, *, /, % and it should support two operands.
        // The format of the expressions must be: {operation} {operand} {operand}.
        // Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

        // You can use the Scanner class
        // It should work like this:

        // Start the program
        // It prints: "Please type in the expression:"
        // Waits for the user input
        // Print the result to the prompt
        // Exit
        System.out.println("Please type in the expression (Example: * 4 4 ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String array[] = s.split(" ");

        String operation = array[0];
        int part1 = Integer.parseInt(array[1]);
        int part2 = Integer.parseInt(array[2]);
        System.out.println(operation + " " + part1 + " " + part2);

        System.out.println("Result: " + calculate(operation, part1, part2));
    }

    public static double calculate(String operation, int operand1, int operand2) {
        double result = 0;
        if (operation.equals("+")) {
            result = (double) operand1 + (double) operand2;
        }
        if (operation.equals("-")) {
            result = (double) operand1 - (double) operand2;
        }
        if (operation.equals("*")) {
            result = (double) operand1 * (double) operand2;
        }
        if (operation.equals("/")) {
            result = (double) operand1 / (double) operand2;
        }
        if (operation.equals("%")) {
            result = (double) operand1 % (double) operand2;
        }
        return result;
    }
}