/*
Coding Ninja: https://www.codingninjas.com/studio/problems/longest-substring-with-at-most-k-distinct-characters_2221410
Leet Code: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

Problem statement
You are given a string 'str' and an integer ‘K’. Your task is to find the length of the largest substring with at most ‘K’ distinct characters.

For example:
You are given ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= K <= 26
1 <= |str| <= 10^6

The string str will contain only lowercase alphabets.    

Time Limit: 1 sec
Note:
You do not need to print anything. It has already been taken care of. Just implement the function.
Sample Input 1:
2
2
abbbbbbc
3
abcddefg
Sample Output 1:
7
4
Explanation:
For the first test case, ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.

For the second test case, ‘str’ = ‘abcddefg’ and ‘K’ = 3, then the substrings that can be formed is [‘cdde’, ‘ddef’]. Hence the answer is 4.
Sample Input 2:
2
3
aaaaaaaa
1
abcefg
Sample Output 2:
8   
1   

Hints:
1. Try to think of a brute force approach.
2. Try to think of a two-pointer solution.
*/
import java.util.HashMap;

public class Solution {

	public static int kDistinctChars(int k, String str) {
		// Write your code here
		int n = str.length();
		HashMap<Character, Integer> hm = new HashMap<>();
		int start = 0;
		int answer = 0;
		for(int i =0;i<n;i++){
			char ch = str.charAt(i);
			hm.put(ch, hm.getOrDefault(ch,0)+1);
			if(hm.size() > k){
				char first = str.charAt(start);
				hm.put(first, hm.get(first)-1);
				if(hm.get(first) == 0){
					hm.remove(first);
				}
				start++;
			}
			answer = Math.max(answer, i-start+1);
		}
		return answer;
	}

}
