/*
Coding Ninja: https://www.codingninjas.com/studio/problems/longest-prefix-which-is-suffix_3146849
Leet Code: https://leetcode.com/problems/longest-happy-prefix/description/
Problem statement
You are given a string ‘str’.
Find the longest prefix in the string which is also a suffix of the string, excluding the string itself.
If there's no such string return an empty string "".

Example:
Input: ‘str’ = ‘ababcdabab’ 
Output: 'abab'
Explanation:
Here the prefix ‘abab’ is equal to the suffix ‘abab’. The length of the prefix is 4. There's no other prefix that has length > 4 and is also present as a suffix. Hence the answer is 'abab'. 
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
aaaaabaa
Expected Answer:
"aa"
Output on console:
aa

Explanation of Sample Input 1:
For this test case, ‘str’ = ‘aaaaabaa’. Here the prefix ‘aa’ is equal to the suffix ‘aa’. The length of the prefix is 2. There's no other prefix with length > 2 which is also present as a suffix. Hence the answer is 'aa'.


Sample Input 2:
aab
Expected Answer:
""
Output on console:
-1

Expected Time Complexity:
Try to do this in O(n), where 'n' is the length of string 'str'.
Constraints:
1 <= |str| <= 10^6
All the characters of ‘str’ are lower case English alphabets.
Time Limit: 1 sec
*/
public class Solution {
    public static String longestPrefixSuffix(String str){
        // Write your code here.
        int n = str.length();
        int i = n-2;
        int indexChecked = 1;
        int right = n-1;
        String result = "";
        int count = 0;
        while(i>= 0){
            if(str.charAt(i) == str.charAt(right)){
                i--;
                right--;
                count ++;
                if(i == -1){
                    result = result + str.substring(0, count);
                    break;
                }
            }
            else {
                i = n-2-indexChecked;
                right = n-1;
                indexChecked ++;
                count = 0;
            }
        }
        return result;
    }
}
