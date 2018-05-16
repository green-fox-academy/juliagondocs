import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CAB {
    int firstN;
    int secondN;
    int thirdN;
    int fourthN;
    String state;

    @Override
    public String toString() {
        return firstN +
                " " + secondN +
                " " + thirdN +
                " " + fourthN;
    }

    int count;

    public CAB() {
        this.firstN = (int) Math.random() * 10;
        this.secondN = (int) Math.random() * 10;
        this.thirdN = (int) Math.random() * 10;
        this.fourthN = (int) Math.random() * 10;
        this.state = "playing";
        count = 0;
    }

    public CAB(int first, int second, int third, int fourth) {
        this.firstN = first;
        this.secondN = second;
        this.thirdN = third;
        this.fourthN = fourth;
        this.state = "playing";
        count = 0;
    }


    public String guess() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String guess[] = s.split(" ");
        String[] result = new String[4];
        List<Integer> secretList = Arrays.asList(this.firstN, this.secondN, this.thirdN, this.fourthN);

        if (guess.length == 4) {
            for (int i = 0; i < guess.length; i++) {
                if (secretList.contains(Integer.parseInt(guess[i]))) {
                    result[i] = "bull |";
                    for (int j = 0; j < 4; j++) {
                        if (secretList.get(j) == Integer.parseInt(guess[i])) {
                            if (i == j) {
                                result[i] = "cow |";
                            }
                        }
                    }
                } else {
                    result[i] = "x |";
                }
            }
        }
        this.count += 1;
        state = "playing";
        String finalResult = "";
        for (int i = 0; i < 4; i++) {
            finalResult += result[i];
        }
        if (Collections.frequency(Arrays.asList(result), "cow |") == 4) {
            state = "wins";
        }
        return finalResult;
    }


    public static void main(String[] args) {
        CAB game = new CAB(3, 4, 3, 2);
        System.out.println(game.toString());
        while ( game.state != "wins") {
            System.out.println(game.guess());
        }
        if (game.state == "wins") {
            System.out.println("Congratulation! You Win");
        }
    }

}
