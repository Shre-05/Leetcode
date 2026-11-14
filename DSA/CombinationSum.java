/*
39. Combination Sum
Medium
Topics
premium lock icon
Companies
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40 */

import java.util.*;

class ComibationSum{
    public static void main(String[] args) {
        int[] arr={2,3,6,7};
        comSum(arr,0,7,new ArrayList<>());
    }
    private static void comSum(int []arr,int i,int target,ArrayList<Integer>Curr){
        // base condition
        if(i==arr.length){
            if(target==0){
                System.out.println(Curr);
            }
            return;
        }
        if(arr[i]<=target){
            // pick
            Curr.add(arr[i]);
            comSum(arr, i, target-arr[i], Curr);

            
            Curr.remove(Curr.size()-1);
            
        }
        // not to pick up
        comSum(arr, i+1, target, Curr);
    }
}

// leetcode
// tc-2^n+(T/M)
// sc-O(n+(T/M))
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return comSum(candidates,target,0,new ArrayList<>(),new ArrayList<>());
    }
    private static List<List<Integer>> comSum(int arr[],int target,int i,ArrayList<Integer>Curr, List<List<Integer>>ans){
        // base condition
        if(target==0){
            ans.add(new ArrayList<>(Curr));
            return ans;
        }
        if(i==arr.length){
            return ans;
        }
        // loop
        if(arr[i]<=target){
            // pick
            Curr.add(arr[i]);
            comSum(arr,target-arr[i],i,Curr,ans);

            // remove
            Curr.remove(Curr.size()-1);
        }
        comSum(arr,target,i+1,Curr,ans);

        return ans;
    }
}
