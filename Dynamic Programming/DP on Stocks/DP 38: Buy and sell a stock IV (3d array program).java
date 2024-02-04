/*
Coding Ninja: https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock-iv_1080698
Leet Code: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

Problem statement
You have been given an array 'PRICES' consisting of 'N' integers where PRICES[i] denotes the price of a given stock on the i-th day. You are also given an integer 'K' denoting the number of possible transactions you can make.

Your task is to find the maximum profit in at most K transactions. A valid transaction involves buying a stock and then selling it.

Note
You can’t engage in multiple transactions simultaneously, i.e. you must sell the stock before rebuying it.
For Example
Input: N = 6 , PRICES = [3, 2, 6, 5, 0, 3] and K = 2.
Output: 7

Explanation : The optimal way to get maximum profit is to buy the stock on day 2(price = 2) and sell it on day 3(price = 6) and rebuy it on day 5(price = 0) and sell it on day 6(price = 3). The maximum profit will be (6 - 2) + (3 - 0) = 7.
Detailed explanation ( Input/output format, Notes, Images )
Constraints
1 <= T <= 100
1 <= N <= 5000
0 <= K <= N/2
0 <= ARR[i] <=10^5

Time Limit : 1 sec
Sample Input 1
2
5 2
8 5 1 3 10
4 2
10 8 6 2 
Sample Output 1
9
0
Explanation for Sample 1
Test Case 1: In this case, we can make a maximum of 2 transactions. The optimal way to get maximum profit is to make only 1 transaction, i.e., buy the stock on day 3 (price = 1) and sell it on day 5(price = 10). The profit will be 10 - 1 = 9.

Test Case 2: In the second test case, we can make a maximum of 2 transactions. The optimal way to get maximum profit is to make 0 transactions because the price of stock is continuously decreasing and we will have a loss if we buy and sell the stock.
Sample Input 2
2
4 0
2 6 5 2
4 2
1 2 3 5
Sample Output 2
0
4
Java (SE 1.8)
45678910111213141516171819202122232425312
import java.util.* ;
import java.io.*; 
public class Solution
{
public static int maximumProfit(int[] prices, int n, int k)
    {   if(k == 0){
        return 0;
        }
        // Write your code here.
        int dp[][][] = new int[n+1][2][k+1];
…                        dp[index][buy][count]  = 0 + dp[index+1][0][count];
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}


======================================== Solution Idea ===============================
Similar to DP:37, just change the value of transaction count to k instead of 2
*/
// Dynamic Programming Tabulation Approach
import java.util.* ;
import java.io.*; 
public class Solution
{
public static int maximumProfit(int[] prices, int n, int k)
    {   if(k == 0){
        return 0;
        }
        // Write your code here.
        int dp[][][] = new int[n+1][2][k+1];
        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<2;buy++){
                for(int count = 0;count <= k;count++){
                    if(buy == 1){
                        dp[index][buy][count] = Math.max(-prices[index] + dp[index+1][0][count], 0 + dp[index+1][1][count]);
                    }
                    else {
                        if(count - 1 >= 0)
                        dp[index][buy][count]  = Math.max(prices[index] + dp[index+1][1][count-1], 0 + dp[index+1][0][count]);
                        else
                        dp[index][buy][count]  = 0 + dp[index+1][0][count];
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}
