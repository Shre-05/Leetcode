class Ex:
    def __init__(self,num):
        self.num=num
    def print_Rec(self,num):
        if(num==0):
            return "Done"
        print(num)
        return self.print_Rec(num-1)
a=Ex(5)
result=a.print_Rec(5)
print(result)


class Ex:
    def __init__(self, num):
        self.num = num
        
    def print_recursive(self, num):
        # 1. Base Case: stops the recursion when num reaches 0
        if num == 0:
            return "Done"
        
        # 2. Process: print the current number passed to the function
        print(num) 
        
        # 3. Recursive Call: function calls itself with (num - 1)
        return self.print_recursive(num - 1)

a = Ex(5)
result = a.print_recursive(5)
print(result)
