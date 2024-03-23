/*
Coding Ninja: https://www.codingninjas.com/studio/problems/maximum-of-all-subarrays-of-size-k_1170789
Problem statement
You are given an array consisting of N non-negative integers, and an integer K denoting the length of a subarray, your task is to determine the maximum elements for each subarray of size K.

Note:
A subarray is a contiguous subset of an array.

The array may contain duplicate elements.

The given array follows 0-based indexing.

It is guaranteed that there exists at least one subarray of size K.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 10^5
1 <= K <= N
1 <= arr[i] <= 10^9

Time Limit: 1sec
Sample Input 1:
1
4 2
10 7 8 11
Sample Output 1:
10 8 11
Explanation For Sample Input 1:
The first subarray of length 2 is [10,7] and the maximum of it is 10, then the next subarray of length 2 is [7,8] and the maximum of it is 8, and the last subarray of size 2 is [8,11] and the maximum of it is 11, So the output is [10,8,11].
Sample Input 2:
1
4 3 
11 3 9 6
Sample Output 2:
11 9

*/
import java.util.* ;
import java.io.*; 
public class Solution 
{

    public static ArrayList<Integer> maxOfSubarray(ArrayList<Integer> nums, int n, int k) 
	{
        // Write your code here. 
        ArrayList<Integer> arr = new ArrayList<>();
        int i =0 ;
        int j =0;
        int max = Integer.MIN_VALUE;
        while(j < n){
            max = Math.max(max, nums.get(j));
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                arr.add(max);
                j++;
                if(arr.get(i) == max){
                    max = Integer.MIN_VALUE;
                    for(int l=i+1;l<j;l++){
                        max = Math.max(max, nums.get(l));
                    }
                }
                i++;    
            }
        }
        return arr;
    }

}
