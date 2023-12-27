/*
Coding Ninja Link: https://www.codingninjas.com/studio/problems/postfix-to-infix_8382386?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=DISCUSS

Problem statement
You are given a mathematical expression in postfix notation. The expression consists of alphabets(both lowercase and uppercase) and operators.



Convert this expression to infix notation.



Note:
Surround every expression with a pair of parentheses “()”.


Example:
Input: ‘postfix’ = “ab+c+”

Output: ‘infix’ = “((a+b)+c)”

Explanation: The expression ((a+b)+c)” in infix is equivalent to “ab+c+” in postfix.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
ab+c+
Sample Output 1:
((a+b)+c)


Explanation Of Sample Input 1 :
The expression “((a+b)+c)” in infix is equivalent to “ab+c+” in postfix.


Sample Input 2 :
9
ABC/DA-*+
Sample Output 2 :
(A+((B/C)*(D-A)))


Constraints:
3 <= ‘postfix.length’ <= 10^4
-----Solution idea ------
similar to prefix to infix expression conversion
*/
import java.util.*;
public class Solution {
    public static String postToInfix(String postfix) {
        // Write your code here.
         Stack<String> st = new Stack<>();
         for(int i=1;i<postfix.length();i++){
             char c = postfix.charAt(i);
             if(!Character.isAlphabetic(c) && !st.isEmpty()){
                 String op1 = st.pop();
                 String op2 = st.pop();
                 st.push("("+op2+c+op1+")");
             }
             else{
                 st.push(c+"");
             }
         }
         return st.peek();

    }
}
