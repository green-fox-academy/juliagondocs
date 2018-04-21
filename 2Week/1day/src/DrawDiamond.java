import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // diamond like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *
        //
        // The diamond should have as many lines as the number was
        Scanner scanner = new Scanner(System.in);
        int userInput1 = scanner.nextInt();
        if (userInput1 % 2 != 0) {
            userInput1 += 1;
        }
        for (int i = 0; i <= userInput1 / 2; i++) {
            for (int j = 0; j < userInput1 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < (userInput1 / 2); i++) {
            for (int j = 0; j < i + (userInput1 / 2) + 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= (userInput1 / 2) - i - 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
