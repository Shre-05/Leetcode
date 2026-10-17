# FIFO data structure
class Queue:
    def __init__(self):
        self.s=[]
    # to chcek lenegth of a queue:/tp check if empty
    def isEmpty(self):
        return len(self.s)==0
    # to insert an element
    def insert(self,value):
        self.s.append(value)
    # to delete an elemnt
    def delete(self):
        if(self.isEmpty()==True):
            print("Empty Queue")
        return self.s.pop(0)
    # to print:
    def print(self):
        if(self.isEmpty()==True):
            print("Empty Queue")
        else:
            for i in range(len(self.s)):
                print(self.s[i],end="->")
q=Queue()
q.insert(10)
q.insert(20)
q.insert(30)
q.delete()
q.print()


class Deque:
    def __init__(self):
        self.s=[]
    # to chcek if the queue is empty:
    def isEmpty(self):
        return len(self.s)==0
    # insert at rear:
    def insert_at_rear(self,value):
        self.s.append(value)
    # insert at beginning-front
    def insert_at_front(self,value):
        self.s.insert(0,value)
    # remove from end-rear
    def remove_from_rear(self):
        if(self.isEmpty()):
            print("Empty")
        return self.s.pop()
    # remove from start-front
    def remove_from_front(self):
        if(self.isEmpty()):
            print("Empty")
        return self.s.pop(0)
    # print
    def print(self):
        if(self.isEmpty()):
            print("Empty")
        else:
             for t in range(len(self.s)):
                  print(self.s[t],end=" ")
    
d=Deque()
d.insert_at_front(10)
d.insert_at_front(20)
d.insert_at_rear(30)
d.remove_from_rear()
d.remove_from_front()
d.remove_from_rear()
d.print()


class CQ:
    def __init__(self,size):
        self.size=size
        self.s=[None]*size
        self.front=self.rear=-1
        
    # Check if the circular queue is completely empty
    def isEmpty(self):
        # Both pointers being -1 indicates there are no elements in the queue
        if(self.front==-1 and self.rear==-1):
            return True
        else:
            return False
            
    # Check if the circular queue is completely full
    def isFull(self):
        # The queue is full if the next circular position after rear matches front
        if((self.rear+1)%self.size)==self.front:
            return True
        else:
            return False
            
    # Insert an element at the rear end of the queue
    def enque(self,value):
        # 1. Condition to check if queue is full
        if self.isFull():
            return "Queue is full"
        # 2. Condition to handle insertion of the very first element
        elif self.front==-1:
            self.front=self.rear=0
            self.s[self.front]=value
        # 3. Regular insertion where rear cycles back using modulo operator
        else:
            self.rear=(self.rear+1)%self.size
            self.s[self.rear]=value
            
    # Remove/Delete an element from the front end of the queue
    def dequeu(self):
        # 1. Condition to check underflow if queue is already empty
        if(self.isEmpty()):
            return "Empty"
        # 2. Condition if only one element is left; resets pointers back to -1
        elif self.front==self.rear:
            self.front=-1
            self.rear=-1
        # 3. Regular deletion where front moves forward and cycles using modulo
        else:
            self.front=(self.front+1)%self.size

    # Display all valid contents of the circular queue
    def print(self):
        # Exit immediately and log "Empty" if the queue contains no elements
        if(self.isEmpty()):
            print("Empty")
            return
            
        # Initialize traversal variable at front pointer
        i=self.front
        while True:
            # Print current slot item separated by space
            print(self.s[i],end=" ")
            # Break out of loop once the trailing rear pointer is reached
            if(i==self.rear):
                break
            # Cycle index forward within the physical array limits
            i=(i+1)%self.size
        print()
        
q=CQ(4)
q.enque(10)
q.enque(20)
q.enque(30)
q.enque(40)
q.dequeu()
q.dequeu()
q.dequeu()
q.dequeu()
q.dequeu()
q.print()
