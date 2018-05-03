import java.util.ArrayList;
import java.util.List;

public class Dominoes {
    public static void main(String[] args) {
        List<Domino> dominoes = initializeDominoes();
        // You have the list of Dominoes
        // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
        // eg: [2, 4], [4, 3], [3, 5] ...
        System.out.println(dominoes);
        System.out.println("sorted: " + sortDominoes1(dominoes));
        System.out.println("sorted2: " + sortDominoes2(dominoes));
    }

    static List<Domino> initializeDominoes() {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));
        return dominoes;
    }

    static List<Domino> sortDominoes1(List<Domino> dominoes) {
        List<Domino> sortedDominoes = new ArrayList<>();
        sortedDominoes.add((Domino) dominoes.get(0));
        for (int i = 1; i < dominoes.size(); i++) {
            int[] temp = sortedDominoes.get(i - 1).getValues();
            for (int j = 0; j < dominoes.size(); j++) {
                int[] temp1 = dominoes.get(j).getValues();
                if (temp[1] == temp1[0]) {
                    sortedDominoes.add((Domino) dominoes.get(j));
                }
            }
        }
        return sortedDominoes;
    }

    static List<Domino> sortDominoes2(List<Domino> dominoes) {
        List<Domino> sortedDominoes = new ArrayList<>();
        sortedDominoes.add(dominoes.get(0));
        dominoes.remove(0);
        int counter = 0;

        while (!dominoes.isEmpty()) {
            for (int i = 0; i < dominoes.size(); i++) {
                if (sortedDominoes.get(counter).getValues()[1] == dominoes.get(i).getValues()[0]) {
                    counter++;
                    sortedDominoes.add(counter, dominoes.get(i));
                    dominoes.remove(i);
                }
            }
        }
        return sortedDominoes;
    }
}