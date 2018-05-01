import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottery {
    public static void main(String[] args) {
        // Create a method that find the 5 most common lottery numbers in lottery.csv
        Path path = Paths.get("lottery.csv");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("No such file or directory");
        }

        String[][] data = new String[lines.size()][16];
        String[] numbers = new String[lines.size() * 5];
        int count = 0;
        for (int i = 0; i < lines.size(); i++) {
            data[i] = lines.get(i).split(";");
            for (int j = 0; j < 5; j++) {
                numbers[count] = data[i][j + 11];
                count += 1;
            }
        }
        int[] winningNumbers = commonNumbers(numbers);
        for (int element : winningNumbers) {
            System.out.println(element);
        }
    }

    public static int[] commonNumbers(String[] lotteryNumbers) {
        int[] occurrence = new int[91];
        for (int i = 0; i < lotteryNumbers.length; i++) {
            int current = Integer.valueOf(lotteryNumbers[i]);
            for (int j = 1; j < 91; j++) {
                if (current == j) {
                    occurrence[j] += 1;
                }
            }
        }
        // not works perfectly
        // if the occurrences are equals we need to select it as well -> more than 5 top occ.
        int[] maximumOfOccurrences = new int[5];
        for (int i = 0; i < 5; i++) {
            int maxi = 0;
            int position = 0;
            for (int j = 1; j < 91; j++) {
                if (maxi < occurrence[j]) {
                    maxi = occurrence[j];
                    position = j;
                }
            }
            occurrence[position] = 0;
            maximumOfOccurrences[i] = position;
        }
        return maximumOfOccurrences;
    }
}
