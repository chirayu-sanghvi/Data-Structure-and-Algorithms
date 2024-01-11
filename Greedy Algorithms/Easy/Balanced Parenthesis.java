/*
Coding Ninja: https://www.codingninjas.com/studio/problems/balanced-parentheses_8162202
Leet Code: https://leetcode.com/problems/valid-parenthesis-string/description/

Problem statement
Given an expression string 's', check whether the pairs and orders of {}, (), and [] brackets are correct. If the brackets are balanced, the function should return true; otherwise, it should return false.



Example:
's' = {[()]}, the function should return true since all brackets are correctly balanced. 

However, if the string 's' =  "{[()})", the expected behavior for the function is to return false. 

This is because the closing square bracket ']' is mismatched with the closing parenthesis ')', resulting in unbalanced brackets.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
[{}()]
Sample Output 1:
true
Explanation Of Sample Input 1:
's' = [{}()]
Since all the brackets are properly balanced, therefore output is ‘true’.
Sample Input 2:
[(])
Sample Output 2:
false
Explanation Of Sample Input 2:
's' = [(])
Since ‘(‘ bracket is not balanced properly inside “[]” brackets, therefore output is ‘false’.
Constraints:
1 <= 's'.length <= 5*10^4
Time Limit: 1 sec
*/
import java.util.*;
public class Solution {
    public static boolean isBalanced(String S){
        // Write your code here.
        Stack<Character> st = new Stack<>();
        int n = S.length();
        for(int i=0;i<n;i++){
            char a = S.charAt(i);
            if(a=='{' || a=='[' || a== '('){
                st.push(a);
            }
            else if(st.isEmpty()){
                return false;
            }
            else if(a == ')' && st.peek() != '('){
                    return false;
            }
            else if(a == '}' && st.peek() != '{'){
                    return false;
            }
            else if(a == ']' && st.peek() != '['){
                    return false;
            }
            else{
                st.pop();
            }
        }
        if(st.isEmpty())
        return true;
        return false;
    }
    
}
