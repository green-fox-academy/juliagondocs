package Animals;

public class Dog extends Animal {

    String move() {
        return "Kutya futtaban";
    }

    public Dog(String name, int numberOfLegs) {
        super(name, numberOfLegs);
    }
}
