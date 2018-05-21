public class Skeleton extends Character {

     static boolean hasKey;

    public Skeleton() {
        super("img/skeleton.png", 2 * Hero.heroLevel * d6(),Hero.heroLevel / 2 * d6(), Hero.heroLevel * d6());
        hasKey = false;
    }

    public boolean getKey () {
        return hasKey;
    }
}
