package Animals;

public class Snake extends Animal {
    @Override
    String move() {
        return "Csúszik";
    }

    public Snake(String name, int numberOfLegs) {
        super(name, numberOfLegs);
    }
}
