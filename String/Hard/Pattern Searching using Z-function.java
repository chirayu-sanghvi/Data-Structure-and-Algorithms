/*
Coding Ninja: https://www.codingninjas.com/studio/problems/pattern-searching-using-z-algorithm_8395752
Leet Code: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
Problem statement
You are given two strings, ‘s’ of size ‘n’, which is the text string, and ‘pattern’ of size ‘m’, which is the pattern string.
Your task is to return all the indices in sorted order (in 1-based indexing) of string ‘s’ such that starting from that index, the substring in ‘s’ of length ‘m’ is equal to ‘pattern’.

Example:
Input: ‘n’ = 8, ‘m’ = 3
‘s’ = “abdchabd”, ‘pattern’ = “abd”

Output: 1 6
Explanation: The indices where the string ‘s’ substring of length ‘3’ matches with string ‘pattern’ are 1 and 6.
 <br/> 
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
8 3
abdchabd
abd

Sample Output 1 :
1 6


Explanation Of Sample Input 1:
Input: ‘n’ = 8, ‘m’ = 3
‘s’ = “abdchabd”, ‘pattern’ = “abd”
Output: 1 6
Explanation: The indices where the string ‘s’ substring of length ‘3’ matches with string ‘pattern’ are 1 and 6.
<br/>
Sample Input 2:
6 2
aaaaaa
aa

Sample Output 2:
1 2 3 4 5
Explanation Of Sample Input 2:
Input: ‘n’ = 6, ‘m’ = 2
‘s’ = “aaaaaa”, ‘pattern’ = “aa”

Output: 1 2 3 4 5
Explanation: The indices where the string ‘s’ substring of length ‘2’ matches with string ‘pattern’ are 1, 2, 3, 4, and 5.

Constraints:
1 <= n <= 10^4
1 <= m <= n
All letters in the string ‘s’ and ‘pattern’ are lowercase letters.
Time Limit: 1-sec
*/
import java.util.*;
import java.util.List;

public class Solution {
    public static List< Integer > search(String s, String pattern){
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = pattern.length();
        for(int i=0;i<n-m+1;i++){
            if(s.charAt(i) == pattern.charAt(0)){
                if(s.substring(i, pattern.length()+i).equals(pattern))
                    result.add(i+1);
            }
        }
        return result;
    }
}
