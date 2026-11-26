/*
118. Pascal's Triangle
Easy
Topics
premium lock icon
Companies
You are given an integer numRows.

Return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it and the first and last number on each row must be equal to 1, as shown below:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
  */
 import java.util.*;
class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangleSolution p=new PascalsTriangleSolution();
        p.pascal(5);

        List<List<Integer>>ans=p.generate(5);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
class PascalsTriangleSolution{
    public void pascal(int n){
        int [][]arr=new int [n][];
        for(int i=0;i<n;i++){
            arr[i]=new int[i+1];
        }
 
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==i || j==0){
                    arr[i][j]=1;
                }
                else{
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
    public List<List<Integer>> generate(int n) {
        List<List<Integer>>ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            ArrayList<Integer>curr=new ArrayList<>();

            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    curr.add(1);
                }
                else{
                    List<Integer>prev=ans.get(i-1);
                    curr.add(prev.get(j-1)+prev.get(j));
                }
            }

        ans.add(curr);
        }
        return ans;
    }
}
