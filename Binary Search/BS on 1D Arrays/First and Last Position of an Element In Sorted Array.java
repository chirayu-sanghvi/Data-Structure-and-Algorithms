/*
Coding Ninja: https://www.codingninjas.com/studio/problems/first-and-last-position-of-an-element-in-sorted-array_1082549
Problem statement
You have been given a sorted array/list 'arr' consisting of ‘n’ elements. You are also given an integer ‘k’.



Now, your task is to find the first and last occurrence of ‘k’ in 'arr'.



Note :
1. If ‘k’ is not present in the array, then the first and the last occurrence will be -1. 
2. 'arr' may contain duplicate elements.


Example:
Input: 'arr' = [0,1,1,5] , 'k' = 1

Output: 1 2

Explanation:
If 'arr' = [0, 1, 1, 5] and 'k' = 1, then the first and last occurrence of 1 will be 1(0 - indexed) and 2.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
8 2
0 0 1 1 2 2 2 2


Sample output 1:
4 7


Explanation of Sample output 1:
For this testcase the first occurrence of 2 in at index 4 and last occurrence is at index 7.


Sample Input 2:
4 2
1 3 3 5


Sample output 2:
-1 -1


Expected Time Complexity:
Try to do this in O(log(n)).


Constraints:
1 <= n <= 10^5
0 <= k <= 10^9
0 <= arr[i] <= 10^9

Time Limit : 1 second
*/
import java.util.*;
public class Solution {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int a[] = new int[2];
        a[0] = -1;
        a[1] = -1;
        firsto(arr,n,k,a);
        if(a[0] == -1){
            return a;
        }
        lasto(arr,n,k,a);
        return a;
    }

    public static void firsto(ArrayList<Integer> arr, int n, int k, int[] a){
        int l = 0;
        int h = n-1;
        int mid = 0;
        while(l<=h){
            mid = (int)(l+h)/2;
            if(arr.get(mid) == k){
                a[0] = mid;
                h = mid-1;
            }
            else if(arr.get(mid) > k){
                h = mid-1;
            }
            else{
                l = mid+1;
            }    
        }
    } 

    public static void lasto(ArrayList<Integer> arr, int n, int k, int[] a){
        int l = 0;
        int h = n-1;
        int mid = 0;
        while(l<=h){
            mid = (int)(l+h)/2;
            if(arr.get(mid) == k){
                a[1] = mid;
                l = mid+1;
            }
            else if(arr.get(mid) > k){
                h = mid-1;
            }
            else{
                l = mid+1;
            }    
        }
    } 

};
