/*
485. Max Consecutive Ones
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1. */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_count=0;
        int curr_count=0;
        int i=0;

        while(i<nums.length){
            if(nums[i]==1){
                curr_count++;
            }
            else{
                max_count=Math.max(max_count,curr_count);
                curr_count=0;
            }
            i++;
        }
        if(i==nums.length){
            max_count=Math.max(max_count,curr_count);
        }
        return max_count;
    }
}