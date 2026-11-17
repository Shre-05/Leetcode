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


import java.util.*;

public class SudokuSolver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        System.out.println("Enter Sudoku (9 rows, use . for empty cells):");

        // Taking input
        for (int i = 0; i < 9; i++) {
            String row = sc.next();

            for (int j = 0; j < 9; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        Sudoku solver = new Sudoku();

        // Display original Sudoku
        System.out.println("\nOriginal Sudoku:");
        printBoard(board);

        // Solve Sudoku
        solver.solveSudoku(board);

        // Display solved Sudoku
        System.out.println("\nSolved Sudoku:");
        printBoard(board);

        sc.close();
    }

    // Display Sudoku
    static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------------");
            }

            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }
}

class Sudoku {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int[] emptyCell = new int[2];

        if (!isEmpty(board, emptyCell)) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int val = 1; val <= 9; val++) {
            char charVal = (char)(val + '0');

            if (isSafe(board, row, col, charVal)) {
                board[row][col] = charVal;

                if (solve(board)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

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

        // Check 3x3 grid
        int rowIndex = row - row % 3;
        int colIndex = col - col % 3;

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
