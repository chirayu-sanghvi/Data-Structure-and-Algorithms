/*
Coding Ninja: https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471
Problem statement
You are given an infinite supply of coins of each of denominations D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make a change for value V using coins of denominations from D. Print 0, if a change isn't possible.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3
1 2 3
4
Sample Output 1:
4
Explanation for Sample Output 1:
We can make a change for the value V = 4 in four ways.
1. (1,1,1,1), 
2. (1,1, 2), [One thing to note here is, (1, 1, 2) is same as that of (2, 1, 1) and (1, 2, 1)]
3. (1, 3), and 
4. (2, 2)
Sample Input 2 :
3
5 3 2
1
Sample Output 2:
0
*/

// Dynamic Programming - Tabulation Solution
public class Solution {
	public static long countWaysToMakeChange(int arr[], int value){
        //write your code here		
		int n = arr.length;
		long dp[][] = new long[n][value+1];
		for(int i=0;i<=value;i++){
			if(i%arr[0] == 0){
				dp[0][i] = 1;
			}
		}

		for(int i=1;i<n;i++){
			for(int j=0;j<=value;j++){
				long notTaken = dp[i-1][j];
				long taken = 0;
				if(arr[i] <= j){
					taken = dp[i][j-arr[i]];
				}
				dp[i][j] = notTaken+taken;
			}
		}
		return dp[n-1][value];	
	}	
}
