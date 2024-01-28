/*
Coding Ninja: https://www.codingninjas.com/studio/problems/longest-common-subsequence_624879
Leet Code: https://leetcode.com/problems/longest-common-subsequence/description/
 
Problem statement
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.

For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.

Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.
*/
// Recusion Solution

public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
		return find(s,t,s.length()-1,t.length()-1);
    }

	public static int find(String s, String t, int index1, int index2){
		if(index1 < 0 || index2 < 2){
			return 0;
		}

		if(s.charAt(index1) == t.charAt(index2))
		return 1+ find(s,t, index1-1,index2-1);
		return 0 + Math.max(find(s,t,index1-1,index2), find(s,t, index1,index2-1));
	}


}

// Dynamic Programming - Memoization Solution 
import java.util.*;
public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
		int dp[][] = new int[s.length()][t.length()];
		for(int row[]: dp){
			Arrays.fill(row,-1);

		}
		find(s,t,s.length()-1,t.length()-1,dp);
		return dp[s.length()-1][t.length()-1];
    }

	public static int find(String s, String t, int index1, int index2,int[][] dp){
		if(index1 < 0 || index2 < 2){
			return 0;
		}

		if(dp[index1][index2] != -1){
			return dp[index1][index2];
		}
		if(s.charAt(index1) == t.charAt(index2))
		return dp[index1][index2] = 1+ find(s,t, index1-1,index2-1,dp);
		return dp[index1][index2] = 0 + Math.max(find(s,t,index1-1,index2,dp), find(s,t, index1,index2-1,dp));
	}
}

// Dynamic Programming - Tabulation Solution

public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
		int n = s.length();
		int m = t.length();
		int dp[][] = new int[n+1][m+1];
		for(int i=0;i<=n;i++){
			dp[i][0]= 0;
		}
		for(int j=0;j<=m;j++){
			dp[0][j] = 0;
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s.charAt(i-1) == t.charAt(j-1))
				dp[i][j] = 1+dp[i-1][j-1];
				else
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
			}
		}
		return dp[n][m];
    }

}
