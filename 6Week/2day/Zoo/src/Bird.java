public class Bird extends Animal {
    public Bird(String name) {
        super(name);
        this.numberOfLegs = 2;
    }

    public String sing(){
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
}
