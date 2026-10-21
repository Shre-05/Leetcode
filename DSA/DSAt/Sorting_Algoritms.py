# Bubble sort: i loop runs for n and j loop runs for n-1-i range
# largest element is pushed back sorting array in ascending order and vice versa
def bubble_Sort(a):
    n=len(a)
    for i in range(n):
        for j in range(0,n-1-i):
            if(a[j]>a[j+1]):
                a[j],a[j+1]=a[j+1],a[j]
a=[65,3,5,743,245,678,64,3,4]
bubble_Sort(a)
print(a)


def selection_sort(b):
    n=len(b)
    for i in range(n):
        smallest=i
        for j in range(i,n):
            if(b[smallest]>b[j]):
                smallest=j
        b[smallest],b[i]=b[i],b[smallest]
b=[65,3,5,743,245,678,64,3,4]
selection_sort(b)
print(b)

def insertion_sort(c):
    n=len(c)
    for i in range(1,n):
        key=c[i]
        j=i-1
        while(j>=0 and key<c[j]):
            c[j+1]=c[j]
            j=j-1
        c[j+1]=key
c=[65,3,5,743,245,678,64,3,4]
insertion_sort(c)
print(c)

# Merge sort-Divide and Conquer
def Divide(arr,l,r):
    #if left is less tha  right
    if(l<r):
        m=(l+r)//2 #calculate the mid
        Divide(arr,l,m) #recursive call
        Divide(arr,m+1,r)
        merge(arr,l,m,r)
# function to merge the divided lists
def merge(arr,l,m,r):
    # calculating the sizes of the lists
    s1=m-l+1
    s2=r-m

    # creating the empty lists of same size of prev lists to create a photocopy
    L=[0]*s1
    R=[0]*s2

    # copying the elments from the previous lists to new lists
    for i in range(s1):
        L[i]=arr[l+i]
    for j in range(s2):
        R[j]=arr[m+1+j]
    
    # initializig the variables
    # i to track list 1,j for list 2 and k for original array list
    i=j=0
    k=l
    # untill both the arrays have same num of elements
    while(i<s1 and j<s2):
        # comparing the element of array 1 with array 2
        if(L[i]<R[j]):
            arr[k]=L[i]
            i+=1
            k+=1
        else:
            arr[k]=R[j]
            j+=1
            k+=1
    # once one list ends and other list goes on continue
    while(i<s1):
        arr[k]=L[i]
        k+=1 #incrementing the k as well so that array index goes on incrementing
        i+=1
    while(j<s2):
        arr[k]=R[j]
        j+=1
        k+=1

arr=[38,4,5,3,345,7,75,56,878,4,66,67]
Divide(arr,0,11)
print(arr)

# Quick Sort:
def quick_sort(arr,l,r):
    if(l<r):
        p=partition(arr,l,r)
        quick_sort(arr,l,p-1)
        quick_sort(arr,p+1,r)

def partition(arr,l,r):
    pivot=arr[l]
    i=l+1
    j=r

    while True:
        while(i<j and arr[i]<pivot):
            i+=1
        while(i<j and arr[j]>pivot):
            j-=1
        if(i<j):
            arr[i],arr[j]=arr[j],arr[i]
        else:
            break
    arr[l],arr[j]=arr[j],arr[l]
    return j

arr=[38,4,5,3,345,7,75,56,878,4,66,67]
quick_sort(arr,0,len(arr)-1)
print(arr)



arr=[38,4,5,3,345,7,75,56,878,4,66,67]
arr.sort()
print(arr)

# greedy algorithms
# tends to find the optimal solution by taking the best possible decision at every step

# find the max diff and min diff for the given array


def find_min_max(arr):
    arr.sort()
    n=len(arr)
    max_diff=0
    min_diff=0
    j=n-1
    mid=n//2

    for i in range(mid):
        max_diff=max_diff+abs(arr[i]-arr[j])
        j=j-1

        min_diff=min_diff+abs(arr[2*i]-arr[2*i+1])

    print("max diff: ",max_diff)
    print("min diff:",min_diff)
arr=[12,5,25,10,2,15,8,30]
find_min_max(arr)

# coin change problem- find the min number of denominations:
coins=[1,2,5]
amount=11
def coin_change(coins,amount):
    count=0
    coins.sort(reverse=True)
    for coin in coins:
        count+=amount//coin
        amount%=coin

    return count if amount==0 else -1
result=coin_change(coins,amount)
print(result)

# fractional Knapsack:
def fractional_knapsack(price,wt,cap):
    n=len(price)
    items=[(price[i],wt[i],price[i]/wt[i]) for i in range(n)]

    for i in range(n):
        for j in range(i+1,n):
            if(items[i][2]<items[j][2]):
                items[i],items[j]=items[j],items[i]

    profit=0.00
    
    for price,wt,perKg in items:
        if(cap>=wt):
            cap-=wt
            profit+=price
        else:
            profit+=perKg*cap
    return profit

price=[24,21,12,10]
wt=[7,3,4,5]
cap=20
result=fractional_knapsack(price,wt,cap)
print(result)

def Job_schedular(deadline,profit,total_hrs):
    n=len(deadline)

    data=[(deadline[i],profit[i],profit[i]/deadline[i]) for i in range(n)]

    for i in range(n):
        for j in range(i+1,n):
            if(data[i][2]<data[j][2]):
                data[i],data[j]=data[j],data[i]

    for deadline,profit,perhr in data:
        if(total_hrs>=deadline):
            total_hrs-=deadline
        else:
            profit+=perhr*total_hrs
    return profit
deadline=[5,3,3,2,4,2]
profit=[200,180,190,300,120,100]
total_hr=10
result=Job_schedular(deadline,profit,total_hr)
print(result)