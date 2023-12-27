/*
Coding Ninja link: https://www.codingninjas.com/studio/problems/convert-prefix-to-postfix_8391014?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
You are given a string ‘s’ of size ’n’, representing the prefix form of a valid mathematical expression.



Your task is to find out its corresponding postfix expression.



The expected time and space complexity is O(n) and O(n), where ‘n’ is the size of the string ‘s’.



Note:
The only operators used in the expressions are ‘+’, ‘-’, ‘*’, ‘/’.

Example:
Input: ‘n’ = 5, ‘s’ = “/A+BC”

Output: ABC+/

Explanation: For ‘s’ = “/A+BC”, the correct postfix expression is “ABC+/”.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
/A+BC

Sample Output 1 :
ABC+/

Explanation Of Sample Input 1:
Input: ‘n’ = 5, ‘s’ = “/A+BC”

Output: ABC+/

Explanation: For ‘s’ = “/A+BC”, the correct postfix expression is “ABC+/”.


Sample Input 2:
9
-/A+BC*DE

Sample Output 2:
ABC+/DE*-

Explanation of sample output 2:
Input: ‘n’ = 9, ‘s’ = “-/A+BC*DE”

Output: ABC+/DE*-

Explanation: For ‘s’ = “-/A+BC*DE”, the correct postfix expression is “ABC+/DE*-”.

Constraints:
3 <= n < 10^4
The characters in ‘s’ are either one of {‘+’, ‘-’, ‘/’, ‘*’} or is one of the Uppercase Letters.

Time Limit: 1 sec

------------ Idea begind solution --------------
The idea is similar to the idea qwe used to solve the question for converting prefix to infix expression
*/
import java.util.*;
public class Solution {
    public static String preToPost(String s) {
        // Write Your Code Here
        Stack<String> st = new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            char c  = s.charAt(i);
            if(!Character.isAlphabetic(c)){
                String op1 = st.pop();
                String op2 = st.pop();
                st.push(op1+op2+c);
            }
            else{
                st.push(c+"");
            }
        }
        return st.peek();
    }
}



