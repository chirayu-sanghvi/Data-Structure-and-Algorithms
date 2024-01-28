/*
Coding Ninja: https://www.codingninjas.com/studio/problems/minimum-insertions-to-make-a-string-palindrome_985293
Problem statement
A palindrome string is one that reads the same backward as well as forward.



You are given a string 'str'.



Find the minimum number of characters needed to insert in 'str' to make it a palindromic string.



Example :
Input: 'str' = "abca"

Output: 1

Explanation:
If we insert the character ‘b’ after ‘c’, we get the string "abcba", which is a palindromic string. Please note that there are also other ways possible.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
abca


Sample Output 1:
1


Explanation for input 1:
If we insert the character ‘b’ after ‘c’, we get the string "abcba", which is a palindromic string. Please note that there are also other ways possible.


Sample Input 2:
abcdefg


Sample Output 2:
6


Sample Input 3:
aaaaa


Sample Output 3:
0


Expected time complexity :
The expected time complexity is O(|str| ^ 2).


Constraints:
1 <= |str| <= 1000

Where |str| represents the length of the string 'str'.

Time Limit: 1 sec.
*/

// Dynamic Programming Tabulation Solution
import java.util.*;
public class Solution {
    public static int minInsertion(String s) {
        // Write your code here.
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int len = dp[n][n];
        return n-len;
        }
    }
