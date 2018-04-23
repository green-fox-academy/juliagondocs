import java.util.ArrayList;

public class PalindromSearch {
    public static void main(String[] args) {
        //String inputText = "racecar";
        String inputText = "\"dog goat dad duck doodle never\"";
        ArrayList<String> result = searchForPalindrom(inputText);
        System.out.println(result);
    }

    public static ArrayList<String> searchForPalindrom(String inputList) {
        // legalább három
        String[] textString = inputList.split("");
        int count = 0;
        ArrayList<String> palindroms = new ArrayList<>();
        // Consider each pair one by one
        for (int i = 0; i < textString.length; i++) {
            String check_str = textString[i];
            for (int j = i + 1; j < textString.length; j++) {

                // concatenate both strings
                check_str = check_str + textString[j];

                if (isPalindrome(check_str)) {
                    if (check_str.length() >= 3) {
                        palindroms.add(count, check_str);
                        //System.out.println(check_str);
                    }
                }
            }
        }
        return palindroms;
    }

    static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;
    }
}