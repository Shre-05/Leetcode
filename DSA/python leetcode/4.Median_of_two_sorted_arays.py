'''4. Median of Two Sorted Arrays
Solved
Hard
Topics
premium lock icon
Companies
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 10'''

# tc=O(nlogn)
# sc=O(n)
class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        new=[]
        for x in nums1:
            new.append(x)
        for x in nums2:
            new.append(x)
        new.sort()
        if(len(new)%2!=0):
            mid=len(new)//2
            return new[mid]
        else:
            mid=len(new)//2
            nmid=mid-1
            median=(new[nmid]+new[mid])/2
            return median
        
s=Solution()
nums1=[1,3]
nums2=[2]
print(s.findMedianSortedArrays(nums1,nums2))