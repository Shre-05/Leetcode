/*
15. 3Sum
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105 */

import java.util.*;

class ThreeSum {
    public static void main(String[] args) {
        ThreeSumSolution s = new ThreeSumSolution();

        int[] arr = {-1, 0, 1, 2, -1, -4};

        s.Brute(arr, arr.length);
        s.Better(arr, arr.length);
        s.optimal(arr, arr.length);
    }
}

class ThreeSumSolution {

    // =========================================================
    // APPROACH 1: BRUTE FORCE
    // =========================================================

    public void Brute(int[] arr, int n) {

        Set<List<Integer>> set = new HashSet<>();

        // Try every possible combination of 3 elements.
        // i < j < k ensures that the same index isn't reused
        // and avoids checking index permutations.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (arr[i] + arr[j] + arr[k] == 0) {

                        List<Integer> curr = new ArrayList<>();
                        curr.add(arr[i]);
                        curr.add(arr[j]);
                        curr.add(arr[k]);

                        // Sort each triplet so different permutations
                        // become identical, e.g. [-1,0,1] and [1,-1,0].
                        Collections.sort(curr);

                        // HashSet eliminates duplicate triplets.
                        set.add(curr);
                    }
                }
            }
        }

        System.out.println("Brute: " + set);
    }

    /*
     * WHY BRUTE FORCE?
     * Checks all possible triplets.
     * Easy to understand but inefficient for large arrays.
     *
     * TIME COMPLEXITY:
     * O(n^3) for the three nested loops.
     * Sorting a triplet takes O(1), as it contains only 3 elements.
     *
     * AUXILIARY SPACE:
     * O(1) excluding the result set.
     *
     * SPACE INCLUDING OUTPUT:
     * O(number of unique triplets).
     */


    // =========================================================
    // APPROACH 2: BETTER - HASHING
    // =========================================================

    public void Better(int[] arr, int n) {

        Set<List<Integer>> ans = new HashSet<>();

        // Fix one element arr[i].
        for (int i = 0; i < n; i++) {

            // Stores elements encountered previously
            // in the current iteration of i.
            Set<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                // Calculate the third element needed
                // to make the sum equal to zero.
                int third = -(arr[i] + arr[j]);

                // If third was already encountered,
                // a valid triplet exists.
                if (set.contains(third)) {

                    List<Integer> curr = new ArrayList<>();
                    curr.add(arr[i]);
                    curr.add(arr[j]);
                    curr.add(third);

                    // Canonical ordering to eliminate
                    // duplicate triplets in the result set.
                    Collections.sort(curr);

                    ans.add(curr);
                }

                // Add arr[j] AFTER checking.
                // This ensures we don't use the same element
                // as both arr[j] and third.
                set.add(arr[j]);
            }
        }

        System.out.println("Better: " + ans);
    }

    /*
     * WHY IS THIS BETTER?
     *
     * Instead of using a third nested loop to search for the
     * third element, we use a HashSet for lookup.
     *
     * We fix arr[i], then for each arr[j], we calculate
     * the required third element and check if it exists
     * in the HashSet.
     *
     * This reduces the time complexity from O(n^3) to O(n^2)
     * on average.
     *
     * TIME COMPLEXITY:
     * O(n^2) average.
     * Two nested loops + average O(1) HashSet lookup.
     * Sorting a triplet is O(1).
     *
     * AUXILIARY SPACE:
     * O(n) for the inner HashSet.
     *
     * SPACE INCLUDING OUTPUT:
     * O(n + number of unique triplets).
     */


    // =========================================================
    // APPROACH 3: OPTIMAL - SORTING + TWO POINTERS
    // =========================================================

    public void optimal(int[] arr, int n) {

        // Sorting allows us to intelligently move pointers
        // based on whether the sum is smaller or larger than 0.
        Arrays.sort(arr);

        // No HashSet is required for the result because
        // we explicitly skip duplicates.
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // Skip duplicate values for the first element.
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            // j and k move towards each other.
            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];

                if (sum < 0) {
                    // Sum is too small.
                    // Increase it by moving j right.
                    j++;
                }
                else if (sum > 0) {
                    // Sum is too large.
                    // Decrease it by moving k left.
                    k--;
                }
                else {

                    // Found a valid triplet.
                    List<Integer> curr = new ArrayList<>();
                    curr.add(arr[i]);
                    curr.add(arr[j]);
                    curr.add(arr[k]);

                    ans.add(curr);

                    // Move both pointers to look for
                    // the next possible triplet.
                    j++;
                    k--;

                    // Skip duplicate values for j.
                    while (j < k && arr[j] == arr[j - 1])
                        j++;

                    // Skip duplicate values for k.
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                }
            }
        }

        System.out.println("Optimal: " + ans);
    }

    /*
     * WHY IS THIS OPTIMAL?
     *
     * Sorting the array allows us to use two pointers.
     *
     * Instead of searching for the third element using
     * hashing, we adjust j and k based on the sum.
     *
     * Since the array is sorted:
     *
     * sum < 0  -> move j forward to increase the sum.
     * sum > 0  -> move k backward to decrease the sum.
     * sum == 0 -> record the triplet and move both.
     *
     * Duplicate values are skipped directly, so a HashSet
     * is not needed to store the result.
     *
     * TIME COMPLEXITY:
     * O(n log n) for sorting + O(n^2) for traversal.
     * Overall: O(n^2).
     *
     * AUXILIARY SPACE:
     * O(1) auxiliary space, excluding output
     * (assuming in-place sorting).
     *
     * SPACE INCLUDING OUTPUT:
     * O(number of unique triplets).
     */
}
