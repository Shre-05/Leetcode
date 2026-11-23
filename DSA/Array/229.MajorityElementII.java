/*
229. Majority Element II
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array of size n, find all elements that appear more than ⌊n / 3⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 

Follow up: Could you solve the problem in linear time and in O(1) space? */
import java.util.*;

class MajorityElementII {
    public static void main(String[] args) {

        MajorityElementIISolution m = new MajorityElementIISolution();

        int[] arr = {1, 2};

        // Approach 1: Brute Force
        m.Brute(arr, arr.length);

        // Approach 2: HashMap
        m.Better(arr, arr.length);

        // Approach 3: Optimal - Extended Boyer-Moore Voting Algorithm
        m.optimal(arr, arr.length);
    }
}

class MajorityElementIISolution {

    /*
    ============================================================
    APPROACH 1: BRUTE FORCE
    ============================================================

    Idea:
    For every element, count its frequency in the entire array.
    If its frequency is greater than n/3, add it to the result.

    Steps:
    1. Pick an element arr[i].
    2. Count how many times it occurs in the array.
    3. If its frequency > n/3, it is a majority element.
    4. Add it to the result.
    5. Avoid adding the same element more than once.

    Time Complexity (TC): O(N^2)
    - Outer loop traverses the array.
    - Inner loop counts the frequency of each selected element.
    - Each frequency count takes O(N).
    - Overall O(N * N) = O(N^2).

    Space Complexity (SC): O(1) auxiliary space
    - Only a few variables are used for counting.
    - The output list is not considered auxiliary space.

    Limitation:
    - The same element may be counted repeatedly.
    - Repeated frequency calculations waste time.

    Why is the next approach better?
    - A HashMap stores the frequency of each element.
    - We no longer need to repeatedly count the same elements.
    - Time complexity improves from O(N^2) to O(N).

    ============================================================
    */

    public void Brute(int[] arr, int n) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // Avoid checking an element already considered
            boolean alreadyChecked = false;

            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    alreadyChecked = true;
                    break;
                }
            }

            if (alreadyChecked) {
                continue;
            }

            int count = 0;

            // Count frequency of the current element
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            // Check whether frequency exceeds n/3
            if (count > n / 3) {
                result.add(arr[i]);
            }
        }

        System.out.println(result);
    }


    /*
    ============================================================
    APPROACH 2: HASHMAP
    ============================================================

    Idea:
    Store the frequency of each distinct element in a HashMap.

    HashMap:
    - Key   -> Element
    - Value -> Frequency

    Steps:
    1. Traverse the array and store frequencies.
    2. Traverse the keys in the HashMap.
    3. If the frequency of a key exceeds n/3,
       add it to the result.

    Time Complexity (TC): O(N) average
    - First traversal: O(N) to build the HashMap.
    - Second traversal: O(K), where K is the number of
      distinct elements, and K <= N.
    - Overall O(N + K) = O(N).

    Space Complexity (SC): O(N)
    - In the worst case, the HashMap stores N distinct elements.

    Why is this better than Brute Force?
    - Brute Force repeatedly counts the same elements.
    - HashMap calculates frequencies while traversing the array.
    - This reduces TC from O(N^2) to O(N).

    Limitation:
    - Additional space is needed for the HashMap.

    Why is the next approach better?
    - Extended Boyer-Moore Voting Algorithm maintains
      only two candidates and two counters.
    - It eliminates the HashMap and achieves O(1) auxiliary space.

    ============================================================
    */

    public void Better(int[] arr, int n) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Check which elements occur more than n/3 times
        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                result.add(key);
            }
        }

        System.out.println(result);
    }


    /*
    ============================================================
    APPROACH 3: EXTENDED BOYER-MOORE VOTING ALGORITHM
    ============================================================

    Idea:
    Since an element must occur MORE than n/3 times,
    there can be at most TWO majority elements.

    Why at most two?
    - If three elements each appeared more than n/3 times,
      their combined frequencies would exceed n.
    - This is impossible.
    - Hence, at most two majority elements exist.

    We maintain:
    - el1, el2 -> Two potential candidates.
    - c1, c2   -> Their vote counts.

    PHASE 1: Candidate selection

    CASE 1:
    c1 == 0 and current element != el2
    -> Assign current element to el1.

    CASE 2:
    c2 == 0 and current element != el1
    -> Assign current element to el2.

    CASE 3:
    Current element == el1
    -> Increment c1.

    CASE 4:
    Current element == el2
    -> Increment c2.

    CASE 5:
    Current element matches neither candidate
    -> Decrement both c1 and c2.

    Why cancel both counts?
    - We effectively cancel groups of three distinct elements.
    - A majority element appearing more than n/3 times
      cannot be eliminated through these cancellations.
    - Therefore, the surviving candidates can contain all
      possible majority elements.

    PHASE 2: Verification

    - Candidate selection only identifies potential candidates.
    - It does not guarantee that they actually appear > n/3.
    - We reset both counters.
    - Count the actual frequencies of el1 and el2.
    - Add candidates whose frequency exceeds n/3.

    Time Complexity (TC): O(N)
    - First traversal finds potential candidates.
    - Second traversal verifies their frequencies.
    - Both traversals take O(N).
    - Overall O(N).

    Space Complexity (SC): O(1) auxiliary space
    - Only two candidates and two counters are maintained.
    - No frequency map or additional array is used.
    - The output list is excluded from auxiliary space.

    Why is this better than HashMap?
    - HashMap uses O(N) auxiliary space.
    - Boyer-Moore uses O(1) auxiliary space.
    - Both run in O(N) time.
    - Hence, Boyer-Moore is optimal for this problem.

    ============================================================
    */

    public void optimal(int[] arr, int n) {

        int c1 = 0, c2 = 0;
        int el1 = 0, el2 = 0;

        // PHASE 1: Identify the two potential candidates
        for (int i = 0; i < n; i++) {

            // Candidate 1 needs replacement
            if (c1 == 0 && arr[i] != el2) {
                c1 = 1;
                el1 = arr[i];
            }

            // Candidate 2 needs replacement
            else if (c2 == 0 && arr[i] != el1) {
                c2 = 1;
                el2 = arr[i];
            }

            // Current element matches candidate 1
            else if (arr[i] == el1) {
                c1++;
            }

            // Current element matches candidate 2
            else if (arr[i] == el2) {
                c2++;
            }

            // Current element matches neither candidate
            else {
                c1--;
                c2--;
            }
        }

        // PHASE 2: Verify the actual frequencies
        c1 = 0;
        c2 = 0;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (arr[i] == el1) {
                c1++;
            }
            else if (arr[i] == el2) {
                c2++;
            }
        }

        // Add candidate 1 if it is actually a majority
        if (c1 > n / 3) {
            result.add(el1);
        }

        // Add candidate 2 if it is actually a majority
        if (c2 > n / 3) {
            result.add(el2);
        }

        System.out.println(result);
    }
}