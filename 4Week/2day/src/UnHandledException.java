import java.util.Scanner;

public class UnHandledException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int divisor = scanner.nextInt();

        int result = 12 / divisor; // If the input value for divisor was 0 the program breaks
        System.out.println(result); // The program doesn't reach this line if the input was 0
    }
}