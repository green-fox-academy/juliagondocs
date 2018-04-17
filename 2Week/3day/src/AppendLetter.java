import java.util.*;

public class AppendLetter {
    public static void main(String[] args) {
        List<String> far = new ArrayList<String>(Arrays.asList("kuty", "macsk", "kacs", "rók", "halacsk"));
        // Create a method called "appendA()" that adds "a" to every string in the "far" list.
        // The parameter should be a list.
        appendA(far);
        for (Object currentMatch : far) {
            System.out.print(currentMatch + " ");
        }
    }

    public static void appendA(List far) {
        String listString = "";
        int i = 0;
        for (i = 0; i < far.size(); i++) {
            listString = far.get(i) + "a";
            far.set(i, listString);
        }
    }
}

// The output should be: "kutya", "macska", "kacsa", "róka", "halacska"