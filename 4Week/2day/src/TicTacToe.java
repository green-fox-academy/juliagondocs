import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TicTacToe {

    public static void main(String[] args) {
        // Write a function that takes a filename as string,
        // open and read it. The file data represents a tic-tac-toe
        // game result. Return 'X'/'O'/'draw' based on which player
        // has winning situation.

        System.out.println(ticTacResult("win-o.txt"));
        // should print O

        System.out.println(ticTacResult("win-x.txt"));
        // should print X

        System.out.println(ticTacResult("draw.txt"));
        // should print draw
    }

    public static String ticTacResult(String fileName) {
        Path path = Paths.get(fileName);
        String returnString = "";

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("No such file or directory");
        }

        String[][] board = new String[3][3];
        for (int i = 0; i < board.length; i++) {
            board[i] = lines.get(i).split("");
        }

        // There is 4 case to win:
        // ROW Win
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals("X") && board[i][1].equals("X") && board[i][2].equals("X")) {
                return "X";
            }
            if (board[i][0].equals("O") && board[i][1].equals("O") && board[i][2].equals("O")) {
                return "O";
            }
        }

        // Col win
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals("X") && board[1][i].equals("X") && board[2][i].equals("X")) {
                return "X";
            }
            if (board[0][i].equals("O") && board[1][i].equals("O") && board[2][i].equals("O")) {
                return "O";
            }
        }
        // DIAGONAL 1
        if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {
            return "X";
        }
        if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
            return "O";
        }
        // DIAGONAL 2
        if (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")) {
            return "X";
        }
        if (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) {
            return "O";
        }
        return "draw";
    }
}