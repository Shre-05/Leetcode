# a programming approach used to convert the exponential time into the polynomial time
# consist of multiple options to choose whether to consider an element or not
# 0/1 knpasack using dp:
def knapsack(wt,value,cap):
    n=len(wt)
    
    # create a 2D array to store the data
    dp=[[0]*(cap+1) for i in range(n+1)]

    # loop to calculate the last element
    for i in range(1,n+1): #the loop which will start from 1 to n+1
        for w in range(cap+1): #the loop that will run from 0 to cap+1
            if(wt[i-1]<=w): #if the weight of current element is less than weight on the chart
                #if exclude: dp[i-1][w]
                #if include: dp[i-1][w-wt[i-1]]+value[i-1]
                #the max profit value from both will be assigned in the dp[i][w]
                dp[i][w]=max(dp[i-1][w],dp[i-1][w-wt[i-1]]+value[i-1])
            else:
                #if weight is more than cap then the prev above element will be assigned to the current element
                dp[i][w]=dp[i-1][w]
    print("Max profit: ",dp[n][cap])
    
wt=[2,3,4,5]
value=[3,4,5,6]
cap=5
knapsack(wt,value,cap)

def fib(n):
    dp=[0]*(n+1)

    if(n>=1):
        dp[1]=1
    for i in range(2,n+1):
        dp[i]=dp[i-1]+dp[i-2]
    
    return dp[n]

n=5
print(fib(n))