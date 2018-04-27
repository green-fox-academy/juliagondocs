import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        // Write a function that copies a file to an other
        // It should take the filenames as parameters
        // It should return a boolean that shows if the copy was successful
        System.out.println(copyFile("favcats.txt", "copy_favcats.txt"));
    }

    public static boolean copyFile(String file1, String file2) {
        boolean returnBoolean = false;
        Path path1 = Paths.get(file1);
        Path path2 = Paths.get(file2);

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.write(path2, lines);
            returnBoolean = true;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return returnBoolean;
    }
}
