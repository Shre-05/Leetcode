/*
119. Pascal's Triangle II
Solved
Easy
Topics
premium lock icon
Companies
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33
 

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space? */
import java.util.*;

class PascalsTriangleIISolution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>ans=new ArrayList<>();

        ans.add(1);
        for(int i=1;i<=rowIndex;i++){
            ans.add(1);

            for(int j=i-1;j>0;j--){
                ans.set(j,ans.get(j)+ans.get(j-1));
            }
        }
        return ans;
    }
}