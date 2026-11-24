/*
31. Next Permutation

Problem:
Given an array of integers, rearrange it into the next lexicographically
greater permutation.

If no greater permutation exists, rearrange the array into ascending order.

The rearrangement must be in-place with O(1) extra space
for the optimal approach.
*/

import java.util.*;

class NextPermutation {
    public static void main(String[] args) {
        NextPermutationSolution n = new NextPermutationSolution();

        int[] arr = {2, 1, 5, 4, 3, 0, 0};

        // Brute force
        // n.Brute(arr, arr.length);

        // Better (C++ STL reference is included in comments)
        // n.better(arr);

        // Optimal
        n.optimal(arr, arr.length);
    }
}

class NextPermutationSolution {

    /*
    APPROACH 1: BRUTE FORCE

    Intuition:

    1. Generate all possible permutations of the given array.
    2. Sort all the generated permutations in lexicographical order.
    3. Find the first permutation that is lexicographically greater
       than the original array.
    4. Copy that permutation into the original array.

    If no greater permutation exists, the first permutation
    in sorted order will be the answer.

    TC:
        Generating permutations:
            O(N * N!)

        Sorting the generated permutations:
            O(N * N! * log(N!))
            - There are N! permutations.
            - Comparing two permutations can take O(N).

        Searching for the next permutation:
            O(N * N!)
            - In the worst case, we may compare against
              every generated permutation.
            - Each comparison can take O(N).

        Overall:
            O(N * N! * log(N!))

    SC:
        O(N * N!)
        - We store all generated permutations.
        - Each permutation requires O(N) space.
        - There are N! permutations.

    Why this approach works:
        - Every possible permutation is generated.
        - Sorting arranges them in lexicographical order.
        - We select the first permutation greater than the original.
    */

    public void Brute(int[] arr, int n) {

        // Store all generated permutations
        List<int[]> permutations = new ArrayList<>();

        // Temporary array to construct permutations
        int[] temp = new int[n];

        // Tracks whether an element has already been used
        boolean[] used = new boolean[n];

        // Generate all permutations
        generate(arr, temp, used, 0, permutations);

        // Sort permutations lexicographically
        permutations.sort(this::compare);

        // Find the first permutation greater than the original array
        for (int[] permutation : permutations) {

            if (compare(permutation, arr) > 0) {

                // Copy the next permutation into the original array
                for (int i = 0; i < n; i++) {
                    arr[i] = permutation[i];
                }

                printArray(arr);
                return;
            }
        }

        // If no greater permutation exists,
        // the smallest permutation is the first one after sorting.
        int[] smallest = permutations.get(0);

        for (int i = 0; i < n; i++) {
            arr[i] = smallest[i];
        }

        printArray(arr);
    }


    // Recursively generate all permutations
    private void generate(
            int[] arr,
            int[] temp,
            boolean[] used,
            int index,
            List<int[]> permutations
    ) {

        // Base case: a complete permutation has been generated
        if (index == arr.length) {

            // Store a copy of the permutation
            permutations.add(temp.clone());
            return;
        }

        // Try every unused element
        for (int i = 0; i < arr.length; i++) {

            if (!used[i]) {

                // Select the current element
                temp[index] = arr[i];
                used[i] = true;

                // Generate the next position
                generate(arr, temp, used, index + 1, permutations);

                // Backtrack: undo the selection
                used[i] = false;
            }
        }
    }


    // Compare two arrays lexicographically
    // Returns:
    // Negative value -> first array is smaller
    // Zero          -> both arrays are equal
    // Positive value -> first array is greater

    private int compare(int[] a, int[] b) {

        for (int i = 0; i < a.length; i++) {

            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return 0;
    }


    /*
    APPROACH 2: BETTER (USING C++ STL REFERENCE)

    C++ provides a built-in function:

        next_permutation(begin(arr), end(arr));

    It rearranges the array into its next lexicographically
    greater permutation.

    If the array is already the largest permutation,
    it rearranges the array into the smallest permutation.

    Example:

        arr = {1, 2, 3}

        next_permutation(begin(arr), end(arr));

        Result:
        {1, 3, 2}

    Another example:

        arr = {3, 2, 1}

        next_permutation(begin(arr), end(arr));

        Result:
        {1, 2, 3}

    C++ code:

        #include <algorithm>
        using namespace std;

        int main() {
            int arr[] = {1, 2, 3};

            next_permutation(begin(arr), end(arr));

            for(int x : arr)
                cout << x << " ";
        }

    TC: O(N)
        - In the worst case, the suffix is traversed and reversed.
        - The operation is linear.

    SC: O(1)
        - In-place rearrangement.

    Note:
        This is a built-in solution, not an algorithmic explanation.
        Understanding the manual implementation is more important
        for interviews and coding assessments.
    */


    /*
    APPROACH 3: OPTIMAL (MANUAL IMPLEMENTATION)

    Intuition:

    STEP 1:
        Find the breakpoint.

        Traverse from right to left and find the first index
        where arr[i] < arr[i+1].

        This is the position that needs to be increased
        to create the next larger permutation.

    STEP 2:
        Find the rightmost element greater than the breakpoint.

        Since the suffix is in descending order,
        the rightmost element greater than arr[bki] is
        the smallest greater element in that suffix.

    STEP 3:
        Swap the breakpoint with this successor.

    STEP 4:
        Reverse the suffix after the breakpoint.

        This makes the suffix ascending, which gives
        the smallest possible arrangement after increasing
        the breakpoint.

    If no breakpoint exists:
        The array is already the largest permutation.
        Reverse the entire array to get the smallest permutation.

    TC: O(N)
        - Finding the breakpoint takes O(N).
        - Finding the successor takes O(N).
        - Reversing the suffix takes O(N).
        - These operations are sequential, not nested.

    SC: O(1)
        - In-place modification.
        - Only a few variables are used.

    Why is this better than brute force?

        Brute force generates and stores N! permutations
        and sorts them.

        The optimal approach uses the properties of
        lexicographical ordering to identify exactly
        which elements need to change.

        Therefore, it reduces the time complexity
        from factorial time to linear time and
        the space complexity from O(N * N!) to O(1).
    */

    public void optimal(int[] arr, int n) {

        // STEP 1: Find the breakpoint
        // A breakpoint is the first index from the right
        // where arr[i] < arr[i+1].
        // This indicates that we can create a larger permutation.

        int bki = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                bki = i;
                break;
            }
        }

        // STEP 2: If no breakpoint exists,
        // the array is in descending order.
        // This is the largest permutation.
        // Reverse the entire array to get the smallest permutation.

        if (bki == -1) {
            reverse(arr, 0, n - 1);
        }
        else {

            // STEP 3: Find the rightmost element greater than
            // the breakpoint element.
            // Since the suffix is in descending order,
            // the rightmost greater element is the smallest
            // element greater than arr[bki] in that suffix.

            for (int i = n - 1; i > bki; i--) {
                if (arr[i] > arr[bki]) {

                    // Swap breakpoint with its successor
                    swap(arr, i, bki);
                    break;
                }
            }

            // STEP 4: Reverse the suffix after the breakpoint.
            // This makes the suffix as small as possible,
            // resulting in the immediate next permutation.

            reverse(arr, bki + 1, n - 1);
        }

        // Print the resulting permutation
        printArray(arr);
    }


    // Swap two elements using their indices
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // Reverse the array between start and end indices
    private void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }


    // Utility method to print the array
    private void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}