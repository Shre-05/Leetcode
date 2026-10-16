class Node:
    def __init__(self,value,next=None):
        self.value=value
        self.next=next
class SLL:
    def __init__(self,head=None):
        self.head=head
        # insert at end:
    def iae(self,value):
            temp=Node(value)
            if(self.head==None):
                self.head=temp
                temp.next=self.head
                return
            else:
                t=self.head
                while(t.next!=self.head):
                    t=t.next
                t.next=temp
                temp.next=self.head
                return
    def printLL(self):
        t=self.head
        while(t.next!=self.head):
            print(t.value,end="->")
            t=t.next
        print(t.value,end="->")
        t=t.next
        print(t.value)
    
    # insert at beginning
    def iab(self,value):
        temp=Node(value)
        if(self.head==None):
            return
        else:
            t=self.head
            temp.next=self.head
            while(t.next!=self.head):
                t=t.next
            self.head=temp
            t.next=self.head
            return
    # insert at the middle
    def iam(self,value,x):
        temp=Node(value)
        if(self.head==None):
            return
        else:
            t=self.head
            while(t.next!=self.head):
                if(t.value==x): 
                    temp.next=t.next
                    t.next=temp
                    return  
                t=t.next
    
    # remove an element
    def remove(self,value):
        if(self.head==None):
            return
        else:
            t=self.head
            prev=self.head
            # element present at start
            if(t.value==value):
                self.head=t.next
                while(t.next!=self.head):
                    t=t.next
                t.next=self.head
                return
            # element at mid somehwere
            while(t.next!=self.head):
                if(t.value==value):
                    prev.next=t.next
                    return
                prev=t
                t=t.next
            # element present at last
            if(t.value==value):
                prev.next=self.head
                return




s=SLL()
s.iae(10)
s.iae(20)
s.iab(5)
s.iam(50,10)
s.remove(20)
s.printLL()