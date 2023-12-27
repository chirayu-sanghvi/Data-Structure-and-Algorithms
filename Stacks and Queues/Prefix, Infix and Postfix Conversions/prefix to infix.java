/*
Coding Ninja: https://www.codingninjas.com/studio/problems/prefix-to-infix_1215000?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
You are given a string denoting a valid Prefix expression containing ‘+’, ’-’, ’*’, ‘/’ and lowercase letters.



Convert the given Prefix expression into an Infix expression.



Note:
Infix notation is a method of writing mathematical expressions in which operators are placed between operands. For example, "a + b" represents the addition of a and b.

Prefix notation is a method of writing mathematical expressions in which operators are placed before the operands. For example, "+ a b" represents the addition of a and b.

Expression contains lowercase English letters, ‘+’, ‘-’, ‘*’, and  ‘/’. 


Example:
Input: /-ab+-cde

Output: ((a-b)/((c-d)+e))

Explanation:
In this test case, there are four operators ‘/’, ‘-’, ‘+’, ‘-’.
Prefix expression:  /-ab+-cde. 
The operator between  ‘a’ and ‘b’ is ‘-’. Resulting expression: /(a-b)+-cde.
The operator between  ‘c’ and ‘d’ is ‘-’. Resulting expression: /(a-b)+(c-d)e.
The operator between ‘c-d’ and ‘e’ is +. Resulting expression: /(a-b)((c-d)+e).
The operator between ‘a-b’ and ‘((c-d)+e)’ is ‘/’. Resulting expression: ((a-b)/((c-d)+e)).
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
*-a/bc-/dkl


Expected Answer:
((a-(b/c))*((d/k)-l))


Output on console:
((a-(b/c))*((d/k)-l))


Explanation for Sample Input 1:
In this testcase, there are five operators ‘*’, ‘-’, ‘/’, ‘-’, ‘/’.
Prefix Expression: *-a/bc-/dkl.
The operator between  ‘b’ and ‘c’ is ‘/’. Resulting expression: *-a(b/c)-/dkl.
The operator between  ‘d’ and ‘k’ is ‘/’. Resulting expression: *-a(b/c)-(d/k)l.
The operator between  ‘a’ and ‘(b/c)’ is ‘-’. Resulting expression: *(a-(b/c))-(d/k)l.
The operator between  ‘d/k’ and ‘l’ is ‘-’. Resulting expression: *(a-(b/c))((d/k)-l).
The operator between  ‘(a-(b/c))’ and ‘((d/k)-l)’ is ‘*’. Resulting expression: ((a-(b/c))*((d/k)-l)).


Sample Input 2:
*-a/bc-/del


Expected Answer:
((a-(b/c))*((d/e)-l))


Output on console:
((a-(b/c))*((d/e)-l))


Expected Time Complexity:
Try to solve this in O(n^2), where n is the length of expression.


Constraints:
1 <= n <= 500
where n is the length of expression.

Time Limit: 1 sec


-----------Idea behind solution -------------------------
Algorithm for Prefix to Infix: 

Read the Prefix expression in reverse order (from right to left)
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack 
Create a string by concatenating the two operands and the operator between them. 
string = (operand1 + operator + operand2) 
And push the resultant string back to Stack
Repeat the above steps until the end of Prefix expression.
At the end stack will have only 1 string i.e resultant string

*/

import java.util.*;
public class Solution {
    public static String prefixToInfixConversion(String exp) {
        // Write your code here
        Stack<String> st = new Stack<>();
        for(int i=exp.length()-1;i>=0;i--){
            char c = exp.charAt(i);
            if(!Character.isAlphabetic(c)){
                String op1 = st.pop();
                String op2 = st.pop();
                st.push("("+op1+c+op2+")");
            }
            else{
                st.push(c+"");
            }
        }
       return st.peek(); 
    }
}
