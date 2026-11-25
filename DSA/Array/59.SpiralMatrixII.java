/*

Code
Test Result
Testcase
Testcase
59. Spiral Matrix II
Solved
Medium
Topics
premium lock icon
Companies
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20 */
class SpiralMatrixII{
    public static void main(String[] args) {
        SpiralMatrixIIsolution s=new SpiralMatrixIIsolution();
        s.generateMatrix(3);
    }
}

class SpiralMatrixIIsolution {
    public void generateMatrix(int n) {
        int num=1;

        int[][]arr=new int[n][n];

        int left=0;
        int top=0;
        int right=n-1;
        int bottom=n-1;

        while(left<=right && top<=bottom){
            // top row
            for(int i=left;i<=right;i++){
                arr[top][i]=num;
                num++;
            }
            top++;

            // right row
            for(int i=top;i<=bottom;i++){
                arr[i][right]=num;
                num++;
            }
            right--;

            // bottom row
            if(top<=bottom){ 
                for(int i=right;i>=left;i--){
                    arr[bottom][i]=num;
                    num++;
                }
            }
            bottom--;

            // left row
            if(left<=right){ 
                for(int i=bottom;i>=top;i--){
                    arr[i][left]=num;
                    num++;
                }
            }
            left++;


        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}