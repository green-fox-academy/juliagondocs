public class TakesLonger {
    public static void main(String... args) {
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

        // When saving this quote a disk error has occured. Please fix it.
        // Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
        // Using pieces of the quote variable (instead of just redefining the string)
        StringBuilder tmp = new StringBuilder();
        tmp.append(quote.substring(0, 20));
        tmp.append(" always takes longer than");
        tmp.append(quote.substring(20, quote.length()));

        System.out.println(tmp);

    }
}
