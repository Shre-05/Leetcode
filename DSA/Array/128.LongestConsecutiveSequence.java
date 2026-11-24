/*
128. Longest Consecutive Sequence
Medium
Topics
premium lock icon
Companies
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3
 */

import java.util.HashSet;

class LongestConsecutiveSequence {
    public static void main(String[] args) {

        int[] arr = {102, 4, 100, 101, 1, 3, 2, 1};

        LongestConsecutiveSequenceSolution l =
                new LongestConsecutiveSequenceSolution();

        // Brute Force Approach
        l.Brute(arr);

        // Optimal Approach
        l.optimal(arr);
    }
}

class LongestConsecutiveSequenceSolution {

    // ============================================================
    // BRUTE FORCE APPROACH
    // ============================================================
    // INTUITION:
    // Treat every element as the starting point of a potential
    // consecutive sequence.
    //
    // Starting from x, repeatedly search for x + 1 in the array.
    // If found, increment x and the count.
    // Continue until the next consecutive element is not found.
    //
    // Finally, keep track of the longest sequence encountered.
    //
    // TC: O(N^2)
    //     For every starting element, we may repeatedly search
    //     the entire array to find the next consecutive element.
    //     In the worst case, this results in quadratic time.
    //
    // SC: O(1)
    //     We use only a few variables such as x, cnt, found
    //     and longest. No extra data structure proportional to N
    //     is used.
    // ============================================================

    public void Brute(int[] arr) {

        int longest = 0;

        // Treat every element as the starting point
        for (int i = 0; i < arr.length; i++) {

            int x = arr[i];
            int cnt = 1;

            // Keep searching for the next consecutive element
            while (true) {

                boolean found = false;

                // Search for x + 1 in the entire array
                for (int j = 0; j < arr.length; j++) {

                    if (arr[j] == x + 1) {
                        found = true;
                        break;
                    }
                }

                // If the next consecutive element doesn't exist,
                // we cannot extend this sequence further.
                if (!found) {
                    break;
                }

                // Move to the next consecutive element
                x = x + 1;
                cnt++;
            }

            // Update the longest sequence length found so far
            longest = Math.max(longest, cnt);
        }

        System.out.println(longest);
    }


    // ============================================================
    // OPTIMAL APPROACH - HASHSET
    // ============================================================
    // INTUITION:
    // In brute force, searching for the next consecutive element
    // requires traversing the entire array repeatedly.
    //
    // To eliminate this repeated searching, store all elements
    // inside a HashSet.
    //
    // HashSet provides O(1) average-time membership checking.
    //
    // KEY OBSERVATION:
    // A number can be the START of a consecutive sequence only
    // when its previous number (num - 1) is not present in the set.
    //
    // Example:
    // For the sequence 1, 2, 3, 4:
    // 1 is the starting element because 0 is absent.
    // 2 is not a starting element because 1 exists.
    // 3 is not a starting element because 2 exists.
    // 4 is not a starting element because 3 exists.
    //
    // Therefore, we expand a sequence ONLY from its starting
    // element, avoiding repeatedly traversing the same sequence.
    //
    // TC: O(N) EXPECTED
    //     Step 1: Insert N elements into HashSet -> O(N) expected.
    //     Step 2: Traverse the set and expand sequences.
    //             Because we only expand from sequence starters,
    //             each sequence is explored only once.
    //             Overall expected time -> O(N).
    //
    // SC: O(N)
    //     HashSet stores the elements of the array.
    //     In the worst case, it can contain N distinct elements.
    //
    // WHY BETTER?
    //     Brute force repeatedly scans the entire array to locate
    //     consecutive elements, resulting in O(N^2) time.
    //
    //     HashSet makes searching efficient and the starting-point
    //     condition prevents unnecessary repeated traversal.
    //     Therefore, the expected time reduces to O(N).
    // ============================================================

    public void optimal(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        // STEP 1: Insert all elements into the HashSet.
        // Duplicate elements are automatically eliminated.
        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        // STEP 2: Traverse through the HashSet
        for (int num : set) {

            // If num - 1 is absent, num is the starting point
            // of a potential consecutive sequence.
            if (!set.contains(num - 1)) {

                int current = num;
                int cnt = 1;

                // Keep extending the sequence as long as
                // the next consecutive number exists.
                while (set.contains(current + 1)) {

                    current += 1;
                    cnt += 1;
                }

                // Update the maximum consecutive sequence length
                longest = Math.max(longest, cnt);
            }
        }

        System.out.println(longest);
    }
}