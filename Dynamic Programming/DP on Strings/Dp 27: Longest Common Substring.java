/*
Coding Ninja: https://www.codingninjas.com/studio/problems/longest-common-substring_1235207

Problem statement
You are given two strings, 'str1' and 'str2'. You have to find the length of the longest common substring.



A substring is a continuous segment of a string. For example, "bcd" is a substring of "abcd", while "acd" or "cda" are not.



Example:
Input: ‘str1’ = “abcjklp” , ‘str2’ = “acjkp”.

Output: 3

Explanation:  The longest common substring between ‘str1’ and ‘str2’ is “cjk”, of length 3.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
wasdijkl
wsdjkl
Sample Output 1:
 3
Explanation Of Sample Input 1 :
 The longest common substring is “jkl”, of length 3.
Sample Input 2:
tyfg
cvbnuty
Sample Output 2:
2
Explanation Of Sample Input 2 :
The longest common substring is “ty”, of length 2.
Expected time complexity:
The expected time complexity is O(n*m),
Where ‘n’ and ‘m’ are the lengths of ‘st1’ and ‘str2’ respectively.
Constraints:
1 <= str1.length <= 1000
1 <= str2.length <= 1000
*/

// Dynamic Programming Tabulation Solution 
public class Solution {
    public static int lcs(String str1, String str2){
        // Write your code here.
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;
        for(int i =1; i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(dp[i][j], ans);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
