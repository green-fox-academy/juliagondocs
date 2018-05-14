package CharSeq;

public class Main {
    public static void main(String[] args) {
        Gnirts gnirt = new Gnirts("example");
        System.out.println(gnirt.charAt(1));

        Shifter shifter = new Shifter("example", 2);
        System.out.println(shifter.charAt(0));
    }
}
