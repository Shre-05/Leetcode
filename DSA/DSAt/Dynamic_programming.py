# a programming approach used to convert the exponential time into the polynomial time
# consist of multiple options to choose whether to consider an element or not
# 0/1 knpasack using dp:
def knapsack(wt,value,cap):
    n=len(wt)
    
    # create a 2D array to store the data
    dp=[[0]*(cap+1) for i in range(n+1)]

    # loop to calculate the last element
    for i in range(1,n+1):
        for w in range(cap+1):
            if(wt[i-1]<=w):
                dp[i][w]=max(dp[i-1][w],dp[i-1][w-wt[i-1]]+value[i-1])
            else:
                dp[i][w]=dp[i-1][w]
    print("Max profit: ",dp[n][cap])
    
wt=[2,3,4,5]
value=[3,4,5,6]
cap=5
knapsack(wt,value,cap)