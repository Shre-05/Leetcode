/*
131. Palindrome Partitioning
Solved
Medium
Topics
premium lock icon
Companies
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters. */
import java.util.*;
class PalindromePartitioning{
    public static void main(String[] args) {
        String str="aabb";
        PalindromePartitioningSolution s=new PalindromePartitioningSolution(); 
        List<List<String>> ans=s.partition(str);
        System.out.println(ans);
    }
}
class PalindromePartitioningSolution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        ArrayList<String>Curr=new ArrayList<>();

        backtrack(s,0,Curr,ans);
        return ans; 
    }
    public void backtrack(String s,int index,ArrayList<String>Curr,List<List<String>> ans){
        // base case
        if(index==s.length()){
            ans.add(new ArrayList<>(Curr));
            return;
        }
        for(int i=index;i<s.length();i++){
            String sub=s.substring(index,i+1);
            if(isPalindrome(sub)){
                Curr.add(sub);
                backtrack(s,i+1,Curr,ans);
                Curr.remove(Curr.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}