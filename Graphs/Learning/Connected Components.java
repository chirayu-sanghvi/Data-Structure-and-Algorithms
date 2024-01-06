/*
Coding Ninja: https://www.codingninjas.com/studio/problems/find-the-number-of-states_1377943
Leet Code: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/

Problem statement
You are given ‘n’ cities, some of which are connected by bidirectional roads. You are also given an ‘n x n’ matrix i.e. ‘roads’, where if city ‘i’ and ‘j’ are connected by a road then ‘roads[i][j]'= 1, otherwise ‘roads[i][j]' = 0.



A province is a group of cities that are either directly or indirectly connected to each other through roads.



The goal is to count and return the total number of such provinces in the given matrix.



Example:
n = 4, roads = [ [1, 1, 1, 0],
                 [1, 1, 1, 0],
                 [1, 1, 1, 0],
                 [0, 0, 0, 1] ]

So, there are ‘2’ provinces.
Note:
1. A city is connected to itself. So, for every city ‘i’, ‘roads[i][i] = 1’.
Detailed explanation ( Input/output format, Notes, Images )
Sample input 1:
3
1 0 0 
0 1 0 
0 0 1 
Sample output 1:
3
Explanation of sample input 1:
Test Case 1:
n = 3, roads = [ [1, 0, 0],
                 [0, 1, 0],
                 [0, 0, 1] ]

So, there are ‘3’ provinces.
Sample input 2:
4
1 1 0 0 
1 1 0 0 
0 0 1 1 
0 0 1 1 
Sample output 2:
2
Explanation of sample input 2:
n = 4, roads = [ [1, 1, 0, 0],
                 [1, 1, 0, 0],
                 [0, 0, 1, 1],
                 [0, 0, 1, 1] ]

So, there are ‘2’ provinces.
Constraints:
1 <= 'n' <= 200
roads[i][j] is 1 or 0.
roads[i][j] == roads[j][i]

Time limit: 1 sec
*/

public class Solution {
    public static int findNumOfProvinces(int[][] roads, int n) {
        int cnt = 0;
        int vis[] = new int[n];
        for(int i = 0 ;i<n;i++)
        {
            if(vis[i]==0)
            {
                cnt++;
                dfs(i,vis,roads);
            }
        }
        return cnt;
    }

    public static void dfs(int node, int[] visited, int[][] arr){
        for(int j=0;j<arr.length;j++){
            if(arr[node][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(j, visited, arr);
            }
        }
    }

}
