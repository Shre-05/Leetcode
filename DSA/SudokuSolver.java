/*
37. Sudoku Solver
Solved
Hard
Topics
premium lock icon
Companies
Hint
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution. */


class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int[] emptyCell = new int[2];

        // Base condition: no empty cell exists
        if (!isEmpty(board, emptyCell)) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int val = 1; val <= 9; val++) {
            char charVal = (char)(val + '0');

            if (isSafe(board, row, col, charVal)) {
                board[row][col] = charVal;

                // Solve the remaining cells recursively
                if (solve(board)) {
                    return true;
                }

                // Backtrack
                board[row][col] = '.';
            }
        }

        return false;
    }

    // Check whether placing a value is safe
    private boolean isSafe(char[][] board, int row, int col, char charValue) {

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == charValue) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == charValue) {
                return false;
            }
        }

        // Find starting index of 3x3 grid
        int rowIndex = row - row % 3;
        int colIndex = col - col % 3;

        // Check 3x3 grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int actualRow = rowIndex + i;
                int actualCol = colIndex + j;

                if (board[actualRow][actualCol] == charValue) {
                    return false;
                }
            }
        }

        return true;
    }

    // Find an empty cell
    private boolean isEmpty(char[][] board, int[] emptyCell) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    emptyCell[0] = i;
                    emptyCell[1] = j;
                    return true;
                }
            }
        }

        return false;
    }
}
