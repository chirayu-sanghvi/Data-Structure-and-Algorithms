/*
Coding Ninja: https://www.codingninjas.com/studio/problems/trapping-rain-water_630519?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
Leet Code: https://leetcode.com/problems/trapping-rain-water/

Problem statement
You have been given a long type array/list 'arr’ of size 'n’.

It represents an elevation map wherein 'arr[i]’ denotes the elevation of the 'ith' bar.

Print the total amount of rainwater that can be trapped in these elevations.

Note :
The width of each bar is the same and is equal to 1.
Example:
Input: ‘n’ = 6, ‘arr’ = [3, 0, 0, 2, 0, 4].

Output: 10

Explanation: Refer to the image for better comprehension:

Note :
You don't need to print anything. It has already been taken care of. Just implement the given function.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
2 1 1 4
Sample Output 1:
2
Explanation Of Sample Input 1:
Water trapped by:
     block of height 2 is 0 units.
     block of height 1 is 1 unit.
     block of height 1 is 3 1 unit. 
     block of height 4 is 3 0 units.

Hence the total is 2.
Sample Input 2:
5
8 1 8 2 4 
Sample Output 2:
9
Explanation Of Sample Input 2:
Water trapped by:
     block of height 8 is 0 units.
     block of height 1 is 7 units.
     block of height 8 is 0 units. 
     block of height 2 is 2 units.
     block of height 4 is 0 units.

Hence the total is 9.
Expected Time Complexity:
The expected time complexity is O(n).
Constraints :
0 <= n <= 10^6
0 <= arr[i] <= 10^9

Time Limit: 1 sec

------------------- Solution Idea -------------------------------
1) Using two pointers (We have not used any stacks here)
*/
public class Solution {
    public static long getTrappedWater(long []arr, int n) {
        // Write your code here.
        int left = 0;
        int right = n-1;
        long leftmax = 0;
        long rightmax = 0;
        long result = 0;
        while(left <= right){
            if(arr[left] <= arr[right]){
                if(arr[left] >= leftmax){
                    leftmax = arr[left];
                }
                else{
                    result = result + leftmax-arr[left];
                }
                left++;
            }
            else{
                if(arr[right]>=rightmax){
                    rightmax = arr[right];
                }
                else{
                    result = result + rightmax-arr[right];
                }
            right --;
            }
        }
        return result;
    }
}
