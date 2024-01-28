/*
Coding Ninja: https://www.codingninjas.com/studio/problems/minimum-number-of-deletions-and-insertions_4244510
Leet Code: https://leetcode.com/problems/delete-operation-for-two-strings/

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
public class Solution {
    public static int canYouMake(String s1, String s2) {
        // Write your code here.
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int sub = dp[n][m];
        return (n-sub) + (m-sub);
    }
}
