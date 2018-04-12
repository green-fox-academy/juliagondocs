// Loads the scanner to the file
import java.util.Scanner;

public class MlToKm {
    public static void main(String[] args) {
        // Write a program that asks for an integer that is a distance in kilometers,
        // then it converts that value to miles and prints it
        Scanner scanner = new Scanner(System.in);
        int in_km = scanner.nextInt();
        double out_ml = in_km * 0.621371192;
        System.out.println(in_km + " km  = " + out_ml + " miles");

    }
}