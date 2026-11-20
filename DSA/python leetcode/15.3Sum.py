'''15. 3Sum
Attempted
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105'''

# Brute force approach
# tc-O(n^3)
# sc=O(n)
'''class Solution:
    def threeSum(self,nums:list[int])->list[int]:
        nums.sort()
        myset=set()
        n=len(nums)
        for i in range(0,n):
            for j in range(i+1,n):
                for k in range(j+1,n):
                    if(nums[i]+nums[j]+nums[k])==0:
                         myset.add((nums[i],nums[j],nums[k]))
        return [list(ans) for ans in myset]

s=Solution()
nums=[-1,0,1,2,-1,-4]
print(s.threeSum(nums))'''


# Better
# tc=O(n^2)
# sc=O(n)
'''class Solution:
    def threeSum(self,nums:list[int])->list[int]:
        res_Set=set()
        n=len(nums)
        for i in range(0,n):
            myset=set()
            for j in range(i+1,n):
                third=-(nums[i]+nums[j])
                if third in myset:
                    temp=[nums[i],nums[j],third]
                    temp.sort()
                    res_Set.add(tuple(temp))
                myset.add(nums[j])
        return [list(ans) for ans in res_Set]
s=Solution()
nums=[-1,0,1,2,-1,-4]
print(s.threeSum(nums))'''

# optimal
# tc=O(nlogn)+O(n^2)
# sc=o(no.of triplets)
class Solution:
    def threeSum(self,nums:list[int])->list[int]:
        n=len(nums)
        nums.sort()
        ans=[]
        for i in range(n):
            if(i!=0 and nums[i-1]==nums[i]):
                continue
            j=i+1
            k=n-1
            while(j<k):
                sum=nums[i]+nums[j]+nums[k]
                if(sum<0):
                    j+=1
                elif(sum>0):
                    k-=1
                else:
                    temp=[nums[i],nums[j],nums[k]]
                    ans.append((temp))
                    j+=1
                    k-=1
                    while(j<k and nums[j-1]==nums[j]):
                        j+=1
                    while(j<k and nums[k]==nums[k+1]):
                        k-=1
        return ans
    