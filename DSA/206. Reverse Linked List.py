'''206. Reverse Linked List
Solved
Easy
Topics
premium lock icon
Companies
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?'''

class Node:
    def __init__(self,info,next=None):
        self.info=info
        self.next=next
node1=Node(1)
node2=Node(2)
node3=Node(3)
node4=Node(4)
node5=Node(5)

node1.next=node2
node2.next=node3
node3.next=node4
node4.next=node5

# tc=O(n)
# sc=O(1)
head=node1
temp=head
while(temp.next!=None):
    print(temp.info,end=" ")
    temp=temp.next
print(temp.info)
class Solution:
    def Reverse(self,head):
        temp=head
        prev=None
        while(temp!=None):
            front=temp.next
            temp.next=prev
            prev=temp
            temp=front
        return prev

s=Solution()
result=s.Reverse(head)
print(result.info)