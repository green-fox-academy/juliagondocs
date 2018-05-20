public class Skeleton extends Character {

    public Skeleton() {
        super("skeleton.png", 2 * Hero.heroLevel * d6(),Hero.heroLevel / 2 * d6(), Hero.heroLevel * d6());
    }
}
