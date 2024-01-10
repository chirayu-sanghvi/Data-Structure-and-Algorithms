/*
Coding Ninja: https://www.codingninjas.com/studio/problems/single-source-shortest-path_8416371
Problem statement
You are given an undirected graph with 'N' nodes and 'M' edges. The weight of each edge in the graph is one unit.



Given a source vertex 'src', you must return an array 'answer' of length 'N', where 'answer[i]' is the shortest path length between the source vertex 'src' and 'i'th vertex.



Note:
All the nodes are zero-based.
Example:
Input:
N=5, M=5, edges=[(0, 1), (1, 4), (2, 3), (2, 4), (3, 4)], src=1 
Output: 1 0 2 2 1

Explanation: The path from vertices are:-
(1->0) = 1 -> 0, path length is 1.
(1->1) = 1 -> 1, path length is 0.
(1->2) = 1 -> 4 -> 2, the path length is 2.
(1->3) = 1 -> 4 -> 3, path length is 2.
(1->4) = 1 -> 4, the path length is 1.
Hence we return [1, 0, 2, 2, 1]
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4 3
0 1
0 3
2 3
0
Sample Output 1:
0 1 2 1
Explanation Of Sample Input 1:
For test case one:
Input:
N=4, M=3, edges=[(0, 1), (0, 3), (2, 3)], src=0 
Output: 0 1 2 1

Explanation: The path from vertices are:-
(0->0) = 0 -> 0, path length is 0.
(0->1) = 0 -> 1, path length is 1.
(0->2) = 0 -> 3 -> 2, path length is 2.
(0->3) = 0 -> 2, path length is 1.
Hence we return [0, 1, 2, 1]
Sample Input 2:
3 3
0 1
1 2 
0 2
2
Sample Output 2:
1 1 0
Constraints:
1 <= N, M <= 10^2
0 <= src, edges[0], edges[0] <= N-1
Time Limit: 1 sec

====================== Solution Idea ========================
Run BFS, use queue and iterate accordingly and make sure you maintain visited array
*/

import java.util.ArrayList;
import java.util.Queue;
import java.util.*;
public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        int result[] = new int[n];
        result[src] = 0;
        q.add(src);
        int count = 1;
        int visited[] = new int[n];
        visited[src] = 1;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(Integer i: adj.get(node)){
                if(visited[i] == 0){
                    visited[i] = 1;
                    result[i] = result[node]+1;
                    q.add(i);
                }
            }
            count ++;
        }

        for(int i =0;i<n;i++){
            if(visited[i] != 1){
                result[i] = -1;
            }
        }
        return result;
    }
}
