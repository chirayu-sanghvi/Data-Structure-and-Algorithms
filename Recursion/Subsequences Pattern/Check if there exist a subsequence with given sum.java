/*
Coding Ninja: https://www.codingninjas.com/studio/problems/subset-sum_630213

Problem statement
You are given an array 'A' of 'N' integers. You have to return true if there exists a subset of elements of 'A' that sums up to 'K'. Otherwise, return false.

For Example
'N' = 3, 'K' = 5, 'A' = [1, 2, 3].
Subset [2, 3] has sum equal to 'K'.
So our answer is True.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 13
4 3 5 2
Sample Output 1 :
No
Sample Input 2 :
5 14
4 2 5 6 7
Sample Output 2 :
Yes
Constraints :
1 <= 'N' <= 10^3
1 <= 'A[i]' <= 10^3
1 <= 'K' <= 10^3
Time Limit: 1 sec
*/
public class Solution {
    public static boolean isSubsetPresent(int n, int k,int []a) {
        // Write your code here
        int start = 0;
        int currentsum = 0;
        return checksum(n,k,a,start,currentsum);
        
    }

    public static boolean checksum(int n,int k, int[] a,int start,int currentsum){
        if(currentsum == k){
            return true;
        }
        if(currentsum > k || start >= n){
            return false;
        }
        return (checksum(n,k,a, start+1,currentsum+a[start]) || checksum(n,k,a,start+1, currentsum));
    }
}
