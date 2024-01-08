/*
Coding Ninja: https://www.codingninjas.com/studio/problems/detect-cycle-in-a-directed-graph-_920545
Leet Code: https://leetcode.com/problems/course-schedule-ii/solutions/293048/detecting-cycle-in-directed-graph-problem/

Problem statement
Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the given graph contains at least one cycle, else return false.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= V <= 10^3
0 <= E <= 10^3
0 <= A, B < V

Time Limit: 1 sec
Sample Input 1:.
2
4 4
0 1
1 2
2 3
3 0
3 3
1 0
1 2
0 2
Sample Output 1:
true
false
Explanation for Sample Input 1:
In the first case,
From node 0 we can reach 0 again by following this sequence of nodes in the path: 0,1,2,3,0. As we can see in the image below.

In the second case,
There is no cycle in the given graph. As we can see in the image below.

Sample Input 2:
2
3 2
0 1
0 2
3 3
1 1
0 2
1 2
Sample Output 2:
false
true
*/
import java.util.ArrayList;

public class Solution 
{
    public static Boolean isCyclic(int[][] edges, int v, int e) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        int visited[] = new int[v];
        int pathVisited[] = new int[v];
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int x =edges[i][0];
            int y = edges[i][1];
            adj.get(x).add(y);
        }

        for(int i=0;i<v;i++){
            if(visited[i] == 0){
                if(dfsCycleCheck(i, adj, visited, pathVisited)== true){
                    return true;
                }
            }
        }
        return false;
	}

    public static boolean dfsCycleCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited){
        visited[node] = 1;
        pathVisited[node] = 1;

        for(Integer it: adj.get(node)){
            if(visited[it] == 0){
                if(dfsCycleCheck(it, adj, visited, pathVisited)== true){
                    return true;
                }
            }
            else if(pathVisited[it] == 1){
                return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }
}
