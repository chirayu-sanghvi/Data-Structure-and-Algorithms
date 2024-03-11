/*
Coding Ninja: https://www.codingninjas.com/studio/problems/anagram-pairs_626517
Problem statement
You are given two strings 'str1' and 'str1'.



You have to tell whether these strings form an anagram pair or not.



The strings form an anagram pair if the letters of one string can be rearranged to form another string.

Pre-requisites:

Anagrams are defined as words or names that can be formed by rearranging the letters of another word. Such as "spar" can be formed by rearranging letters of "rasp". Hence, "spar" and "rasp" are anagrams. 
Other examples include:

'triangle' and 'integral'
'listen' and 'silent'
Note:
Since it is a binary problem, there is no partial marking. Marks will only be awarded if you get all the test cases correct. 
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
rasp spar
Sample Output 1:
True
Explanation For Sample Output 1:
Since both the strings have one 'a', one 'p', one 'r', and one 's', they are anagrams.
Sample Input 2:
rasp spaz
Sample Output 2:
False
Constraints:
1 <= N <= 10^5 
1 <= M <= 10^5
Where N and M are the lengths of the strings str1 and str2 , respectively.

Time Limit: 1sec
Follow Up:
Can you solve this in O( N ) time?
*/
import java.util.*;
public class Solution {

    public static boolean isAnagram(String str1, String str2) {
        //Your code goes here
        if(str1.length() != str2.length()){
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        Arrays.sort(ch1);   
        Arrays.sort(ch2);
        String s1 = new String(ch1);
        String s2 = new String(ch2);
        if(s1.equals(s2))
            return true;
        return false;
    }
}
