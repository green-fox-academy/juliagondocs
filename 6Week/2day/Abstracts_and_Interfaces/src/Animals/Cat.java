package Animals;

public class Cat extends Animal implements Walkable{
    @Override
    String move() {
        return "Sündörög ";
    }

    @Override
    public void walk() {
        System.out.println(toString() + move());
    }

    public Cat(String name, int numberOfLegs) {
        super(name, numberOfLegs);
    }
}
