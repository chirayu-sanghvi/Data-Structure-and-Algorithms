/*
Coding Ninja: https://www.codingninjas.com/studio/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813
Leet Code: https://leetcode.com/problems/search-insert-position/description/
Problem statement
You are given a sorted array 'arr' of distinct values and a target value 'm'.
You need to search for the index of the target value in the array.
Note:
If the value is present in the array, return its index.
If the value is absent, determine the index where it would be inserted in the array while maintaining the sorted order. 

Example:
Input:  arr = [1, 2, 4, 7],  m = 6 
Output: 3
Explanation: If the given array 'arr' is: [1, 2, 4, 7] and m = 6. We insert m = 6 in the array and get 'arr' as: [1, 2, 4, 6, 7]. The position of 6 is 3 (according to 0-based indexing)

Note:
1) The given array has distinct integers.
2) The given array may be empty.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4 9
1 2 4 7

Sample Output 1:
4
Explanation of Input 1:
The given array 'arr' is: [1, 2, 4, 7] and m = 9. We insert m = 9 in the array and get 'arr' as: [1, 2, 4, 7, 9]. The position of 9 is 4 (according to 0-based indexing).

Sample Input 2:
3 1
2 5 7
Sample Output 2
0
Explanation of Input 2:
The given array 'arr' is: [2, 5, 7] and m = 1. We insert m = 1 in the array and get 'arr' as: [1, 2, 5, 7]. The position of 1 is 0 (according to 0-based indexing)


Sample Input 3:
4 2
1 2 4 7
Sample Output 3:
1
Explanation of Input 3:
The given array 'arr' is: [1, 2, 4, 7] and m = 2. We already have 2 in 'A'. The position of 2 is 1 (according to 0-based indexing)

Expected Time Complexity:
Try to solve the problem in O(log n).
Constraints:
0 ≤ n ≤ 10 ^ 5
1 ≤ m ≤ 10 ^ 9
1 ≤ arr[i] ≤ 10 ^ 9

Where 'arr[i]' is the array element at index 'i'.
Time Limit: 1 sec.
/*
    Time Complexity - O(log N)
    Space Complexity - O(1)
    Where 'N' is the size of the array.
====================================== Soloution Idea ========================================
Apply Binary Search
*/
public class Solution {
    public static int searchInsert(int [] arr, int m){

        int lo = 0;
        int hi = arr.length - 1;
        int ans = -1;

        while(lo <= hi){

            int mid = lo + (hi - lo) / 2;
            // Check if element is present.
            if(arr[mid] == m){
                return mid;
            }

            // Check in left half.
            if(arr[mid] > m){
                hi = mid - 1;
                ans = mid;
            }
            // Check in right half.
            else{
                lo = mid + 1;
            }
        }

        if(ans == -1) {
            ans = arr.length;
        }

        return ans;
    }
}
