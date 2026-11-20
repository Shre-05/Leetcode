"""last node next=self.head
self.head.prev=last node"""
class Node:
    def __init__(self, value=None):
        self.value = value
        self.next = None
        self.prev = None


class CLL:
    def __init__(self, head=None):
        self.head = head

    # insert at end
    def iae(self, value):
        temp = Node(value)

        if(self.head == None):
            self.head = temp
            temp.next = self.head
            temp.prev = self.head
            return
        else:
            t = self.head

            # Traverse until the last node
            while(t.next != self.head):
                t = t.next

            t.next = temp
            temp.prev = t
            temp.next = self.head
            self.head.prev = temp
            return

    # insert at beginning
    def iab(self, value):
        temp = Node(value)

        if(self.head == None):
            self.head = temp
            temp.next = self.head
            temp.prev = self.head
            return
        else:
            t = self.head

            # Find the last node
            while(t.next != self.head):
                t = t.next

            temp.next = self.head
            temp.prev = t             # NEW: connect backward
            self.head.prev = temp
            self.head = temp
            t.next = self.head         # connect last node to new head

    # insert at middle somewhere (after x)
    def iam(self, value, x):
        temp = Node(value)
        t = self.head

        if(self.head == None):
            self.head = temp
            temp.next = self.head
            temp.prev = self.head
            return
        else:
            # Traverse the list to find x
            while(t.next != self.head):
                if(t.value == x):
                    temp.next = t.next
                    t.next.prev = temp
                    t.next = temp
                    temp.prev = t
                    return

                t = t.next

            # NEW: also check the last node
            if(t.value == x):
                temp.next = self.head
                temp.prev = t
                t.next = temp
                self.head.prev = temp
                return

    # remove an element from the list
    def remove(self, value):
        if(self.head == None):
            return
        else:
            t = self.head

            # element present at first location
            if(t.value == value):

                # NEW: handle a list containing only one node
                if(t.next == self.head):
                    self.head = None
                    return

                i = self.head
                j = i.next

                # Find the last node
                while(i.next != self.head):
                    i = i.next

                self.head = j
                j.prev = i
                i.next = j
                return

            # element present in the middle somewhere
            while(t.next != self.head):
                if(t.value == value):
                    t.prev.next = t.next
                    t.next.prev = t.prev
                    return
                else:
                    t = t.next  # Move to the next node

            # element present at last
            if(t.value == value):
                t.prev.next = self.head
                self.head.prev = t.prev
                return

    # print linked list
    def printLL(self):
        # NEW: handle an empty list
        if(self.head == None):
            print("Empty list")
            return

        t = self.head

        # Print until the last node
        while(t.next != self.head):
            print(t.value, end="->")
            t = t.next

        print(t.value, end="->")
        print(self.head.value)


# Test the operations
d = CLL()
d.iae(10)
d.iae(20)
d.iab(5)
d.iam(50, 10)
d.remove(50)
d.printLL()
