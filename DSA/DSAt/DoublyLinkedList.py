
class Node:
    # a structure for creating a node
    def __init__(self, value=None):
        # self is a pointer which stores the address of an object
        self.value = value
        self.prev = None
        self.next = None


class Dll:
    # initializing the head
    def __init__(self, head=None):
        self.head = head

    # insert at end:
    def iae(self, value):
        temp = Node(value)
        t = self.head

        if self.head != None:  # if head is not empty
            while t.next != None:
                t = t.next
            t.next = temp
            temp.prev = t
            return

        self.head = temp  # if head is empty

    # insert at the beginning
    def iab(self, value):
        temp = Node(value)
        temp.next = self.head

        if self.head != None:
            self.head.prev = temp

        self.head = temp

    # insert the value at the middle (after x)
    def iam(self, value, x):
        temp = Node(value)
        t = self.head

        while t != None:
            if t.value == x:
                temp.next = t.next

                if t.next != None:
                    t.next.prev = temp

                t.next = temp
                temp.prev = t
                return

            t = t.next

    # to remove an element
    def remove(self, value):
        t = self.head

        if t == None:
            return

        # found at first
        if t.value == value:
            self.head = t.next

            if t.next != None:
                t.next.prev = None

            return

        # found at middle or last
        while t != None:
            if t.value == value:
                t.prev.next = t.next

                if t.next != None:
                    t.next.prev = t.prev

                return

            t = t.next

    # printing the linked list
    def printLL(self):
        t = self.head

        while t != None:
            print(t.value)
            t = t.next


d = Dll()
d.iae(10)
d.iae(20)
d.iae(30)
d.iab(5)
d.iam(50, 10)
d.remove(30)
d.printLL()
