/*
Coding Ninja: https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_6194560?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
You are given an array of integers 'prices' of size 'n', where ‘prices[i]’ is the price of a given stock on an ‘i’-th day.
You want to maximize the profit by choosing a single day to buy one stock and a different day to sell that stock.
Please note that you can’t sell a stock before you buy one.
Return the maximum profit you can achieve from this transaction.

Example :
Input: ‘prices’ =[7, 1, 5, 4, 3, 6]

Output: 5

Explanation: Purchase stock on day two, where the price is one, and sell it on day six, where the price is 6, profit = 6 - 1 = 5.

Hence we return 5.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
6
7 1 5 4 3 6


Sample Output 1 :
5


Explanation Of Sample Input 1:
Purchase stock on day two, where the price is one, and sell it on day six, where the price is 6. Profit = 6 - 1 = 5.


Sample Input 2:
5
5 4 3 2 1


Sample Output 2 :
0


Expected time complexity :
The expected time complexity is O(n).


Constraints :
1 <= 'n' <= 10 ^ 5
1 <= ‘prices[i]’<= 10 ^ 9

Time Limit: 1 sec

======================= Solution Idea ==================================
Use two pointers to solve this question.
*/
public class Solution {
    public static int bestTimeToBuyAndSellStock(int []prices) {
        // Write your code here.
        int l = 0;
        int r = 1;
        int n = prices.length;
        int profit = 0;
        profit = Math.max(profit,prices[r]-prices[l]);
        while(r<n && l<n){
            if(prices[r] < prices[l]){
                l++;
            }
            else{
                profit = Math.max(profit,prices[r]-prices[l]);
                r++; 
            }
        }
        return profit;
    }
}
