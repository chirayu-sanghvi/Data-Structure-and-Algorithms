/*
Coding Ninja: https://www.codingninjas.com/studio/problems/detect-cycle-in-an-undirected-graph-_758967


Problem statement
Given an undirected graph of 'V' vertices and 'E' edges. Return true if the graph contains a cycle or not, else return false.

Note:

There are no self-loops(an edge connecting the vertex to itself) in the given graph.
Example:
Given N=3, M =2, and edges are (1, 2) and (2, 3), with nodes 1, 2, and 3.

We return false because the given graph does not have any cycle.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= V <= 10^5
0 <= E <= 2 * 10^5
0 <= u,v < V

Time Limit: 1sec
Java (SE 1.8)
7172737475767778798081828384858687888990919293949596979899100
            {

                if(!vis[i])

                {

                    if(bfs(i,adj,vis,V))

                    return true;



*/

import java.util.*;

class pair{

int first;

int second;

public pair(int first,int second)

{

    this.first = first;

    this.second = second;

}

}

public class Solution {

    static class Graph {

        boolean bfs(int node,List<List<Integer>> adj,boolean vis[],int v)

        {

            Queue<pair> q = new LinkedList<>();

            vis[node] = true;

            q.add(new pair(node,-1));

            while(!q.isEmpty())

            {

                int n = q.peek().first;

                int p = q.peek().second;

                q.poll();

                for(int i:adj.get(n))

                {

                    if(!vis[i])

                    {

                        vis[i] = true;

                        q.add(new pair(i,n));

                    }

                    else if(p!=i)

                    return true;

 

                }

            }

            return false;

 

        }

        boolean detectCycle(int V, List<List<Integer>> adj) {

            boolean vis[] = new boolean[V];

            for(int i = 0;i<V;i++)

            {

                if(!vis[i])

                {

                    if(bfs(i,adj,vis,V))

                    return true;

                }

            }

            return false;

        }

    }

}
