/*
Coding Ninja: https://www.codingninjas.com/studio/problems/merge-intervals_699917
Leet Code: https://leetcode.com/problems/merge-intervals/

Problem statement
You are given N number of intervals, where each interval contains two integers denoting the start time and the end time for the interval.

The task is to merge all the overlapping intervals and return the list of merged intervals sorted by increasing order of their start time.

Two intervals [A,B] and [C,D] are said to be overlapping with each other if there is at least one integer that is covered by both of them.

For example:

For the given 5 intervals - [1, 4], [3, 5], [6, 8], [10, 12], [8, 9].

Since intervals [1, 4] and [3, 5] overlap with each other, we will merge them into a single interval as [1, 5].

Similarly, [6, 8] and [8, 9] overlap, merge them into [6,9].

Interval [10, 12] does not overlap with any interval.

Final List after merging overlapping intervals: [1, 5], [6, 9], [10, 12].
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5 
0 <= START, FINISH <= 10^9

Time Limit: 1sec
Sample Input 1:
2
1 3
3 5
Sample Output 1:
1 5  
Explanation for Sample Input 1
Since these two intervals overlap at point 3 so we merge them and the new interval becomes (1,5).
Sample Input 2:
5
1 3 6 8 10
4 5 8 9 12
Sample Output 2:
1 5
6 9
10 12
Java (SE 1.8)
161718192021222324252627282930313233343536373812131415
/*******************************************************
Following is the Interval class structure

    class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
…    }
}

*/
/*******************************************************
Following is the Interval class structure

    class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
*******************************************************/

import java.util.*;
class NestedArrayListComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval list1, Interval list2){
        return Integer.compare(list1.start, list2.start);
    }
}
public class Solution {

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new NestedArrayListComparator());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(i.end, end);
            } else {
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        } 
        result.add(new Interval(start, end));
        return result;
    }
}
