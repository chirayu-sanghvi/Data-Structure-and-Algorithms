/*
Coding Ninja: https://www.codingninjas.com/studio/problems/minimum-cost-to-make-string-valid_1115770
Problem statement
Ninja has been given a string ‘STR’ containing either ‘{’ or ‘}’. 'STR’ is called valid if all the brackets are balanced. Formally for each opening bracket, there must be a closing bracket right to it.

For Example:
“{}{}”, “{{}}”, “{{}{}}” are valid strings while “}{}”, “{}}{{}”, “{{}}}{“ are not valid strings.
Ninja wants to make ‘STR’ valid by performing some operations on it. In one operation, he can convert ‘{’ into ‘}’ or vice versa, and the cost of one such operation is 1.

Your task is to help Ninja determine the minimum cost to make ‘STR’ valid.

For Example:
Minimum operations to make ‘STR’ =  “{{“ valid is 1.
In one operation, we can convert ‘{’ at index ‘1’ (0-based indexing) to ‘}’. The ‘STR’ now becomes "{}" which is a valid string.

Note:
Return -1 if it is impossible to make ‘STR’ valid.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 100
0 <= |STR| <= 10^5
STR[i] = ‘{’ or ‘}’

Time Limit: 1 sec 
Sample Input 1:
2
{{{}
{{}{}}
Sample Output 1:
1
0
Explanation For Sample Input 1:
For the first test case:
The two valid strings that can be obtained from  ‘STR’ using minimum operations “{{}}”   and “{}{}”. Ninja can transform ‘STR’ to “{{}}” by performing the following operations:
Convert ‘{’ at index 2 to ‘}’.

Ninja can transform ‘STR’ to “{}{}” by performing the following operations:
Convert ‘{‘ at index 1 to ‘}’.
The minimum number of operations in transforming ‘STR’ to either of the two valid strings is 1.So, the total cost is 1.

For the second test case:
Given ‘STR’ is already valid so the minimum number of 
operations required is 0.
So, the total cost is 0.
Sample Input 2:
3
{}}{}}
{{{{
{{{}}
Sample Output 2:
1
2
-1
*/
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findMinimumCost(String str) {
      if(str.length() % 2 != 0){
        return -1;
      }
		// Write your code here
      int cost = 0;
      Stack<Character> st = new Stack<>();
      for(int i = 0 ;i < str.length();i++){
        char c = str.charAt(i);
        if(c == '{'){
          st.push(c);
        } else if( c == '}' && !st.isEmpty()){
          st.pop();
        } else if( c == '}' && st.isEmpty()){
          cost++;
          st.push('{');
        }
      }

      while(!st.isEmpty()){
        cost ++;
        st.pop();
        st.pop();
      }
      return cost;
    }
}
