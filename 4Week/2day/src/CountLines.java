import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
    public static void main(String[] args) {
        // Write a function that takes a filename as string,
        // then returns the number of lines the file contains.
        // It should return zero if it can't open the file, and
        // should not raise any error.
        String fileName = "my-file.txt";
        System.out.println(numberOfLines(fileName));

    }

    public static int numberOfLines(String nameOfFile) {
        int result = 0;
        Path pathMyFile = Paths.get(nameOfFile);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(pathMyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = lines.size();
        return result;
    }
}
