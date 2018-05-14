package Comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Domino implements Comparable<Domino> {
    private final int[] values;

    public Domino(int valueA, int valueB) {
        this.values = new int[]{valueA, valueB};
    }

    public int[] getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "[" + values[0] + ", " + values[1] + "]";
    }

    @Override
    public int compareTo(Domino o) {
        int[] first = this.values;
        int[] second = o.values;
        if (first[0] - second[0] == 0) {
            return first[1] - second[1];
        } else {
            return first[0] - second[0];
        }
    }

    public static void main(String[] args) {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));

        for (Domino currentDomino : dominoes) {
            System.out.print(currentDomino + " ");
        }

        System.out.println("");
        System.out.println("-----------------------------------------");

        Collections.sort(dominoes);

        for (Domino currentDomino : dominoes) {
            System.out.print(currentDomino + " ");
        }


    }

}
