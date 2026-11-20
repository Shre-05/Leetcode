class Ex:
    # print nums in ascending order
    def print_asc(self,Lrange,Urange):
        if(Lrange>Urange):
            return
        print(Lrange)
        self.print_asc(Lrange+1,Urange)
    # print nums in desc order
    def print_desc(self,Lrange,Urange):
        if(Lrange>Urange):
            return
        self.print_desc(Lrange+1,Urange)
        print(Lrange)
    # print sum of nums
    def print_Sum(self,num):
        if(num==0):
            return 0
        else:
            return num+self.print_Sum(num-1)
    #print factorial of a num 
    def print_fact(self,num):
        if(num==0 or num==1):
            return 1
        else:
            return num*self.print_fact(num-1)
    # print the power of a num
    def print_power(self,x,n):
        if(n==0):
            return 1
        else:
            return x*self.print_power(x,n-1)
    # print the sum of array elements
    def arr_sum(self,arr):
        if len(arr)==0:
            return 0
        else:
            return arr[0]+self.arr_sum(arr[1:])
    # reverse a string
    def rev_string(self,s):
        if(len(s)<=1):
            return s
        else:
            return self.rev_string(s[1:])+s[0]

def fib(n):
    if(n==1 or n==2):
        return 1
    else:
        return fib(n-1)+fib(n-2)
          
a=Ex()
a.print_asc(1,5)
a.print_desc(1,5)
print(a.print_Sum(5))
print(a.print_fact(5))
print(a.print_power(2,3))
arr=[1,2,3,4,5]
print(a.arr_sum(arr))
s="Hello"
print(a.rev_string(s))
n=5
print(fib(n))

# o/1 knapsack usng recursion:
def knapsack(wt,value,cap,n):
    if(n==0 or cap==0):
        return 0
    if(wt[n-1]>cap):
        return knapsack(wt,value,cap,n-1)
    include=value[n-1]+knapsack(wt,value,cap-wt[n-1],n-1)
    exclude=knapsack(wt,value,cap,n-1)
    return max(include,exclude)

wt=[2,3,4,5]
value=[3,4,5,6]
cap=5
n=len(wt)
print(knapsack(wt,value,cap,n))