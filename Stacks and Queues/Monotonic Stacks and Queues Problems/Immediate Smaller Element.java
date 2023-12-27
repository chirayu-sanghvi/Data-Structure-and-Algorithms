/*
Coding Ninja: https://www.codingninjas.com/studio/problems/immediate-smaller-element-_1062597?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
You are given an integer array 'a' of size 'n'.

For each element in the array, check whether the immediate right element of the array is smaller or not.
If the next element is smaller, update the current index to that element. If not, then -1. The last element does not have any elements on its right.

Example :
Input: 'a' = [4, 7, 8, 2, 3, 1]

Output: Modified array 'a' = [-1, -1, 2, -1, 1, -1]

Explanation: In the array 'a':
4 has 7 on its right. Since 7 is not smaller, we update 4 to -1.

7 has 8 on its right. Since 8 is not smaller, we update 7 to -1.

8 has 2 on its right. Since 2 is smaller than 8, we update 8 to 2.

2 has 3 on its right. Since 3 is not smaller, we update 2 to -1.

3 has 1 on its right. Since 1 is smaller than 3, we update 3 to 1.

1 does not have any element on right. So we update 1 to -1.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
4 7 8 2 3 1


Sample Output 1 :
-1 -1 2 -1 1 -1 


Explanation of The Sample Input 1 :
In the array 'a':
4 has 7 on its right. Since 7 is not smaller, we update 4 to -1.
7 has 8 on its right. Since 8 is not smaller, we update 7 to -1.
8 has 2 on its right. Since 2 is smaller than 8, we update 8 to 2.
2 has 3 on its right. Since 3 is not smaller, we update 2 to -1.
3 has 1 on its right. Since 1 is smaller than 3, we update 3 to 1.
1 does not have any element on right. So we update 1 to -1.


Sample Input 2 :
4
1 2 3 4


Sample Output 2 :
-1 -1 -1 -1 


Sample Input 3 :
4
4 3 2 1


Sample Output 3 :
3 2 1 -1 


Expected time complexity :
The expected time complexity is O(n).


Constraints :
1 <= 'n' <= 10 ^ 5
1 <= 'a[i]' <= 10 ^ 9

Time Limit : 1 sec
------------ Solution Idea --------------------
Similar to next greater element solution
*/

import java.util.*;
public class Solution {
    public static void immediateSmaller(int []arr) {
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            int current = arr[i];
            if(st.isEmpty()){
                arr[i] = -1;
            }
            else if(current >= st.peek()){
                arr[i] = st.pop();
            }
            else{
                arr[i]= -1;
                st.pop();
            }
            st.push(current);
        }
    }
}



