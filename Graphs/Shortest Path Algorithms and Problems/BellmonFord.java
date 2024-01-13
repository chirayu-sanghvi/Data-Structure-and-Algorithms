/*
Coding Ninja: https://www.codingninjas.com/studio/problems/bellman-ford_2041977

Problem statement
You have been given a directed weighted graph of ‘N’ vertices labeled from 1 to 'N' and ‘M’ edges. Each edge connecting two nodes 'u' and 'v' has a weight 'w' denoting the distance between them.
Your task is to calculate the shortest distance of all vertices from the source vertex 'src'.
Note:
If there is no path between 'src' and 'ith' vertex, the value at 'ith' index in the answer array will be 10^8.
Example :

3 3 1
1 2 2
1 3 2
2 3 -1

In the above graph: 

The length of the shortest path between vertex 1 and vertex 1 is 1->1 and the cost is 0.
The length of the shortest path between vertex 1 and vertex 2 is 1->2 and the cost is 2.
The length of the shortest path between vertex 1 and vertex 3 is 1->2->3 and the cost is 1.
Hence we return [0, 2, 1].
Note :

It's guaranteed that the graph doesn't contain self-loops and multiple edges. Also, the graph does not contain negative weight cycles.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 4 1
1 2 4
1 3 3
2 4 7 
3 4 -2
Sample Output 1 :
0 4 3 1
Explanation For Sample Output 1 :

In the above graph: 
The length of the shortest path between vertex 1 and vertex 1 is 1->1 and the cost is 0.
The length of the shortest path between vertex 1 and vertex 2 is 1->2 and the cost is 4.
The length of the shortest path between vertex 1 and vertex 3 is 1->3 and the cost is 3.
The length of the shortest path between vertex 1 and vertex 4 is 1->3->4 and the cost is 1.
Hence we return [0, 4, 3, 1].
Sample Input 2 :
2 1 1
2 1 3
Sample Output 2 :
0 1000000000
Constraints :
1 <= N <= 50
1 <= M <= 300
1 <= src <= N
1 <= u,v <= N
-10^5 <= w <= 10^5

Time Limit: 1 sec
*/
import java.util.List;
import java.util.Arrays;
public class Solution {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        int [] d=new int[n + 1];
        Arrays.fill(d,100000000);
        d[src] = 0;
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                int u = edges.get(j).get(0);
                int v =  edges.get(j).get(1);
                int w =  edges.get(j).get(2);
                if (d[u] != 1000000000 && d[v] > (d[u] + w)) {
                    d[v] = d[u] + w;
                }
            }
        }
        return d;
    }
}
