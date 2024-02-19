/*
Coding Ninja: https://www.codingninjas.com/studio/problems/word-search---l_892986
Leet Code: https://leetcode.com/problems/word-search/description/
Problem statement
You are given a 2D board('N' rows and 'M' columns) of characters and a string 'word'.
Your task is to return true if the given word exists in the grid, else return false. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.

Note:
The same letter cell should not be used more than once.
For Example:
For a given word “design” and the given 2D board 
[[q’, ‘v’, ‘m’, ‘h’],
 [‘d’, ‘e’, ‘s’, ‘i’],
 [‘d’, ‘g’, ‘f’, ‘g’],
 [‘e’, ‘c’, ‘p’, ‘n’]]

The word design can be formed by sequentially adjacent cells as shown by the highlighted color in the 2nd row and last column.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
coding
4 4
c z k l
o d i a
r g n m
m r s d
Sample Output 1:
true
Explanation For Sample Input 1:
For the given word, and grid we can construct from letters of sequentially adjacent cells as shown below:

Sample Input 2:
ninjas
4 4
c d k s
o d s i
d g n j
e r i n
Sample Output 2:
false
Constraints:
1 <= N <= 6
1 <= M <= 6
1 <= |word| <=20

Time Limit: 1 sec
*/
public class Solution {
    public static boolean present(char [][]board, String word, int n, int m) {
        // Write your code here.
        
        int len = word.length();
        int index = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(index)){
                    if(WordSearch(board, word, n, m, len, index, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean WordSearch(char[][] board, String word, int n, int m, int len, int index, int i, int j){
        if(index == len){
            return true;
        }

        if(i<0 || j < 0 || i == n || j == m || board[i][j] != word.charAt(index) || board[i][j] == '!'){
            return false;
        }
        char c = board[i][j];
        int row[] = {-1, 0, +1, 0};
        int col[] = {0, +1, 0, -1};
        boolean top = WordSearch(board, word, n, m, len, index+1, i+row[0], j+col[0]);
        boolean bottom = WordSearch(board, word, n, m, len, index+1, i+row[1], j+col[1]);
        boolean right = WordSearch(board, word, n, m, len, index+1, i+row[2], j+col[2]);
        boolean left = WordSearch(board, word, n, m, len, index+1, i+row[3], j+col[3]);
        board[i][j] = c;
        return top || bottom || right || left;

    }
}
