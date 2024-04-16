/*
Coding Ninja: https://www.naukri.com/code360/problems/first-missing-positive_699946
Problem statement
You are given an array 'ARR' of integers of length N. Your task is to find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can have negative numbers as well.
For example, the input [3, 4, -1, 1] should give output 2 because it is the smallest positive number that is missing in the input array.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
1
5
3 2 -6 1 0
Sample Output 1:
4
Explanation for Input 1:
The first positive number is 1 and it is present in the array similarly 2 and 3 are also present in the array. 4 is missing from the array. Thus, the minimum positive integer that is missing is 4.
Sample Input 2 :
1
5
0 1 2 3 4
Sample Output 2:
5
*/
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int firstMissing(int[] arr, int n) {
		// Write your code here.
		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
		for(int i =0;i<arr.length;i++){
			if(arr[i] < 1){
				continue;
			}
			else{
				hm.put(arr[i], 1);
			}
		}
	int result = 0;
		for(int i =0;i<hm.size();i++){
			if(hm.containsKey(i+1)){
				result = i+1;
			}
			else{
				return result+1;
			}
		}
	return result+1;
	}
}
