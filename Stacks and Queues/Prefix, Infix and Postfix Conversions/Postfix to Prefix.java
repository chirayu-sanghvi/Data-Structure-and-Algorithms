/*
Coding Ninja: https://www.codingninjas.com/studio/problems/postfix-to-prefix_1788455?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
You are given a string denoting a valid Postfix expression containing ‘+’, ’-’, ’*’, ‘/’ and lowercase letters.



Convert the given Postfix expression into a Prefix expression.



Note:
Postfix notation is a method of writing mathematical expressions in which operators are placed after the operands. For example, "a b +" represents the addition of a and b.

Prefix notation is a method of writing mathematical expressions in which operators are placed before the operands. For example, "+ a b" represents the addition of a and b.

Expression contains lowercase English letters, ‘+’, ‘-’, ‘*’, and  ‘/’. 


Example:
Input: abc*+

Output: +a*bc

Explanation:
For the given postfix expression, infix expression is a+b*c. And it's corresponding prefix expression is +a*bc.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
ab+cd-*


Expected Answer:
*+ab-cd 


Output on console:
*+ab-cd 


Explanation Of Sample Input 1:
For this testcase, the infix expression will be (a + b) * (c - d). Hence, our prefix expression will be *+ab-cd.


Sample Input 2:
ab+c-


Expected Answer:
-+abc


Output on console:
-+abc


Expected Time Complexity:
Try to solve this in O(n), where n is the length of expression.    


Constraints:
1 <= |s| <= 10^5

Time Limit: 1 sec

-------- Solution Idea -------------
The idea foe the solution is similar to the idea we used to convert prefix to postfix expression
*/

import java.util.*;
public class Solution {
    public static String postfixToPrefix(String exp) {
        // Write your code here
        Stack<String> st = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(!Character.isAlphabetic(c)){
                String op1 = st.pop();
                String op2 = st.pop();
                st.push(c+op2+op1);
            }
            else{
                st.push(c+"");
            }
        }
        return st.peek();
    }
}
