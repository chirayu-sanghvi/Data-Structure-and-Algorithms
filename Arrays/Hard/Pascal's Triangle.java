/*
Coding Ninja: https://www.codingninjas.com/studio/problems/print-pascal-s-triangle_6917910
Leet Code: https://leetcode.com/problems/pascals-triangle/
Problem statement
You are given an integer ‘N’. You need to return the first ‘N’ rows of Pascal’s triangle.

Example:

Input:
N = 4
Output:
1
1 1
1 2 1
1 3 3 1
Explanation: The output matrix has the first four rows of Pascal’s Triangle. 
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 30
Time Limit: 1 sec
Sample Input 1:
5
Sample Output 1:
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
Explanation Of Sample Input 1:
Input:
N = 5

Output:
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
Explanation: The output matrix has the first five rows of Pascal’s Triangle.
Sample Input 2:
3
Sample Output 2:
1 
1 1
1 2 1
Sample Input 3:
4
Sample Output 3:
1 
1 1 
1 2 1 
1 3 3 1 
*/
import java.util.*;
public class Solution {
    public static int[][] pascalTriangle(int N) {
        // Write your code here.
        int ans[][] = new int[N][];
        if(N == 0) return ans;

        ans[0] = new int[]{1};
        // ans[0][0] = 1;
        if(N == 1) return ans;

        for(int i = 1 ; i < N ; i++){
            int curr[] = new int[i + 1];
            curr[0] = 1;
            curr[i] = 1;
            if(i > 1){
                for(int j = 1 ; j < i ; j++){
                    curr[j] = ans[i - 1][j - 1] + ans[i - 1][j];
                }
            }
            ans[i]= curr;
        }
        return ans;
    }
}
