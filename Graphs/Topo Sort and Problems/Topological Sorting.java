/*
Coding Ninja: https://www.codingninjas.com/studio/problems/topological-sorting_973003

Problem statement
Given a DAG(direct acyclic graph), print Topological Sorting of a given graph

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= V <= 1000
0 <= E <= 3000
0 <= U, V <= V-1

Time Limit: 1sec
Sample Input 1:
1
5 4
0 2
1 2
3 1
0 4
Sample Output 1:
Correct
Sample Output 1 Explanation:
One correct sort order is : 3 1 0 4 2.

===================== Solution Idea ======================
Use dfs with stack and visited array to keep track of the ordering of node in such a way
that if an edge is (u -> v) then node u should appear before node v which means that 
node v should be added in the stack first and then node u, because when we pop out elements from 
the staack node u will always comes first as stack follows LIFO ordering.
*/

import java.util.*;
public class Solution {

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Write your code here!
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i< e;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        int visited[] = new int[v];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<v;i++){
            if(visited[i] == 0){
                dfs(i, visited, st, adj);
            }
        }
        List<Integer> arr = new ArrayList<>();

        while(!st.isEmpty()){
            arr.add(st.pop());
        }
        return arr;

    }

    public static void dfs(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        for(Integer i: adj.get(node)){
            if(visited[i] == 0){
                dfs(i, visited, st, adj);
            }
        }
        st.push(node);
    }

}
