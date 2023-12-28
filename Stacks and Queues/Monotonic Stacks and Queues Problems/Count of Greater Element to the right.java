/*
Coding Ninja: https://www.codingninjas.com/studio/problems/count-of-greater-elements-to-the-right_8365436?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
You are given an array 'arr' of length 'N'.
You are given 'Q' queries, and for each query, you are given an index(0-based indexing).
Answer to each query is the number of the strictly greater elements to the right of the given index element.
You must return an array 'answer' of length ’N’, where ‘answer[i]’ is the answer to the ‘ith’ query.

Example:
Input:
arr = [5, 2, 10, 4], N=4, Q=2, query = [0, 1]
Output:
1 2

Explanation: The element at index 0 is 5 for the first query. There is only one element greater than 5 towards the right, i.e., 10.
For the second query, the element at index 1 is 2. There are two elements greater than 2 towards the right, i.e., 10 and 4. 

Hence we return [1, 2]
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
8 3
1 3 6 5 8 9 13 4
0 1 5
Sample Output 1:
7 6 1
Explanation Of Sample Input 1:
For test case one:
Input:
arr = [1, 3, 6, 5, 8, 9, 13, 4], N=8, Q=3, query = [0, 1, 5]
Output:
7 6 1

Explanation: The element at index 0 is 1 for the first query. There are seven elements greater than 1 towards the right, i.e., 3, 6, 5, 8, 9, 13, and 4.
For the second query, the element at index 1 is 3. There are six elements greater than 3 towards the right, i.e., 6, 5, 8, 9, 13, and 4. 
For the third query, the element at index 5 is 9. There is only one element greater than 9 towards the right, i.e., 13. 

Hence we return [7, 6, 1].
Sample Input 2:
4 4
1 2 3 4
0 1 2 3
Sample Output 2:
3 2 1 0
Constraints:
1 <= N <= 10^4
1 <= Q <= 100
1 <= arr[i] <= 10^5.
0 <= query[i] <= ‘N’-1
Time Limit: 1 sec
*/

import java.util.*;
public class Solution {
    public static int[] countGreater(int []arr, int []query) {
        // Write your code here.
        int n = arr.length;
        int q = query.length;
        int res[] = new int[q];
        int counter = 0;
        for(int i: query){
            Stack<Integer> st = new Stack<>();
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    st.push(arr[j]);
                }
            }
            res[counter] = st.size();
            counter++;
        } 
        return res;
    }
}
