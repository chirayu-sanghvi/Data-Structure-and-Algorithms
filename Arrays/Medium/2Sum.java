/*
Coding Ninja: https://www.codingninjas.com/studio/problems/reading_6845742?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
Sam want to read exactly ‘TARGET’ number of pages.

He has an array ‘BOOK’ containing the number of pages for ‘N’ books.

Return YES/NO, if it is possible for him to read any 2 books and he can meet his ‘TARGET’ number of pages.

Example:
Input: ‘N’ = 5, ‘TARGET’ = 5
‘BOOK’ = [4, 1, 2, 3, 1] 

Output: YES
Explanation:
Sam can buy 4 pages book and 1 page book.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5 5
4 1 2 3 1
Sample Output 1 :
YES
Explanation Of Sample Input 1:
Sam can buy 4 pages book and 1-page book.
Sample Input 2:
2 1
1 2
Sample Output 2 :
NO
Expected Time Complexity:
O( N ), Where N is the length of the array.
Constraints:
1  <= N <= 10^3
1 <= BOOK[i], TARGET <= 10^6
Time Limit: 1 sec

================= Solution Idea ===============================
Using HashMap to keep track of the target - book page value
*/
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static String read(int n, int []book, int target){
        // Write your code here.
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i = 0;i<n;i++){
            if(!hm.containsKey(book[i])){
                hm.put(book[i],1);
            }
            else{
                hm.put(book[i],hm.get(book[i])+1);
            }
        }

        for (HashMap.Entry<Integer, Integer> entry : hm.entrySet()) {
            int x = target - entry.getKey();
            if(x == entry.getKey() && entry.getValue() > 1){
                return "YES";
            }
            else if(hm.containsKey(x)){
                return "YES";
            }
        }
        return "NO";
    }
}
