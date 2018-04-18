public class Summing {
    public static void main(String[] args) {
        //  Create the usual class wrapper
        //  and main method on your own.

        // - Write a function called `sum` that sum all the numbers
        //   until the given parameter and returns with an integer
        System.out.println(sum(8));
    }

    public static int sum(int input) {
        int sumarized = 0;
        for (int i = 0; i < input; i++) {
            sumarized += i;
        }
        return sumarized;
    }

}
