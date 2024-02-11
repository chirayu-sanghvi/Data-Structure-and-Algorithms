/*
Coding Ninja: https://www.codingninjas.com/studio/problems/search-in-a-rotated-sorted-array-ii_7449547
Leet Code: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

Problem statement
You are given a rotated sorted array 'a' of length 'n' and a 'key'. You need to determine if the 'key' exists in the array 'a'.



The given sorted array is rotated from an unknown index 'x'. Such that after rotation the array became [a[x], a[x+1]...., a[n-1], a[1]..., a[x-1]], (0-based indexing). For example, if the array is [1, 2, 3, 4, 5] and x = 2 then the rotated array will be [3, 4, 5, 1, 2, 3].



Return True if the 'key' is found in 'a'. Otherwise, return False.



Note: Array ‘a’ may contain duplicate elements.



Example:

Input: a = [6, 10, 1, 3, 5], key = 3

Output: True

Explanation: The array 'a' contains the 'key' = 3, so we return True.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
7 4
3 4 5 0 0 1 2


Sample Output 1:
True


Explanation Of Sample Input 1:
Input: a = [3, 4, 5, 0, 0, 1, 2], key = 4

Output: True

Explanation: The array 'a' contains the 'key' = 3, so we return True.


Sample Input 2:
6 47
31 44 56 0 10 13


Sample Output 2:
False


Expected Time Complexity:
Try to solve this with average time complexity O(log(n)).
Constraints:
1 <= 'n' <= 10^5
0 <= 'a[i]', 'key' <= 10^9
Time Limit: 1 sec
*/
public class Solution {
    public static boolean searchInARotatedSortedArrayII(int []A, int key) {
        // Write your code here.
        int n = A.length;
        int h = n-1;
        int l = 0;
        int mid = 0;
        while(l <= h){
            mid = (int)(h+l)/2;
            if(A[mid] == key){
                return true;
            }
            if(A[mid] == A[l] && A[mid] == A[h]){
                l++;
                h--;
                continue;
            }
            if(A[mid] >= A[l]){
                if(A[l] <= key && key <= A[mid]){
                    h=mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else{
                if(A[mid] <= key && key <= A[h]){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
        }
    return false;
    }
}
