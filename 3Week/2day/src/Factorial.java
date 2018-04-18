public class Factorial {
    public static void main (String[] args) {
    //  Create the usual class wrapper
    //  and main method on your own.

    // - Create a function called `factorio`
    //   that returns it's input's factorial
        System.out.println(factorio(10));

    }
    public static int factorio ( int input) {
        int factorized = 1;
        for (int i = 1; i < input ; i++) {
            factorized*=i;
        }
        return factorized;
    }
}
