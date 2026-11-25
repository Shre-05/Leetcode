/*

Code
Test Result
Testcase
Testcase
48. Rotate Image
Medium
Topics
premium lock icon
Companies
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000 */

/*
LeetCode 48: Rotate Image

Problem:
Rotate an n x n matrix by 90 degrees clockwise, in-place.
*/
class RotateImage{
    public static void main(String[] args) {
        int arr[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        RotateImageSolution r=new RotateImageSolution();
        r.Brute(arr, arr.length, arr[0].length);
        System.out.println();

        int arr2[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        r.optimal(arr2, arr2.length, arr2[0].length);
    }
}

class RotateImageSolution{

    /*
    ========================= BRUTE FORCE =========================

    INTUITION:
    To rotate a matrix 90 degrees clockwise, every element needs
    to move to a new position.

    Instead of modifying the original matrix directly, we create
    another matrix of dimensions m x n.

    Mapping:
    arr[i][j] --> ans[j][n-1-i]

    Why this mapping?
    - The original first row becomes the last column.
    - The original second row becomes the second-last column.
    - And so on.

    TIME COMPLEXITY:
    O(N * M)

    We visit every element exactly once and place it in its
    corresponding position in the new matrix.

    SPACE COMPLEXITY:
    O(N * M)

    We create a new matrix of dimensions m x n to store the
    rotated result.

    =============================================================
    */
    public void Brute(int [][]arr,int n,int m){
        int[][] ans=new int[m][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j][n-1-i]=arr[i][j];
            }
        }

        printArray(ans, n, m);
    }


    /*
    ========================= OPTIMAL =============================

    INTUITION:

    We need to rotate the matrix 90 degrees clockwise without
    creating another matrix.

    We can achieve this in two steps:

    STEP 1: TRANSPOSE THE MATRIX
    - Swap elements across the main diagonal.
    - arr[i][j] gets swapped with arr[j][i].
    - We only traverse the upper triangular part of the matrix
      to avoid swapping the same elements twice.

    STEP 2: REVERSE EVERY ROW
    - After transposing, reverse each individual row.
    - This produces the required 90-degree clockwise rotation.

    WHY IS THIS BETTER THAN BRUTE FORCE?

    Brute force creates a new matrix of size N x N to store
    the rotated result.

    The optimal approach uses the original matrix itself:
    - The transpose is performed in-place.
    - Each row is reversed in-place.

    Therefore, we eliminate the need for an additional matrix.

    TIME COMPLEXITY:
    O(N^2)

    1. Transpose: O(N^2) in the worst case.
    2. Reverse every row: O(N^2).

    Total:
    O(N^2) + O(N^2) = O(N^2).

    SPACE COMPLEXITY:
    O(1) auxiliary space.

    We use only a temporary variable for swapping.
    No additional matrix or data structure is created.

    =============================================================
    */

    public void optimal(int[][]arr,int n,int m){

        // STEP 1: Transpose the matrix
        // Swap arr[i][j] with arr[j][i]
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<m;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }

        // STEP 2: Reverse every row
        for(int i=0;i<n;i++){
            int left=0;
            int right=n-1;

            while(left<right){
                int temp=arr[i][left];
                arr[i][left]=arr[i][right];
                arr[i][right]=temp;

                left++;
                right--;
            }
        }

        printArray(arr, n, m);
    }


    // Helper method to print the matrix
    private void printArray(int[][]arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}