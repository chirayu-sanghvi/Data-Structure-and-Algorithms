/*
Coding Ninja Link: https://www.codingninjas.com/studio/problems/day-23-:-infix-to-postfix-_1382146?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
You are given a string 'exp' which is a valid infix expression.



Convert the given infix expression to postfix expression.



Note:
Infix notation is a method of writing mathematical expressions in which operators are placed between operands. 

For example, "3 + 4" represents the addition of 3 and 4.

Postfix notation is a method of writing mathematical expressions in which operators are placed after the operands. 

For example, "3 4 +" represents the addition of 3 and 4.

Expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’. 


Example:
Input: exp = ‘3+4*8’

Output: 348*+

Explanation:
Here multiplication is performed first and then the addition operation. Hence postfix expression is  3 4 8 * +.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3^(1+1)

Expected Answer:
311+^


Output printed on console:
311+^


Explanation of Sample Input 1:
For this testcase, we will evaluate 'b' = (1+1) first. 

Hence it's equivalent postfix expression will be "11+". 

Next we will evaluate 3^b. It's equivalent postfix expression will be "3b^". 

Replacing 'b' with it's equivalent postfix we get "311+^".


Sample Input 2:
a+b+c+d-e


Expected Answer:
ab+c+d+e-


Output printed on console:
ab+c+d+e-


Expected Time Complexity:
Try to do this in O(n).


Constraints:
1 <= 'n' <= 5000 

‘n’, is the length of EXP
The expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’. 

Time Limit: 1 sec

-------------- This is a O(n) time complexity solution ---------------------------------
*/

import java.util.*;
public class Solution {

            static int precedence(char c){
            if (c == '^')
                return 3;
            else if (c == '/' || c == '*')
                return 2;
            else if(c =='+' || c == '-')
                return 1;
            else
                return -1;
        }

    public static String infixToPostfix(String exp) {
        // Write your code here
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);

            if(Character.isLetterOrDigit(c))
                str.append(c);
            else if (c == '(')
                st.push(c);
            else if (c == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    str.append(st.pop());
                }
                st.pop();
            }
            else {
                while(!st.isEmpty() && (precedence(c) < precedence(st.peek()) || precedence(c) == precedence(st.peek()))){
                    str.append(st.pop());
                }
                st.push(c);
            }
        }

        while(!st.isEmpty()){
            str.append(st.pop());
        }

        return str.toString();
    }
}
