/*
Coding Ninja: https://www.codingninjas.com/studio/problems/find-peak-element_1081482
Leet Code: https://leetcode.com/problems/find-peak-element/description/
Problem statement
You are given an array 'arr' of length 'n'. Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.



Peak element is defined as that element that is greater than both of its neighbors. If 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.



Assume 'arr[-1]' and 'arr[n]' as negative infinity.



Note:
1.  There are no 2 adjacent elements having same value (as mentioned in the constraints).
2.  Do not print anything, just return the index of the peak element (0 - indexed).
3. 'True'/'False' will be printed depending on whether your answer is correct or not.


Example:

Input: 'arr' = [1, 8, 1, 5, 3]

Output: 3

Explanation: There are two possible answers. Both 8 and 5 are peak elements, so the correct answers are their positions, 1 and 3.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
1 8 1 5 3


Expected Answer:
1


Output on Console:
True


Explanation of sample input 1 :
There are two possible answers. Both 8 and 5 are peak elements, so the correct answers are their positions, 1 and 3. Any of these 2 numbers will print 'True'.


Sample Input 2:
3
1 2 1 


Expected Answer:
1


Output on Console:
True


Expected time complexity:
The expected time complexity is O(log 'n').


Constraints:
1 <= 'n' <= 10^5
1 <= 'arr[i]' <= 10^5
'arr[i]' != 'arr[i + 1]' for all 'i' in range 0 <= 'i' < 'n' - 1
*/
import java.util.ArrayList;

public class Solution {

    public static int findPeakElement(ArrayList<Integer> arr) {

        // Write your code here.

        int s =0;

        int e = arr.size()-1;

        if(arr.get(0)>arr.get(1)){

            return 0;

        }

        if(arr.get(arr.size()-1)>arr.get(arr.size()-2)){

            return arr.size()-1;

        }

        while(e>=s){

            int mid=s+(e-s)/2;

            if((arr.get(mid)>arr.get(mid+1)) && (arr.get(mid)>arr.get(mid-1))){

                return mid;

            }

            else if(arr.get(mid)<arr.get(mid+1)){

                s=mid+1;

            }

            else {

                e =mid-1;

            }

        }

        return 1;

    }

};
