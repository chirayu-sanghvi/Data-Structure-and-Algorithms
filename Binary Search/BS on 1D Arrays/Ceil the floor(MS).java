/*
Coding Ninja: https://www.codingninjas.com/studio/problems/ceiling-in-a-sorted-array_1825401
Problem statement
You're given a sorted array 'a' of 'n' integers and an integer 'x'.
Find the floor and ceiling of 'x' in 'a[0..n-1]'.

Note:
Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.

Example:
Input: 
n=6, x=5, a=[3, 4, 7, 8, 8, 10]   

Output:
4

Explanation:
The floor and ceiling of 'x' = 5 are 4 and 7, respectively.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6 8
3 4 4 7 8 10


Sample Output 1 :
8 8


Explanation of sample input 1 :
Since x = 8 is present in the array, it will be both floor and ceiling.


Sample Input 2 :
6 2
3 4 4 7 8 10


Sample Output 2 :
-1 3


Explanation of sample input 2 :
Since no number is less than or equal to x = 2 in the array, its floor does not exist. The ceiling will be 3.


Constraints :
1 <= n <= 2 * 10^5      
1 <= a[i] <= 10^9
Time limit: 1 sec
*/
/*
    Time Complexity - O(log N)
    Space Complexity - O(1)

    Where 'N' is the size of the array.
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
