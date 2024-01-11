/*
Coding Ninja: https://www.codingninjas.com/studio/problems/maximum-meetings_1062658
Leet Code: https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

Problem statement
You are given the schedule of 'N' meetings with their start time 'Start[i]' and end time 'End[i]'.
You have only 1 meeting room. So, you need to return the maximum number of meetings you can organize.
Note:
The start time of one chosen meeting can’t be equal to the end time of the other chosen meeting.

For example:
'N' = 3, Start = [1, 3, 6], End = [4, 8, 7].

You can organize a maximum of 2 meetings. Meeting number 1 from 1 to 4, Meeting number 3 from 6 to 7.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
6
1 3 0 5 8 5
2 4 6 7 9 9
Sample Output 1:
4
Explanation For Sample Input 1:
You can organize a maximum of 4 meetings: 

Meeting number 1 from 1 to 2.
Meeting number 2 from 3 to 4.
Meeting number 4 from 5 to 7.
Meeting number 5 from 8 to 9.
Sample Input 2:
5
0 7 1 4 8
2 9 5 9 10
Sample Output 2:
2 
Constraints:
1 <= 'N' <= 10^5
0 <= 'Start[i]' < 'End[i]' <= 10^9

Time Limit: 1 sec
*/
import java.util.*;
public class Solution {
    public static int maximumMeetings(int []start, int []end) {
        // Write your code here.
        int[][] map =new int[start.length][2];
        for(int i=0;i<start.length;i++){
            map[i][0] =start[i];
            map[i][1] =end[i];
        }
        Arrays.sort(map,(a,b)->(a[1]-b[1]));
        int cnt=1;
        int e=map[0][1];
        for(int i=1;i<start.length;i++){
            if(map[i][0]>e){
                cnt++;
                e=map[i][1];
            }
        }
        return cnt;
    }
}
