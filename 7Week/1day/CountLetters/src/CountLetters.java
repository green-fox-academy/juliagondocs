import java.util.Arrays;
import java.util.HashMap;

public class CountLetters {
    public static HashMap<Character, Integer> countLetters(String string) {
        HashMap<Character, Integer> dictionary = new HashMap<>();
        char[] temp = string.toCharArray();
        Arrays.sort(temp);

        dictionary.put(temp[0], 1);
        for (int i = 1; i < temp.length; i++) {
            if (temp[i - 1] == temp[i]) {
                dictionary.put(temp[i], dictionary.get(temp[i]) + 1);
            } else {
                dictionary.put(temp[i], 1);
            }
        }
        return dictionary;
    }

    //public static void main(String[] args) {
    //    String alma = "aaabbb";
    //    HashMap<Character, Integer> result = countLetters(alma);
    //    System.out.println(result.get('b'));
    //    System.out.println(result.get('a'));
    //}

}
