/*
Coding Ninja: https://www.codingninjas.com/studio/problems/dijkstra's-shortest-path_985358
  
Problem statement
You have been given an undirected, connected graph of ‘V’ vertices (labelled from 0 to V-1) and ‘E’ edges. Each edge connecting two nodes 'u' and 'v' has a weight denoting the distance between them.
Your task is to find the shortest path distance from the source node 'S' to all the vertices. You have to return a list of integers denoting the shortest distance between each vertex and source vertex 'S'.

Note:
1. There are no self-loops(an edge connecting the vertex to itself) in the given graph.
2. There are no parallel edges i.e no two vertices are directly connected by more than 1 edge.

For Example:

Input:
4 5
0 1 5
0 2 8
1 2 9
1 3 2
2 3 6

The source node is node 0.

The shortest distance from node 0 to node 0 is 0.
The shortest distance from node 0 to node 1 is 5. In the above figure, the green path represents this distance. The path goes from node 0->1, giving distance = 5.
The shortest distance from node 0 to node 2 is 8. In the above figure, the pink path represents this distance. The path goes from node 0->2, giving distance = 8.
The shortest distance from node 0 to node 3 is 7. In the above figure, the yellow path represents this distance. The path goes from node 0->1->3, giving distance = 7.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1
5 7 0
0 1 7
0 2 1
0 3 2
1 2 3
1 3 5 
1 4 1
3 4 7
Sample Output 1
0 4 1 2 5
Explanation of sample input 1
The source node is node 0.
The shortest distance from node 0 to node 0 is 0.
The shortest distance from node 0 to node 1 is 4. In the above figure, the green path represents this distance. The path goes from node 0->2->1, giving distance = 1+3 = 4.
The shortest distance from node 0 to node 2 is 1. In the above figure, the red path represents this distance. The path goes from node 0->2, giving distance = 1
The shortest distance from node 0 to node 3 is 2. In the above figure, the pink path represents this distance. The path goes from node 0->3, giving distance = 2.
The shortest distance from node 0 to node 4 is 5. In the above figure, the yellow path represents this distance. The path goes from node 0->2->1->4, giving distance = 1+3+1 = 5.
Sample Input 2:
3 3 2
1 0 9
2 1 8
0 2 4
Sample Output 2:
4 8 0 
Constraints:
1 <= 'V' <= 10^5
1 <= 'E' <= 10^5
1 <= distance between vertices <= 10^5

Time limit: 1 second
*/
import java.util.*;
class Pair{
  int v,wt;
  Pair(int v,int wt){
    this.v=v;
    this.wt=wt;
  }
}
public class Solution {
    public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
        // Write your code here.
       List<List<Pair>> l=new ArrayList<>();
       Queue<Pair> pq=new PriorityQueue<>((x,y)->x.wt-y.wt);
       pq.add(new Pair(source,0));
       for(int i=0;i<vertices;i++){
       List<Pair> tem=new ArrayList<>();
           l.add(tem);
       }
       for(int i=0;i<edge.length;i++){
         int a=edge[i][0];
         int b=edge[i][1],c=edge[i][2];
         l.get(a).add(new Pair(b,c));
         l.get(b).add(new Pair(a,c));
       }
       int dis[]=new int[vertices];
       Arrays.fill(dis,Integer.MAX_VALUE);
       dis[source]=0;
       while(!pq.isEmpty()){
        Pair p=pq.poll();
        for(Pair curr:l.get(p.v)){
         if(p.wt+curr.wt<dis[curr.v]){
          dis[curr.v]=p.wt+curr.wt;
          pq.add(new Pair(curr.v,dis[curr.v]));
             
           }
         }
       }
       List<Integer> ans=new ArrayList<>();
       for(int i:dis) ans.add(i);
       return ans;
    }
}
