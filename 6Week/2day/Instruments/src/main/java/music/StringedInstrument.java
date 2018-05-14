package main.java.music;

public abstract class StringedInstrument  extends Instrument{
    public int numberOfStrings;

    protected abstract String sound();

    public void play() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.numberOfStrings + "-stringed instrument that goes " + this.sound();
    }


}
