public class Print {
    public static void main(String[] args) {
        // - Create a function called `printer`
        //   which prints the input String parameters
        // - It can have any number of parameters

        // Examples
        // printer("first")
        // printer("first", "second")
        // printer("first", "second", "third", "fourth")
        // ...
        String[] parameters = {"first", "second", "third", "fourth"};
        printer(parameters);
    }

    public static void printer(String[] inputString) {
        for (int i = 0; i < inputString.length; i++) {
            if (i < inputString.length - 1) {
                System.out.print(inputString[i] + " | ");
            } else {
                System.out.print(inputString[i]);
            }
        }
    }
}
