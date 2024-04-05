/*
Coding Ninja: https://www.naukri.com/code360/problems/printing-longest-increasing-subsequence_8360670
Problem statement
You are given an array 'arr' of length 'n'.



Find the Longest Increasing Subsequence of the array.



A subsequence is a subset of an array achieved by removing some (possibly 0) elements without changing the order of the remaining elements.



Increasing subsequence means a subsequence in which all the elements are strictly increasing.



Longest increasing subsequence is an increasing subsequence that has the largest length possible.



Please note that there may be more than one LIS (Longest Increasing Subsequence) possible. Return any one of the valid sequences.



Example:
Input: ‘arr’ = [5, 6, 3, 4, 7, 6]

Output: LIS = [5, 6, 7] OR [3, 4, 7] OR [3, 4, 6]

Explanation: All these three subsequences are valid Longest Increasing Subsequences. Returning any of them is correct.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
6
5 6 3 4 7 6


Sample Output 1:
3


Explanation Of Sample Input 1 :
There are three valid LIS for the given array: [5, 6, 7], [3, 4, 7] OR [3, 4, 6], and their length is 3.


Sample Input 2 :
5
1 2 3 4 5


Sample Output 2 :
5


Explanation Of Sample Input 2 :
There is only one valid LIS for the array: [1, 2, 3, 4, 5], and its length is 5.


Expected time complexity:
The expected time complexity is O(‘n’ ^ 2).


Constraints:
1 <= ‘n’ <= 500
1 <= ‘arr[i]’ <= 10^5
*/
import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.List;
public class Solution {
    public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
        // Write Your Code Here
    int n = arr.length;
	int hash[] = new int[n];
	int dp[] = new int[n];
	int max = 1;
	int last = 0;
	Arrays.fill(dp,1);
	for(int i =0;i<n;i++){
		hash[i] = i;
		for(int j = 0;j<i;j++){
			if(arr[j] < arr[i] && 1 + dp[j] > dp[i]){
				dp[i] = 1 + dp[j];
				hash[i] = j;
			}
		}
		if(max < dp[i]){
			max = dp[i];
			last = i;
		}
	}
    List<Integer> array = new ArrayList<>();
    array.add(arr[last]);
    while(hash[last] != last){
        last = hash[last];
        array.add(arr[last]);
    }
	Collections.reverse(array);
    return array;
    }
}
