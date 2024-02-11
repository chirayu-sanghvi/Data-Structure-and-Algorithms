/*
Coding Ninja: https://www.codingninjas.com/studio/problems/rotated-array_1093219
Leet Code: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Problem statement
You are given an array 'arr' of size 'n' having unique elements that has been sorted in ascending order and rotated between 1 and 'n' times which is unknown.



The rotation involves shifting every element to the right, with the last element moving to the first position. For example, if 'arr' = [1, 2, 3, 4] was rotated one time, it would become [4, 1, 2, 3].



Your task is to find the minimum number in this array.



Note :
All the elements in the array are distinct. 


Example :
Input: arr = [3,4,5,1,2]

Output: 1

Explanation: The original array was [1,2,3,4,5] and it was rotated 3 times.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4
3 4 1 2   


Sample Output 1 :
1


Explanation of Sample Input 1 :
The original array was [1, 2, 3, 4] and it was rotated 2 times.


Sample Input 2 :
6
25 30 5 10 15 20


Sample Output 2 :
5


Explanation of Sample Input 2 :
The original array was [5, 10, 15, 20, 25, 30] and it was rotated 2 times.


Expected Time Complexity:
Try to solve this with O(log(n)) time complexity.


Constraints :
1 <= n <= 10^5
1 <= arr[i] <= 10^9

Time Limit: 1 sec
*/
public class Solution {
    public static int findMin(int []arr) {
        // Write your code here.
        int mid = 0;
        int h=arr.length-1;
        int l = 0;
        int ans = Integer.MAX_VALUE;
        while(l<=h){
            mid = (int)(l+h)/2;
            if(arr[l] <= arr[h]){
            ans = Math.min(ans, arr[l]);
            break;
            }
            else if(arr[mid] >= arr[l]){
                ans = Math.min(ans, arr[l]);
                l = mid+1;
            }
            else{
                ans = Math.min(ans, arr[mid]);
                h = mid-1;
            }
        }
        return ans;
    }
}
