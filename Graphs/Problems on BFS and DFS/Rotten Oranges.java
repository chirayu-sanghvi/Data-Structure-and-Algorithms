/*
Coding Ninja: https://www.codingninjas.com/studio/problems/rotting-oranges_701655
Leet Code: https://leetcode.com/problems/rotting-oranges/description/

Problem statement
You have been given a grid containing some oranges. Each cell of this grid has one of the three integers values:

Value 0 - representing an empty cell.
Value 1 - representing a fresh orange.
Value 2 - representing a rotten orange.
Every second, any fresh orange that is adjacent(4-directionally) to a rotten orange becomes rotten.

Your task is to find out the minimum time after which no cell has a fresh orange. If it's impossible to rot all the fresh oranges then print -1.

Note:
1. The grid has 0-based indexing.
2. A rotten orange can affect the adjacent oranges 4 directionally i.e. Up, Down, Left, Right.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 500
1 <= M <= 500
0 <= grid[i][j] <= 2

Time Limit: 1 sec
Sample Input 1:
3 3
2 1 1
1 1 0
0 1 1 
Sample Output 1:
4
Explanation of Sample Input 1:
Minimum 4 seconds are required to rot all the oranges in the grid as shown below.

Sample Input 2:
3 3
2 1 0
0 1 1
1 0 1
Sample Output 2:
-1
Explanation of Sample Input 2:
The bottom left corner fresh orange (row 2, column 0) has no adjacent oranges. Hence, it's impossible to rot it.
*/

import java.util.*;

class Pair{
	int row;
	int col;
	int time;
	Pair(int row, int col, int time){
		this.row = row;
		this.col = col;
		this.time = time;
	}
}
public class Solution {
	public static int minTimeToRot(int[][] grid, int n, int m) {
		// Write your code here.
		Queue<Pair> q = new LinkedList<>();
		int [][] visited = new int[n][m];
		int countFresh = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j] == 2){
					q.add(new Pair(i,j,0));
					visited[i][j] = 2;
				}
				else {
					visited[i][j] = 0;
				}
				if(grid[i][j] == 1){
					countFresh++;
				}
			}
		}

		int tm = 0;
		int drow[] = {-1, 0, +1, 0};
		int dcol[] = {0, 1, 0, -1};
		int count = 0;
		while(!q.isEmpty()){
			int r = q.peek().row;
			int c = q.peek().col;
			int t = q.peek().time;
			tm = Math.max(tm,t);
			q.remove();
			for(int i=0;i<4;i++){
				int nrow = r+drow[i];
				int ncol = c+dcol[i];
				if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
					q.add(new Pair(nrow,ncol, t+1));
					visited[nrow][ncol] = 2;
					count++;
				}
			}
		}

		if(countFresh != count){
			return -1;
		}
		return tm;
	}
}
