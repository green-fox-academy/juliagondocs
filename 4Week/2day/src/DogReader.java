import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class DogReader {
    public static void main(String[] args) {
        Path dogSource = Paths.get("secretdog.txt");
        ArrayList<String> dogs = new ArrayList<>(
                Arrays.asList("Buksi",
                        "Fürkész",
                        "Morzsi",
                        "Lóri"));
        try {
            Files.write(dogSource,dogs);
            // ha nincs hiba, nem megyünk be a a catch ágba
            //throw new NullPointerException("No such file exists");
            // irasvédetté tettem, és tényleg kidobta a hibát
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("bib happened");
            throw new NullPointerException("No such file exists");
            // ha van hiba!
        } finally {
            // ez mindenképpen lefut, ha semmelyik catch ágba sem jut be
        }
    }
}
