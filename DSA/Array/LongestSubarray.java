import java.util.*;

public class LongestSubarray {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};

        LongestSubarraySolution l = new LongestSubarraySolution();

        // Approach 1: Brute Force - generate every subarray and calculate its sum
        l.Brute(arr, 3);

        // Approach 2: Better Brute Force - maintain running sum
        l.betterBrute(arr, 3);

        // Approach 3: Optimal - Prefix Sum + HashMap
        l.optimal(arr, 3);
    }
}

class LongestSubarraySolution {

    // ============================================================
    // APPROACH 1: BRUTE FORCE
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    // ============================================================

    public void Brute(int[] arr, int x) {

        int len = 0; // Stores the maximum length of a subarray with sum x

        // Generate every possible starting index
        for (int i = 0; i < arr.length; i++) {

            // Generate every possible ending index for the starting index i
            for (int j = i; j < arr.length; j++) {

                int sum = 0; // Reset sum for every new subarray

                // Traverse the subarray from i to j to calculate its sum
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                // If the sum of the current subarray equals x
                if (sum == x) {

                    // Update len if the current subarray is longer
                    len = Math.max(len, j - i + 1);
                }
                // if all are +ve
                // if(sum>x){
                //     break;
                // }
            }
        }

        // Print the longest subarray length found
        System.out.println(len);
    }


    // ============================================================
    // APPROACH 2: BETTER BRUTE FORCE
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    // ============================================================

    public void betterBrute(int[] arr, int x) {

        int len = 0; // Stores the maximum length of a subarray with sum x

        // Choose every possible starting index
        for (int i = 0; i < arr.length; i++) {

            int sum = 0; // Running sum for subarrays starting at index i

            // Extend the subarray one element at a time
            for (int j = i; j < arr.length; j++) {

                // Add the current element instead of recalculating the entire sum
                sum += arr[j];

                // Check whether the current subarray sum equals x
                if (sum == x) {

                    // Update the maximum length
                    len = Math.max(len, j - i + 1);
                }
            }
        }

        // Print the longest subarray length found
        System.out.println(len);
    }


    // ============================================================
    // APPROACH 3: OPTIMAL
    // PREFIX SUM + HASHMAP
    // Time Complexity: O(N) average
    // Space Complexity: O(N)
    // ============================================================

    public void optimal(int[] arr, int k) {

        // Stores Prefix Sum -> Earliest Index where that prefix sum occurred
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0; // Maintains the cumulative sum from index 0 to i
        int len = 0;       // Stores the maximum subarray length found

        // Conceptually, before the array starts, prefix sum is 0 at index -1
        // This helps us handle subarrays starting from index 0
        map.put(0, -1);

        // Traverse the array once
        for (int i = 0; i < arr.length; i++) {

            // Update the cumulative prefix sum by adding the current element
            prefixSum += arr[i];

            // We need an earlier prefix sum equal to prefixSum - k
            // Because: Current Prefix Sum - Earlier Prefix Sum = k
            int req = prefixSum - k;

            // If the required prefix sum exists in the map,
            // then the subarray between that index + 1 and i has sum k
            if (map.containsKey(req)) {

                // Calculate the subarray length and update maximum length
                len = Math.max(len, i - map.get(req));
            }

            // Store the current prefix sum only if it has never occurred before
            // We retain the earliest index to maximize subarray length
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        // Print the maximum length of the subarray whose sum equals k
        System.out.println(len);
    }
}