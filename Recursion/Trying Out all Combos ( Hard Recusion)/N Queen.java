/*
Coding Ninja: https://www.codingninjas.com/studio/problems/n-queens_696453
Leet Code: https://leetcode.com/problems/n-queens/description/
 N Queens
Hard
120/120
Average time to solve is 36m
Contributed by
16 upvotes
Problem statement
You are given 'N', and for a given 'N x N' chessboard. Find a configuration of 'N' queens such that no queen can attack any other queen on the chess board.



A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to return all such configurations.



Note:
If no such configuration is present return an empty array, it will be represented as 'No Configuration' in the output.
For Example:
For a chessboard of size 4*4
The configurations are 

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0 
Explanation:
The first and second configuration are shown in the image above in example.
Sample Input 2:
3
Sample Output 2 :
'No Configuration'
Constraints :
1 <= N <= 10
Time Limit: 1 second

*/
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List< List< Integer > > nQueens(int n)
    {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                arr[i][j] = 0;
            }
        }
        findq(0, arr, result);
        return result;
    }

    public static void findq(int col, int arr[][], List<List<Integer>> result){
        if(col == arr.length){
            result.add(construct(arr));
            return;
        }

        for(int row = 0;row<arr.length;row++){
            if(validate(arr, row, col)){
                arr[row][col] = 1;
                findq(col+1,arr,result);
                arr[row][col] = 0;
            }
        }
    }

    public static boolean validate(int[][] arr, int row, int col){
        int duprow = row;
        int dupcol = col;

        while(row >= 0 && col >= 0){
            if(arr[row][col] == 1)
                return false;
            row --;
            col --;
        }

        row = duprow;
        col = dupcol;

        while(col >= 0){
            if(arr[row][col] == 1)
                return false;
            col--;
        }

        row = duprow;
        col = dupcol;

        while(row < arr.length && col >= 0){
            if(arr[row][col] == 1)
                return false;
            row++;
            col--;
        }
        return true;
    }

    public static List<Integer> construct(int[][] arr){
        List<Integer> res = new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            for(int j = 0;j<arr.length;j++){
                res.add(arr[i][j]);
            }
        }
        return res;
    }
}
