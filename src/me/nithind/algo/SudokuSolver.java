package me.nithind.algo;

/**
 * Created by devangn on 15-01-17.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {




        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println("");
        }
    }

    public boolean isValid() {
        return false;
    }

    public static void main(String args[]) {
        char[][] n = {{'.','.','9','7','4','8','.','.','.'},
                "7........".toCharArray(),
                ".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(),
                ".64.1.59.".toCharArray(),
                ".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(),
                "........6".toCharArray(),
                "...2759..".toCharArray()
        };
        SudokuSolver s = new SudokuSolver();
        s.solveSudoku(n);
    }
}
