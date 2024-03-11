/*
Coding Ninja: https://www.codingninjas.com/studio/problems/longest-common-prefix_628874

Problem statement
You are given an array ‘arr’ of ‘n’ strings.



Find the longest common prefix in all these strings.



If there is no common prefix in all the strings return "-1".


Example:
Input: 'arr' = [“abcd”, “abc”, “abref”, “abcde”]

Output: ab

Explanation:
Answer is “ab”, as it is the longest prefix present in all the given strings.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
Codingninjas
Coding
Coders
Codezen


Sample Output 1:
Cod   


Explanation of sample output 1:
In the given testcase, the longest prefix that is present in all the strings is “Cod”. Hence the answer is “Cod”. 

Sample Input 2:
3
abcd
Abcd
abc
Sample Output 2:
-1


Explanation of sample output 2:
In the given testcase, there is no prefix that is present in all the strings. Hence the answer is “-1”


Constraints:
1 <= ‘n’ <= 10^3
1 <= ‘arr[i].length’ <= 10^3

Time Limit: 1 sec


Expected Time Complexity:
Try solving this in O(n).
*/
import java.util.*;
public class Solution {
    public static String commonPrefix(String []arr,int n){
        //Write your code here
        String [] a = arr;
        int size = a.length;
 
        /* if size is 0, return empty string */
        if (size == 0)
            return "";
 
        if (size == 1)
            return a[0];
 
        /* sort the array of strings */
        Arrays.sort(a);
 
        /* find the minimum length from first and last string */
        int end = a[0].length();
 
        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
            i++;
 
        String pre = a[0].substring(0, i);
        if(pre.length() > 0){
        return pre;
        }
        return "-1";
    }
}
