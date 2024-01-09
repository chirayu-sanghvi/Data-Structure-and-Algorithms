/*
Coding Ninja: https://www.codingninjas.com/studio/problems/course-schedule-ii_1069243
Leet Code: https://leetcode.com/problems/course-schedule-ii/description/

Problem statement
You have been given ‘N’ courses and some courses may have prerequisites. Now consider a matrix ‘PREREQUISITES’ of size 'M' x 2 which represents that you must complete the course 'PREREQUISITES[i][1]' before the course 'PREREQUISITES[i][0]'.



Your task is to return the order of courses you should take to finish all courses.



Note:
If it is impossible to finish all courses, return an empty array. If there are multiple answers, return any one.


For example:
Input:
3 2
1 2
2 3

There are three courses to take. To start with, First course 3 is taken. Then course 2 is taken for which course 3 must be completed. 

At last course 1 is taken for which course 2 must be completed. So the correct course order is [3,2,1].    
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4 4
2 1
3 1
4 2
4 3
Sample Output 1:
1
Explanation of Sample Output 1:
There are a total of 4 courses to take. To take course 4 you should have finished both courses 2 and 3. 

Both courses 2 and 3 should be taken after you finish course 1. So one correct course order is [1,2,3,4]. Another correct ordering is [1,3,2,4]. 

When the ordering is one of the above two sets then output is 1.
Sample Input 2:
2 1
2 1
Sample Output 2:
1
Constraints :
2 <= 'N' <= 10^5
0 <= 'M' <= 10^5

Where ‘PREREQUISITES’ denotes the prerequisites matrix.

Time limit: 1 sec

===================== Solution Idea ========================
find the indegree of each node
Create an empty queue
if indegree of the particular node is zero add it in the queue 
and iterate accordingly by eliminating the nodes whose indegree is zero
Update the indegree of oter nodes as well after deletion of the parent node.
*/

import java.util.*;
public class Solution {
    public static List<Integer> findSchedule(int numCourses, List<List<Integer>> prerequisites) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<= numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        int n = prerequisites.size();
        for(int i=0;i<n;i++){
            int u = prerequisites.get(i).get(1);
            int v = prerequisites.get(i).get(0);
            adj.get(u).add(v);
        }

        int indegree[] = new int[numCourses+1];
        for(int i=1;i< numCourses;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i= 1;i<=numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        
        int ind = 1;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            result.add(node);
            ind++;
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        if(ind == numCourses){
            return result;
        }
        List<Integer> empty = new ArrayList<>();
        return empty;
    
    }
}
