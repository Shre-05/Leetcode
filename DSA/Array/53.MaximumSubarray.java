/*
    LeetCode 53: Maximum Subarray

    Given an integer array, find the contiguous subarray
    with the largest sum.

    Example:
    Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    Output: 6
    Subarray: [4, -1, 2, 1]

    Approaches:
    1. Improved Brute Force – O(N^2)
    2. Kadane's Algorithm – O(N)
    3. Kadane's Algorithm with Subarray Tracking – O(N)
*/

class MaximumSubarray {
    public static void main(String[] args) {

        MaximumSubarraySolution m = new MaximumSubarraySolution();

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        m.Brute(arr);
        System.out.println();

        m.optimal(arr);
        m.optimalArray(arr);
    }
}

class MaximumSubarraySolution {

    /*
    ============================================================
    APPROACH 1: IMPROVED BRUTE FORCE
    ============================================================

    INTUITION:

    - Generate all possible subarrays.
    - Fix the starting index i.
    - Extend the ending index j from i to the end of the array.
    - Maintain a running sum instead of recalculating the
      subarray sum from scratch.
    - Whenever a larger sum is found, update maxi and
      record the subarray boundaries.

    TIME COMPLEXITY: O(N^2)

    - The outer loop selects the starting index.
    - The inner loop extends the subarray and updates
      the running sum in constant time.
    - There are approximately N * N iterations.

    SPACE COMPLEXITY: O(1)

    - Only a few variables are used.
    - No additional data structure is required.

    WHY BETTER THAN BASIC BRUTE FORCE?

    - Basic brute force uses three nested loops.
    - The third loop repeatedly calculates the sum
      of each subarray from scratch.
    - This takes O(N^3) time.

    - Here, we reuse the running sum while extending
      the subarray.
    - This eliminates the third loop and reduces
      the time complexity from O(N^3) to O(N^2).
    ============================================================
    */

    public void Brute(int[] arr) {

        // Stores the maximum subarray sum found so far
        int maxi = Integer.MIN_VALUE;

        // Stores the boundaries of the maximum-sum subarray
        int ansStart = 0;
        int ansEnd = 0;

        // Fix the starting index of the subarray
        for (int i = 0; i < arr.length; i++) {

            // Reset sum for every new starting index
            int sum = 0;

            // Extend the subarray from index i to j
            for (int j = i; j < arr.length; j++) {

                // Add the current element to the running sum
                // Avoids recalculating the sum from scratch
                sum += arr[j];

                // If a larger subarray sum is found
                if (sum > maxi) {

                    // Update the maximum sum
                    maxi = sum;

                    // Record the subarray boundaries
                    ansStart = i;
                    ansEnd = j;
                }
            }
        }

        // Print the maximum subarray sum
        System.out.println("Maximum Sum: " + maxi);

        // Print the actual maximum-sum subarray
        System.out.print("Subarray: ");

        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    /*
    ============================================================
    APPROACH 2: KADANE'S ALGORITHM
    ============================================================

    INTUITION:

    Instead of generating all possible subarrays,
    we maintain a running sum and make a decision
    at every index.

    - Add the current element to the running sum.
    - Update maxi whenever a larger running sum is found.
    - If the running sum becomes negative, discard it
      and reset it to zero.

    WHY RESET WHEN SUM < 0?

    A negative running sum decreases the sum of any
    subarray extended from it.

    Therefore, it is better to discard a negative
    running sum and start fresh from the next element.

    TIME COMPLEXITY: O(N)

    - The array is traversed only once.
    - Each element is processed in constant time.

    SPACE COMPLEXITY: O(1)

    - Only sum and maxi are maintained.

    WHY BETTER THAN APPROACH 1?

    - Approach 1 generates all possible subarrays
      using two nested loops.
    - Kadane's Algorithm avoids explicitly generating
      all subarrays.
    - It intelligently discards negative running sums
      that cannot help improve a future subarray.

    - This eliminates the nested loop and reduces
      the time complexity from O(N^2) to O(N).
    ============================================================
    */

    // Prints only the maximum subarray sum
    public void optimal(int[] arr) {

        // Maintains the running sum of the current subarray
        int sum = 0;

        // Stores the maximum subarray sum found so far
        // MIN_VALUE handles arrays containing only negative elements
        int maxi = Integer.MIN_VALUE;

        // Traverse the array once
        for (int i = 0; i < arr.length; i++) {

            // Add the current element to the running sum
            sum += arr[i];

            // Update maximum sum if a larger sum is found
            maxi = Math.max(maxi, sum);

            // If the running sum becomes negative,
            // it cannot help increase a future subarray sum
            if (sum < 0) {
                sum = 0;
            }
        }

        // Print the maximum subarray sum
        System.out.println("Maximum Sum: " + maxi);
    }


    /*
    ============================================================
    APPROACH 3: KADANE'S ALGORITHM WITH SUBARRAY TRACKING
    ============================================================

    INTUITION:

    Kadane's Algorithm can also be used to find
    the actual subarray responsible for the maximum sum.

    Along with sum and maxi, we maintain:

    start:
        Starting index of the current potential subarray.

    ansStart:
        Starting index of the maximum-sum subarray
        found so far.

    ansEnd:
        Ending index of the maximum-sum subarray
        found so far.

    Whenever a new maximum sum is found:
        - Update maxi.
        - Store start in ansStart.
        - Store the current index i in ansEnd.

    Whenever the running sum becomes negative:
        - Reset sum to zero.
        - Set start = i + 1 because the next element
          can become the starting point of a new subarray.

    TIME COMPLEXITY: O(N)

    - One traversal finds the maximum sum and boundaries.
    - Another traversal prints the selected subarray.
    - Overall complexity remains O(N).

    SPACE COMPLEXITY: O(1)

    - Only a constant number of variables are maintained.
    - No additional data structure is used.

    WHY BETTER THAN APPROACH 2?

    - The time and space complexity remain the same.
    - However, this approach provides additional functionality.
    - It records the boundaries of the subarray that
      produces the maximum sum.
    - We can therefore print the actual subarray,
      rather than only printing its sum.
    ============================================================
    */

    // Prints the maximum-sum subarray
    public void optimalArray(int[] arr) {

        // Maintains the running sum of the current subarray
        int sum = 0;

        // Stores the maximum subarray sum found so far
        int maxi = Integer.MIN_VALUE;

        // Starting index of the current potential subarray
        int start = 0;

        // Boundaries of the maximum-sum subarray found so far
        int ansStart = 0;
        int ansEnd = 0;

        // Traverse the array once
        for (int i = 0; i < arr.length; i++) {

            // Add the current element to the running sum
            sum += arr[i];

            // If a new maximum sum is found
            if (sum > maxi) {

                // Update the maximum sum
                maxi = sum;

                // Record the boundaries of the maximum subarray
                ansStart = start;
                ansEnd = i;
            }

            // If the running sum becomes negative,
            // discard the current subarray
            if (sum < 0) {

                // Reset the running sum
                sum = 0;

                // The next element can become the starting point
                start = i + 1;
            }
        }

        // Print the maximum subarray sum
        System.out.println("Maximum Sum: " + maxi);

        // Print the actual maximum-sum subarray
        System.out.print("Subarray: ");

        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}