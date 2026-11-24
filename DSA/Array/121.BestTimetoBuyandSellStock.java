/*
121. Best Time to Buy and Sell Stock

Problem:
Given an array prices where prices[i] represents the stock price
on the ith day, we need to choose:
    1. One day to buy the stock.
    2. A different day in the future to sell the stock.

Return the maximum profit possible.
If no profit is possible, return 0.

Constraint:
We must buy before selling.
Only one transaction is allowed.
*/

class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 2, 3, 6, 4};

        BestTimetoBuyAndSellStocksSolution b =
                new BestTimetoBuyAndSellStocksSolution();

        b.Brute(arr);
        System.out.println(b.optimal(arr));
    }
}

class BestTimetoBuyAndSellStocksSolution {

    /*
    APPROACH 1: BRUTE FORCE

    Intuition:
    Consider every possible buying day.
    For each buying day, consider every possible selling day
    that comes after it.

    Calculate the profit for every valid buy-sell pair
    and maintain the maximum profit encountered.

    TC: O(N^2)
        - Outer loop considers every possible buying day.
        - Inner loop considers every possible selling day
          after the buying day.
        - Therefore, we examine approximately N*N pairs.

    SC: O(1)
        - We use only a few variables.
        - No additional data structure is used.

    Why this approach works:
        - Every possible valid transaction is considered.
        - We never sell before buying because j starts at i+1.
        - Initializing profit to 0 ensures that if no profitable
          transaction exists, we return 0.
    */

    public void Brute(int[] arr) {
        int profit = 0;

        // i represents the buying day
        for (int i = 0; i < arr.length; i++) {

            int buy = arr[i];

            // j represents the selling day
            // Selling must happen after buying
            for (int j = i + 1; j < arr.length; j++) {

                int sell = arr[j];

                // Calculate profit for this transaction
                int cost = sell - buy;

                // Maintain the maximum profit
                profit = Math.max(cost, profit);
            }
        }

        System.out.println(profit);
    }


    /*
    APPROACH 2: OPTIMAL (GREEDY / SINGLE PASS)

    Intuition:
    Instead of checking every possible buying-selling pair,
    maintain the minimum stock price encountered so far.

    At every day:
        1. Assume we sell the stock today.
        2. Calculate profit using the minimum price encountered
           before or up to this point.
        3. Update the maximum profit.
        4. Update the minimum price for future transactions.

    TC: O(N)
        - We traverse the array only once.
        - Each iteration performs constant-time operations.

    SC: O(1)
        - We maintain only two variables:
              mini   -> minimum price encountered so far
              profit -> maximum profit encountered so far

    WHY IS THIS BETTER THAN BRUTE FORCE?

        Brute force checks every possible buying-selling pair,
        resulting in O(N^2) time.

        But we don't need to repeatedly check all buying prices.

        For any selling day, the best possible buying day
        before it is simply the day with the minimum price
        encountered so far.

        By maintaining this minimum while traversing the array,
        we eliminate the nested loop and reduce the time
        complexity from O(N^2) to O(N).

    This is the optimal solution because:
        - O(N) time is necessary to process the input.
        - O(1) auxiliary space is achieved.
    */

    public int optimal(int[] prices) {

        // Stores the minimum stock price encountered so far
        int mini = Integer.MAX_VALUE;

        // Stores the maximum profit achievable so far
        int profit = 0;

        // Traverse the array
        for (int i = 0; i < prices.length; i++) {

            // Calculate profit if we sell the stock today
            // using the minimum price encountered so far
            int cost = prices[i] - mini;

            // Update maximum profit
            profit = Math.max(cost, profit);

            // Update minimum buying price
            mini = Math.min(mini, prices[i]);
        }

        return profit;
    }
}