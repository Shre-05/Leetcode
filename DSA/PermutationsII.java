/*
47. Permutations II
Solved
Medium
Topics
premium lock icon
Companies
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10 */
import java.util.*;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        per(nums,0,ans);
        return ans;
    }
    public List<List<Integer>> per(int arr[],int index,List<List<Integer>> ans){
        // base consition
        if(index==arr.length){
            ArrayList<Integer>Curr=new ArrayList<>();
            for(int nums:arr){
                Curr.add(nums);
            }
            ans.add(Curr);
            return ans;
        }

        HashSet<Integer>set=new HashSet<>();
        for(int i=index;i<arr.length;i++){
            if(set.contains(arr[i])){
                continue;
            }
            set.add(arr[i]);
            swap(arr,i,index);
            per(arr,index+1,ans);
            swap(arr,i,index);
        }

        return ans;
    }
    private void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}