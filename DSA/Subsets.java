/*
78. Subsets
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique. */

import java.util.*;
class subsetSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        printSubset(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    void printSubset(int[]nums,int i,ArrayList<Integer>Curr,List<List<Integer>>ans){
        // base condition
        if(i==nums.length){
            ans.add(new ArrayList<>(Curr));
            return;
        }

        // to pick
        Curr.add(nums[i]);
        printSubset(nums,i+1,Curr,ans);

        Curr.remove(Curr.size()-1);

        // not to pick
        printSubset(nums,i+1,Curr,ans);
    }
}
class Subsets{
    public static void main(String[] args) {
        int []arr={3,1,2};
        subsetSolution s=new subsetSolution();
        System.out.println(s.subsets(arr));
        
    }
}