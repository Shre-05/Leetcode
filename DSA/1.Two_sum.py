'''1. Two Sum
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists'''
'''class Two_sum{
    public int[] twoSum(int []nums,int target){
        int []arr=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]+nums[j]==target && i!=j){
                    arr[0]=i;
                    arr[1]=j;
                }            
            }
        }
        return arr;
    }
    public static void main(String []args){
        int []nums={2,7,11,15};
        int target=9;
        Two_sum s=new Two_sum();
        int []result=s.twoSum(nums,target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}'''

# Brute force approach
'''class Solution:
    def twoSum(self,nums:list[int],target:int)->list[int]:
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                if(nums[i]+nums[j]==target):
                    return [i,j]
                
s=Solution()
nums=[2,7,11,15]
target=9
result=s.twoSum(nums,target)
print(result)'''

# Optimized approach
'''class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        dict={}
        for i in range(len(nums)):
            if(target-nums[i]) in dict:
                return(i,dict[target-nums[i]])
            dict[nums[i]]=i

s=Solution()
nums=[2,7,11,15]
target=9
result=s.twoSum(nums,target)
print(result)'''
