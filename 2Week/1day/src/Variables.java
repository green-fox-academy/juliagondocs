public class Variables {
    public static void main(String[] args) {
        // String
        String welcome = "Hello, World";
        System.out.println(welcome);

        // Boolean
        boolean isAwesome = true;
        System.out.println(isAwesome);

        // Whole number
        // integer (32 bit; min: -2 147 483 648; max: 2 147 483 647)
        int theMeaningOfLifeAndTheUniverseAndEverything = 42;
        System.out.println(theMeaningOfLifeAndTheUniverseAndEverything);

        // Floating point number
        // Double (64 bit, double precision IEEE 754)
        double pi = 3.141592;
        System.out.println(pi);

        // Other mentioned types
        byte bbbb = 2;     // Byte (8 bit; min:-128; max: +127)
        short s = 567;  // Short (16 bit; min: -32768 ; max: +32 767)
        long l = 30000000000000L; // long (64 bit; min: -9 223 372 036 854 775 808 ;max: 9 223 372 036 854 775 807)
        float fff = 1.3f;
        float f2 = 45f; // Float (32 bit single precision IEEE 754)

        // Declaring a variable
        int number;

        // Assigning a variable, (define its value)
        number = 12;

        // Mutate a variable, (redefine its value)
        number = 23;

        //***************************************************************************************************
        int a = 12;
        a += 4;
        System.out.println(a); // Prints 16

        int b = 12;
        b -= 4;
        System.out.println(b); // Prints 8

        int c = 12;
        System.out.println(c++); // Prints 12
        System.out.println(c); // Prints 13

        int d = 12;
        System.out.println(++d); // Prints 13
        System.out.println(d); // Prints 13

        int e = 12;
        System.out.println(e--); // Prints 12
        System.out.println(e); // Prints 11

        int f = 12;
        System.out.println(--f); // Prints 11
        System.out.println(f); // Prints 11

        int g = 12;
        g *= 3;
        System.out.println(g); // Prints 36

        int h = 12;
        h /= 3;
        System.out.println(h); // Prints 4

        int i = 12;
        i %= 7;
        System.out.println(i); // Prints 5
    }
}