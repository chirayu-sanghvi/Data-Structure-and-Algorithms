/*
Coding Ninja: https://www.codingninjas.com/studio/problems/shortest-path-in-a-binary-maze_893065
Leet Code: https://leetcode.com/problems/shortest-path-in-binary-matrix/

Problem statement
Given a maze in the form of a binary rectangular matrix of size M*N, where each element can either be 0 or 1, the task is to find the length of the shortest path in a maze from a given source cell to a destination cell.

The path can only be created out of a cell if its value is 1 and at any given moment, we can only move one step in one of the four directions. The valid moves are:

Up: (x, y) -> (x - 1, y)
Left: (x, y) -> (x, y - 1)
Down: (x, y) -> (x + 1, y)
Right: (x, y) -> (x, y + 1)
If there is no path from a given source cell to a destination cell, return -1.

For example :
consider the binary matrix below. If source = (0, 0) and destination = (3, 4), the shortest path from source to destination has length 11.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 10
1 <= M, N <= 100

Time Limit: 1sec
Sample Input 1 :
2
3 4
1 1 1 1
0 1 1 0
0 0 1 1
0 0
2 3
2 2
1 1
0 1
0 0
1 1
Sample Output 1 :
5
2
Explanation of Sample Input 1 :
For the first test case, the shortest path between the source cell (0, 0) and destination cell (2,3) is highlighted in the figure below, having a length of 5.

For the second test case, the only path from the source cell to the destination cell has a length of 2.
Sample Input 2 :
2
2 2
1 1
1 1
0 1
1 1
2 2
1 0
0 1
0 0
1 1
Sample Output 2 :
1
-1
*/

import java.util.Queue;
import java.util.*;
/*************************************

Following is the Point Class structure

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

**************************************/
class grid{
	int distance;
	int xcorr;
	int ycorr;
	grid(int distance, int xcorr, int ycorr){
		this.distance = distance;
		this.xcorr = xcorr;
		this.ycorr = ycorr;
	}
}
public class Solution {
	public static int shortestPathBinaryMatrix(int[][] matrix, Point src, Point dest) {
		// Write your code here
		int x_src = src.x;
		int y_src = src.y;
		int x_dest = dest.x;
		int y_dest = dest.y;
		if(matrix[x_src][y_src] == 0){
			return -1;
		}
		if(x_src == x_dest && y_src == y_dest)
			return 0;

		Queue<grid> q = new LinkedList<>();
		int n = matrix.length;
		int m = matrix[0].length;
		int distance_matrix[][] = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				distance_matrix[i][j] = (int)(1e9);
			}
		}
		q.add(new grid(0, x_src, y_src));
		distance_matrix[x_src][y_src] = 0;
		int drow[] = {-1, 0, +1, 0};
		int dcol[] = {0, +1, 0, -1};
		while(!q.isEmpty()){
			grid index = q.peek();
			q.remove();
			int dist = index.distance;
			int row = index.xcorr;
			int col = index.ycorr;
			for(int i=0;i<4;i++){
				int nrow = row + drow[i];
				int ncol = col + dcol[i];
				if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && matrix[nrow][ncol] == 1 && dist+1 < distance_matrix[nrow][ncol]){
					distance_matrix[nrow][ncol] = 1+dist;
					if(nrow == x_dest && ncol == y_dest){
						return dist+1;
					}
					q.add(new grid(distance_matrix[nrow][ncol], nrow, ncol));
				}
			}
		}
		return -1;

	}
}
