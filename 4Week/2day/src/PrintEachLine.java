import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class PrintEachLine {
    public static void main(String[] args) throws IOException {
        // Write a program that opens a file called "my-file.txt", then prints
        // each of lines form the file.
        // If the program is unable to read the file (for example it does not exists),
        // then it should print an error message like: "Unable to read file: my-file.txt"

        Path pathMyFile = Paths.get("my-file.txt");

        if (Files.isReadable(pathMyFile)) {
            System.out.println("Letezik");
            //1:
            List<String> lines = Files.readAllLines(pathMyFile);
            for (String line : lines) {
                System.out.println(line);
            }
            //2:
            Files.lines(Paths.get("my-file.txt")).forEach(line -> System.out.println(line));
        } else {
            System.out.println("no such file");
        }
    }
}