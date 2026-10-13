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


head=node1
current=head
while(current.next!=None):
    print(current.info,end=" ")
    current=current.next
print(current.info)

class Solution:
    def check(self,head):
        slow=head
        fast=head
        while(fast!=None and fast.next!=None):
            slow=slow.next
            fast=fast.next.next
        
        temp=slow
        prev=None
        while(temp!=None):
            front=temp.next
            temp.next=prev
            prev=temp
            temp=front

        first=head
        second=prev
        while(second!=None):
            if(first.info!=second.info):
                return False
            first=first.next
            second=second.next
        return True


s=Solution()
print(s.check(head))