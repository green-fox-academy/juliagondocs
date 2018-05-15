public class Fibonacci {

    public static float fibonacci(int x) {
        float[] sequence = new float[x];
        sequence[0] = 1;
        sequence[1] = 1;
        if (x > 1) {
            for (int i = 2; i < x; i++) {
                sequence[i] = sequence[i - 1] + sequence[i - 2];
            }
        }
        return sequence[x - 1];
    }
}
