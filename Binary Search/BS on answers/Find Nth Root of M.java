/*
Coding Ninja: https://www.codingninjas.com/studio/problems/nth-root-of-m_1062679
Problem statement
You are given two positive integers 'n' and 'm'. You have to return the 'nth' root of 'm', i.e. 'm(1/n)'. If the 'nth root is not an integer, return -1.

Note:
'nth' root of an integer 'm' is a number, which, when raised to the power 'n', gives 'm' as a result.


Example:
Input: ‘n’ = 3, ‘m’ = 27

Output: 3

Explanation: 
3rd Root of 27 is 3, as (3)^3 equals 27.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3 27


Sample Output 1:
3


Explanation For Sample Input 1:
3rd Root of 27 is 3, as (3)^3 equals 27.


Sample Input 2:
4 69


Sample Output 2:
-1


Explanation For Sample Input 2:
4th Root of 69 is not an integer, hence -1.


Expected Time Complexity:
Try to do this in O(log(n+m)).


Constraints:
1 <= n <= 30
1 <= m <= 10^9

Time Limit: 1 sec.
*/
public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low = 1;
        int high = m;
        int mid = 0;
        while(low <= high){
            mid = (int)(low+high)/2;
            int val = (int)Math.pow(mid,n);
            if(val == m){
                return mid;
            }
            else if(val > m){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}

