/*
Coding Ninja: https://www.codingninjas.com/studio/problems/binary-search-trees_8160443
Problem statement
You are given an array ‘order’ which represents the inorder traversal of a binary search tree.



Find out if this traversal is valid or not.



Note: All values in the BST must be unique.

For Example:

‘order’ = {1, 2, 3, 4,5} is a valid inorder traversal for the following binary search tree:
      4
     / \
    2   5
   / \
  1   3
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= ‘N’ <= 10^5
1 <= ‘order[i]’ <= 10^9
Time Limit: 1 sec
Sample Input 1:
6
2 3 5 8 9 10
Sample Output 1:
true   
Explanation of sample output 1:
In this testcase, ‘order’ = {2, 3, 5, 8, 9, 10} is a valid inorder traversal for the following binary search tree:

      8
    /   \
  3      9
 / \       \
2   5       10
Sample Input 2:
4
1 2 1 4
Sample Output 2:
false


====================== Solution Idea =============================
Point to Remember: Inorder traversal of a BST is sorted and does not contain duplicates.
Check if the array is sorted in inorder traversal and it should not contain duplicates. 
If this condition satisfies then return true else return false.
*/
public class Solution {  
    public static boolean isValidBST(int []order){        
        // Write your code here.        
        int n=order.length-1;        
        for(int i=0;i<n;i++){            
            if(order[i]>=order[i+1]){                
                return false;            
            }        
        }
        return true;  
    } 
}  
