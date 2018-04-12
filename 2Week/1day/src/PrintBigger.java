import java.util.Scanner;

public class PrintBigger {
    public static void main (String [] args ){
        // Write a program that asks for two numbers and prints the bigger one
        Scanner scanner = new Scanner(System.in);
        int userInput1 = scanner.nextInt();
        int userInput2 = scanner.nextInt();
        if (userInput1 - userInput2 > 0) {
            System.out.println(userInput1);
        }else {
            System.out.println(userInput2);
        }

    }
}
