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

# 