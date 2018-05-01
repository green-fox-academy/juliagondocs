import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EncodedLines {
    public static void main(String[] args) {
        // Create a method that decrypts the duplicated-chars.txt
        Path path = Paths.get("encoded-lines.txt");

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("No such file or directory");
        }
        System.out.println(decoding(lines));
    }

    public static ArrayList<String> decoding(List<String> wrongText) {
        ArrayList<String> correctText = new ArrayList<>();
        for (int i = 0; i < wrongText.size(); i++) {
            String currentOut = "";
            String line;
            line = wrongText.get(i);
            for (int j = 0; j < line.length(); j++) {
                char currentIn = line.charAt(j);
                if (Integer.valueOf(currentIn) != 32) {
                    Integer position = Integer.valueOf(currentIn) - 1;
                    int number = (int) position;
                    currentOut += String.valueOf((char) number);
                } else {
                    currentOut += String.valueOf((char) 32);
                }
            }
            correctText.add(currentOut);
        }
        return correctText;
    }
}
