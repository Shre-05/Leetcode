"""# Implementation using basic

class Stack:
    def __init__(self):
        self.s=[]

    # to check the length of a stack
    def length(self):
        return len(self.s)
    # to push an element inside stack
    def push(self,value):
        return self.s.append(value)
    # to peek inside the stack
    def peek(self):
        if(len(self.s)==0):
            return ("Empty stack")
        else:
            return self.s[-1]
    # to pop an element from top
    def pop(self):
        if(len(self.s)==0):
            return "Empty stack"
        else:
            return self.s.pop()
    
s=Stack()
s.push(10)
print(s.peek())
print(s.length())
s.push(20)
print(s.peek())
print(s.length())
print(s.pop())

# Implementation using array
class Stack:
    def __init__(self):
        self.s=[None]*5
        self.top=-1

    # to check the length of stack:
    def length(self):
        return self.top+1
    # to push 
    def push(self,value):
        if(self.top==len(self.s)-1):
            return "Stack overflow"
        else:
            self.top+=1
            self.s[self.top]=value

    # to peek an element
    def peek(self):
        if(self.top==-1):
            return "stack is empty"
        else:
            return self.s[self.top]
    # to pop an element
    def pop(self):
        if(self.top==-1):
            return "stack is empty"
        else:
            value=self.s[self.top]
            self.top-=1
            return value
        
    def printStack(self):
        for i in range(self.top + 1):
            print(self.s[i], end="->")
        print()
        
s=Stack()
s.push(10)
print(s.length())
print(s.peek())

s.push(20)
print(s.length())
print(s.peek())

s.push(30)
s.push(40)
print(s.length())
print(s.peek())
s.printStack()
print(s.pop())"""

# implementation using an array:

# Stack implementation using an array
"""class Stack:
    def __init__(self, cap):
        self.arr = [0] * cap
        self.cap = cap
        self.top = -1

    # Push an element onto the stack
    def push(self, value):
        if self.top == self.cap - 1:
            return "Stack is full"

        self.top += 1
        self.arr[self.top] = value

    # Remove and return the top element
    def pop(self):
        if self.top == -1:
            return "Stack is empty"

        value = self.arr[self.top]
        self.top -= 1
        return value

    # Return the top element without removing it
    def peek(self):
        if self.top == -1:
            return "Stack is empty"

        return self.arr[self.top]

    # Check whether the stack is empty
    def isEmpty(self):
        return self.top == -1

    # Check whether the stack is full
    def isFull(self):
        return self.top == self.cap - 1

    # Print only the elements currently in the stack
    def printstack(self):
        for i in range(self.top + 1):
            print(self.arr[i], end=" -> ")
        print("None")


a = Stack(5)

a.push(5)
a.push(7)
print(a.pop())

a.push(10)
print(a.pop())

print(a.peek())
print(a.isEmpty())
print(a.isFull())

a.pop()
print(a.isEmpty())

a.pop()
print(a.isEmpty())

print(a.peek())
a.printstack()
"""
# implementation using linkedlist:
class Node:
    def __init__(self,info):
        self.info=info
        self.next=next
class stack:
    def __init__(self):
        self.top=-1
        self.count=0
    # push
    def push(self,value):
        temp=Node(value)
        temp.next=self.top
        self.top=temp
        self.count+=1
        return
    # pop
    def pop(self):
        if(self.top==-1):
            return "empty"
        else:
            temp=self.top
            val=temp.info
            self.top=self.top.next
            del temp
            self.count-=1
            return val
    # peek
    def peek(self):
        if(self.top==-1):
            return "Empty"
        else:
            val=self.top.info
            return val
    # isEmpty
    def isEmpty(self):
        return self.top==-1
    # size
    def size(self):
        return self.count
    
    

    
a=stack()
a.push(5)
a.push(4)
print(a.size())
print(a.pop())
print(a.peek())
a.pop()
a.pop()
print(a.isEmpty())
print(a.size())