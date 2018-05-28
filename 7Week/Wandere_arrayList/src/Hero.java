public class Hero extends Character {
    static int heroStep;
    static int heroLevel = 1;

    public Hero() {
        super("img/hero-down.png", 20 + 3 * d6(), 2 * d6(), 5 + d6());
    }

    public static int getHeroStep() {
        return heroStep;
    }

    public static int getHeroLevel() {
        return heroLevel;
    }

    public void setHeroLevel(int heroLevel) {
        Hero.heroLevel = heroLevel;
    }
}
