/*
40. Combination Sum II
Solved
Medium
Topics
premium lock icon
Companies
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30 */
import java.util.*;
class comSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return comSum(candidates,target,0,new ArrayList<>(),new ArrayList<>());
    }
    private List<List<Integer>> comSum(int arr[],int target,int index,ArrayList<Integer>Curr,List<List<Integer>>ans){
        // base condition
        if(target==0){
            ans.add(new ArrayList<>(Curr));
            return ans;
        }
        // looping through all the indexes
        for(int i=index;i<arr.length;i++){
            // to skip the same candidates
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            // if arr value is greater than target
            if(arr[i]>target){
                break;
            }
            // pick not to pick
            Curr.add(arr[i]);
            comSum(arr,target-arr[i],i+1,Curr,ans);
            Curr.remove(Curr.size()-1);
        }
        return ans; 

    }
    
}
class CombinationSumII{
    public static void main(String[] args) {
        comSum s=new comSum();
        int []arr={1,1,1,2,2};
        int target=4;

        System.out.println(s.combinationSum2(arr, target));

    }
}