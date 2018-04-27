import java.util.Scanner;

public class Divider {
    public static void main(String[] args) {
        // Create a function that takes a number
        // divides ten with it,
        // and prints the result.
        // It should print "fail" if the parameter is 0
        Scanner scanner = new Scanner(System.in);
        int divisor = scanner.nextInt();
        divider(divisor);
    }

    public static void divider(double inputNumber) {
        try {
            int result = 10 / (int) inputNumber;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero!");
        }
    }
}
