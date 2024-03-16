/*
Solution Idea: 
1) Sort the array based on their starting timing
2) Compare the starting time of the second interval start time with the fist interval ending time.
3) After comparing update the value of mininmum and maximum accordingly.
4) If at any time you find that the above comparision is resulting false then add those min and max value in the result arraylist.
5) Update the value of the min and max with the new interval start and end time and continue the loop.

Coding Ninja: https://www.codingninjas.com/studio/problems/merge-all-overlapping-intervals_6783452
Leet Code: https://leetcode.com/problems/merge-intervals/
Problem statement
Ninja is playing with intervals. He has an array of intervals called ‘Arr’ having ‘N’ intervals.



However, he doesn’t like overlapping intervals. So you must help Ninja by merging all the overlapping intervals in ‘Arr’ and return an array of non-overlapping intervals.



Note:
Two intervals [L1, R1] and [L2, R2] such that L1 <= L2, are said to be overlapping if and only if L2 <= R1.
For example:
For ‘N’ = 4, and 
‘Arr’ = {{1, 3}, {2, 4}, {3, 5}, {6, 7}}
We can see that {1, 3} and {2, 4} overlap, so if we merge them, we get {1, 4}.
Now ‘Arr’ becomes: {{1, 4}, {3, 5}, {6, 7}}
Still, we observe that {1, 4} and {3, 5} overlap, hence we merge them into {1, 5}.
Hence, ‘Arr’ becomes {{1, 5}, {6, 7}}.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
9
1 2
1 3
1 6
3 4
4 4
4 5
5 5
6 6
6 6
Sample Output 1 :
1 6
Explanation Of Sample Input 1:
Arr after each merge
{{1, 2}, {1, 3}, {1, 6}, {3, 4}, {4, 4}, {4, 5}, {5, 5}, {6, 6}, {6, 6}}
{{1, 3}, {1, 6}, {3, 4}, {4, 4}, {4, 5}, {5, 5}, {6, 6}, {6, 6}}
{{1, 6}, {3, 4}, {4, 4}, {4, 5}, {5, 5}, {6, 6}, {6, 6}}
{{1, 6}, {4, 4}, {4, 5}, {5, 5}, {6, 6}, {6, 6}}
{{1, 6}, {4, 5}, {5, 5}, {6, 6}, {6, 6}}
{{1, 6}, {5, 5}, {6, 6}, {6, 6}}
{{1, 6}, {6, 6}, {6, 6}}
{{1, 6}, {6, 6}}
{{1, 6}}
Sample Input 2:
7
2 2
2 3
2 5
3 6
4 4
4 5
6 6
Sample Output 2:
2 6
Constraints:
1 <= N <= 10^5
1 <= L <= R <= 10^9

Time Limit: 1 sec.
*/
import java.util.*;

class sortIncrease implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> list1, List<Integer> list2){
        int secondElement1 = list1.get(0);
        int secondElement2 = list2.get(0);
        return Integer.compare(secondElement1, secondElement2);
    }
}
public class Solution {
    public static List< List< Integer > > mergeOverlappingIntervals(int [][]arr){
        // Write your code here.
        List<List<Integer>> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
           temp.add(Arrays.asList(arr[i][0], arr[i][1]));
        }

        Collections.sort(temp, new sortIncrease());
        int min = temp.get(0).get(0);
        int max = temp.get(0).get(1);

        for(int i = 0;i<temp.size()-1;i++){
            if(max >= temp.get(i+1).get(0)){
                max = Math.max(max,temp.get(i+1).get(1));
                continue;
            }
            result.add(Arrays.asList(min,max));
            min = temp.get(i+1).get(0);
            max = temp.get(i+1).get(1);
            
        }
        result.add(Arrays.asList(min,max));
        return result;
    }
}
