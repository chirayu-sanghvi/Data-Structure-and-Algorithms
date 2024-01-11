/*
Coding Ninja: https://www.codingninjas.com/studio/problems/non-overlapping-intervals_3169341
Leet Code: https://leetcode.com/problems/non-overlapping-intervals/description/

Problem statement
Ninja is the steel factory owner, and there are 'N' workers working at that factory. Each worker has his own working time, and it is provided in the array 'intervals' where 'INTERVALS[i][0]' gives the start time of the 'i'th worker and 'INTERVALS[i][1]' gives the end time of the 'i'th worker.

Ninja does not want to allow more than one worker to work at the same time, so he needs your help to find the minimum number of workers he needs to reschedule their work time so as there are non-overlapping working times in any two workers.

Example:
Input: 'INTERVALS' = [[1, 2], [1, 3], [2, 3], [3, 4]]
Output: 1

After rescheduling the worker with the interval [1, 3] it is possible to get the non-overlapping working times.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= ‘T’ <= 10
1 <= 'N' <= 10^4
'INTERVALS[i].LENGTH' == 2
'INTERVALS[i][0]' < 'INTERVALS[i][1]'
'INTERVALS[i][j]' <= 10^9
Time Limit: 1sec
Sample Input 1 :
2
4
1 2
2 3
1 3
3 4
3
3 4
4 5
5 6
Sample Output 1 :
1
0
Explanation Of Sample Input 1 :
For the first test case, After rescheduling the worker with the interval [1, 3] it is possible to get the non-overlapping working times.

For the second test case, there are no overlapping time intervals. Hence we do not need to reschedule any worker's time.
Sample Input 2 :
2
5
2 3
4 5
6 7
2 4
3 6
4
4 6
4 7
3 5
3 5
Sample Output 2 :
2
3
Java (SE 1.8)
123456789101112131415161718192021
import java.util.*;
public class Solution {
	public static int minimumReschedules(int n, int[][] intervals) {
		// Write your code here.
		int result = 0;
		Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
		int start = intervals[0][0];
		int end= intervals[0][1];
		for(int i=1;i<n;i++){
			if(intervals[i][0]<end){
*/

import java.util.*;
public class Solution {
	public static int minimumReschedules(int n, int[][] intervals) {
		// Write your code here.
		int result = 0;
		Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
		int start = intervals[0][0];
		int end= intervals[0][1];
		for(int i=1;i<n;i++){
			if(intervals[i][0]<end){
				end= Math.min(end, intervals[i][1]);
				result++;
			}
			else{
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		return result;
	}
}
