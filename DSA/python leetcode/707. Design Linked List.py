"""707. Design Linked List
Solved
Medium
Topics
premium lock icon
Companies
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3"""

class Node:
    def __init__(self,val,next=None):
        self.val=val
        self.next=next
class MyLinkedList:

    def __init__(self,head=None):
        self.head=head

    def get(self, index: int) -> int:
        t=self.head
        i=0
        if(self.head==None):
            return 
        if(index==0):
            return t.val
        while(t!=None):
            if(i==index):
                return t.val
                return
            else:
                i=i+1
                t=t.next
        return -1

    def addAtHead(self, val: int) -> None:
        temp=Node(val)
        if(self.head==None):
            self.head=temp
            return
        else:
            t=self.head
            temp.next=self.head
            self.head=temp
            return

    def addAtTail(self, val: int) -> None:
        temp=Node(val)
        if(self.head==None):
            self.head=temp
            return
        else:
            t=self.head
            while(t.next!=None):
                t=t.next
            t.next=temp
            return

    def addAtIndex(self, index: int, val: int) -> None:
        if(index<0):
            return
        temp=Node(val)
        t=self.head
        i=0
        prev=self.head
        if index == 0:
            self.addAtHead(val)
            return
        while(t!=None):
            if(i==index):
                temp.next=t
                prev.next=temp
                return
            prev=t
            i=i+1
            t=t.next
        if(i==index):
            self.addAtTail(val)
            return

    def deleteAtIndex(self, index: int) -> None:
        t=self.head
        prev=t
        i=0
        
        if(self.head==None):
            return 
        if index == 0:
            self.head = self.head.next
            return
        while(t.next!=None):
            if(i==index):
                prev.next=t.next
                return
            i=i+1
            prev=t
            t=t.next
        if(i==index):
            prev.next=None
            return
    def printLL(self):
        t=self.head
        if(self.head==None):
            return
        else:
            while(t.next!=None):
                print(t.val,end="->")
                t=t.next
            print(t.val)
        
obj=MyLinkedList()
obj.addAtHead(5)
obj.addAtTail(10)
obj.addAtIndex(1,20)
obj.printLL()