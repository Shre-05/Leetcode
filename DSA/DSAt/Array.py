'''# Using python array module: 
# Import the python array module
from array import *
# from array module create an array named arr
arr=array("i",[1,2,3,4,5])
print(arr)
# print each element of an array using a loop
for i in range(len(arr)):
    print(arr[i],end=" ")
# Enhanced for loop
print("")
for x in arr:
    print(x,end=",")

print("\n")

# array functions:
print(len(arr))
print(arr.typecode)
# arr.reverse()
# print("Reversed array is: ")
# for x in arr:
#     print(x,end=" ")
# print("")

arr.insert(2,20)
for x in arr:
    print(x,end=" ")
print(" ")

arr.append(30)
for x in arr:
    print(x,end=" ")
print(" ")

arr.extend([2,3])
for x in arr:
    print(x,end=" ")
print(" ")

arr.remove(20)
for x in arr:
    print(x,end=" ")
print(" ")

removed= arr.pop(2)
print(removed)
for x in arr:
    print(x,end=" ")
print(" ")

ind=arr.index(30)
print(ind)

# can access and update the elements as well
print(arr[3])
arr[3]=10
print(arr[3])
for x in arr:
    print(x,end=" ")
print(" ")


# to create a copy of an array
copyArray=array(arr.typecode,(x for x in arr))
print("The new copy array is: ")
for x in copyArray:
    print(x,end=" ")

squareArray=array(arr.typecode,(x*x for x in arr))
print("\nThe square array is: ")
for i in range(0,len(squareArray)):
    print(squareArray[i],end=" ")
print(" ")
# Slicing in array:
newArray=arr[1:6:2]
for x in newArray:
    print(x,end=" ")
print()

narr=arr[::-1]
for x in narr:
    print(x,end=" ")

print("\nThe OG array is: ")
for x in arr:
    print(x,end=" ")
print(" ")

negarr=arr[-6:-2:2]
for x in negarr:
    print(x,end=" ")
print(" ")


# To take array as an input from user
inputArray=array("i",[])
n= int(input("Enter the number of elemnets in an array: "))
for i in range(0,n):
    inputArray.append(int(input(f"Enter the element at index {i}: ")))

for x in inputArray:
    print(x,end=" ")
print(" ")

try:
    arr.index(1000)
except:
    print("Element is not present!")'''

# Using numpy module
from numpy import *

# 1.creating a homogeneos/hetero array
arr=array([1,2,3,4], int)
print(arr)

arr_new=array([1,2,3,4,"a",1.23])
print(arr_new)

# Ap numbers- linspace-end included
# third element represent theparts to be made
lin_arr=linspace(10,20,5)
print(lin_arr)

# exclsuding the end- ap numbers
# here third element represent the gap
ar_arr=arange(10,20,2)
print(ar_arr)

# when nums are in log power
log_arr=logspace(10,20,5)
print(log_arr)

# all 0's of size n:
zer_arr=zeros(10)
print(zer_arr)

# all 1's of size n:
one_arr=ones(10)
print(one_arr)

# a specific element x of size n:
spe_arr=full(10,5)
print(spe_arr)

# Multidimensional array

# zero dim
zer_dim_arr=array(['A'])
print(zer_dim_arr)
print(zer_dim_arr.shape)
print(zer_dim_arr[0])

# One dimensional array
one_dim_arr=array(['A','B','C'])
print(one_dim_arr,one_dim_arr.shape)
print(one_dim_arr[1])
one_dim_arr[0]='D'
print(one_dim_arr)

# Two dimensional array
two_dim_arr=array([['A','B','C'],
                   ['D','E','F'],
                   ['g','h','i']])
print(two_dim_arr)
print(two_dim_arr.shape)
print(two_dim_arr[1,1])
print("\nElements od two_dim_arr are: ")
for i in range(0,3):
    for j in range(0,3):
        print(two_dim_arr[i][j],end=" ")

print("\n")
# Three dimensional array
three_dim_arr=array([[['A','B','C'],['D','E','F'],['g','h','i']],
                    [['A','B','C'],['D','E','F'],['g','h','i']],
                    [['A','B','C'],['D','E','F'],['g','h','i']]])
print(three_dim_arr)
print(three_dim_arr.shape)
print(three_dim_arr[1][2][0])
print("\nElements of three_dim_arr are: ")
for i in range(0,3):
    for j in range(0,3):
        for k in range(0,3):
            print(three_dim_arr[i][j][k],end=" ")

