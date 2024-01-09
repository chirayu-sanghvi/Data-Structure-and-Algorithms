/*
Coding Ninja: https://www.codingninjas.com/studio/problems/safe-nodes-in-the-graph_1376703

Problem statement
Ninja has been given a matrix/list 'EDGES' denoting 'E' edges of a directed graph having ‘N’ nodes. Ninja starts walking from some node (say ‘START’) in the graph along a directed edge of the graph. If Ninja reaches an end node (say ‘END’) (a node that has no outgoing directed edges), Ninja stops walking.

Now a starting node ‘START’ is a safe node only if Ninja must eventually walk to an end node ‘END’. More specifically, there must be a natural number ‘K’, so that Ninja must have stopped at an end node in less than ‘K’ steps for any choice of where to walk.

For Example: For the graph, as shown in the picture below, [2, 4] are the only safe nodes.


Ninja wants to know all the safe nodes in the graph in sorted order. Can you help Ninja to find out all the safe nodes?

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 100
1 <= N <= 10 ^ 4
1 <= E <= 10 ^ 4
0 <= EDGE[i][0] and EDGE[i][1] < N

Where ‘EDGE[i][0]’ and ‘EDGE[i][1]’ represents the directed edge.

Time Limit: 1 sec
Sample Input 1 :
2
3 2
1 2
2 0
2 0
Sample Output 1:
0 1 2
0 1
Explanation for Sample Output 1:
For the first test case:
[0, 1, 2] are the safe nodes. See the picture below for your reference:

For the second case:
[0, 1] are the safe nodes. Because there is no edge between nodes so each node is a starting and an ending node.
Sample Input 2 :
2
5 3
0 1
1 0
0 2
2 2
0 1
1 0
Sample Output 2 :
2 3 4
Explanation for Sample Output 1:
For the first test case:
[2, 3, 4] are the safe nodes. See the picture below for your reference:

For the second test case:
There are no safe nodes. So we return an empty array/list.

===================== Solution Idea =================
Used same concept I used in the course schedule II question done before.
*/

import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<Integer> safeNodes(int edges[][], int n, int e) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i< n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<e;i++){
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int indegree[] = new int[n];
        for(int i=0;i< n;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i= 0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            result.add(node);
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
