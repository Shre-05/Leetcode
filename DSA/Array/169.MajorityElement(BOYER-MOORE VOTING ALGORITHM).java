import java.util.*;

class MajorityElement {
    public static void main(String[] args) {

        MajorityElementSolution m = new MajorityElementSolution();

        int arr[] = {2,2,3,3,1,2,2};

        // Approach 1: Brute Force
        m.Brute(arr);

        // Approach 2: HashMap
        m.Better(arr);

        // Approach 3: Boyer-Moore Voting Algorithm
        System.out.println(m.majorityElement(arr));
    }
}

class MajorityElementSolution {

    /*
    ============================================================
    APPROACH 1: BRUTE FORCE
    ============================================================

    Idea:
    For every element in the array, count how many times it
    appears in the entire array.

    Steps:
    1. Pick an element arr[i].
    2. Traverse the entire array and count its occurrences.
    3. If its frequency is greater than n/2, it is the majority
       element.
    4. Print it and break.

    Time Complexity (TC): O(N^2)
    - The outer loop iterates through N elements.
    - For every element, the inner loop traverses the entire
      array to count its occurrences.
    - Therefore, O(N * N) = O(N^2).

    Space Complexity (SC): O(1)
    - We use only a few variables such as num and count.
    - No additional data structure is used.

    Limitation:
    - We repeatedly count the frequency of elements.
    - The same element may be counted multiple times.
    - This leads to unnecessary repeated work.

    Why is the next approach better?
    - Instead of repeatedly counting the same elements,
      we can store their frequencies using a HashMap.
    - This avoids repeated traversals and reduces the
      time complexity from O(N^2) to O(N).

    ============================================================
    */

    public void Brute(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int num = arr[i];
            int count = 0;

            // Count occurrences of the current element
            for (int j = 0; j < arr.length; j++) {

                if (num == arr[j]) {
                    count++;
                }
            }

            // Check whether it is the majority element
            if (count > arr.length / 2) {
                System.out.println(num);
                break;
            }
        }
    }


    /*
    ============================================================
    APPROACH 2: HASHMAP / FREQUENCY COUNTING
    ============================================================

    Idea:
    Store the frequency of each distinct element in a HashMap.

    HashMap:
    - Key   -> Element from the array
    - Value -> Frequency of that element

    Steps:
    1. Traverse the array.
    2. Store/update the frequency of each element in the map.
    3. Traverse the keys of the map.
    4. If any element has a frequency greater than n/2,
       return/print that element.

    Time Complexity (TC): O(N)
    - First traversal: O(N) average to build the frequency map.
    - Second traversal: O(K), where K is the number of distinct
      elements. K <= N.
    - Overall: O(N + K) = O(N) average.

    Space Complexity (SC): O(N)
    - In the worst case, the HashMap may store N distinct
      elements.
    - Therefore, auxiliary space is O(N).

    Why is this better than Brute Force?
    - Brute Force repeatedly traverses the entire array
      for every element.
    - HashMap stores frequencies while traversing the array.
    - We avoid repeatedly counting the same elements.
    - TC improves from O(N^2) to O(N).

    Limitation:
0    - We use additional memory to store frequencies.
    - The HashMap can take O(N) space in the worst case.

    Why is the next approach better?
    - Boyer-Moore Voting Algorithm finds the majority element
      without storing frequencies in a HashMap.
    - It achieves O(N) time and O(1) auxiliary space.

    ============================================================
    */

    public void Better(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // First pass: Store the frequency of every element
        for (int i = 0; i < arr.length; i++) {

            int num = arr[i];

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find the element whose frequency is greater than n/2
        for (int key : map.keySet()) {

            if (map.get(key) > arr.length / 2) {
                System.out.println(key);
                break;
            }
        }
    }


    /*
    ============================================================
    APPROACH 3: BOYER-MOORE VOTING ALGORITHM (OPTIMAL)
    ============================================================

    Idea:
    Instead of storing the frequency of every element, we
    maintain two variables:

    1. el  -> Potential majority candidate.
    2. cnt -> Current vote count of the candidate.

    Rules:

    CASE 1: cnt == 0
    - Select the current element as the new candidate.
    - Set cnt = 1.

    CASE 2: Current element == candidate
    - Increment cnt because the candidate receives another vote.

    CASE 3: Current element != candidate
    - Decrement cnt because the current element cancels one
      vote of the existing candidate.

    Why does this work?
    - A majority element appears MORE than n/2 times.
    - This means the majority element has more occurrences
      than all the other elements combined.
    - We can conceptually cancel one majority occurrence
      against one non-majority occurrence.
    - Even after these cancellations, the majority element
      cannot be completely eliminated.
    - Therefore, the surviving candidate will be the majority
      element.

    Time Complexity (TC): O(N)
    - We traverse the array once.
    - Each iteration performs constant-time operations.
    - Therefore, TC = O(N).

    Space Complexity (SC): O(1)
    - We only maintain two variables: el and cnt.
    - No HashMap or additional array is required.
    - Therefore, SC = O(1).

    Why is this better than HashMap?
    - Both approaches have O(N) time complexity.
    - HashMap requires O(N) additional space.
    - Boyer-Moore requires only O(1) additional space.
    - Therefore, Boyer-Moore is optimal for this problem.

    IMPORTANT:
    - This problem guarantees that a majority element exists.
    - Hence, we don't need an additional verification pass.
    - If the majority element were NOT guaranteed to exist,
      we would need to verify the candidate's frequency
      after the first pass.

    ============================================================
    */

    public int majorityElement(int[] nums) {

        int cnt = 0;
        int el = 0;

        for (int i = 0; i < nums.length; i++) {

            // If the current vote count becomes 0,
            // select a new candidate
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            }

            // Same element -> candidate gains a vote
            else if (nums[i] == el) {
                cnt++;
            }

            // Different element -> cancel one vote
            else {
                cnt--;
            }
        }

        // Majority element is guaranteed to exist
        return el;
    }
}