/*
36. Valid Sudoku
Solved
Medium
Topics
premium lock icon
Companies
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'. */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // loop through all the cells of a board
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                // skip the empty value
                if(board[i][j]=='.'){
                    continue;
                }
                char val=board[i][j];
                if(!(isSafe(board,i,j,val))){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(char[][]board,int row,int col,char value){
        char charValue=value;
        // horizontal
        for(int j=0;j<9;j++){
            if(j!=col && board[row][j]==charValue){
                return false;
            }
        }
        // vertical
        for(int i=0;i<9;i++){
            if(i!=row && board[i][col]==charValue){
                return false;
            }
        }
        // 3*3 grid
        int rowIndex=row-row%3;
        int colIndex=col-col%3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int actualRow=rowIndex+i;
                int actualCol=colIndex+j;

                // skipping the current index
                if(actualRow==row && actualCol==col){
                    continue;
                }

                if(board[actualRow][actualCol]==charValue){
                    return false;
                }
            }
        }
        return true;
    }
}