/*
Coding Ninja: https://www.codingninjas.com/studio/problems/first-negative-integer-in-every-window-of-size-k_1164406
Problem statement
You have been given an array of integers 'ARR' and an integer ‘K’. You need to find the first negative integer in each window of size ‘K’.

Note :
If a window does not contain a negative integer, then print 0 for that window.
For example :
If N = 9, arr[ ] = {-10, 20, -30, -40, 50, 60, -70, 80, 90} and K = 3

then the output will be
{-10 -30 -30 -40 -70 -70 -70}
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10^2
1 <= N <= 10^3
-10^4 <= data <= 10^4
1 <= K <= N

Where ‘N’ is the size of the array, “data” is the value of the element of the array 'ARR' and ‘K’ is the window size.

Time Limit: 1 sec
Sample Input 1:
1
9
-10 20 -30 -40 50 60 -70 80 90
3
Sample Output 1:
-10 -30 -30 -40 -70 -70 -70
Explanation For Sample Input 1:
Here the first negative integer in the window  of size K = 3 is [-10, -30, -30, -40, -70, -70, -70]
Sample Input 2:
1
6
-10 20 30 -40 -50 60
2
Sample Output 2:
-10 0 -40 -40 -50 
Explanation For Sample Input 2:
Here the first negative integer in the window  of size 'K' is [-10, 0, -40, -40, -50]
*/
import java.util.* ;
import java.io.*;

public class Solution 
{
    public static ArrayList<Integer> firstNegativeInteger(ArrayList<Integer> arr, int k, int n)
    {
        //    Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int i =0, j=0;
        while(j<n){
            if(arr.get(j) < 0){
                q.add(arr.get(j));
            }
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                if(q.size() == 0) result.add(0);
                else {
                    if(q.peek() == arr.get(i)) result.add(q.poll());
                    else result.add(q.peek());
                }
                i++;
                j++;
            }
        }
        return result;
    }
}
