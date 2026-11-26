/*
16. 3Sum Closest
Medium
Topics
premium lock icon
Companies
You are given an integer array nums of length n and an integer target.

Find three integers at distinct indices in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104 */
import java.util.*;
class ThreeSumClosest{
    public static void main(String[] args) {
        ThreeSumClosestSolution t=new ThreeSumClosestSolution();
        int[] arr = {-8, -3, 1, 4, 6, 10};
        System.out.println(t.optimal(arr,arr.length,13));
    }
}
class ThreeSumClosestSolution{
    public int optimal(int []arr,int n,int target){
        int closet=arr[0]+arr[1]+arr[2];

        for(int i=0;i<n;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];

                if(Math.abs(target-sum)<Math.abs(target-closet)){
                    closet=sum;
                }
                if(sum<target){
                    j++;
                }
                else if(sum>target){
                    k--;
                }
                else{
                    return sum;
                }
            }
            
            
            
        }
        return closet;
    }
}