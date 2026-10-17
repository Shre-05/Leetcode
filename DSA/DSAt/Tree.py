# A data structure used to store the data in the heirarchical or non linear structure
# implementation can be done using an Array for fix size or he Linkedlist for dynamic size

# Tree creation
class Node:
    def __init__(self,value):
        self.value=value
        self.left=None
        self.right=None
root=Node(1)
root.left=Node(3)
root.right=Node(5)
root.left.left=Node(2)
root.left.right=Node(4)
root.right.right=Node(8)

class Tree:
    # Tree Transversal
    # Preorder: root->left->right
    def preOrder(self,root):
        if(root!=None):
            print(root.value,end="->")
            self.preOrder(root.left)
            self.preOrder(root.right)

    # Inorder: left->root->right
    def inOrder(self,root):
        if(root!=None):
            self.inOrder(root.left)
            print(root.value,end="->")
            self.inOrder(root.right)

    # PostOrder: left->right->root
    def postOrder(self,root):
        if(root!=None):
            self.postOrder(root.left)
            self.postOrder(root.right)
            print(root.value,end="->")

# preOrder(root)
# inOrder(root)
t=Tree()
print("\nPrinting using PreOrder transversal method..")
t.preOrder(root)
print("\nPrinting using inOrder transversal method..")
t.inOrder(root)
print("\nPrinting using postOrder transversal method..")
t.postOrder(root)
