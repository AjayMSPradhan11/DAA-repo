public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        int[][] chessboard = new int[n][n];
        if (solveNQueens(chessboard, 0)) {
            System.out.println("Solution found:");
            printChessboard(chessboard);
        } else {
            System.out.println("No solution exists.");
        }
    }
    public static boolean solveNQueens(int[][] chessboard, int col) {
        int n = chessboard.length;
        if (col == n) {
            return true; // All queens are placed successfully
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(chessboard, i, col)) {
                chessboard[i][col] = 1; // Place queen
                if (solveNQueens(chessboard, col + 1)) {
                    return true;
                }
                chessboard[i][col] = 0; // Backtrack if placing the queen doesn't lead to a solution
            }
        }

        return false; // If queen cannot be placed in any row of the current column
    }
    public static boolean isSafe(int[][] chessboard, int row, int col) {
        int n = chessboard.length;
// Check this row on the left side
        for (int i = 0; i < col; i++) {
            if (chessboard[row][i] == 1) {
                return false;
            }
        }
// Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }
// Check lower diagonal on the left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    public static void printChessboard(int[][] chessboard) {
        for (int[] row : chessboard) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }

            System.out.println();
        }
    }
}