package CharSeq;

public class Gnirts implements CharSequence {
    public String gnirt;

    public Gnirts(String gnirt) {
        this.gnirt = gnirt;
    }

    @Override
    public int length() {
        return this.gnirt.length();
    }

    @Override
    public char charAt(int index) {
        return gnirt.charAt(gnirt.length() - index - 1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
