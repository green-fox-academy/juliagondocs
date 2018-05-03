import java.util.Arrays;

public class DiceSet {
    // You have a `DiceSet` class which has a list for 6 dices
    // You can roll all of them with roll()
    // Check the current rolled numbers with getCurrent()
    // You can reroll with reroll()
    // Your task is to roll the dices until all of the dices are 6
    int[] dices = new int[6];

    public int[] roll() {
        for (int i = 0; i < dices.length; i++) {
            dices[i] = (int) (Math.random() * 6) + 1; // i-edik kocka mit dobott -> mindegyik kocka ad egy számot
        }
        return dices;
    }

    public int[] getCurrent() {
        return dices;
    }

    public int getCurrent(int i) {
        return dices[i];
    }

    public void reroll() {
        for (int i = 0; i < dices.length; i++) {
            dices[i] = (int) (Math.random() * 6) + 1;
        }
    }

    public void reroll(int k) {
        dices[k] = (int) (Math.random() * 6) + 1;
    }

    @Override
    public String toString() {
        return "[" + dices[0] + ", " + dices[1] + ", " + dices[2] + ", " +
                dices[3] + ", " + dices[4] + ", " + dices[5] + "]";
    }

    public static void main(String[] args) {
        // 1: All of the dices are 6 in same time
        System.out.println("Number of throws: " + throwSixSameTime());

        //2: roll the dices until all of the dices are 6
        DiceSet diceSet = new DiceSet();
        diceSet.roll();
        if (areAllSix(diceSet) != true) {
            for (int i = 0; i < 6; i++) {
                while (diceSet.getCurrent(i) != 6) {
                    diceSet.reroll(i);
                }
            }
        }
        System.out.println(areAllSix(diceSet) + ": all of the dices are 6.");

        //diceSet.getCurrent();
        //System.out.println(diceSet.getCurrent(5));
        //diceSet.reroll();
        //diceSet.getCurrent();
        //diceSet.reroll(4);
        //diceSet.getCurrent();
    }

    public static int throwSixSameTime() {
        DiceSet diceSet = new DiceSet();
        diceSet.roll();
        int summary = 0;
        int count = 0;
        while (summary != 36) {
            diceSet.roll();
            summary = 0;
            count++;
            for (int i = 0; i < 6; i++) {
                summary += diceSet.getCurrent(i);
            }
        }
        return count;
    }

    public static boolean areAllSix(DiceSet diceSet) {
        boolean allSix = false;
        int summary = 0;
        for (int i = 0; i < 6; i++) {
            summary += diceSet.getCurrent(i);
        }
        if (summary == 36) {
            allSix = true;
        }
        return allSix;
    }
}
