public class Hero extends Character {
    static int heroStep;
    static int heroLevel;

    public Hero() {
        super("img/hero-down.png" ,20 + 3 * d6(),2 * d6(), 5 + d6());
        this.heroLevel =0;
    }
}
