/*
Coding Ninja: https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock-with-transaction-fee_3118974
Leet Code: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
Problem statement
You are given an array 'prices' of size 'n', denoting the price of stocks on 'n' days.
Rahul can buy one stock at a time, and he must sell it before buying stock on another day.
The entire transaction of selling and buying the stock requires some transaction fee, given as 'fee'.
Find the maximum profit Rahul can achieve by trading on the stocks.

Example :
Input: 'prices' =  [1, 2, 3] and 'fee' = 1

Output: 1

Explanation: We can generate the maximum profit of 1 by buying the stock on the first day for price = 1 and then selling it on the third day for price = 3.

The profit will be: 3 - 1 - 1(transaction fee) = 1
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 1
1 2 3


Sample Output 1 :
1


Explanation Of Sample Input 1 :
We can generate the maximum profit of 1 by buying the stock on the first day for price = 1 and then selling it on the third day for price = 3.                                                                                                     
The profit will be: 3 - 1 - 1(transaction fee) = 1


Sample Input 2 :
4 2
1 3 5 6


Sample Output 2 :
3


Expected time complexity :
The expected time complexity is O(n).


Constraints :
1 <= 'n' <= 10 ^ 4
0 <= 'prices[i]' <= 10 ^ 5
0 <= 'fee'<= 10 ^ 5
*/
// Dynamic Programming Memoization Approach
import java.util.*;
public class Solution {
    public static int maximumProfit(int[] prices, int n, int fee) {
        // Write your code here.
        int dp[][] = new int[n][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return find(prices,n, 0, 1, dp, fee);
    }

    public static int find(int[] prices, int n, int index, int buy, int[][] dp, int fee){
        if(index == n){
            return 0;
        }
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[index] + find(prices, n, index+1, 0, dp, fee), 0 + find(prices, n, index+1, 1, dp, fee)) ;
        }
        else{
            profit = Math.max(prices[index]-fee + find(prices, n, index+1,1, dp, fee), 0+ find(prices, n, index+1, 0, dp, fee));
        }
        return dp[index][buy] = profit;
    }       
}
