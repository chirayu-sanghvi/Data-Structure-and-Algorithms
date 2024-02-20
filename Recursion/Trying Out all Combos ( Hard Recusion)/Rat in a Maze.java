/*
Coding Ninja: https://www.codingninjas.com/studio/problems/rat-in-a-maze-_8842357
Leet Code: https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

Problem statement
You are given a N*N maze with a rat placed at 'mat[0][0]'. Find all paths that rat can follow to reach its destination i.e. mat[N-1][N-1]. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).



In the given maze, each cell can have a value of either 0 or 1. Cells with a value of 0 are considered blocked, which means the rat cannot enter or traverse through them. On the other hand, cells with a value of 1 are open, indicating that the rat is allowed to enter and move through those cells.



Example:
mat:{{1, 0, 0, 0},
     {1, 1, 0, 1}, 
     {1, 1, 0, 0},
     {0, 1, 1, 1}}

All possible paths are:
DDRDRR (in red)
DRDDRR (in green)

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3
1 1 1
1 0 1
1 1 1
Sample Output 1 :
DDRR
RRDD
Explanation of Sample Input 1:
Only 2 path is possible.

Sample Input 2 :
2
1 1
1 0
Sample Output 2 :
-1
Explanation of Sample Input 2:
No path exists.
Constraints:
2 <= N <= 5
0 <= mati][j] <=1

Time Limit: 1sec

*/
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<String> ratMaze(int [][]mat) {
        // Write your code here.
        List<String> result = new ArrayList<>();
        int n = mat.length;
        findMaze(mat,n,0,0,"", result, new boolean[n][n]);
        if(result.size() == 0){
            result.add("-1");
        }
        return result;
    }

    public static void findMaze(int mat[][], int n, int i, int j, String str, List<String> result, boolean visited[][]){
        if(i == n-1 && j == n-1 && mat[i][j] != 0 ){
            result.add(str);
            return;
        }

        if(i < 0 || j < 0 || i >= n || j >= n || mat[i][j] == 0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        if(i-1 >= 0)
        findMaze(mat,n,i-1,j,str+"U", result, visited);
        if(j+1 < n)
        findMaze(mat,n,i,j+1,str+"R", result, visited);
        if(i+1 < n)
        findMaze(mat,n,i+1,j,str+"D", result, visited);
        if(j-1 >= 0)
        findMaze(mat,n,i,j-1,str+"L", result, visited);
        visited[i][j] = false;
    }
}
