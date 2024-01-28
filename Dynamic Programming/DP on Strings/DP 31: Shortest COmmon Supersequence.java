/*
Coding Ninja: https://www.codingninjas.com/studio/problems/shortest-common-supersequence_4244493
Leet Code: https://leetcode.com/problems/shortest-common-supersequence/description/

Problem statement
Given two strings, ‘A’ and ‘B’. Return the shortest supersequence string ‘S’, containing both ‘A’ and ‘B’ as its subsequences. If there are multiple answers, return any of them.

Note: A string 's' is a subsequence of string 't' if deleting some number of characters from 't' (possibly 0) results in the string 's'.

For example:
Suppose ‘A’ = “brute”, and ‘B’ = “groot”

The shortest supersequence will be “bgruoote”. As shown below, it contains both ‘A’ and ‘B’ as subsequences.

A   A A     A A
b g r u o o t e
  B B   B B B  

It can be proved that the length of supersequence for this input cannot be less than 8. So the output will be bgruoote.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
2
brute
groot
bleed
blue
Sample Output 1 :
bgruoote
bleued
Explanation For Sample Input 1 :
For First Case - Same as explained in above example.

For the second case - 

‘A’ = “bleed”, and ‘B’ = “blue”

The shortest supersequence will be “bleued”. As shown below, it contains both ‘A’ and ‘B’ as subsequences.

A A A   A A
b l e u e d
B B   B B

It can be proved that the length of supersequence for this input cannot be less than 6. So the output will be bleued.
Sample Input 2 :
2
coding
ninjas
blinding
lights
Sample Output 2 :
codningjas
blindinghts
============================================================== Solution Idea ============================================================
FInd the LCS and then traverse it backward, if it matches then add it once otherwise add both i and j until they are greate than zero
*/
// Dynamic Programming Tabulation Solution 
import java.util.* ;
import java.io.*; 
public class Solution {
    public static String shortestSupersequence(String s, String t) {
        // Write your code here..
        int n = s.length();
        int m = t.length();
		int dp[][] = new int[n+1][m+1];

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s.charAt(i-1) == t.charAt(j-1))
				dp[i][j] = 1+dp[i-1][j-1];
				else
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
			}
		}
		int len = dp[n][m];
        String result = "";
        int i = n, j = m;
        while(i>0 && j>0){
            if(s.charAt(i-1) == t.charAt(j-1)){
                result= s.charAt(i-1) + result;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                result = s.charAt(i-1) + result;
                i--;
            }
            else{
            result = t.charAt(j-1) + result;
             j--;
            }
        }

        while(i>0){
                result = s.charAt(i-1) + result;
                i--; 
        }

        while(j>0){
                result = t.charAt(j-1) + result;
                j--; 
        }
    return result;
    }

}
