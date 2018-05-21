public class Boss extends Character{

    public Boss() {
        super("img/boss.png", 2 * Hero.heroLevel * d6() + d6(),Hero.heroLevel / 2 * d6() + d6() / 2, Hero.heroLevel * d6() + Hero.heroLevel);
    }
}
