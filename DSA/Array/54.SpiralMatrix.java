/*
54. Spiral Matrix
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100 */
/**
 * SpiralMatrix
 */
import java.util.*;
class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrixSolution s=new SpiralMatrixSolution();
        int [][]arr={
            {1,2,3,4,5,6},
            {20,21,22,23,24,7},
            {19,32,33,34,25,8},
            {18,31,33,34,25,9},
            {17,30,29,28,27,10},
            {16,15,14,13,12,11}
        };
        s.printSpiralElements(arr);
    }
        
}
class SpiralMatrixSolution {
    public void printSpiralElements(int[][]arr){

            ArrayList<Integer> ans = new ArrayList<>();

            int n = arr.length - 1;
            int m = arr[0].length - 1;

            // Four boundaries that define the current unvisited portion
            // of the matrix.
            int top = 0;
            int bottom = n;
            int left = 0;
            int right = m;

            /*
            INTUITION:

            We traverse the matrix layer by layer in clockwise order.

            Each layer consists of:
            1. Top row       -> Left to Right
            2. Right column  -> Top to Bottom
            3. Bottom row    -> Right to Left
            4. Left column   -> Bottom to Top

            After completing one layer, we shrink the boundaries
            and move towards the inner layers.

            The four boundaries help us track which elements
            are already visited and which are yet to be traversed.

            TIME COMPLEXITY:
            O(N * M)

            Every matrix element is visited exactly once.
            Therefore, for an N x M matrix, we traverse N * M elements.

            SPACE COMPLEXITY:
            O(1) AUXILIARY SPACE

            We use only four boundary variables:
            top, bottom, left and right.

            However, the output ArrayList requires O(N * M) space.
            This output space is generally excluded when calculating
            auxiliary space complexity.

            WHY THIS APPROACH IS EFFICIENT:

            Instead of using a visited matrix or another data structure
            to keep track of visited elements, we shrink the boundaries
            after every traversal.

            This eliminates the need for extra tracking memory
            and ensures that every element is visited exactly once.
            */

            while(left <= right && top <= bottom){

                // STEP 1: Traverse the top row from Left to Right
                for(int i = left; i <= right; i++){
                    ans.add(arr[top][i]);
                }
                top++; // Shrink the top boundary


                // STEP 2: Traverse the right column from Top to Bottom
                for(int i = top; i <= bottom; i++){
                    ans.add(arr[i][right]);
                }
                right--; // Shrink the right boundary


                // STEP 3: Traverse the bottom row from Right to Left
                // Check whether a bottom row still exists to avoid
                // traversing an already visited row.
                if(top <= bottom){
                    for(int i = right; i >= left; i--){
                        ans.add(arr[bottom][i]);
                    }
                    bottom--; // Shrink the bottom boundary
                }


                // STEP 4: Traverse the left column from Bottom to Top
                // Check whether a left column still exists to avoid
                // traversing an already visited column.
                if(left <= right){
                    for(int i = bottom; i >= top; i--){
                        ans.add(arr[i][left]);
                    }
                    left++; // Shrink the left boundary
                }
            }

            for(int num:ans){
                System.out.print(num+" ");
            }
        
    }
}