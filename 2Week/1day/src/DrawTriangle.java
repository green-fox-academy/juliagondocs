import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // triangle like this:
        //
        // *
        // **
        // ***
        // ****
        //
        // The triangle should have as many lines as the number was
        Scanner scanner = new Scanner(System.in);
        int userInput1 = scanner.nextInt();
        String piramid = new String();
        for (int a = 0; a <= userInput1; a++) {
            piramid += '*';
            System.out.println(piramid);
        }
    }
}
