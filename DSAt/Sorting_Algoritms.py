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

