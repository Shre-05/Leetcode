/*
125. Valid Palindrome
Solved
Easy
Topics
premium lock icon
Companies
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters. */
class ValidPalindrome{
    public static void main(String[] args) {
        String str="A man, a plan, a canal: Panama";
        ValidPalindromeSolution s=new ValidPalindromeSolution();
        System.out.println(s.isPalindrome(str));
    }
}
class ValidPalindromeSolution {
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;

        while(left<right){
            // check if left leter is letter/digit or skip
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } 
            // check if right leter is letter/digit or skip
            else if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }  
            else{
                if(Character.toLowerCase(s.charAt(left))!=(Character.toLowerCase(s.charAt(right)))){
                    return false;
                }
                left++;
                right--;
            }   
        }
        return true;
    }
}