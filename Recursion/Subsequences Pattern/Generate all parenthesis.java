/*
Coding Ninja: https://www.codingninjas.com/studio/problems/-binary-strings-with-no-consecutive-1s._893001

Problem statement
You have been given an integer 'N'. Your task is to generate and return all binary strings of length 'N' such that there are no consecutive 1's in the string.
A binary string is that string which contains only ‘0’ and ‘1’.

For Example:
Let ‘N'=3, hence the length of the binary string would be 3. 

We can have the following binary strings with no consecutive 1s:
000 001 010 100 101 
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
Sample Output 1:
0000 0001 0010 0100 0101 1000 1001 1010 
Explanation of sample input 1:
For N = 4 we get the following Strings:

0000 0001 0010 0100 0101 1000 1001 1010 

Note that none of the strings has consecutive 1s. Also, note that they are in a lexicographically increasing order.
Sample Input 2:
2
Sample Output 2:
00 01 10
Constraints:
1 <= 'N' <= 20

Time limit: 1 second

=========================== Solution Idea ==========================
Use Recursion to generate all string as per the conditions
*/
import java.util.List;
import java.util.*;
public class Solution {
    public static List< String > generateString(int N) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<String>();
        if(N==0){
            return result;
        }
        char[] str = new char[N];
        str[0] = '0';
        generateFurtherString(N,str,1,result);

        str[0] = '1';
        generateFurtherString(N,str,1,result);
        Collections.sort(result);
        return result;
    }

    public static void generateFurtherString(int N, char str[], int k, ArrayList<String> result){
        if(k == N){
            result.add(new String(str));
            return; 
        }

        if(str[k-1]=='1'){
            str[k] = '0';
            generateFurtherString(N, str, k+1, result);
        }

        if(str[k-1] == '0'){
            str[k] = '1';
            generateFurtherString(N, str, k+1, result);
            str[k] = '0';
            generateFurtherString(N, str, k+1, result);
        }
    }
}
