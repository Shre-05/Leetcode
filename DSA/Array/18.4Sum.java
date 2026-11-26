/*
18. 4Sum
Medium
Topics
premium lock icon
Companies
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]] */

import java.util.*;

class FourSum{
    public static void main(String[] args) {
        FourSumSolution f=new FourSumSolution();
        int arr[]={1,0,-1,0,-2,2};
        f.optimal(arr, arr.length, 0);
    }
}
class FourSumSolution {
    public void optimal(int[] arr,int n, int target) {
        Arrays.sort(arr);
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n-3;i++){

            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n-2;j++){

                if(j>i+1 && arr[j]==arr[j-1]) continue;
                int k=j+1;
                int l=n-1;

                while(k<l){
                    long sum=(long)arr[i]+arr[j]+arr[k]+arr[l];

                    if(sum<target){
                        k++;
                    }
                    else if(sum>target){
                        l--;
                    }
                    else{
                        ArrayList<Integer>curr=new ArrayList<>();
                        curr.add(arr[i]);
                        curr.add(arr[j]);
                        curr.add(arr[k]);
                        curr.add(arr[l]);

                        ans.add(curr);

                        k++;
                        l--;

                        while(k<l && arr[k]==arr[k-1]) k++;
                        while(k<l && arr[l]==arr[l+1]) l--;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}