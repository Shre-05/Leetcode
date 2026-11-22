/*
525. Contiguous Array
Solved
Medium
Topics
premium lock icon
Companies
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 
525
Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1. */
import  java.util.*;
class ContiguousArray525{
    public static void main(String[] args) {
        ContiguousArraySolution c=new ContiguousArraySolution();
        int[]arr={1,0,0,1,0,0,1,0};
        c.Brute(arr, arr.length);
        c.Better(arr, arr.length);
        c.optimal(arr);
    }
}
class ContiguousArraySolution{
    public void Brute(int[]arr,int n){
        int len=0;
        for(int i=0;i<n;i++){
            int cnt0=0;
            int cnt1=0;
            for(int j=i;j<n;j++){
                if(arr[j]==0){
                    cnt0++;
                }
                else{
                    cnt1++;
                }

                if(cnt0==cnt1){
                    len=Math.max(len,j-i+1);
                }
            }
        }
        System.out.println(len);
    }
    public void Better(int []nums,int n){
        int ps=0;
        int len=0;

        HashMap<Integer,Integer>map=new HashMap<>();

        map.put(0,-1);

        for(int i=0;i<nums.length;i++){

            if(nums[i]==0){
                ps--;
            }else{
                ps++;
            }

            if(map.containsKey(ps)){
                len=Math.max(len,i-map.get(ps));
            }
            if(!map.containsKey(ps)){
                map.put(ps,i);
            }
        }
        System.out.println(len);;
    }

    public void optimal(int []nums){
        int n = nums.length;

        // Array to store the earliest index of each offsetted prefix sum
        int[] arr = new int[2 * n + 1];

        // Mark every state as unvisited
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -5;
        }

        // Offsetted prefix sum 0 was seen before the array at index -1
        arr[n] = -1;

        // Prefix sum starts at 0, but we shift it by n
        int count = n;

        int max_len = 0;

        for (int i = 0; i < n; i++) {

            // Convert 0 to -1 and 1 to +1
            count += (2 * nums[i] - 1);

            // If this prefix sum state is seen for the first time
            if (arr[count] == -5) {
                arr[count] = i;
            } 
            else {
                // Same prefix sum means equal numbers of 0 and 1
                max_len = Math.max(max_len, i - arr[count]);
            }
        }

        System.out.println(max_len);
    }
}