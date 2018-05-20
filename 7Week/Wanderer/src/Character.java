public class Character extends GameObject {

    private int maxHP;
    private int currentHP;
    private int DP;
    private int SP;

    public Character() {
    }

    public Character(String filePath, int currentHP, int DP, int SP) {
        super(filePath);
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.DP = DP;
        this.SP = SP;

    }

    static public int d6() {
        int d6 = (int)(1 + (Math.random() * 6));
        return d6;
    }
}
