/*
Coding Ninja: https://www.codingninjas.com/studio/problems/longest-common-subsequence_624879

Problem statement
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.

For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.

Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.

*/

// Dynamic Programming (Bottom Up) Solution
import java.util.*;
import java.io.*;

public class Solution {
 static int mod=1000000007;
public static int findWays(int num[], int tar) {
    int n=num.length;
    return bottomUp(n,tar,num);
}  
  
    
public static int bottomUp(int n,int sum,int[] arr){
    int[][] t=new int[n+1][sum+1];
    t[0][0] = 1;
    for(int i=1; i<n+1; i++) {
        for(int j=0; j<sum+1; j++) {
            if(arr[i-1] <= j) {
              t[i][j] = (t[i-1][j] + t[i-1][j-arr[i-1]])%mod; 
            } 		         		
            else{
               t[i][j] = t[i-1][j];
            }
        }
    }
    return t[n][sum]%mod;
}    
}
