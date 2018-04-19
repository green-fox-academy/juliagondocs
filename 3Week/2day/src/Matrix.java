public class Matrix {
    public static void main(String[] args) {
        // - Create (dynamically) a two dimensional array
        //   with the following matrix. Use a loop!
        //
        //   1 0 0 0
        //   0 1 0 0
        //   0 0 1 0
        //   0 0 0 1
        //
        // - Print this two dimensional array to the output
        int[][] matrix = new int[4][4]; // default ertek zero
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j)
                    matrix[i][j] = 1;
            }
        }
        for (int[] rows : matrix) {
            for (int coloumns : rows) {
                System.out.print(coloumns + " ");
            }
            System.out.println();
        }
    }
}
