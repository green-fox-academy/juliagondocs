public class Reptile extends Animal{

    public Reptile (String name) {
        super(name);
        this.name=name;
        numberOfLegs=4;
        isDangerous=true;
    }

    @Override
    public String breed() {
        return "laying eggs";
    }

    @Override
    public String move() {
        return "crawling and swimming";
    }
}
