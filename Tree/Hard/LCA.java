/*
Coding Ninja: https://www.codingninjas.com/studio/problems/lca-of-binary-tree_920541
Leet Code: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

Problem statement
You have been given a Binary Tree of distinct integers and two nodes ‘X’ and ‘Y’. You are supposed to return the LCA (Lowest Common Ancestor) of ‘X’ and ‘Y’.



The LCA of ‘X’ and ‘Y’ in the binary tree is the shared ancestor of ‘X’ and ‘Y’ that is located farthest from the root.



Note :
You may assume that given ‘X’ and ‘Y’ definitely exist in the given binary tree.
For example :
For the given binary tree

LCA of ‘X’ and ‘Y’ is highlighted in yellow colour.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
1 2 3 4 7 -1 -1 -1 -1 -1 -1
4 7
Sample Output 1 :
2
Explanation of Sample Input 1 :

Sample Input 2 :
1 2 3 -1 -1 -1 -1
2 3
Sample Output 2 :
1
Constraints :
0 <= 'N' <= 3000
0 <= 'DATA' <= 10^4

Where 'DATA' is a node value of the binary tree.

Time Limit: 1 sec
*/
/************************************************************

 Following is the TreeNode class structure

 class TreeNode<T>
 {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     TreeNode(T data)
     {
         this.data = data;
         left = null;
         right = null;
     }
 };

 ************************************************************/

public class Solution {
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        //    Write your code here.
        if(root == null){
            return -1;
        }

        if(root.data == x || root.data == y){
            return root.data;
        }

        int l = lowestCommonAncestor(root.left, x, y);
        int r = lowestCommonAncestor(root.right, x, y);

        if(l == -1){
            return r;
        }
        else if(r == -1) {
            return l;
        }
        else{
            return root.data;
        }

    }

}
