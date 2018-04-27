import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class WriteSingleLine {
    public static void main(String[] args) {
        // Open a file called "my-file1.txt"
        // Write your name in it as a single line
        // If the program is unable to write the file,
        // then it should print an error message like: "Unable to write file: my-file.txt"

        ArrayList<String> myName = new ArrayList<>(Arrays.asList("Julcsi"));
        Path myFile = Paths.get("my-file_1.txt");

        try {
            Files.write(myFile, myName);
        } catch (IOException e) {
            System.out.println("Unable to write file: my-file_1.txt");
        }

    }
}
