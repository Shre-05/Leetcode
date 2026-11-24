import java.util.ArrayList;

public class ArrayLeaders {
    public static void main(String[] args) {

        int[] arr = {10, 22, 12, 3, 0, 6};

        ArrayLeadersSolution a = new ArrayLeadersSolution();

        // Brute Force Approach
        a.Brute(arr, arr.length);

        System.out.println();

        // Optimal Approach
        a.optimal(arr, arr.length);
    }
}

class ArrayLeadersSolution {

    // ============================================================
    // BRUTE FORCE APPROACH
    // ============================================================
    // INTUITION:
    // For every element, we check all the elements to its right.
    // If we find any element greater than the current element,
    // then the current element cannot be a leader.
    //
    // An element is a leader if it is greater than or equal
    // to every element present on its right.
    //
    // TC: O(N^2)
    //     Outer loop runs N times.
    //     For every element, the inner loop can traverse
    //     the remaining elements.
    //
    // SC: O(N)
    //     ArrayList stores the leaders.
    //     In the worst case, all N elements can be leaders.
    // ============================================================

    public void Brute(int[] arr, int n) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Traverse each element and check whether it is a leader
        for (int i = 0; i < arr.length; i++) {

            // Initially, assume the current element is a leader
            boolean flag = true;

            // Check all elements present to the right
            for (int j = i + 1; j < arr.length; j++) {

                // If any element to the right is greater,
                // then the current element is NOT a leader.
                if (arr[j] > arr[i]) {
                    flag = false;
                    break; // No need to check further
                }
            }

            // If no greater element was found on the right,
            // the current element is a leader.
            if (flag == true) {
                ans.add(arr[i]);
            }
        }

        // Print all the leaders in their original order
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }


    // ============================================================
    // OPTIMAL APPROACH
    // ============================================================
    // INTUITION:
    // Instead of checking every element to the right repeatedly,
    // traverse the array from RIGHT TO LEFT.
    //
    // Maintain maxi, which stores the maximum element encountered
    // so far while traversing from right to left.
    //
    // If arr[i] >= maxi, then arr[i] is a leader because
    // no element to its right is greater than arr[i].
    //
    // Every time we encounter a leader, add it to the answer.
    //
    // Since we traverse from right to left, the leaders are
    // collected in reverse order. Therefore, print them
    // from the end of the ArrayList to restore original order.
    //
    // TC: O(N)
    //     We traverse the array once to identify leaders.
    //     Printing the answer takes at most O(N).
    //
    // SC: O(N)
    //     ArrayList stores the leaders.
    //     In the worst case, all N elements can be leaders.
    // ============================================================

    public void optimal(int[] arr, int n) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Stores the maximum element seen so far
        // while traversing from right to left.
        int maxi = Integer.MIN_VALUE;

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {

            // If the current element is greater than or equal
            // to the maximum element on its right,
            // it qualifies as a leader.
            if (arr[i] >= maxi) {
                ans.add(arr[i]);
            }

            // Update the maximum element seen so far
            maxi = Math.max(maxi, arr[i]);
        }

        // Leaders were collected from right to left.
        // Print them in their original left-to-right order.
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i) + " ");
        }
    }
}