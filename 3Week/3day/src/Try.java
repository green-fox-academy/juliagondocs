public class Try {
    public static void main (String[] args ) {
        int[] colorRandom = new int[3];
            for (int j = 0; j < 3; j++) {
                colorRandom[j] = (int) (Math.random() * 255);
            }
            System.out.println(colorRandom.toString());
    }
}
