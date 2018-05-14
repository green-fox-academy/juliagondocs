public class Bird extends Animal implements Flyable {

    public Bird(String name) {
        this.name = name;
    }

    public String sing() {
        return "chirp";
    }

    @Override
    public String breed() {
        return "laying eggs";
    }

    @Override
    public String move() {
        return "flying";
    }

    @Override
    public void land() {
        System.out.println("Landing on trees");
    }

    @Override
    public void fly() {
        System.out.println("Flying with wings");
    }

    @Override
    public void takeOff() {
        System.out.println("Take off if tired");
    }
}
