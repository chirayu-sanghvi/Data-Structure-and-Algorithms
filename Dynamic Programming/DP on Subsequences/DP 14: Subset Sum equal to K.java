/*
Coding Ninja: https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954
Problem statement
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 5
1 <= N <= 10^3
0 <= ARR[i] <= 10^9
0 <= K <= 10^3

Time Limit: 1 sec
Sample Input 1:
2
4 5
4 3 2 1
5 4
2 5 1 6 7
Sample Output 1:
true
false
Explanation For Sample Input 1:
In example 1, ‘ARR’ is {4,3,2,1} and ‘K’ = 5. There exist 2 subsets with sum = 5. These are {4,1} and {3,2}. Hence, return true.
In example 2, ‘ARR’ is {2,5,1,6,7} and ‘K’ = 4. There are no subsets with sum = 4. Hence, return false.
Sample Input 2:
2
4 4
6 1 2 1
5 6
1 7 2 9 10
Sample Output 2:
true
false
Explanation For Sample Input 2:
In example 1, ‘ARR’ is {6,1,2,1} and ‘K’ = 4. There exist 1 subset with sum = 4. That is {1,2,1}. Hence, return true.
In example 2, ‘ARR’ is {1,7,2,9,10} and ‘K’ = 6. There are no subsets with sum = 6. Hence, return false.

*/

// Dynamic Programming ( Top - Down) -Memoization Method
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int dp[][] = new int[n][k+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return find(n-1,k,arr,dp);
    }

    public static boolean find(int index, int target, int[] arr, int[][] dp){
        if(target == 0){
            return true;
        }
        if(index == 0){
            return arr[index] == target;
        }
        if(dp[index][target] != -1){
            if(dp[index][target] == 1){
                return true;
            }
            return false;
        }
        boolean notTake = find(index-1, target, arr,dp);
        boolean Take = false;
        if(arr[index] <= target){
            Take = find(index-1, target-arr[index],arr, dp);
        }
        dp[index][target] = (notTake || Take) ? 1 : 0;
        return notTake || Take;
    }
}
