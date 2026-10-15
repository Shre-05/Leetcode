# Creation of a 4 node linkedList
class Node:
    def __init__(self,info,next=None):
        self.info=info
        self.next=next
node1=Node(15)
node2=Node(30)
node3=Node(29)
node4=Node(50)

node1.next=node2
node2.next=node3
node3.next=node4

head=node1
current=head

while(current!=None):
    print(current.info,end=" -> ")
    current=current.next
print(None)
# Array=Conagious memory allocation
# non contaguious memory allocation and dynamic size allocation/inc/dc in size=LinkedList

# Singly LinkedList:
class Node:
    # constructor used to initialize object
    def __init__(self,info,next=None):
        self.info=info
        self.next=next
class singlyLinkedList:
    def __init__(self,head=None):
        self.head=head
    
    # Insert at begining:
    def insertAtBeginning(self,value):
        
        temp=Node(value)
        # giving adress of head to newly craeted node
        temp.next=self.head
        # updating and assogning head to the new node
        self.head=temp
    
    # Insertion at the middle:
    def insertAtMiddle(self,value,x): #x=value after which we want to add an element
        temp=Node(value)
        t=self.head
        while(t.next!=None):
            if(t.info==x): #if current element is equal to x
                temp.next=t.next
                t.next=temp
            t=t.next

    # function to insert the element at an end
    def insertAtEnd(self,value):
        # temp points to the new node
        temp=Node(value)

        if(self.head!=None): #if already a part of ll is present
            t=self.head #pointer to point the head as head can't move
            while(t.next!=None): #loop to run until the adress is not null
                t=t.next
            t.next=temp #if address equals none, then add the temp address there
        else:
            self.head=temp #is no ll was present then mark temp as head
            
    # Remove an element
    def remove(self,value):
        # t and prev pointing to the first element
        t=self.head
        prev=self.head
        # if the value is found at the first element
        if(t.info==value):
            self.head=t.next
        # if value is in between somewhere
        while(t.next!=None):
            if(t.info==value):
                prev.next=t.next
                break
            else:
                prev=t #assigning the value of t to prev
                t=t.next #moving t forward
        #if value is found at the end index
        if(t.info==value):
            prev.next=None

    def printLL(self):
        t=self.head
        while(t.next!=None):
            print(t.info)
            t=t.next
        print(t.info)

s=singlyLinkedList()
s.insertAtEnd(10)
s.insertAtEnd(20)
s.insertAtBeginning(5)
s.insertAtMiddle(30,10)
s.remove(5)
s.printLL()