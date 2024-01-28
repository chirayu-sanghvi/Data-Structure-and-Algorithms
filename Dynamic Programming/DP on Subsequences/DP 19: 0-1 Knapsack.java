/*
Coding Ninja: https://www.codingninjas.com/studio/problems/0-1-knapsack_920542\
Problem statement
A thief is robbing a store and can carry a maximal weight of W into his knapsack. There are N items and the ith item weighs wi and is of value vi. Considering the constraints of the maximum weight that a knapsack can carry, you have to find and return the maximum value that a thief can generate by stealing items.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 10^2
1<= wi <= 50
1 <= vi <= 10^2
1 <= W <= 10^3

Time Limit: 1 second
Sample Input:
1 
4
1 2 4 5
5 4 8 6
5
Sample Output:
13
*/

// Dynamic Programming - Memoization Solution
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */
        int dp[][] = new int[n][maxWeight+1];
        for(int row[]:dp){
        Arrays.fill(row,-1);
        }
        return find(weight,value, n, maxWeight, n-1, dp);
    }

    public static int find(int weight[], int[] value, int n, int cap, int index, int dp[][]){
        if(index == 0){
            if(weight[index] <= cap){
                return value[index];
            }
            return 0;
        }

        if(dp[index][cap] != -1)
        return dp[index][cap];

        int notTake = 0 + find(weight,value,n, cap, index-1, dp);
        int take = Integer.MIN_VALUE;
        if(weight[index] <= cap){
            take = value[index] + find(weight,value,n,cap-weight[index], index-1, dp);
        }
        return dp[index][cap] = Math.max(notTake,take);
    }

  
// Dynamic Programming - Tabulation Solution 
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */
        int dp[][] = new int[n][maxWeight+1];
        for(int i=weight[0];i<=maxWeight;i++){
            dp[0][i] = value[0];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=maxWeight;j++){
                int notTake = 0 + dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= j){
                    take = value[i] + dp[i-1][j-weight[i]];
                }
                dp[i][j] = Math.max(notTake,take);
            }
        }
        return dp[n-1][maxWeight];
    }
}
