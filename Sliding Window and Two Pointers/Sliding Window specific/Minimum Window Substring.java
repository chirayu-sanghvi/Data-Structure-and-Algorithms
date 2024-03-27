/*
Coding Ninja: https://www.naukri.com/code360/problems/minimum-window-substring_1215004
Leet Code: https://leetcode.com/problems/minimum-window-substring/submissions/1215533380/
Problem statement
You are given two strings ‘A’ and ‘B’. Your task is to return a substring ‘S’ of ‘A’ such that the following conditions hold true :
• You can make ‘B’ from ‘S’ by removing some characters and rearranging some characters zero or more times.
• Length of ‘S’ must be as minimum as possible.

Note :
Testcases are generated such that a substring always exists and is unique.
Example :

A = ninjas, B = sin
All possible substrings with which 'B' can be created are
"ninjas", "injas".

Hence the substring with minimum length is "injas".
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
fight it 
Sample Output 1 :
ight
Explanation Of Sample Input 1 :
Given A = “fight” and B = “it” 
Consider the substring “ight” of A. 
We can remove g and h from it to get “it”.
We can also get "it" from "fight" but it is not the substring with minimum length.
Sample Input 2 :
coding cin
Sample Output 2 :
codin
Constraints :
1 <=  |A| = |B| <= 3000
Both A, B contain only lowercase English letters.

Where |A| and |B| are the length of strings.

Time Limit: 1 sec
*/
import java.util.HashMap;

public class Solution {
    public static String minSubString(String a, String b) {
        //Write your code here
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c:b.toCharArray()){
            hm.put(c,hm.getOrDefault(c, 0)+1);
        }
        String answer = "";
        int min = Integer.MAX_VALUE;
        int count = hm.size();
        int i =0,j=0, n = a.length();
        while(j<n){
            char c = a.charAt(j);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)-1);
                if(hm.get(c) == 0){
                    count --;
                }
            }
            while(count == 0){
                if(min > j-i+1){
                    min = Math.min(j-i+1, min);
                    answer = a.substring(i, j+1);
                }
                if(hm.containsKey(a.charAt(i))){
                    hm.put(a.charAt(i), hm.get(a.charAt(i))+1);
                    if(hm.get(a.charAt(i))== 1){
                        count ++;
                    }
                }
                i++;
            }
            j++;
        }
        return answer;
    }
}
