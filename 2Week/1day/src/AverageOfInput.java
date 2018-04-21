import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        // Write a program that asks for 5 integers in a row,
        // then it should print the sum and the average of these numbers like:
        //
        // Sum: 22, Average: 4.4
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        int n4 = scanner.nextInt();
        int n5 = scanner.nextInt();

        double sum = n1 + n2 + n3 + n4 + n5;
        double average = n1 + n2 + n3 + n4 + n5 / 5.;

        System.out.println("Average : " + average + ", Sum: " + sum);

    }
}