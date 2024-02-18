/*
Coding Ninja: https://www.codingninjas.com/studio/problems/row-of-a-matrix-with-maximum-ones_982768
Problem statement
You are given a 2D matrix 'ARR' (containing either ‘0’ or ‘1’) of size 'N' x 'M', where each row is in sorted order.
Find the 0-based index of the first row with the maximum number of 1's.
Note :
If two rows have the same number of 1’s, return the row with a lower index.

If no row exists where at-least one '1' is present, return -1.

Example:
Input: ‘N’ = 3, 'M' = 3
'ARR' = 
[     [ 1,  1,  1 ],
      [ 0,  0,  1 ],
      [ 0,  0,  0 ]   ]

Output: 0

Explanation: The 0th row of the given matrix has the maximum number of ones.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 3
1  1  1
0  0  1
0  0  0
Sample Output 1 :
0
Explanation of Input 1 :
The 0th row of the given matrix has the maximum number of ones.
Sample Input 2:
2 2
1  1
1  1
Sample Output 2:
0
Explaination of Sample Output 2:
The 0th and 1st rows of the given matrix have the maximum number of ones, so we will output the lower index value.
Sample Input 3 :
2 1
0
0
Sample Output 3 :
-1
Explaination of Sample Output 3:
No row is present where at-least one '1' is present. Hence the answer is -1.
Constraints :
1 ≤ N, M ≤ 100
0 ≤ ARR[i][j] ≤ 1

Where ARR[i][j] denotes the matrix elements.

Time Limit: 1 sec 

*/
// Linear Search Solution
import java.util.ArrayList;
public class Solution
{
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> arr, int n, int m)
    {
        //	  Write your code here.
        int count = 0;
        int index = -1;
        int sum = 0;
        for(int i =0;i<n;i++){
            sum = 0;
            for(int j=0;j<m;j++){
                sum = sum + arr.get(i).get(j);

            }
            if(sum > count){
                    index = i;
                    count = sum;
            }
        }
    return index;
    }
}

