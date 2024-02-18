/*
Coding Ninja: https://www.codingninjas.com/studio/problems/search-in-a-sorted-2d-matrix_6917532
Leet Code: https://leetcode.com/problems/search-a-2d-matrix-ii/description/
Problem statement
You are given a 2D matrix ‘MATRIX’ of ‘N’*’M’ dimension. You must check whether a given number ‘target’ is present in the matrix.



The following properties apply to the given matrix:

1. In each row, integers are sorted from left to right.
2. Each row's first integer is greater than the previous row's last integer.
Example:

Input:
'MATRIX' = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60] ], 'TARGET' = 3 
Output:1
Explanation: Since the given number ‘TARGET’ is present in the matrix, we return true.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3 3
1 3 7
10 12 15
19 20 21
12
Sample Output 1:
1
Explanation Of Sample Input 1:
Input:
'MATRIX' = [ [1, 3, 7], [10, 12, 15], [19, 20, 21] ], 'TARGET' = 12 
Output: 1

Explanation: Since the given number ‘TARGET’ is present in the matrix, we return true.
Sample Input 2:
4 4
1 5 9 13
14 15 16 17
19 20 21 50
59 60 71 80
80
Sample Output 2:
1
Constraints:
1 <= 'N', 'M' <=10^5
1 <= 'MATRIX [ i ] [ j ]', 'TARGET' <= 10^9
The sum of N*M over all test cases is less than 2*10^5.
Time Limit: 1 sec
*/
import java.util.*;
public class Solution {
    public static boolean searchElement(int [][]MATRIX, int target) {
        // Write your code here.
        int n = MATRIX.length;
        int m = MATRIX[0].length;
        int i = 0;
        while(i < n){
            if(MATRIX[i][m-1] ==  target){
              return true;
            }
            if(MATRIX[i][m-1] < target){
                i++;
                continue;
            }
            int low = 0;
            int high = m-1;
            int mid = 0;
            while(low <= high){
                mid = (int)(low+high)/2;
                if(MATRIX[i][mid] == target){
                    return true;
                }
                else if(MATRIX[i][mid] < target){
                    low = mid+1;
                }
                else{
                    high = mid -1;
                }
            }
            i++;
        }
        return false;
        
    }
}

