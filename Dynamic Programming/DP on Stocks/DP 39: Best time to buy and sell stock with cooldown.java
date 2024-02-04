/*
Coding Ninja: https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock-with-cooldown_3125969
Leet Code: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
Problem statement
You are given a list of stock prices of size 'n' called ‘prices’, where ‘prices[i]’ represents the price on ‘i’th day.



Your task is to calculate the maximum profit you can earn by trading stocks if you can only hold one stock at a time.



After you sell your stock on the ‘i’th day, you can only buy another stock on ‘i + 2’ th day or later.



Example:
Input: 'prices' = [4, 9, 0, 4, 10]

Output: 11

Explanation:
You are given prices = [4, 9, 0, 4, 10]. To get maximum profits you will have to buy on day 0 and sell on day 1 to make a profit of 5, and then you have to buy on day 3  and sell on day 4 to make the total profit of 11. Hence the maximum profit is 11.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
1 2 3 4


Expected Answer:
3


Output on console:
3


Explanation:
For this test case, prices = [1, 2, 3, 4]. To get the maximum profit you have to buy the stock on day 0 and sell on day 3 to get the maximum profit of 4. Hence the answer is 4.


Sample Input 2:
3
5 4 3


Expected Answer:
0


Output on console:
0


Expected Time Complexity:
Try to solve this in O(n).


Constraints:
1 <= n <= 10^5
1 <= prices[i] <= 10^6

Time Limit: 1 sec
*/
// Dynamic Programming Memoization Approach
import java.util.*;
public class Solution {
    public static int stockProfit(int[] prices) {
        // Write your code here.
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return find(prices,n, 0, 1, dp);
    }

    public static int find(int[] prices, int n, int index, int buy, int[][] dp){
        if(index >= n){
            return 0;
        }
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[index] + find(prices, n, index+1, 0, dp), 0 + find(prices, n, index+1, 1, dp));
        }
        else{
            profit = Math.max(prices[index] + find(prices, n, index+2,1, dp), 0 + find(prices, n, index+1, 0, dp));
        }
        return dp[index][buy] = profit;
    }
}
