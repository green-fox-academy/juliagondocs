package Animals;

public class Sparrow extends Animal implements Walkable{
    @Override
    String move() {
        return "Csipog";
    }

    @Override
    public void walk() {
        System.out.println(toString() + move());
    }

    public Sparrow(String name, int numberOfLegs) {
        super(name, numberOfLegs);
    }
}
