import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cats {

    public static void main(String[] args) {

        ArrayList<String> favCats = new ArrayList<>(
                Arrays.asList(
                        "Cirmi",
                        "Mirci",
                        "Tóbiás",
                        "Rohadt dög",
                        "Cuki cica"
                )
        );
        Path cuteCats = Paths.get("favcats.txt");

        try {
            Files.write(cuteCats, favCats);
        } catch (IOException e) {
            System.out.println("no such file");
        }

        List<String> favCatsBack = null;
        try {
            favCatsBack = getAllCat();
        } catch (IOException e) {
            System.out.println("bibi");
        } finally {
            if (favCatsBack != null) {
                for (String cat : favCatsBack) {
                    System.out.println(cat);
                }
            }
        }

    }


    public static List<String> getAllCat() throws IOException {
        Path cuteCats = Paths.get("favcats.txt");
        return Files.readAllLines(cuteCats);
    }
}