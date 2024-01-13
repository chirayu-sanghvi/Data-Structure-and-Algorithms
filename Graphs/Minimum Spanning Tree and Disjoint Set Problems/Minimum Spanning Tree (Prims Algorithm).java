/*
Coding Ninja: https://www.codingninjas.com/studio/problems/minimum-spanning-tree_631769

Problem statement
You are given an undirected, connected and weighted graph G(V, E), consisting of V number of vertices (numbered from 0 to V-1) and E number of edges.

Find and print the total weight of the Minimum Spanning Tree (MST) using Kruskal's algorithm.

By definition, a minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V <= 10^5
1 <= E <= 3 * 10^5
0 <= X < N
0 <= Y < N
1 <= W <= 10^4

where V and E represent the number of vertices and edges respectively.
X and Y represent the vertices between which there is an edge.
W is the weight of the edge.

Time limit: 1sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
9
Explanation for Sample Input 1:
The edge (2,3) having weight 8 will be excluded from the MST. The total weight of the MST then will be 1 + 3 + 5 = 9.
Sample Input 2:
4 4
1 2 6
2 3 2
1 3 2
1 0 2
Sample Output 2:
6
*/
import java.util.*;

class pair{
	int dest;
	int weight;
	pair(int dest, int weight){
		this.dest = dest;
		this.weight = weight;
	}
}
public class Solution {
	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		//Your code goes here
		ArrayList<ArrayList<pair>> adj = new ArrayList<>();
		for(int i=0;i<n;i++){
			adj.add(new ArrayList<pair>());
		}
		int m = edges.size();
		for(int i=0;i<m;i++){
			adj.get(edges.get(i).get(0)).add(new pair(edges.get(i).get(1),edges.get(i).get(2)));
			adj.get(edges.get(i).get(1)).add(new pair(edges.get(i).get(0),edges.get(i).get(2)));
		}
		int visited[] = new int[n];
		PriorityQueue<pair> q = new PriorityQueue<>((a,b)->(a.weight - b.weight));
		int result = 0;
		q.add(new pair(0,0));
		int minSpan[] = new int[n];
		minSpan[0] = 0;
		while(!q.isEmpty()){
			pair p = q.peek();
			int v = p.dest;
			int w = p.weight;
			q.remove();
			if(visited[v] == 1){
				continue;
			}
			visited[v] = 1;
			result = result + w;
			for(pair iter : adj.get(v)){
				int destination = iter.dest;
				int wt = iter.weight;
				q.add(new pair(destination,wt));
			}
		}
	return result;
	}
}
