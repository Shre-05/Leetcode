/*
90. Subsets II
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10 */
import java.util.*;
public class subsetSum2 {
    public static void main(String[] args) {
        List<List<Integer>> ans=new ArrayList<>();
        int arr[]={1,2,2,2,3,3};
        Arrays.sort(arr);
        subSum(arr,0,new ArrayList(),ans);
        System.out.println(ans);
    }
    public static void subSum(int []arr,int index,ArrayList<Integer>Curr,List<List<Integer>>ans){
        ans.add(new ArrayList<>(Curr));
        for(int i=index;i<arr.length;i++){
            if(i!=index && arr[i]==arr[i-1]) continue;
            Curr.add(arr[i]);
            subSum(arr, i+1, Curr, ans);
            Curr.remove(Curr.size()-1);

        }
    }
}
