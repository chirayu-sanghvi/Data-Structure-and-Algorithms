/*
Coding Ninja: https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock-ii_630282
Leet Code: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Problem statement
You have been given stock values/prices for N number of days. Every i-th day signifies the price of a stock on that day. Your task is to find the maximum profit which you can make by buying and selling the stocks.

 Note :
You may make as many transactions as you want but can not have more than one transaction at a time i.e, if you have the stock, you need to sell it first, and then only you can buy it again.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
Time Limit: 1 sec
Sample Input 1 :
1
7
1 2 3 4 5 6 7
Sample Output 1 :
6
Explanation :
We can make the maximum profit by buying the stock on the first day and selling it on the last day.
Sample Input 2 :
1
7
7 6 5 4 3 2 1
Sample Output 2 :
0
Explanation :
We can make the maximum profit by not buying the stock.
*/

// Basic Maxima Minima Approach
public class Solution {
   public static long getMaximumProfit (int n, long[] arr) {
       // Your code goes here.
       long profit = 0;
         long holdingStockprice = 0;
         for(int i=0; i<arr.length - 1; i++)
         {
           holdingStockprice = arr[i];
           if(arr[i+1] > holdingStockprice)
           {
               profit += arr[i+1] - arr[i]; 
              
           }
         }  
         return profit;
   }
}

// Dynamic Programming (Memoization)
import java.util.*;
public class Solution {
    public static long getMaximumProfit (int n, long[] values) {
        // Your code goes here.
        long dp[][] = new long[n][2];
        for(long row[] : dp){
            Arrays.fill(row, -1);
        }
        return find(n,values, 0, 1, dp);
        
    }

    public static long find(int n, long[] values, int index, int buy, long[][] dp){
        if(index == n){
            return 0;
        }

        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        long profit = 0;
        if(buy == 1){
            profit = Math.max(-values[index]+find(n,values,index+1,0,dp), 0 + find(n, values, index+1, 1,dp));
        }
        else {
            profit = Math.max(values[index] + find(n, values,index+1, 1,dp), 0 + find(n,values, index+1, 0,dp));
        }
        return dp[index][buy] = profit;
    }
}

// Reminder: You have to understand and implement the Tabulation approach to solve this problem
