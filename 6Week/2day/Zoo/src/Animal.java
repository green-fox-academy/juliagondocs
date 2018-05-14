public abstract class Animal {
    protected int age;
    protected String name;
    protected String color;
    protected int height;
    protected boolean isDangerous;
    protected int numberOfLegs;

    public Animal( String name) {
        this.name = name;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public abstract String breed();
    public abstract String move();

}
