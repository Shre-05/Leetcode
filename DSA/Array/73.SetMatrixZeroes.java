/*
73. Set Matrix Zeroes
Medium
Topics
premium lock icon
Companies
Hint
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution? */

class SetMatrixZeroes{
    public static void main(String[] args) {
        SetMatrixZeroesSolution s=new SetMatrixZeroesSolution();
        int [][]arr={
            {1,1,1,1},
            {1,0,1,0},
            {1,1,0,1},
            {1,1,1,1}
        };
        int [][]arr2={
            {1,1,1,1},
            {1,0,1,0},
            {1,1,0,1},
            {1,1,1,1}
        };
        int [][]arr3={
            {1,1,1,1},
            {1,0,1,0},
            {1,1,0,1},
            {1,1,1,1}
        };
        s.Brute(arr, arr.length, arr[0].length);
        System.out.println();
        s.Better(arr2, arr2.length, arr2[0].length);
        System.out.println();
        s.optimal(arr3, arr3.length, arr3[0].length);
    }
}

class SetMatrixZeroesSolution {

    // ============================================================
    // BRUTE FORCE APPROACH - Using -1 as a temporary marker
    // ============================================================

    /*
       INTUITION:
       - Traverse the matrix and find original zeroes.
       - Whenever a zero is found, mark its entire row and column with -1.
       - Preserve original zeroes so that they remain identifiable.
       - Finally, convert all -1 markers into 0.

       TC: O(N * M * (N + M))
       SC: O(1) auxiliary space

       WHY TC IS HIGH:
       For every original zero, we traverse its entire row (M) and
       column (N) to mark them. In the worst case, there can be
       O(N * M) original zeroes.

       WHY SC IS O(1):
       We don't use any additional arrays. We modify the matrix itself.

       WHY THE BETTER APPROACH IS BETTER:
       We repeatedly traverse rows and columns for every zero.
       Instead, we can store which rows and columns need to be zeroed
       and update the matrix afterward, avoiding repeated traversals.
    */

    public void Brute(int[][] arr, int n, int m) {

        // Step 1: Find original zeroes and mark their rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (arr[i][j] == 0) {
                    markRow(arr, i, m);
                    markCol(arr, j, n);
                }
            }
        }

        // Step 2: Convert temporary -1 markers into 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }

        printArray(arr, n, m);
    }

    // Mark the row with -1, but preserve original zeroes
    private void markRow(int[][] arr, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    // Mark the column with -1, but preserve original zeroes
    private void markCol(int[][] arr, int k, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i][k] != 0) {
                arr[i][k] = -1;
            }
        }
    }


    // ============================================================
    // BETTER APPROACH - Using separate row and column arrays
    // ============================================================

    /*
       INTUITION:
       - Create a rowArray to track rows containing original zeroes.
       - Create a colArray to track columns containing original zeroes.
       - First traversal identifies and records affected rows/columns.
       - Second traversal sets a cell to zero if its row OR column is marked.

       TC: O(N * M)
       SC: O(N + M)

       WHY TC IS O(N * M):
       - First traversal: O(N * M) to identify zeroes.
       - Second traversal: O(N * M) to update the matrix.
       - Total: O(N * M) + O(N * M) = O(N * M).

       WHY SC IS O(N + M):
       - rowArray requires O(N) space.
       - colArray requires O(M) space.

       WHY THIS IS BETTER THAN BRUTE:
       We avoid repeatedly traversing entire rows and columns for every
       original zero. Instead, we identify affected rows and columns
       once and update the matrix in a separate traversal.
    */

    public void Better(int[][] arr, int n, int m) {

        // Auxiliary arrays to track affected rows and columns
        // rowArray[i] = 1 -> row i contains an original zero
        // colArray[j] = 1 -> column j contains an original zero
        int[] rowArray = new int[n];
        int[] colArray = new int[m];

        // Step 1: Identify original zeroes and record affected rows/columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (arr[i][j] == 0) {
                    rowArray[i] = 1;
                    colArray[j] = 1;
                }
            }
        }

        // Step 2: Traverse again and zero cells belonging to marked rows
        // or marked columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (rowArray[i] == 1 || colArray[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }

        printArray(arr, n, m);
    }


    // ============================================================
    // OPTIMAL APPROACH - Using first row and first column as markers
    // ============================================================

    /*
       INTUITION:
       - Instead of creating rowArray and colArray, use the matrix itself.
       - arr[i][0] acts as the marker for row i.
       - arr[0][j] acts as the marker for column j.
       - Since arr[0][0] is shared by the first row and first column,
         we separately track the first column using col0.

       TC: O(N * M)
       SC: O(1) auxiliary space

       WHY TC IS O(N * M):
       - First traversal: O(N * M) to identify and mark zeroes.
       - Second traversal: O(N * M) to update the interior cells.
       - First row and first column processing: O(N + M).
       - Total remains O(N * M).

       WHY SC IS O(1):
       We reuse the first row and first column of the matrix for marking.
       Only one additional variable, col0, is used.

       WHY THIS IS BETTER THAN THE BETTER APPROACH:
       The Better approach requires two additional arrays of size N and M.
       Here, we use the original matrix as our tracking structure,
       reducing auxiliary space from O(N + M) to O(1), while keeping
       the same time complexity.
    */

    public void optimal(int[][] arr, int n, int m) {

        // Separate flag to track whether the first column needs to be zeroed
        // Initially, assume the first column does not need to be zeroed
        int col0 = 1;

        // Step 1: Use the first row and first column as marker arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (arr[i][j] == 0) {

                    // Mark the corresponding row
                    arr[i][0] = 0;

                    // Mark the corresponding column
                    if (j != 0) {
                        arr[0][j] = 0;
                    }
                    else {
                        // If the zero belongs to the first column,
                        // track it separately
                        col0 = 0;
                    }
                }
            }
        }

        // Step 2: Zero the interior cells using the markers
        // Skip the first row and first column for now
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // Step 3: Zero the first row if required
        // arr[0][0] acts as the marker for the first row
        if (arr[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }

        // Step 4: Zero the first column if required
        // col0 independently tracks the first column
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }

        printArray(arr, n, m);
    }


    // ============================================================
    // UTILITY METHOD - PRINT MATRIX
    // ============================================================

    void printArray(int[][] arr, int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}