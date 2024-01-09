/*
Coding Ninja: https://www.codingninjas.com/studio/problems/detect-cycle-in-a-directed-graph_1062626

Problem statement
You are given a directed graph having ‘N’ nodes. A matrix ‘EDGES’ of size M x 2 is given which represents the ‘M’ edges such that there is an edge directed from node EDGES[i][0] to node EDGES[i][1].

Find whether the graph contains a cycle or not, return true if a cycle is present in the given directed graph else return false.

For Example :
In the following directed graph has a cycle i.e. B->C->E->D->B.

Note :
1. The cycle must contain at least two nodes.
2. It is guaranteed that the given graph has no self-loops in the graph.
3. The graph may or may not be connected.
4. Nodes are numbered from 1 to N.
5. Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 ≤ T ≤ 5

2 <= N <= 100
1 <= M <= min(100,N(N-1)/2)
1 <= EDGES[i][0], EDGES[i][1] <= N

Where ‘T’ is the number of test cases.

Time Limit: 1 sec
Sample Input 1 :
1
5
6
1 2
4 1
2 4
3 4
5 2
1 3
Sample Output 1 :
true
Explanation For Input 1 :
The given graph contains cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1.
Sample Input 2 :
2
5
4
1 2
2 3
3 4
4 5
2
1
1 2
Sample Output 2 :
false
false
Explanation For Input 2 :
The given graphs don’t contain any cycle.



==================== Solution Idea =========================
Our intuition is to go through each and every node in the given graph and try to detect where we can find a back edge and track the node which we have already visited so that we can find out where the cycle is present in the given directed graph.

 

We can use DFS (Depth First Search) Approach. 

To detect cycles, check for a cycle in individual trees by checking back edges and keep track of vertices currently in the recursion stack of the function for DFS traversal.
If a vertex is reached that is already in the recursion stack, then there is a cycle in the tree.
The edge that connects the current vertex to the vertex in the recursion stack of the given directed graph is a back edge.
 

We will create a recursion function which marks the nodes as visited and keeps a track of whether a cycle is present or not in the given graph by detecting the previously visited nodes.

 

Steps are as follows:

 

We need to create a recursive function that uses the current node, visited, and recursion stack.
Firstly mark the current node as visited and also mark the current node into the recursion stack.
Now track all the nodes which are not visited and are adjacent to the current node.
Then recursively call the function for those nodes, If the recursive function returns true then return true.
And if the adjacent nodes are already visited in the recursion stack then return true.
For the whole approach, create a wrapper function that calls the recursive function for all the vertices, and if any instance function returns true then return true as the answer.
Else, if for all vertices the function returns false then return false as the answer.
Time Complexity
O(N + M), where ‘N’ is the number of nodes and ‘M’ is the number of edges.

 

The Time Complexity of this method is the same as the time complexity of the Depth First Search traversal, so the overall time complexity will be O(N + M).

Space Complexity
O(N), where ‘N’ is the number of nodes in the given graph.

 

To store the visited and recursion stack O(N) space is needed, so the overall space complexity will be O(N).

*/

/*
    Time Complexity: O(N+M)
    Space Complexity: O(N)

    Where N is the number of nodes and M is the number of edges in the given graph.
*/

import java.util.ArrayList;

class Graph {
    private static int noOfNodes;

    // Pointer to an array containing adjacency lists.
    private static ArrayList < Integer > adj[];

    // Act as Constructor.
    Graph(int noOfNodes) {
        adj = new ArrayList[noOfNodes];

        for (int i = 0; i < noOfNodes; i++) {
            adj[i] = new ArrayList < Integer > ();
        }

        this.noOfNodes = noOfNodes;
    }

    // To add an edge to between two nodes in a Graph.
    public void addEdge(int a, int b) {
        // Add b to a's list.
        adj[a].add(b);
    }

    // Returns true if there exists a cycle in the given graph.
    public boolean checkCyclic() {

        /* 
            Initialise checkVisited as false 
            i.e. nodes are not visited yet.
        */
        ArrayList < Boolean > checkVisited = new ArrayList < Boolean > (noOfNodes);

        // Initialise nodes as not a part of recursion stack.
        ArrayList < Boolean > rStack = new ArrayList < Boolean > (noOfNodes);

        for (int i = 0; i < noOfNodes; i++) {
            checkVisited.add(false);
            rStack.add(false);
        }

        /*
            Call the recursive helper function to
            detect cycle in different DFS trees.
        */

        for (int i = 0; i < noOfNodes; i++) {
            if (checkCyclicHelper(i, checkVisited, rStack)) {
                return true;
            }
        }
        return false;
    }

    // Helper function for checkCyclic().
    private boolean checkCyclicHelper(int v, ArrayList < Boolean > checkVisited, ArrayList < Boolean > rStack) {

        if (checkVisited.get(v) == false) {

            /* 
                Make the current node as visited 
                and part of recursion stack.
            */
            checkVisited.set(v, true);
            rStack.set(v, true);

            for (int i = 0; i < adj[v].size(); ++i) {
                if (!checkVisited.get(adj[v].get(i)) && checkCyclicHelper(adj[v].get(i), checkVisited, rStack)) {
                    return true;
                } else if (rStack.get(adj[v].get(i))) {
                    return true;
                }
            }

            // Remove the vertex from recursion stack.
            rStack.set(v, false);
        }

        return false;
    }
}

public class Solution {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
        Graph directedG = new Graph(n);

        int m = edges.size();

        for (int i = 0; i < m; i++) {
            directedG.addEdge(edges.get(i).get(0) - 1, edges.get(i).get(1) - 1);
        }

        return directedG.checkCyclic();
    }
}

