
class Node:
    def __init__(self, value=None):
        self.value = value
        self.next = None
        self.prev = None


class DLL:
    def __init__(self, head=None):
        self.head = head

    # Insert at end
    def iae(self, value):
        temp = Node(value)
        t = self.head

        if self.head == None:
            self.head = temp
            return
        else:
            while t.next != None:
                t = t.next

            t.next = temp
            temp.prev = t
            return

    # Insert at beginning
    def iab(self, value):
        temp = Node(value)

        if self.head == None:
            self.head = temp
            return
        else:
            temp.next = self.head
            self.head.prev = temp
            self.head = temp
            return

    # Insert in the middle (after x)
    def iam(self, value, x):
        temp = Node(value)

        if self.head == None:
            self.head = temp
            return
        else:
            t = self.head

            while t != None:  # NEW: also checks the last node
                if t.value == x:
                    temp.next = t.next
                    temp.prev = t

                    # NEW: update next node's prev only if it exists
                    if t.next != None:
                        t.next.prev = temp

                    t.next = temp
                    return

                t = t.next

    # Remove an element
    def remove(self, value):
        if self.head == None:
            return

        else:
            t = self.head

            # If value is present at the beginning
            if t.value == value:
                self.head = t.next

                # NEW: handle deleting the only node
                # and avoid accessing None.prev
                if self.head != None:
                    self.head.prev = None  # NEW

                return

            # Element present somewhere after the head
            while t.next != None:
                if t.value == value:
                    t.prev.next = t.next
                    t.next.prev = t.prev
                    return

                t = t.next

            # If element is present at the last
            if t.value == value:
                t.prev.next = None
                return

    # Print linked list
    def printLL(self):
        t = self.head

        # NEW: handle an empty list
        if t == None:
            print("Empty list")
            return

        while t.next != None:
            print(t.value, end="->")
            t = t.next

        print(t.value)


# Testing
d = DLL()
d.iae(10)
d.iae(20)
d.iab(5)
d.iam(50, 10)
d.remove(20)
d.printLL()
