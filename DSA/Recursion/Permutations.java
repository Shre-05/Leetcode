/*
46. Permutations
Solved
Medium
Topics
premium lock icon
Companies
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
 */
import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[]freq=new boolean[nums.length];
        ArrayList<Integer> Curr=new ArrayList<>();
        permut(nums,freq,Curr,ans);
        return ans;
    }
    public List<List<Integer>> permut(int []arr,boolean[]freq,ArrayList<Integer>Curr,List<List<Integer>>ans){
        // base condition
        if(Curr.size()==arr.length){
            ans.add(new ArrayList<>(Curr));
            return ans;
        }

        for(int i=0;i<arr.length;i++){
            if(!freq[i]){
                freq[i]=true;
                Curr.add(arr[i]);
                permut(arr,freq,Curr,ans);
                Curr.remove(Curr.size()-1);
                freq[i]=false;
            }
        }
        return ans;
    }
}


// Approach 2:
class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        per(nums,0,ans);

        return ans;
        
    }
    public List<List<Integer>> per(int []arr,int index,List<List<Integer>> ans){
        //base condition
        if(index==arr.length){
            ArrayList<Integer>Curr=new ArrayList<>();
            for(int nums:arr){
                Curr.add(nums);
            }
            ans.add(Curr);
            return ans;
        }

        for(int i=index;i<arr.length;i++){
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