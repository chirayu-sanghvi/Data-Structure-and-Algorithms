/*
Coding Ninja: https://www.codingninjas.com/studio/problems/unique-paths-ii_977241
Leet Code: https://leetcode.com/problems/unique-paths-ii/description/

Problem statement
Given a ‘N’ * ’M’ maze with obstacles, count and return the number of unique paths to reach the right-bottom cell from the top-left cell. A cell in the given maze has a value '-1' if it is a blockage or dead-end, else 0. From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only. Since the answer can be large, print it modulo 10^9 + 7.

For Example :
Consider the maze below :
0 0 0 
0 -1 0 
0 0 0

There are two ways to reach the bottom left corner - 

(1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
(1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)

Hence the answer for the above test case is 2.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 10
1 <= N,M <= 200

Note: It is guaranteed that the top-left cell does not have an obstacle.

Time Limit: 1 sec
Sample Input 1 :
2    
2 2
0 0
0 0
3 3
0 0 0 
0 -1 0 
0 0 0
Sample Output 1 :
2
2
Explanation For Sample Output 1 :
For the first test case, there are two possible paths to reach (2, 2) from (1, 1) : 
    (1, 1) -> (1, 2) -> (2, 2)
    (1, 1) -> (2, 1) -> (2, 2)

For the second test case, there are two ways to reach the bottom left corner - 
(1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
(1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)
Sample Input 2 :
1
2 2
0 -1
-1  0
Sample Output 2 :
0
*/

// Bottom up Tabulation Solution
import java.util.*;
public class Solution {
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        int dp[][] = new int[n][m];
        int mod = 1000000007;
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i>0 || j>0) && mat.get(i).get(j) == -1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i== 0 && j ==0){
                    dp[i][j] = 1;
                    continue;
                }
                int left = 0;
                int up = 0;
                if(i > 0) 
                    left = dp[i-1][j];
                if(j > 0) 
                    up = dp[i][j-1];
                dp[i][j] = (left + up)% mod;
            }
        }
        return dp[n-1][m-1];
    }
}
