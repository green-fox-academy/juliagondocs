import java.lang.reflect.Array;
import java.util.Arrays;

public class Anagram {


    public static boolean areEquals(String string1, String string2) {
        char[] temp = string1.toCharArray();
        Arrays.sort(temp);
        String sortedString1 = String.valueOf(temp);

        temp = string2.toCharArray();
        Arrays.sort(temp);
        String sortedString2 = String.valueOf(temp);

        if (sortedString1.equals(sortedString2)) {
            return true;
        } else {
            return false;
        }
    }

}
