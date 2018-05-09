package Animals;

public abstract class Animal implements Comparable<Animal>{
    private String name;
    private int numberOfLegs;

    abstract String move();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", numberOfLegs=" + numberOfLegs +
                " hello }";
    }

    public Animal(String name, int numberOfLegs) {
        this.name = name;
        this.numberOfLegs = numberOfLegs;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public int compareTo(Animal o) {
        if (o instanceof Animal) {
            return this.numberOfLegs - ( (Animal) o).numberOfLegs;
        }
        return 0;
    }
}
