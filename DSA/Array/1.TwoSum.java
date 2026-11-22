/*
1. Two Sum
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9

Output: [0,1]

Explanation:

The sum of nums[0] and nums[1] is 2 + 7 = 9, which equals the target. Therefore, the indices [0, 1] are returned.

Example 2:

Input: nums = [3,2,4], target = 6

Output: [1,2]

Explanation:

The sum of nums[1] and nums[2] is 2 + 4 = 6, which equals the target. Therefore, the indices [1, 2] are returned.

Example 3:

Input: nums = [3,3], target = 6

Output: [0,1]

Explanation:

The sum of nums[0] and nums[1] is 3 + 3 = 6, which equals the target. Therefore, the indices [0, 1] are returned.

 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity? */

import java.util.*;

/*
===========================================================
                    LEETCODE 1: TWO SUM
===========================================================

PROBLEM:
Given an array of integers and a target, return the indices
of two numbers such that their sum equals the target.

CONSTRAINTS:
1. Exactly one valid solution exists.
2. We cannot use the same element twice.
3. The answer can be returned in any order.

Example:
    arr = [2, 6, 5, 8, 11]
    target = 14

    Output = [1, 3]

    Because arr[1] + arr[3] = 6 + 8 = 14.

-----------------------------------------------------------
APPROACH 1: BRUTE FORCE
-----------------------------------------------------------

IDEA:
Check every possible pair of elements in the array.

For every i, we check all elements from index i onwards
using j. If arr[i] + arr[j] equals target, we have found
the required pair.

We skip i == j because we cannot use the same element twice.

TIME COMPLEXITY: O(N^2)
    - Two nested loops.
    - In the worst case, we examine nearly every possible pair.

SPACE COMPLEXITY: O(1)
    - We use a fixed-size array of 2 elements to store indices.
    - Auxiliary space does not depend on input size.

LIMITATION:
    - We repeatedly check multiple pairs.
    - This becomes inefficient for large arrays.

===========================================================
*/

class TwoSum {

    public static void main(String[] args) {

        TwoSumSolution t = new TwoSumSolution();

        int arr[] = {2, 6, 5, 8, 11};

        t.Brute(arr, 14);

        t.Better(arr, 14);

        t.optimal(arr, 14);
    }
}

class TwoSumSolution {

    // -----------------------------------------------------
    // APPROACH 1: BRUTE FORCE
    // TC: O(N^2)
    // SC: O(1)
    // -----------------------------------------------------

