/*
Coding Ninja: https://www.codingninjas.com/studio/problems/occurrence-of-x-in-a-sorted-array_630456
Problem statement
You have been given a sorted array/list of integers 'arr' of size 'n' and an integer 'x'.
Find the total number of occurrences of 'x' in the array/list.
Example:
Input: 'n' = 7, 'x' = 3
'arr' = [1, 1, 1, 2, 2, 3, 3]
Output: 2
Explanation: Total occurrences of '3' in the array 'arr' is 2.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
7 3
1 1 1 2 2 3 3

Sample Output 1:
2

Explanation For Sample Input 1:
In the given list, there are 2 occurrences of integer 3.

Sample Input 2:
 5 6
 1 2 4 4 5

Sample Output 2:
 0
Explanation For Sample Input 2:
In the given list, there are 0 occurrences of integer 6.

Expected time complexity:
The expected time complexity is O(log 'n').

Constraints:
1 <= n <= 10^4
1 <= arr[i] <= 10^9
1 <= x <= 10^9
Where arr[i] represents the element i-th element in the array/list.
Time Limit: 1sec
*/
public class Solution {
    public static int count(int arr[], int n, int k) {
        int a[] = new int[2];
        a[0] = -1;
        a[1] = -1;
        firsto(arr,n,k,a);
        if(a[0] == -1){
            return 0;
        }
        lasto(arr,n,k,a);
        return a[1]-a[0]+1;
    }

    public static void firsto(int[] arr, int n, int k, int[] a){
        int l = 0;
        int h = n-1;
        int mid = 0;
        while(l<=h){
            mid = (int)(l+h)/2;
            if(arr[mid]== k){
                a[0] = mid;
                h = mid-1;
            }
            else if(arr[mid]> k){
                h = mid-1;
            }
            else{
                l = mid+1;
            }    
        }
    } 

    public static void lasto(int[] arr, int n, int k, int[] a){
        int l = 0;
        int h = n-1;
        int mid = 0;
        while(l<=h){
            mid = (int)(l+h)/2;
            if(arr[mid] == k){
                a[1] = mid;
                l = mid+1;
            }
            else if(arr[mid] > k){
                h = mid-1;
            }
            else{
                l = mid+1;
            }    
        }
    } 
}
