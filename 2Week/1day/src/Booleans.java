public class Booleans {
    public static void main(String[] args) {
        // true, false
        System.out.println(true); // Prints true
        System.out.println(false); // Prints false

        // Boolean Operators
        // Negation
        System.out.println("1:" + !true); // Prints false
        System.out.println("2:" + !false); // Prints true

        // And
        System.out.println("3:" + (true && true)); // Prints true
        System.out.println("4:" + (true && false)); // Prints false
        System.out.println("5:" + (false && true)); // Prints false
        System.out.println("6:" + (false && false)); // Prints false

        // Or
        System.out.println("7:" + (true || true)); // Prints true
        System.out.println("8:" + (true || false)); // Prints true
        System.out.println("9:" + (false || true)); // Prints true
        System.out.println("10:" + (false || false)); // Prints false
    }
}