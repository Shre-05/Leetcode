public class ConsecutiveOnes {
    public static void main(String[] args) {
        ConsecutiveOnesSolution c = new ConsecutiveOnesSolution();

        int[] arr = {1, 1, 2, 3, 3, 4, 4};

        c.brute(arr);
        c.Better(arr);
        c.optimal(arr);
    }
}

class ConsecutiveOnesSolution {

    /*
     * BRUTE FORCE APPROACH
     *
     * Goal: Find the first element that occurs exactly once.
     *
     * Logic:
     * 1. Pick an element arr[i].
     * 2. Traverse the entire array and count its occurrences.
     * 3. If its frequency is exactly 1, print it and break.
     *
     * TC: O(N^2)
     * - Outer loop traverses N elements.
     * - Inner loop traverses N elements to calculate frequency.
     * - Therefore, O(N * N) = O(N^2).
     *
     * SC: O(1)
     * - Only a few variables are used.
     * - No additional data structure is created.
     */
    public void brute(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int num = arr[i];
            int count = 0;

            // Count the occurrences of the current element
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == num) {
                    count++;
                }
            }

            // If the element occurs exactly once, print and stop
            if (count == 1) {
                System.out.println(num);
                break;
            }
        }
    }


    /*
     * BETTER APPROACH: FREQUENCY HASHING USING ARRAY
     *
     * Logic:
     * 1. Find the maximum element in the array.
     * 2. Create a frequency array of size maxi + 1.
     * 3. Use the original elements as indices of the frequency array.
     * 4. Increment the frequency of each element.
     * 5. Traverse the frequency array to find elements
     *    whose frequency is exactly 1.
     *
     * TC: O(N + M)
     * - Finding maximum: O(N)
     * - Updating frequency array: O(N)
     * - Traversing frequency array: O(M)
     * - M = maxi + 1
     *
     * SC: O(M)
     * - Additional frequency array of size maxi + 1.
     *
     * Limitations:
     * - Works for non-negative numbers in this implementation.
     * - If maxi is extremely large, allocating the frequency
     *   array can waste memory.
     * - Negative values cannot directly be used as array indices.
     */
    public void Better(int[] arr) {

        // 1. Find the maximum element - O(N)
        int maxi = 0;

        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        // 2. Create frequency array - SC: O(maxi + 1)
        int[] HashArray = new int[maxi + 1];

        // 3. Count the frequency of each element - O(N)
        for (int i = 0; i < arr.length; i++) {
            HashArray[arr[i]]++;
        }

        // 4. Find elements occurring exactly once - O(maxi + 1)
        for (int i = 0; i < HashArray.length; i++) {
            if (HashArray[i] == 1) {
                System.out.println(i);
                // No break because this prints ALL unique elements.
            }
        }
    }


    /*
     * OPTIMAL APPROACH: XOR
     *
     * Logic:
     * XOR has the following properties:
     *
     * 1. a ^ a = 0
     * 2. a ^ 0 = a
     * 3. XOR is commutative and associative.
     *
     * If every element occurs exactly twice except ONE element,
     * XOR cancels the duplicate pairs and leaves the single element.
     *
     * Example:
     * 1 ^ 1 ^ 2 ^ 3 ^ 3 ^ 4 ^ 4
     *
     * = (1 ^ 1) ^ 2 ^ (3 ^ 3) ^ (4 ^ 4)
     * = 0 ^ 2 ^ 0 ^ 0
     * = 2
     *
     * TC: O(N)
     * - One traversal of the array.
     *
     * SC: O(1)
     * - Only one variable is used.
     *
     * IMPORTANT LIMITATION:
     * This approach is valid when every other element occurs
     * exactly twice and only one element occurs once.
     *
     * It does NOT generally find the first element occurring once.
     * It also fails to identify a unique element if multiple
     * elements have odd frequencies.
     */
    public void optimal(int[] arr) {

        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        System.out.println(xor);
    }
}