/*
Coding Ninja: https://www.codingninjas.com/studio/problems/subsequence-counting_3755256
Leet Code: https://leetcode.com/problems/distinct-subsequences/description/

Problem statement
A Subsequence of a string is the string that is obtained by deleting 0 or more letters from the string and keeping the rest of the letters in the same order.
We are given two strings, 'str' and 'sub'.
Find the number of subsequences of 'str' which are equal to 'sub'.
Since the answer can be very large, print it modulo 10 ^ 9 + 7.



Example :
Input: 'str' = “brootgroot” and 'sub' = “brt”

Output: 3

Explanation: The following subsequences formed by characters at given indices (0-based) of 'str' are equal to 'sub' :

str[0] = ‘b’, str[1] = ‘r’, str[4] = ‘t’

str[0] = ‘b’, str[1] = ‘r’, str[9] = ‘t’

str[0] = ‘b’, str[6] = ‘r’, str[9] = ‘t’
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
brootgroot
brt


Sample Output 1 :
3


Explanation For Sample Input 1 :
The following subsequences formed by characters at given indices (0-based) of 'str' are equal to 'sub' :

str[0] = ‘b’, str[1] = ‘r’, str[4] = ‘t’

str[0] = ‘b’, str[1] = ‘r’, str[9] = ‘t’

str[0] = ‘b’, str[6] = ‘r’, str[9] = ‘t’


Sample Input 2 :
dingdingdingding
ing


Sample Output 2 :
20


Sample Input 3:
aaaaa
a


Sample Output 3:
5


Expected time complexity :
The expected time complexity is O(|str| * |sub|).


Constraints:
1 <= |str| <= 1000
1 <= |sub| <= 1000

Where |str| represents the length of the string 'str', and |sub| represents the length of the string 'sub'.

Time Limit: 1 sec.
====================================== Solution Idea ========================================
This is a string matching solution, 
n the recursive logic, we set the base case too if(i<0 ) and if(j<0) but we can’t set the dp array’s index to -1. Therefore a hack for this issue is to shift every index by 1 towards the right.
First we initialize the dp array of size [n+1][m+1] as zero.
Next, we set the base condition (keep in mind 1-based indexing), we set the first column’s value as 1 and the first row as 1.
Similarly, we will implement the recursive code by keeping in mind the shifting of indexes, therefore S1[i] will be converted to S1[i-1]. Same for S2.
At last, we will print dp[N][M] as our answer.
*/

// Dynamic Programming Tabulation Solution 
import java.util.*;
public class Solution {
    public static int distinctSubsequences(String str, String sub) {
        // Write your code here.
        int mod = (int)(Math.pow(10,9)+7);
        int n = str.length();
        int m = sub.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str.charAt(i-1) == sub.charAt(j-1)){
                    int leave = dp[i-1][j-1];
                    int stay = dp[i-1][j];
                    dp[i][j]= (leave+stay)%mod;
                }
                else{
                    dp[i][j] = dp[i-1][j]%mod;
                }
            }
        }
        return (int)dp[n][m]%mod;
    }
}
