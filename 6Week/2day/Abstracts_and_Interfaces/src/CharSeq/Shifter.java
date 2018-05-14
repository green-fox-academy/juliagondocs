package CharSeq;

public class Shifter implements CharSequence {
    public String example;
    public int shifter;

    public Shifter(String example, int shifter) {
        this.example = example;
        this.shifter = shifter;
    }

    @Override
    public int length() {
        return this.example.length();
    }

    @Override
    public char charAt(int index) {
        return this.example.charAt(index + shifter);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
