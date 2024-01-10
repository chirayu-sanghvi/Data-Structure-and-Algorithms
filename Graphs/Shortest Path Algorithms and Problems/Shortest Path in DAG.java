/*
Coding Ninja: https://www.codingninjas.com/studio/problems/shortest-path-in-dag_8381897

Problem statement
You are given a directed acyclic graph of 'N' vertices(0 to 'N' - 1) and 'M' weighted edges.
Return an array that stores the distance(sum of weights) of the shortest path from vertex 0 to all vertices, and if it is impossible to reach any vertex, then assign -1 as distance.
For Example:
'N' = 3, 'M' = 3, 'edges' = [0, 1, 2], [1, 2, 3], [0, 2, 6]].

Distance (0 to 0) = 0.
Distance (0 to 1) = 2.
Distance (0 to 2) = 0->1 + 1->2 = 2+3 = 5.
So our answer is [0, 2, 5].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3 3
2 0 4
0 1 3
2 1 2
Sample Output 1:
0 3 -1
Explanation of sample output 1:

Distance (0 to 0) = 0.
Distance (0 to 1) = 3.
Distance (0 to 2) = We cannot reach vertex 2 from 0.
So our answer is [0, 3, -1].
Sample Input 2:
4 4
2 1 5
0 2 3
0 1 2
2 3 1
Sample Output 2:
0 2 3 4
Constraints:
1 <= 'N', 'M' <= 10^5
1 <= edge weight <= 10^5
Time Limit: 1 sec
===================================== Solution Idea ================================
Use topological sort and stack to find the order of the nodes and then iterate through them accordingly and updating distance array on each iteration with minimum distance for each node
*/

import java.util.*;
class pair{
    int y;
    int w;
    pair(int y,int w){
        this.y = y;
        this.w = w;
    }
}
public class Solution {
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        // Write your code here
        int result[] = new int[n];
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<pair>());
        }
        
        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new pair(v,wt));
        }

        int visited[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                topo(i, adj, visited, st);
            }
        }

        int distance[] = new int[n];
        for(int i=0;i<n;i++){
            distance[i] = (int)(1e9);
        }

        distance[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int dest = adj.get(node).get(i).y;
                int weight = adj.get(node).get(i).w;
                if(distance[node] + weight < distance[dest]){
                    distance[dest] = distance[node] + weight;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(distance[i] == (int)(1e9)){
                distance[i] = -1;
            }
        }
        return distance;
    }

    public static void topo(int node, ArrayList<ArrayList<pair>> adj, int[] visited, Stack<Integer> st){
        visited[node] = 1;
        for(int i=0;i<adj.get(node).size();i++){
            int dest = adj.get(node).get(i).y;
            if(visited[dest] != 1){
                topo(dest, adj, visited, st);
            }
        }
        st.push(node);
    } 
}
