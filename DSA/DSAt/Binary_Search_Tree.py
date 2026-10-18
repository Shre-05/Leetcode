# BST:a binary tree structure which can have any num of child but element on left of a root node must be less while on right must be greater
class Node:
    # initializing the values of a node
    def __init__(self,value):
        self.left=None
        self.right=None
        self.value=value

def insert(root,value):
    if(root==None): #if root is none
        return Node(value)
    if(root.value==value): #if root value is equal to the node value #base condition
        return root
    if(root.value>value): #if root is greater than value
        root.left=insert(root.left,value)
    else:
        root.right=insert(root.right,value) #if root is smaller than value
    return root

# to search an element
def search(root,value):
    if(root==None):
        print("Element not found!")
        return
    if(root.value==value):
        print("Element found!")
        return
    if(root.value>value):
        search(root.left,value)
    else:
        search(root.right,value)

# to print the elements of bst:
def inOrder(root):
    if(root!=None):
        inOrder(root.left)
        print(root.value,end=" ")
        inOrder(root.right)

# delete a node
# case 1: no child present to the root(current) node
# case 2:only 1 either left or right child is present
# case 3:both child are prsent

# defining a helper function to calculate the successor if both the childs are present
def get_successor(root):
    root=root.right
    while(root!=None and root.left!=None):
        root=root.left
    return root

# deletion function
def delete(root,value):
    # check if the root is empty
    if(root==None):
        return root
    # if the value of root is less than the value of node
    if(root.value<value):
        root.right=delete(root.right,value)
    # if the value of rooot is greater than the value of node
    elif(root.value>value):
        root.left=delete(root.left,value)
    else: #f both values are equal
        if(root.left==None): #if node does not have left child
            return root.right
        
        if(root.right==None): #if node does not have right child
            return root.left
        
        else: #if node have both childs
            succ=get_successor(root)
            root.value=succ.value # copy value of succ to root
            root.right=delete(root.right,succ.value) #delete succ node from leaf
    return root

root=insert(None,20)
root=insert(root,15)
root=insert(root,30)
root=insert(root,40)
root=insert(root,12)
root=insert(root,18)
root=insert(root,25)
root=insert(root,50)
inOrder(root)
search(root,40)
search(root,100)

inOrder(root)
delete(root,20)
print("\n")
inOrder(root)
