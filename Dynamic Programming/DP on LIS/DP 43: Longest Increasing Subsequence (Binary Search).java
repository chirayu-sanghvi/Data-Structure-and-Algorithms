/*
Coding Ninja: https://www.codingninjas.com/studio/problems/longest-increasing-subsequence_630459
Leet Code: https://leetcode.com/problems/longest-increasing-subsequence/
Problem statement
For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order.

Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.

For example:
[1, 2, 3, 4] is a strictly increasing array, while [2, 1, 4, 3] is not.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
6
5 4 11 1 16 8
Sample Output 1 :
3
Explanation of Sample Input 1:
Length of longest subsequence is 3 i.e. [5, 11, 16] or [4, 11, 16].
Sample Input 2:
3
1 2 2
Sample Output 2 :
2
*/
// Binary Search Solution 
import java.util.Collections;
import java.util.ArrayList;
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(arr[0]);
		int n = arr.length;
		for(int i=1;i<n;i++){
			if(arr[i] > al.get(al.size()-1)){
			al.add(arr[i]);
			}
			else {
				int index = Collections.binarySearch(al, arr[i]);
				if(index < 0){
					index = -index-1;
				}
				al.set(index,arr[i]);
			}
		}
		return al.size();
	}

}
