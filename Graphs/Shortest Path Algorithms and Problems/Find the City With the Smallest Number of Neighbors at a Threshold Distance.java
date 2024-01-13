/*
Coding Ninja: https://www.codingninjas.com/studio/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance_1264289
Leet Code: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/

Problem statement
You are given ‘N’ cities numbered from 0 to N-1 and ‘M’ edges. These cities are connected with undirected weighted edges. You are also given a positive integer, ‘distanceThreshold’.

Your task is to find the ‘city’ to which the minimum number of cities are reachable through some path whose distance is no more than the given ‘distanceThreshold’.

Note:

1. If multiple such cities exist, you have to find the city with the greatest number.

2. The distance of a path connecting two cities, ‘U’ and ‘V’, is the sum of the weight of the edges along that path.

3. The distance between two cities is the minimum of all possible path distances.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
2 <= N <= 100
1 <= M <= (N * (N - 1)) / 2
0 <= U, V < N
1 <= W, distanceThreshold <= 100 

Where ‘T’ denotes the number of test cases, ‘N’ represents the number of cities, and ‘M’ denotes the number of edges.
‘U’, ‘V’, and ‘W’ denote the edge between city ‘U’ and ‘W’ having weight ‘W’.

Time limit: 1 sec.
Sample Input 1:
1
5 5 3
0 1 1
1 2 1
2 3 3
3 4 1
0 3 3
Sample Output 1:
4

Explanation for sample input 1:
The cities reachable to each city at a ‘distanceThreshold’ = 3 are as follows:
City 0 -> {City 1, City 2, City 3}
City 1 -> {City 0, City 2}
City 2 -> {City 0, City 1, CIty 3}
City 3 -> {City 0, City 2, City 3}
City 4 -> {City 3}
The city with the smallest number of neighbors at a ‘distanceThreshold’ = 3 is city 4 which has only 1 neighboring city.
Sample Input 2:
1
3 3 4
0 1 2
1 2 2
2 0 1
Sample Output 2:
2

Explanation for sample input 2:
The cities reachable to each city at a ‘distanceThreshold’ = 4 are as follows:
City 0 -> {City 1, City 2}
City 1 -> {City 0, City 2}
City 2 -> {City 0, City 1}
All three cities have 3 neighboring cities, So the answer must be the city with the greatest number that is city 2.
*/
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int findTheCity(int n, ArrayList<ArrayList<Integer>> edges, int distanceThreshold) {
		// Write your code here
        int dis[][]=new int[n][n];
        for(int[] a:dis) Arrays.fill(a,(int)(1e9));
        for(int i=0;i<edges.size();i++){
          int u=edges.get(i).get(0), v=edges.get(i).get(1),w=edges.get(i).get(2);
          dis[u][v]=w;
          dis[v][u]=w;
          dis[u][u]=0;
          dis[v][v]=0;
        }
        for(int k=0;k<n;k++){
          for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
              if(dis[i][k]!=(int)(1e9) && dis[k][j]!=(int)(1e9)){
                dis[i][j]=Math.min(dis[i][j], dis[i][k]+dis[k][j]);
              }
            }
          }
        }
        int cityCount=n,city=-1;
        for(int i=0;i<n;i++){
          int currentCount=0;
          for(int j=0;j<n;j++){
            if(dis[i][j]<=distanceThreshold) currentCount++;
          }
          if(currentCount<=cityCount){
            cityCount=currentCount;
            city=i;
          }
        }
        return city;
	}
}
