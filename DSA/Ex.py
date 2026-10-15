class Node:
    def __init__(self,info,next=None):
        self.info=info
        self.next=next
class SLL:
    def __init__(self,head=None):
        self.head=head
    # to inser an element at end
    def iae(self,value):
        temp=Node(value)
        if(self.head!=None):
            t=self.head
            while(t.next!=None):
                t=t.next
            t.next=temp
        else:
            self.head=temp

    def iab(self,value):
        temp=Node(value)
        if(self.head!=None):
            temp.next=self.head
            self.head=temp
        self.head=temp
    
    def iam(self,value,x):
        temp=Node(value)
        t=self.head
        while(t.next!=None):
            if(t.info==x):
                temp.next=t.next
                t.next=temp
                return
            t=t.next

    def remove(self,value):
            t=self.head
            prev=self.head
            # element found at first location
            if(t.info==value):
                self.head=t.next
            # somewere in mid
            while(t.next!=None):
                if(t.info==value):
                    prev.next=t.next
                    return
                prev=t
                t=t.next
            # at end
            if(t.info==value):
                prev.next=None

    def printLL(self):
        t=self.head
        while(t.next!=None):
            print(t.info)
            t=t.next
        print(t.info)



obj=SLL()
obj.iae(10)
obj.iae(20)
obj.iab(5)
obj.iam(30,10)
obj.remove(5)
obj.printLL()