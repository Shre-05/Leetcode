import java.util.*;

class SortColors {
    public static void main(String[] args) {
        SortColorsSolution s = new SortColorsSolution();

        int[] arr = {0,1,1,0,1,2,1,2,0,0,0};

        // Approach 1: Merge Sort
        s.Brute(arr, arr.length-1);
        s.printArray(arr);

        int[] arr2 = {0,1,1,0,1,2,1,2,0,0,0};

        // Approach 2: Counting
        s.Better(arr2);
        s.printArray(arr2);

        int[] arr3 = {0,1,1,0,1,2,1,2,0,0,0};

        // Approach 3: Dutch National Flag Algorithm
        s.optimal(arr3);
    }
}

class SortColorsSolution {

    /*
    ============================================================
    APPROACH 1: MERGE SORT
    ============================================================

    Idea:
    Instead of specifically exploiting the fact that the array
    contains only 0, 1 and 2, we use a general-purpose sorting
    algorithm (Merge Sort) to sort the entire array.

    Merge Sort works by:
    1. Dividing the array into two halves.
    2. Recursively sorting both halves.
    3. Merging the sorted halves.

    Why is this not the most efficient approach for this problem?
    - Merge Sort is designed to sort general arrays containing
      arbitrary values.
    - Here, we only have three distinct values: 0, 1 and 2.
    - Using a general sorting algorithm doesn't exploit this
      restricted input.

    Time Complexity (TC):
    O(N log N)
    - The array is divided into halves log N times.
    - Each level requires O(N) work during merging.
    - Therefore, total time = O(N log N).

    Space Complexity (SC):
    O(N)
    - Temporary arrays/lists are used during merging.
    - The recursion stack additionally takes O(log N).
    - The temporary merge storage dominates, so SC = O(N).

    Conclusion:
    Correct, but unnecessarily expensive compared to approaches
    specifically designed for an array containing only 0, 1 and 2.
    ============================================================
    */

    public void Brute(int[] arr, int n) {
        mergeSort(arr, 0, n);
    }

    void mergeSort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        ArrayList<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = 0; i < temp.size(); i++) {
            arr[low + i] = temp.get(i);
        }
    }

    /*
    ============================================================
    APPROACH 2: COUNTING
    ============================================================

    Idea:
    Since the array contains only 0, 1 and 2, instead of sorting
    individual elements, we count the frequency of each value.

    Steps:
    1. Traverse the array and count the number of 0s, 1s and 2s.
    2. Overwrite the array:
       - First, place all 0s.
       - Next, place all 1s.
       - Finally, place all 2s.

    Why is this better than Merge Sort?
    - Merge Sort sorts elements through divide-and-conquer.
    - Here, we don't need a general sorting algorithm.
    - We exploit the fact that only 3 distinct values exist.
    - We eliminate the temporary merge storage.
    - We achieve linear time instead of O(N log N).

    Time Complexity (TC):
    O(N)
    - First traversal: O(N) to count frequencies.
    - Second traversal: O(N) to overwrite the array.
    - Total: O(N) + O(N) = O(N).

    Space Complexity (SC):
    O(1)
    - We use only three integer variables for counting.
    - No additional array or data structure proportional to N.

    Conclusion:
    Better than Merge Sort in this problem because it takes
    linear time and constant auxiliary space.

    However:
    - It still requires two passes through the array.
    - We first count and then reconstruct the array.

    Can we do it in a single pass without counting?
    Yes -> Dutch National Flag Algorithm.
    ============================================================
    */

    public void Better(int[] arr) {

        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        // First pass: Count the frequency of 0, 1 and 2
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                cnt0++;
            else if (arr[i] == 1)
                cnt1++;
            else
                cnt2++;
        }

        // Second pass: Overwrite the array with all 0s
        for (int i = 0; i < cnt0; i++) {
            arr[i] = 0;
        }

        // Place all 1s after the 0s
        for (int i = cnt0; i < cnt0 + cnt1; i++) {
            arr[i] = 1;
        }

        // Place all 2s in the remaining positions
        for (int i = cnt0 + cnt1; i < arr.length; i++) {
            arr[i] = 2;
        }
    }

    /*
    ============================================================
    APPROACH 3: DUTCH NATIONAL FLAG ALGORITHM (OPTIMAL)
    ============================================================

    Idea:
    Sort the array in a single traversal using three pointers:
    low, mid and high.

    We divide the array into four conceptual regions:

    [0 ... low-1]       -> All 0s
    [low ... mid-1]     -> All 1s
    [mid ... high]      -> Unprocessed elements
    [high+1 ... N-1]    -> All 2s

    Initially:
    low = 0
    mid = 0
    high = N-1

    We examine arr[mid]:

    CASE 1: arr[mid] == 0
    - 0 belongs in the leftmost region.
    - Swap arr[mid] with arr[low].
    - Increment low and mid.

    Why increment both?
    - The 0 has been placed in its correct region.
    - The element swapped into mid is either 0 or 1 and is
      already handled appropriately in this case because low
      is within the 0/1 boundary before mid.
    - Hence, both pointers move forward.

    CASE 2: arr[mid] == 1
    - 1 already belongs in the middle region.
    - Simply increment mid.

    CASE 3: arr[mid] == 2
    - 2 belongs in the rightmost region.
    - Swap arr[mid] with arr[high].
    - Decrement high.

    Why DON'T we increment mid here?
    - The element swapped from arr[high] into arr[mid] is
      unknown and hasn't been processed yet.
    - Therefore, we must examine the same mid position again.

    Time Complexity (TC):
    O(N)
    - Each element is processed and the pointers move across
      the array.
    - Although swaps occur, each pointer movement reduces the
      unprocessed region.
    - The array is processed in a single traversal.

    Space Complexity (SC):
    O(1)
    - Only three pointers and a temporary variable for swapping.
    - No extra array or data structure is used.

    Why is this optimal?
    - Counting approach: O(N) time, O(1) space, but two passes.
    - Dutch National Flag: O(N) time, O(1) space, one pass.
    - We directly rearrange elements without counting or
      reconstructing the array.

    This is the optimal solution for this problem.

    ============================================================
    */

    public void optimal(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            // Case 1: Current element is 0
            if (arr[mid] == 0) {
                swap(arr, low, mid);

                // Expand the 0-region
                low++;
                mid++;
            }

            // Case 2: Current element is 1
            else if (arr[mid] == 1) {

                // 1 already belongs in the middle region
                mid++;
            }

            // Case 3: Current element is 2
            else {
                swap(arr, mid, high);

                // Expand the 2-region
                high--;

                // Don't increment mid:
                // The swapped-in element is still unprocessed.
            }
        }

        printArray(arr);
    }

    // Swaps elements at indices i and j
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Prints the array
    void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}