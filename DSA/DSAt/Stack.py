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
print(s.pop())"""

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
print(s.pop())