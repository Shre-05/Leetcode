'''876. Middle of the Linked List
Solved
Easy
Topics
premium lock icon
Companies
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100'''

# tc=O(n)
# sc=O(1)
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


head=node1
current=head
while(current.next!=None):
    print(current.info,end=" ")
    current=current.next
print(current.info)

class Solution:
    def findMid(self,head):
        slow=head
        fast=head
        while(fast!=None and fast.next!=None):
            slow=slow.next
            fast=fast.next.next
        return slow
s=Solution()
result=s.findMid(head)
print(result.info)