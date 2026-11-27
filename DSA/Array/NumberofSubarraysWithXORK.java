/*
Number of Subarrays With XOR K
Difficulty: Medium

Given an integer array arr and an integer k, find the number of contiguous subarrays whose XOR of all elements is equal to k.

A subarray is a contiguous, non-empty sequence of elements from the array.
Example 1
Input: arr = [4, 2, 2, 6, 4], k = 6

Output: 4


Explanation: The subarrays whose XOR equals 6 are:
- [4, 2] → 4 XOR 2 = 6
- [2, 2, 6] → 2 XOR 2 XOR 6 = 6
- [6] → 6
- [2, 6, 4] → 2 XOR 6 XOR 4 = 6
Note: The subarrays are identified by their positions, so different occurrences count separately.Example 2
Input: arr = [5, 1, 6, 3], k = 2

Output: 1


Example 3
Input: arr = [1, 2, 3, 2], k = 0

Output: 1


Constraints
- \(1 \le arr.length \le 10^5\)
- \(0 \le arr[i] \le 10^9\)
- \(0 \le k \le 10^9\) */

class NumberofSubarraysWithXORK{
    public static void main(String[] args) {
        NumberofSubarraysWithXORKSolution n=new NumberofSubarraysWithXORKSolution();
        int arr[]={4,2,2,6,4};
        n.Brute(arr, arr.length, 6);
        n.Better(arr, arr.length, 6);
    }
}
class NumberofSubarraysWithXORKSolution{
    public void Brute(int[]arr,int n,int target){
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int xor=0;
                for(int k=i;k<=j;k++){
                    xor=xor^arr[k];

                }
                if(xor==target){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public void Better(int[]arr,int n,int target){
        int cnt=0;
        for(int i=0;i<n;i++){
            int xor=0;
            for(int j=i;j<n;j++){
                xor=xor^arr[j];
                if(xor==target){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}