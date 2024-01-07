/*
Coding Ninja: https://www.codingninjas.com/studio/problems/flood-fill-_1082141
Leet Code: https://www.codingninjas.com/studio/problems/flood-fill-_1082141?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
An 'IMAGE' is represented by the 2-D array of positive integers, where each element of 2-D represents the pixel value of the image.



The given 'IMAGE' has 'N' rows and 'M' columns. You are given the location of the pixel in the image as ('X', 'Y')(0-based indexing) and a pixel value as 'P'.



Your task is to perform a “flood fill” operation on the given coordinate (X, Y) with pixel value 'P'.



Let the current pixel value of ('X', 'Y') be equal to C. To perform the flood fill operation on the coordinate (X, Y) with pixel value 'P' you need to do the following operations in order:

1. Replace the pixel value of ('X', 'Y') with 'P'.

2. Visit all non-diagonal neighbours of ('X', 'Y') having pixel values equal to C and replace their pixel value with 'P'.

3. Non – diagonal neighbours are Up('X' - 1, 'Y'), Down('X' + 1, 'Y'), Left('X', 'Y' - 1), right('X', 'Y' + 1). Also, you cannot go out of bounds.

4. Visit all non-diagonals neighbours of coordinates visited in step 2 having pixel value equal to C and replace their pixel value with 'P'. 

5. Repeat step 2, until you have visited all your neighbours
For Example:
For  'N' = 5 , 'M' = 4 , 'X' = 2 , 'Y' = 2 and 'P' = 5
Given 'IMAGE' is shown below:

[7, 1, 1, 1]
[1, 7, 7, 7]
[7, 7, 7, 0]
[7, 7, 7, 4]
[4, 4, 4, 4]

After the flood fill operation, we will replace all neighbour's 7s with 5.

So our 'IMAGE' will become:

[7, 1, 1, 1]
[1, 5, 5, 5]
[5, 5, 5, 0]
[5, 5, 5, 4]
[4, 4, 4, 4]
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 2
1 1 3
0 0
1 1
1 0    
Sample Output 1 :
0 0
3 3
3 0
Explanation :
We will replace all 1’s with 4 except the one which is at the bottom right corner i.e. 3,3. 
Sample Input 2 :
4 3
1 1 4
0 0 2
1 1 2
1 0 2
2 2 1
Sample Output 2 :
0 0 2
4 4 2
4 0 2
2 2 1
Constraints :
1 <= N,M <= 100 
0 <= X <= N – 1
0 <= Y <= M - 1
0 <= IMAGE[i][j], P <= 10^9

Where 'IMAGE[i][j]' denotes the image matrix pixel elements.

Time limit: 1 sec
*/

import java.util.Queue;
import java.util.*;
class pair{
    int row;
    int col;
    pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Solution {
    public static int[][] floodFill(int[][] image, int n, int m, int x, int y, int p) {
        // Write your code here.
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        int [][] visited = new int[n][m];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(x,y));
        visited[x][y] = 1;
        int initial = image[x][y];
        image[x][y] = p;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && image[nrow][ncol] == initial){
                    q.add(new pair(nrow,ncol));
                    visited[nrow][ncol] = 1;
                    image[nrow][ncol] = p;
                }
            }
        }
        return image;
    }
}

