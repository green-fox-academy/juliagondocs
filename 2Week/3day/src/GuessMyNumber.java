import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press ENTER to get default 1-100 number range. \nYou can specify another number range (e.g. 1-20) by typing it in:");
        String inputRange = scanner.nextLine();
        System.out.println("How many lives would you like to have? (Type a number:)");
        int numberOfLives = scanner.nextInt();
        guessMyNumber(inputRange, numberOfLives);
    }

    public static void guessMyNumber(String inputRange, int numberOfLives) {
        int rangeMin;
        int rangeMax;
        if (inputRange.equals("")) {
            rangeMin = 1;
            rangeMax = 100;
        } else {
            String[] inputStringArray = inputRange.split("-");
            rangeMin = Integer.parseInt(inputStringArray[0]);
            rangeMax = Integer.parseInt(inputStringArray[1]);
        }

        int numberToGuess = (int) (rangeMin + Math.random() * (rangeMax - rangeMin));
        Scanner scanner = new Scanner(System.in);
        String takeAwayMessage = "GAME OVER!\nBy the way, the number I thought of was " + numberToGuess + " :)";

        while (numberOfLives != 0) {
            System.out.println("Make your guess: ");
            int guessedNumber = scanner.nextInt();
            if (guessedNumber == numberToGuess) {
                System.out.println("Congratulations! You've won!");
                numberOfLives = 0;
                takeAwayMessage = "Good job!";
            } else if (guessedNumber > numberToGuess) {
                numberOfLives--;
                if (numberOfLives == 1) {
                    System.out.println("Too high. You have " + numberOfLives + " life left.");
                } else if (numberOfLives != 0) {
                    System.out.println("Too high. You have " + numberOfLives + " lives left.");
                }
            } else if (guessedNumber < numberToGuess) {
                numberOfLives--;
                if (numberOfLives == 1) {
                    System.out.println("Too low. You have " + numberOfLives + " life left.");
                } else if (numberOfLives != 0) {
                    System.out.println("Too low. You have " + numberOfLives + " lives left.");
                }
            }
        }
        System.out.println(takeAwayMessage);
    }
}