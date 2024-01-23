/*
Coding Ninja: https://www.codingninjas.com/studio/problems/triangle_1229398
Leet Code: https://leetcode.com/problems/triangle/description/

Problem statement
You are given a triangular array/list 'TRIANGLE'. Your task is to return the minimum path sum to reach from the top to the bottom row.

The triangle array will have N rows and the i-th row, where 0 <= i < N will have i + 1 elements.

You can move only to the adjacent number of row below each step. For example, if you are at index j in row i, then you can move to i or i + 1 index in row j + 1 in each step.

For Example :
If the array given is 'TRIANGLE' = [[1], [2,3], [3,6,7], [8,9,6,1]] the triangle array will look like:

1
2,3
3,6,7
8,9,6,10

For the given triangle array the minimum sum path would be 1->2->3->8. Hence the answer would be 14.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 5
1 <= N <= 10^3 
-10^6 <= TRIANGLE[i][pos] <= 10^6 ,                

Where 'TRIANGLE[i][pos]' is the element at row = 'i' & position = 'pos' in triangle array.  

Time limit: 1 sec
Sample Input 1 :
2
4
2 
3 4
6 5 7
4 1 8 3
1
-10 
Sample output 1 :
11
-10
Sample Input explanation:
Test case 1:
Here our triangle array is:

2
3 4
6 5 7 
4 1 8 3

In this array, the minimum path will be 2->3->5->1, so the minimum sum path would be 2+3+5+1=11

Test case 2:
In this case, there is one row. Thus, the minimum path will be -10, and the minimum sum path=-10.
Sample input 2 :
2
4
1
2 3
4 5 6
7 8 9 10
3
5
-1 3
22 1 -9
Sample Output 2 :
14
-1
*/
// Recusion (Partially Accepted)
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        return minimum(triangle, n, 0,0);
    }

    public static int minimum(int[][] triangle, int n, int i, int j){
        if(i == n-1){
            return triangle[n-1][j];
        }

        int down = triangle[i][j] + minimum(triangle,n,i+1,j);
        int dia = triangle[i][j] + minimum(triangle,n,i+1,j+1);
        return Math.min(down, dia); 
    }
}

// Dynamic Programming ( Memoization ) - Partially Accepted
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int dp[][]= new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return minimum(triangle, n,dp, 0,0);
    }

    public static int minimum(int[][] triangle, int n, int[][] dp, int i, int j){
        if(i == n-1){
            return triangle[n-1][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = triangle[i][j] + minimum(triangle,n,dp,i+1,j);
        int dia = triangle[i][j] + minimum(triangle,n,dp,i+1,j+1);
        return Math.min(down, dia); 
    }
}

// Dynamic Programming ( Tabulation ) Completely Accepted
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int dp[][]= new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row,0);
        }

        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle[n-1][j];
        }

        for(int i = n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = triangle[i][j] + dp[i+1][j];
                int diag = triangle[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}


// Dynamic Programming (Space Optimized on top of Tabulation)
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int front[] = new int[n];
        Arrays.fill(front, 0);
        int current[] = new int[n];
        Arrays.fill(current, 0);
        for(int j=0;j<n;j++){
            front[j] = triangle[n-1][j];
        }

        for(int i = n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = triangle[i][j] + front[j];
                int diag = triangle[i][j] + front[j+1];
                current[j] = Math.min(down, diag);
            }
            front = current.clone();
        }
    return front[0];
    }

}
