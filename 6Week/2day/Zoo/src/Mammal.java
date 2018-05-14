public class Mammal extends Animal{

    public Mammal (String name) {
        super(name);
        this.name=name;
        numberOfLegs=4;
        isDangerous=false;
        color="brown";
    }

    public String breed() {
        return "pushing miniature versions out";
    }
    public String move() {
        return "walking";
    }
}
