package main.java.music;

public class Violin extends StringedInstrument {
    public Violin() {
        this.numberOfStrings = 4;
    }

    Violin(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public String sound() {
        return "Screech";
    }
}
