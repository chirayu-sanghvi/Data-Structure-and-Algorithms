/*
Coding Ninja: https://www.codingninjas.com/studio/problems/longest-substring-without-repeating-characters_630418?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
Leet Code: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Problem statement
Given a string input of length n, find the length of the longest substring without repeating characters i.e return a substring that does not have any repeating characters.

Substring is the continuous sub-part of the string formed by removing zero or more characters from both ends.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
 1<= n <=10^5

Time Limit: 1 sec
Sample Input 1:
 abcabcbb 
Sample Output1:
 3
Explanation For Sample Input 1:
Substring "abc" has no repeating character with the length of 3.
Sample Input 2:
 aaaa
Sample Output 2:
1


================================ Solution Idea ================================
Createa hashmap of the character and its index, iterate through the input string and update the length of the maxlen and hashmap values accordingly. 
I have used two pointers left and right with hashmap to solve this problem.
*/
import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		//write your code here
		HashMap<Character,Integer> hm = new HashMap<>();
		int left=0, right =0, maxlen = 0;
		int n = input.length();
		while(right < n){
			char c = input.charAt(right);
			if(hm.containsKey(c)){
				left = Math.max(hm.get(c)+1,left);
			}
			hm.put(c,right);
			maxlen = Math.max(maxlen, right-left+1);
			right ++;
		}
		return maxlen;
	}
}
