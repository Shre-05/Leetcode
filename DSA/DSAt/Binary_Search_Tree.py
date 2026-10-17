# BST:a binary tree structure which can have any num of child but element on left of a root node must be less while on right must be greater
class Node:
    def __init__(self,value):
        self.left=None
        self.right=None
        self.value=value

def insert(root,value):
    if(root==None):
        return Node(value)
    if(root.value==value):
        return root
    if(root.value>value):
        root.left=insert(root.left,value)
    else:
        root.right=insert(root.right,value)
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
