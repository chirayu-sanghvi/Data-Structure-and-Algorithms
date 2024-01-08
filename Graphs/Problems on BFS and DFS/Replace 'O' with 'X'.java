/*
Coding Ninja: https://www.codingninjas.com/studio/problems/replace-%E2%80%98o%E2%80%99-with-%E2%80%98x%E2%80%99_630517

Problem statement
Given a 2D array grid G of 'O's and 'X's. The task is to replace all 'O' with 'X' contained in each island. Where, an island is a set of 'O's connected horizontally or vertically and surrounded by 'X' from all of it's boundaries. (Boundary means top, bottom, left and right)

Example:
{{X, X, O, X, X, X},
 {X, X, O, X, O, X},
 {X, X, X, O, O, X},
 {X, O, X, X, X, X},
 {O, X, O, O, X, X},
 {X, X, X, X, O, X}}
In the above example, there are 3 islands. Considering Zero based indexing of rows and columns, in the following islands described here, (x,y) represents the element in xth row and yth column.

Island 1: Formed by three elements at (1, 4), (2, 3), (2, 4) positions.

Island 2: Formed by a single element at (3, 1) position.

Island 3: Formed by two elements at (4, 2), (4, 3) positions.

Note:

In the above example, elements at positions (0, 2) and (1,2) do not form an island as there is no 'X' surronding it from the top.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= 'N', 'M' <= 1000

Time Limit: 1 sec
Sample Input 1:
5 4
X X O O
X O X X
X O O X
X O X X
X X X X
Sample Output 1:
X X O O
X X X X
X X X X
X X X X
X X X X
Explanation of Sample Output 1:
There is only one island in the above input. Considering zero based indexing, The co-ordinates of the island are (1, 1), (2, 1), (2, 2) and (3, 1). We just need to replace the O's at this co-ordinates with X's. Hence the output.
Sample Input 2:
3 4
X X O X
X O X X
X X O O
Sample Output 2:
X X O X
X X X X
X X O O
*/


public class Solution{

    public static void replaceOWithX(char matrix[][]) {
        // write your code here
        int drow[] = {-1, 0 , +1, 0};
        int dcol[] = {0, +1, 0, -1};
        int n = matrix.length;
        int m = matrix[0].length;
        int visited[][] = new int[n][m];
        
        for(int j=0;j<m;j++){
            if(visited[0][j] == 0 && matrix[0][j] == 'O'){
                dfs(0 , j, visited, drow, dcol, matrix);
            }

            if(visited[n-1][j] == 0 && matrix[n-1][j] == 'O'){
                dfs(n-1, j, visited, drow, dcol, matrix);
            }
        }
    
        for(int j=0;j<n;j++){
            if(visited[j][0] == 0 && matrix[j][0] == 'O'){
                dfs(j , 0, visited, drow, dcol, matrix);
            }

            if(visited[j][m-1] == 0 && matrix[j][m-1] == 'O'){
                dfs(j, m-1, visited, drow, dcol, matrix);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] != 1 && matrix[i][j] == 'O'){
                    matrix[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(int x, int y, int[][] visited, int[] drow, int[] dcol, char[][] matrix){
        visited[x][y] = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<4;i++){
            int nrow = x+drow[i];
            int ncol = y+dcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && matrix[nrow][ncol] == 'O'){
                dfs(nrow, ncol, visited, drow, dcol, matrix);
            }
        }
    }
}
