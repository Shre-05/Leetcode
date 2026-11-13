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
class Solution {
    //unique elements present
    // {1, 2, 3} -> {}
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<List<Integer>>();
        generateSubsets(subsetList, new ArrayList<Integer>(), 0, nums);
        return subsetList;
    }

    void generateSubsets(List<List<Integer>> subsetList, List<Integer> currList, int idx, int [] nums){
        
        if(idx == nums.length){
            subsetList.add(currList);
            return;
        }
        //skip curr elem 
        generateSubsets(subsetList, new ArrayList<>(currList), idx+1, nums);
        //add curr elem 
        List<Integer> listWithElemAdded = new ArrayList<>(currList);
        listWithElemAdded.add(nums[idx]);
        generateSubsets(subsetList, listWithElemAdded, idx+1, nums);
    }
}