/*
Coding Ninja: https://www.codingninjas.com/studio/problems/roman-numeral-to-integer_981308
Problem statement
You are given a string 's' that represents a Roman number. Convert the Roman number to an integer and return it.



Roman numerals are represented by seven different symbols: I, V, X, L, C, D, and M.



Table of values:
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example:
3 is written as III in Roman numeral, just three ones added together. 13 is written as XIII, which is simply X + III. The number 25 is written as XXV, which is XX + V 
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
XII
Sample Output 1:
12
Explanation For Sample Input 1 :
We know that ‘X’ is 10, and we have 2 ‘I’ after it. Therefore the number is 12
Sample Input 2:
XC
Sample Output 2:
90
Constraints:
1 <= roman.length <= 15

Time limit: 1 second
Follow Up:
Can you solve this in O(N) time?
*/
import java.util.*;
public class Solution {
    public static int romanToInt(String s) {
        // Write your code here
        HashMap<Character,Integer> h  = new HashMap<Character,Integer>();
        h.put('I',1);
        h.put('V',5);
        h.put('X',10);
        h.put('L',50);
        h.put('C',100);
        h.put('D',500);
        h.put('M',1000);
        int result = 0;
        for(int i =0;i<s.length()-1;i++){
            char x = s.charAt(i);
            if(h.get(x) >= h.get(s.charAt(i+1)))
            result = result + h.get(x);
            else
            result = result - h.get(x);
        }
        result = result + h.get(s.charAt(s.length()-1));
        return result;


    }
}
