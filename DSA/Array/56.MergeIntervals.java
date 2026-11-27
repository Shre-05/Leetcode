/*
56. Merge Intervals
Medium
Topics
premium lock icon
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104 */
import java.util.*;
class MergeIntervals{
    public static void main(String[] args) {
        int[][] intervals = {
            {8, 10},
            {1, 3},
            {2, 6},
            {15, 18}
        };

        MergeIntervalsSolution obj = new MergeIntervalsSolution();

        int[][] result = obj.Brute(intervals);

        System.out.println("Merged Intervals:");

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }

        int[][] result2 = obj.Brute(intervals);

        System.out.println("Optimal Merged Intervals:");

        for (int[] interval : result2) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
class MergeIntervalsSolution{
    public int[][] Brute(int[][] intervals){
        int n=intervals.length;

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]>ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];

            if(ans.isEmpty()==false && end<=ans.get(ans.size()-1)[1]){
                continue;
            }

            for(int j=i+1;j<n;j++){
                if(intervals[j][0]<=end){
                    end=Math.max(end,intervals[j][1]);
                }
                else{
                    break;
                }
            }
            ans.add(new int[]{start,end});
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] optimal(int[][]intervals){
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]>ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(ans.isEmpty()|| intervals[i][0]>ans.get(ans.size()-1)[1]){
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }
            else{
                    ans.get(ans.size()-1)[1] = Math.max(
                    ans.get(ans.size()-1)[1],
                    intervals[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}