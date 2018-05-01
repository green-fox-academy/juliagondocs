import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ReversedOrder {

    public static void main(String[] args) {
        // Create a method that decrypts the duplicated-chars.txt
        Path path = Paths.get("reversed-order.txt");

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
            correctText.add(wrongText.get(wrongText.size() - i - 1));
        }
        return correctText;
    }
}