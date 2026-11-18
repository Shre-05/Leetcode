/*
680. Valid Palindrome II
Solved
Easy
Topics
premium lock icon
Companies
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters. */

class ValidPalindromeII{
    public static void main(String[] args) {
        ValidPalindromeIISolution s= new ValidPalindromeIISolution();
        String str="aba";
        System.out.println(s.validPalindrome(str));
    }
}

class ValidPalindromeIISolution {
    public boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;

        while(left<right){
            if(s.charAt(left)==s.charAt(right)){         
                left++;
                right--;
            }
            else{
                return isPalindrome(s,left+1,right)||isPalindrome(s,left,right-1);
            }

        }
        return true;
    }
    public boolean isPalindrome(String s,int left,int right){
        

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