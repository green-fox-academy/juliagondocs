public class Animal {
    int hunger;
    int thirst;

    public Animal() {
        this(50, 50);
    }

    public Animal(int hunger, int thirst) {
        this.hunger = hunger;
        this.thirst = thirst;
    }

    public void eat() {
        this.hunger -= 1;
    }

    public void drink() {
        this.thirst -= 1;
    }

    public void play() {
        this.hunger += 1;
        this.thirst += 1;
    }
}
