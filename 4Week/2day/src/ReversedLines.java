import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ReversedLines {

    public static void main(String[] args) {
        // Create a method that decrypts the duplicated-chars.txt
        Path path = Paths.get("reversed-lines.txt");

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("No such file or directory");
        }


        System.out.println(decrypt(lines));
    }

    public static ArrayList<String> decrypt(List<String> wrongText) {
        ArrayList<String> correctText = new ArrayList<>();
        for (int i = 0; i < wrongText.size(); i++) {
            String row = "";
            String[] line;
            line = wrongText.get(i).split("");
            for (int j = 0; j < line.length; j++) {
                row += line[line.length - j - 1];
            }
            correctText.add(row);
        }
        return correctText;
    }
}