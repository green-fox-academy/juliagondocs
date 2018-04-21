import java.util.Scanner;

public class AnimalAndLegs {
    public static void main(String[] args) {
        // Write a program that asks for two integers
        // The first represents the number of chickens the farmer has
        // The second represents the number of pigs owned by the farmer
        // It should print how many legs all the animals have
        Scanner scanner = new Scanner(System.in);
        int numberOfChickens = scanner.nextInt();
        int numberOfPigs = scanner.nextInt();

        int numberOfLegs = numberOfChickens * 2 + numberOfPigs * 4;
        System.out.println(numberOfLegs);

    }
}