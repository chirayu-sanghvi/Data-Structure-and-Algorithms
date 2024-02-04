/*
Coding Ninja: https://www.codingninjas.com/studio/problems/longest-increasing-subsequence_630459
Leet Code: https://leetcode.com/problems/longest-increasing-subsequence/
Problem statement
For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order.

Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.

For example:
[1, 2, 3, 4] is a strictly increasing array, while [2, 1, 4, 3] is not.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
6
5 4 11 1 16 8
Sample Output 1 :
3
Explanation of Sample Input 1:
Length of longest subsequence is 3 i.e. [5, 11, 16] or [4, 11, 16].
Sample Input 2:
3
1 2 2
Sample Output 2 :
2
*/
// Recursion 
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
		int n = arr.length;
		return find(arr, n, 0, -1);
	}

	public static int find(int[] arr, int n, int index, int prev){
		if(index == n){
			return 0;
		}

		int notTake = 0 + find(arr,n, index+1, prev);
		int Take = 0;
		if(prev == -1 || arr[index] > arr[prev]){
			Take = 1 + find(arr, n, index+1, index);
		}
		return Math.max(notTake, Take);
	}

}


// Dynamic Programming Memoization Solution
import java.util.*;
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
		int n = arr.length;
		int dp[][] = new int [n][n+1];
		for(int row[] : dp){
			Arrays.fill(row, -2);
		}
		return find(arr, n, 0, -1, dp);
	}

	public static int find(int[] arr, int n, int index, int prev, int[][] dp){
		if(index == n){
			return 0;
		}

		if(dp[index][prev+1] != -2){
			return dp[index][prev+1];
		}

		int notTake = 0 + find(arr,n, index+1, prev, dp);
		int Take = 0;
		if(prev == -1 || arr[index] > arr[prev]){
			Take = 1 + find(arr, n, index+1, index, dp);
		}
		return dp[index][prev+1] = Math.max(notTake, Take);
	}

}


// Dynamic Programming Tabulation Solution
import java.util.*;
public class Solution {
	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
		int n = arr.length;
		int dp[][] = new int [n+1][n+1];
		for(int index = n-1;index>= 0 ; index--){
			for(int prev = index-1;prev >= -1; prev--){
				int notTake = dp[index+1][prev+1];
				int Take = 0;
				if(prev == -1 || arr[index] > arr[prev]){
					Take = 1 + dp[index+1][index+1];
				}
				dp[index][prev+1] = Math.max(notTake, Take);
			}
		}
		return dp[0][-1+1];
	}
}
