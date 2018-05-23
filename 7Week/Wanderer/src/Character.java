public class Character extends GameObject {

    private int maxHP;
    private int currentHP;
    private int DP;
    private int SP;


    public Character(String filePath, int currentHP, int DP, int SP) {
        super(filePath);
        this.maxHP = currentHP;
        this.currentHP = currentHP;
        this.DP = DP;
        this.SP = SP;

    }

    static public int d6() {
        int d6 = (int) (1 + (Math.random() * 6));
        return d6;
    }

    public boolean isAlive() {
        if (this.currentHP >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getDP() {
        return DP;
    }

    public int getSP() {
        return SP;
    }


    public void strike(Character defenser) {
        System.out.println("AUUU");

        int strikeValue = strikeValue();
        System.out.println("Strike Value1: " + strikeValue);
        // a hero strikes first
        if (strikeValue > defenser.getDP()) {
            defenser.currentHP = defenser.currentHP - (strikeValue - defenser.DP);
            if (defenser.currentHP < 0) {
                defenser.die();
            }
        }

        // the defenser strikes back
        strikeValue = strikeValue();
        System.out.println("Strike Value2: " + strikeValue);
        if (strikeValue > this.DP) {
            this.currentHP = this.currentHP - (strikeValue - this.DP);
            if (this.currentHP < 0) {
                die();
            }
        }
        System.out.println(currentHP + " " + defenser.currentHP);
    }

    public int strikeValue() {
        return 2 * d6() + SP;
    }

    public void die() {
        currentHP = 0;
    }

    @Override
    public String toString() {
        return " " + currentHP;
    }
}
