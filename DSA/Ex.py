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