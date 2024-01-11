/*
Coding Ninja: https://www.codingninjas.com/studio/problems/lemonade-change_8224112
Leet Code: https://leetcode.com/problems/lemonade-change/description/

Problem statement
Ninja is a lemonade seller, and all the lemonade costs 5 rupees for each product. The amount paid by each customer will be 5, 10, or 20 rupees.
You are given an array ‘bill’ of length ‘N’, where ‘bill[i]’ represents the amount paid by the ‘i’th customer. You must return the extra amount to the customers in the order they appear in the bill.
Given the array ‘bill’, you must return whether or not Ninja can return the correct change to all the customers.
Example:
Input:
bill = [5, 5, 5, 10, 10, 20], N = 6

Output:
true

Explanation: We collected 5 rupees each from the first, second, and third customers. For the fourth and fifth customers, we can return one 5 rupees coin to each. For the sixth customer, we can return one 5 rupees coin and one 10 rupees coin.
Hence we return true.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
8
5 5 5 5 10 10 20 20


Sample Output 1:
true


Explanation Of Sample Input 1:
For test case one:

Input:
bill = [5, 5, 5, 5, 10, 10, 20, 20], N=8

Output:
true

Explanation: We collected 5 rupees from the first, second, third, and fourth customers. For the fifth and sixth customers, we can return them one 5 rupees coin. For the seventh and eighth customers, we can return one 5 rupees coin and one 10 rupees coin each.
Hence we return ‘true’.


Sample Input 2:
7
5 10 5 10 5 20 20 


Sample Output 2:
false


Constraints:
1 <= N <= 10^5
’bill[i]’ is 5, 10, or 20.
Time Limit: 1 sec
*/
public class Solution {
    public static boolean lemonadeChange(int []bill) {
        // Write your code here.
        int totalFive=0, totalTen=0,totalTwenty=0;
        for(int n: bill){
            if(n==5){
                totalFive++;
            }
            if(n== 10){
                totalTen++;
                if(totalFive < 1){
                    return false;
                }
                totalFive--;
            }
            if(n == 20){
                totalTwenty++;
                if(totalFive == 0){
                    return false;
                }
                if(totalFive < 3 && totalTen < 1){
                    return false;
                }
                if(totalTen > 1 && totalFive >=1){
                    totalTen--;
                    totalFive--;
                }
                else if(totalTen < 1 && totalFive > 3){
                    totalFive = totalFive-3;
                }
            }
        }
        return true;
    }
}