    public void Brute(int[] arr, int target) {

        // Array to store the indices of the answer
        int[] ans = new int[2];

        // Traverse the array using the first pointer
        for (int i = 0; i < arr.length; i++) {

            // Traverse the elements from index i onwards
            for (int j = i; j < arr.length; j++) {

                // We cannot use the same element twice
                if (i == j)
                    continue;

                // Check whether the current pair sums to target
                if (arr[i] + arr[j] == target) {

                    // Store the indices of the two elements
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        // Print the indices of the answer
        for (int i = 0; i < 2; i++) {
            System.out.println(ans[i]);
        }
    }


    /*
    ---------------------------------------------------------
    APPROACH 2: BETTER - HASHMAP
    TC: O(N) average
    SC: O(N)

    IDEA:
    Instead of checking every pair using nested loops,
    we use a HashMap to search for the required element.

    For every arr[i]:

        req = target - arr[i]

    We check whether req already exists in the HashMap.

    If it exists:
        We have found the required pair.

    If it doesn't exist:
        We store the current element and its index.

    HASHMAP:
        Key   -> Array element
        Value -> Original index of that element

    WHY IS IT BETTER THAN BRUTE FORCE?

    Brute force repeatedly searches for the required element
    by checking multiple elements.

    HashMap allows us to check whether the required element
    exists in O(1) average time.

    Therefore, we reduce the time complexity from O(N^2)
    to O(N) average by using additional space.

    ---------------------------------------------------------
    */

    public void Better(int[] arr, int target) {

        // HashMap stores:
        // Key   -> Number
        // Value -> Index of the number
        HashMap<Integer, Integer> map = new HashMap<>();

        // Array to store the answer indices
        int[] nums = new int[2];

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Calculate the number required to reach target
            int req = target - arr[i];

            // Check whether the required number already exists
            if (map.containsKey(req)) {

                // Current element's index
                nums[0] = i;

                // Previously stored required element's index
                nums[1] = map.get(req);
            }

            else {

                // Store the current element and its index
                // so that future elements can find it
                map.put(arr[i], i);
            }
        }

        // Print the answer indices
        for (int num : nums) {
            System.out.println(num);
        }
    }


    /*
    ---------------------------------------------------------
    APPROACH 3: TWO POINTERS
    TC: O(N log N)
    SC: Sorting-dependent

    IDEA:
    Two Pointer approach requires a sorted array.

    We place:
        left  -> At the beginning of the sorted array
        right -> At the end of the sorted array

    We calculate:

        sum = arr[left] + arr[right]

    CASE 1: sum < target
        The sum is too small.
        Move left forward to try a larger element.

    CASE 2: sum > target
        The sum is too large.
        Move right backward to try a smaller element.

    CASE 3: sum == target
        We have found the required pair.

    WHY DOES IT WORK?

    Because the array is sorted.

    If the sum is smaller than target:
        Moving right backward would make the sum even smaller.
        Therefore, we move left forward.

    If the sum is greater than target:
        Moving left forward would make the sum even greater.
        Therefore, we move right backward.

    SORTING:
        Arrays.sort() sorts the array in ascending order.

    TIME COMPLEXITY:
        Sorting       -> O(N log N)
        Pointer search -> O(N)

        Overall -> O(N log N)

    SPACE COMPLEXITY:
        Sorting an int[] using Java's Arrays.sort() generally
        uses stack space, commonly O(log N), rather than
        creating a separate array of N elements.

    LIMITATION FOR LEETCODE 1:

        This implementation prints the PAIR VALUES,
        not the original indices.

        Also, sorting changes the original array's order.

        Therefore, this implementation demonstrates the
        Two Pointer pair-sum technique, but does not fully
        satisfy LeetCode 1's original-index requirement.

        To return original indices using Two Pointers,
        we must preserve indices while sorting, for example
        by sorting value-index pairs.

    ---------------------------------------------------------
    */

    public void optimal(int[] arr, int target) {

        // Initialize the two pointers
        int left = 0;
        int right = arr.length - 1;

        // Sort the array before applying Two Pointers
        Arrays.sort(arr);

        // Continue while the pointers haven't crossed
        while (left < right) {

            // Calculate the sum of the elements at both pointers
            int sum = arr[left] + arr[right];

            // If the sum is smaller than target,
            // we need a larger sum
            if (sum < target) {
                left++;
            }

            // If the sum is greater than target,
            // we need a smaller sum
            else if (sum > target) {
                right--;
            }

            // If the sum equals target, pair is found
            else {
                System.out.println(arr[left] + " " + arr[right]);
                break;
            }
        }
    }
}


/*
===========================================================
                  FINAL COMPARISON
===========================================================

APPROACH          TIME COMPLEXITY       SPACE COMPLEXITY
-----------------------------------------------------------
Brute Force       O(N^2)                O(1)
HashMap           O(N) average          O(N)
Two Pointers      O(N log N)            Sorting-dependent
-----------------------------------------------------------

BEST APPROACH FOR LEETCODE 1:
    HASHMAP

WHY?

    1. O(N) average time complexity.
    2. Does not require sorting.
    3. Preserves original indices.
    4. Works with negative numbers.
    5. Works with duplicate values.
    6. Satisfies the follow-up of less than O(N^2).

===========================================================

DSA LEARNING:

BRUTE FORCE:
    Check every possible pair.

HASHING:
    Use additional space to reduce searching time.

TWO POINTERS:
    Use sorted order to eliminate unnecessary comparisons.

===========================================================
*/