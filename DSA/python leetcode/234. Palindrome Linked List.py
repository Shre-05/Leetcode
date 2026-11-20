'''234. Palindrome Linked List
Solved
Easy
Topics
premium lock icon
Companies
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?'''

class Node:
    def __init__(self,info,next=None):
        self.info=info
        self.next=next
node1=Node(1)
node2=Node(2)
node3=Node(2)
node4=Node(1)

node1.next=node2
node2.next=node3
node3.next=node4

# tc=O(n)
# sc=O(1)
head=node1
temp=head
while(temp.next!=None):
    print(temp.info,end=" ")
    temp=temp.next
print(temp.info)

class Solution:
    def checkPalindrome(self,head=None):
        # first find the mid of the linkedlist
        slow=head
        fast=head
        while(fast!=None and fast.next!=None):
            slow=slow.next
            fast=fast.next.next
        # here slow=mid
        # now use this slow as a start of the other list ans reverse it
        temp=slow
        prev=None
        while(temp!=None):
            front=temp.next
            temp.next=prev
            prev=temp
            temp=front
        # now here the value of prev will represent the head node of the reverse linkedlist
        # now consider head as the start of one ll and prev as the start of other ll
        first=head
        second=prev
        while(second!=None):
            if(first.info!=second.info):
                return False
            first=first.next
            second=second.next
        return True

s=Solution()
result=s.checkPalindrome(head)
print(result)