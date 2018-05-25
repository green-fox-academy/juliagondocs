public class Skeleton extends Character {

    boolean hasKey;

    public Skeleton() {
        super("img/skeleton.png", 2 * Hero.heroLevel * d6(),Hero.heroLevel / 2 * d6(), Hero.heroLevel * d6());
        hasKey = false;
    }


    public void setHasKey() {
        hasKey=true;
    }


    public boolean hasKey() {
        return hasKey;
    }
}
