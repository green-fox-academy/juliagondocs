public class Hero extends Character {
    static int heroStep;
    static int heroLevel;

    public Hero() {
        super( 20 + 3 * d6(),2 * d6(), 5 + d6());
    }
}
