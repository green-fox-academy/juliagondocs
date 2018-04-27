import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class WriteMultipleLines {
    public static void main(String[] args) {
        // Create a function that takes 3 parameters: a path, a word and a number,
        // than it should write to a file.
        // The path parameter should be a string, that describes the location of the file.
        // The word parameter should be a string, that will be written to the file as lines
        // The number paramter should describe how many lines the file should have.

        // So if the word is "apple" and the number is 5, than it should write 5 lines
        // to the file and each line should be "apple"
        // The function should not raise any error if it could not write the file.
        String myPath = "C:/Users/Julcsika/Desktop/greenfox/4Week/2day/my-file_2.txt";
        String word = "I am smart and genius ! :-)";
        int number = 34;
        writeToFile(myPath,word,number);
    }

    public static void writeToFile(String path, String word, int number) {
        Path myFile = Paths.get(path);
        ArrayList<String> text = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            text.add(i,word);
        }

        try {
            Files.write(myFile, text);
        } catch (IOException e) {
            System.out.println(" ");
        }
    }
}
