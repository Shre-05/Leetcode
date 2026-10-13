'''14. Longest Common Prefix
Solved
Easy
Topics
premium lock icon
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty'''

# tc=O(m*n)
# sc=O(n)
class Solution:
    def func(self,str0s)->str:
        if(len(strs)==0):
            return ""
        result=""
        base=strs[0]

        for i in range(0,len(base)):
            for word in strs:
                if(len(word)==i or word[i]!=base[i]):
                    return result
            result+=base[i]
        return result
    
s=Solution()
strs=["flower","flow","flight"]
print(s.func(strs))