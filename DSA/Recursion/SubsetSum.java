/*
Subset Sums
Difficulty: MediumAccuracy: 72.55%Submissions: 200K+Points: 4
Given an array arr of integers, return the sums of all subsets in the list.  Return the sums in any order.

Examples:

Input: arr[] = [2, 3]
Output: [0, 2, 3, 5]
Explanation: When no elements are taken then Sum = 0. When only 2 is taken then Sum = 2. When only 3 is taken then Sum = 3. When elements 2 and 3 are taken then Sum = 2+3 = 5.
Input: arr[] = [1, 2, 1]
Output: [0, 1, 1, 2, 2, 3, 3, 4]
Explanation: The possible subset sums are 0 (no elements), 1 (either of the 1's), 2 (the element 2), and their combinations.
Input: arr[] = [5, 6, 7]
Output: [0, 5, 6, 7, 11, 12, 13, 18]
Explanation: The possible subset sums are 0 (no elements), 5, 6, 7, and their combinations.
Constraints:

1 ≤ arr.size() ≤ 15
0 ≤ arr[i] ≤ 105
 */
import java.util.*;
public class SubsetSum {
    public static void main(String[] args) {
        int []arr={3,1,2};
        ArrayList<Integer> Result=subsetSum(arr,0,new ArrayList<>(),0);
        Collections.sort(Result);
        System.out.println(Result);
    }
    public static ArrayList<Integer> subsetSum(int arr[],int i,ArrayList<Integer>Curr,int sum){
        // base case
        if(i==arr.length){
            Curr.add(sum);
            return Curr;
        }

        // pick
        subsetSum(arr, i+1, Curr, sum+arr[i]);
        // no pick
        subsetSum(arr, i+1, Curr, sum);

        
        return Curr;
        
    }  
     
}
