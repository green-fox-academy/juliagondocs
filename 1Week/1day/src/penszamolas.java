public class penszamolas {
    public static void main(String[] args) {
        int husz = 20;
        int tiz = 10;
        int szaz = 100;
        int ketszaz = 200;
        int ot = 5;
        int otven = 50;

        int db5 = 60;
        int db10 = 30;
        int db20 = 70;
        int db50 = 70;
        int db100 = 73;
        int db200 = 61;

        long osszeg = ot * db5 + tiz * db10 + husz * db20 + otven * db50 + szaz * db100 + ketszaz * db200;
        System.out.println(osszeg);
    }


}
