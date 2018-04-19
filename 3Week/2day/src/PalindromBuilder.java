public class PalindromBuilder {
    public static void main(String[] args) {
        System.out.println(palindrom("Julcsika"));
        System.out.println(palindrom("Dávidka"));
    }

    public static String palindrom(String inputString) {
        char[] inputStringArray = inputString.toCharArray();
        int length = inputString.length();
        for (int i = 0; i < length; i++) {
            inputString += inputStringArray[length - 1 - i];
        }
        return inputString;
    }
}
