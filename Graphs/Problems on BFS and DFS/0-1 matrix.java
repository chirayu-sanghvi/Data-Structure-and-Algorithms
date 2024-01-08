/*
Coding Ninja: https://www.codingninjas.com/studio/problems/distance-of-nearest-cell-having-1-in-a-binary-matrix_1169913
Leet Code: https://leetcode.com/problems/01-matrix/description/

Problem statement
You have been given a binary matrix 'MAT' containing only 0’s and 1’s of size N x M. You need to find the distance of the nearest cell having 1 in the matrix for each cell.

The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the coordinates of the current cell and i2, j2 are the coordinates of the nearest cell having value 1.
Note :
You can only move in four directions which are : Up, Down, Left and Right.
For example :
If N = 3, M = 4

and mat[ ][ ] = { 0, 0, 0, 1,
                  0, 0, 1, 1,
                  0, 1, 1, 0 }

then the output matrix will be

3  2  1  0
2  1  0  0
1  0  0  1
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 5
1 <= N <= 2*10^2
1 <= M <= 2*10^2

Where ‘T’ is the number of test cases, ‘N’ is the number of rows in the matrix and ‘M’ is the number of columns in the matrix.
Sample Input 1:
1
3 4
0 0 0 1
0 0 1 1
0 1 1 0
Sample Output 1:
3 2 1 0
2 1 0 0
1 0 0 1
Sample Input 2:
1
3 3
1 0 0 
0 0 1 
0 1 1
Sample Output 2:
0 1 1 
1 1 0 
1 0 0
*/

import java.util.*;
public class Solution {
	public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
		// Write your code here.
        boolean vis[][]=new boolean[n][m];
        int dist[][]=new int[n][m];
        Queue<Triple> q=new LinkedList<>();
        int[] dr={1,0,-1,0},dc={0,-1,0,1};
        for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
           if(mat.get(i).get(j)==1){
             vis[i][j]=true;
             q.add(new Triple(i,j,0));
           }
         }
        }
        while(!q.isEmpty()){
          Triple t=q.poll();
          int ri=t.a,cj=t.b,steps=t.dis;
          dist[ri][cj]=steps;
          for(int i=0;i<4;i++){
            int r=ri+dr[i],c=cj+dc[i];
            if(r>=0 && c>=0 && r<n && c<m && !vis[r][c]){
             vis[r][c]=true;
             q.add(new Triple(r,c,steps+1));
            }
          }
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
          ArrayList<Integer> curr=new ArrayList<>();
          for(int j=0;j<m;j++) curr.add(dist[i][j]);
          ans.add(curr);
        }
        return ans;
	}
}
class Triple{
  int a,b,dis;
  Triple(int a,int b,int dis){
    this.a=a;
    this.b=b;
    this.dis=dis;
  }
}
