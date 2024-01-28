/*
Coding Ninja: https://www.codingninjas.com/studio/problems/longest-palindromic-subsequence_842787
Leet Code: 

Problem statement
You have been given a string ‘A’ consisting of lower case English letters. Your task is to find the length of the longest palindromic subsequence in ‘A’.

A subsequence is a sequence generated from a string after deleting some or no characters of the string without changing the order of the remaining string characters. (i.e. “ace” is a subsequence of “abcde” while “aec” is not).

A string is said to be palindrome if the reverse of the string is the same as the actual string. For example, “abba” is a palindrome, but “abbc” is not a palindrome.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 10 ^ 2

Where ‘T’ is the number of test cases, and ‘N’ is the length of the string.

Time limit: 1 sec.
Sample Input 1:
2
bbabcbcab
bbbab
Sample Output 1:
7
4
Explanation of Sample Input 1:
For the first test case, the longest palindromic subsequence is “babcbab”, which has a length of 7. “bbbbb” and “bbcbb” are also palindromic subsequences of the given string, but not the longest one.

For the second test case, the longest palindromic subsequence is “bbbb”, which has a length of 4.
Sample Input 2:
3
cbbd
bebeeed
abcd
Sample Output 2:
2
4
1
================================= Solution Idea =========================
Just reverse the string and the apply longest common subsequence algorithm
*/

// Dynamic Programming Tabulation Method 
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int longestPalindromeSubsequence(String s) {
		// Write your code here.
		String t = new StringBuilder(s).reverse().toString();
		int n = s.length();
		int dp[][] = new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(s.charAt(i-1) == t.charAt(j-1)){
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[n][n];
	}
}
