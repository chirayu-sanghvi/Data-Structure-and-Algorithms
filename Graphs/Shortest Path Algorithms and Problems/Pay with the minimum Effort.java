/*
Coding Ninja: https://www.codingninjas.com/studio/problems/path-with-minimum-effort_1380958
Leet Code: https://www.codingninjas.com/studio/problems/path-with-minimum-effort_1380958

Problem statement
You are given heights, a 2D array of size 'rows' x 'columns', where heights[row][col] represents the height of a cell (which would contain a row and column).



You are a Ninja training for an upcoming battle. You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).



You can move up, down, left, or right, and you wish to find a route that requires the minimum time. A route's time is the maximum absolute difference in heights between two consecutive cells of the route.



You must return the minimum time required to travel from the top-left cell to the bottom-right cell.



For Example:
Input: 'heights' = [[1, 8, 8],[3, 8, 9],[5,3,5]]
Output: 2

Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3 3
1 2 3
3 8 4
5 3 5
Sample output 1:
1 
Explanation:

The figure above describes the following heights list (array). 

Here, The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than the route [1,3,5,3,5].
Sample Input 2:
3 3
1 3 1
9 9 3
9 9 1
Sample output 2:
2
Constraint :
rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 10^6

Where ‘rows’ is the number of rows and ‘columns’ is the number of columns. 

Time Limit: 1 sec
*/

import java.util.*;

class tuple{
    int distance;
    int x;
    int y;
    tuple(int distance, int x, int y){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
public class Solution {
    public static int minimumTimeTakingPath(int[][] heights){
        // Write your code here.
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<tuple> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);
        int[][] distance_matrix = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance_matrix[i][j] = (int)(1e9);
            }
        }

        distance_matrix[0][0] = 0;
        pq.add(new tuple(0,0,0));
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,+1,0,-1};

        while(!pq.isEmpty()){
            tuple tup = pq.peek();
            pq.remove();
            int d = tup.distance;
            int r = tup.x;
            int c = tup.y;

            if(r == n-1 && c == m-1){
                return d;
            }

            for(int i =0 ;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int newEffort = Math.max(d, Math.abs(heights[r][c]-heights[nrow][ncol]));
                    if(newEffort < distance_matrix[nrow][ncol]){
                        distance_matrix[nrow][ncol] = newEffort;
                        pq.add(new tuple(distance_matrix[nrow][ncol], nrow, ncol));
                    }
                }
            }
        }
        return -1;
    }
}
