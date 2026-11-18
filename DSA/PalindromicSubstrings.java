/*
647. Palindromic Substrings
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters. */
class PalindromicSubstrings{
    public static void main(String[] args) {
        PalindromicSubstringsSolution s=new PalindromicSubstringsSolution();
        String str="aba";
        int cnt=s.countSubstrings(str);
        System.out.println(cnt);
    }
}
class PalindromicSubstringsSolution {
    public int countSubstrings(String s) {
        int left,right;
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
             left=i;
             right=i;

            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;

            }
             left=i;
             right=i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;

            }

        }
        return count;
    }
}