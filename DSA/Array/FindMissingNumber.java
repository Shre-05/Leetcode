import java.util.*;

public class FindMissingNumber {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5};
        int n = 5;

        FindMissingNumberSolution f = new FindMissingNumberSolution();

        System.out.println("Brute Force:");
        f.Brute(arr, n);

        System.out.println("Better (Hashing):");
        f.Better(arr, n);

        System.out.println("Optimal (Sum Formula):");
        f.OptimalUsingSum(arr, n);

        System.out.println("Optimal (XOR):");
        f.OptimalUsingXOR(arr, n);
    }
}

class FindMissingNumberSolution {

    /*
     =========================================================
     APPROACH 1: BRUTE FORCE
     =========================================================

     Idea:
     - Check every number from 1 to N.
     - For each number, search the entire array to check
       whether that number exists.
     - If it does not exist, it is the missing number.

     TC: O(N * N) = O(N^2)
     SC: O(1)
    */

    public void Brute(int arr[], int n) {

        // Check every number in the range 1 to N
        for (int i = 1; i <= n; i++) {

            int flag = 0;

            // Search for the current number i in the array
            for (int j = 0; j < arr.length; j++) {

                if (arr[j] == i) {
                    flag = 1;  // Number found
                    break;     // No need to search further
                }
            }

            // If flag remains 0, the number is missing
            if (flag == 0) {
                System.out.println(i);
                break; // Exactly one number is missing
            }
        }
    }


    /*
     =========================================================
     APPROACH 2: BETTER - HASHING
     =========================================================

     Idea:
     - Create a hash array of size N+1.
     - The index represents the number.
     - Initially, every index contains 0.
     - Traverse the given array and mark the corresponding
       index in the hash array as 1.
     - Traverse the hash array from 1 to N.
     - The index containing 0 represents the missing number.

     Example:
     arr = {1, 2, 4, 5}
     N = 5

     hash[1] = 1
     hash[2] = 1
     hash[3] = 0  <-- missing
     hash[4] = 1
     hash[5] = 1

     TC: O(N)
     SC: O(N)
    */

    public void Better(int arr[], int n) {

        // Hash array to track the presence of each number
        // Java automatically initializes int arrays with 0
        int hash[] = new int[n + 1];

        // Mark the presence of each array element
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] = 1;
        }

        // Find the index that was never marked
        for (int i = 1; i < hash.length; i++) {

            if (hash[i] == 0) {
                System.out.println(i);
                break;
            }
        }
    }


    /*
     =========================================================
     APPROACH 3: OPTIMAL - SUM FORMULA
     =========================================================

     Idea:
     - The sum of numbers from 1 to N is:

           Sum = N * (N + 1) / 2

     - Calculate the expected sum.
     - Calculate the actual sum of the array.
     - Subtract the actual sum from the expected sum.

           Missing Number = Expected Sum - Actual Sum

     TC: O(N)
     SC: O(1)

     NOTE:
     int may overflow for sufficiently large N.
     Therefore, use long for calculations.
    */

    public void OptimalUsingSum(int arr[], int n) {

        // Expected sum of numbers from 1 to N
        long sum1 = (long) n * (n + 1) / 2;

        // Calculate actual sum of the given array
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // The difference gives the missing number
        long missingNumber = sum1 - sum;

        System.out.println(missingNumber);
    }


    /*
     =========================================================
     APPROACH 4: OPTIMAL - XOR
     =========================================================

     Idea:
     XOR properties:

     1. a ^ a = 0
     2. a ^ 0 = a
     3. XOR is associative and commutative

     - XOR all numbers from 1 to N.
     - XOR all elements of the given array.
     - XOR the two results.

     All numbers appearing in both sets cancel out.
     The missing number remains.

     TC: O(N)
     SC: O(1)
    */

    public void OptimalUsingXOR(int arr[], int n) {

        int xor1 = 0;
        int xor2 = 0;

        // XOR of all numbers from 1 to N
        for (int i = 1; i <= n; i++) {
            xor1 = xor1 ^ i;
        }

        // XOR of all elements present in the array
        for (int i = 0; i < arr.length; i++) {
            xor2 = xor2 ^ arr[i];
        }

        // Common elements cancel out
        int res = xor1 ^ xor2;

        System.out.println(res);
    }
}