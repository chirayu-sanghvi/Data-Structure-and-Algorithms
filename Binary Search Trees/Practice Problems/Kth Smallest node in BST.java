/*
Coding Ninja: https://www.codingninjas.com/studio/problems/kth-smallest-node-in-bst_920441
Leet Code: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

Problem statement
You have been given a Binary Search Tree of integers. You are supposed to return the k-th (1-indexed) smallest element in the tree.



For example:
For the given binary search tree and k = 3

The 3rd smallest node is highlighted in yellow colour.   
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3
10 5 15 4 7 14 16 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
7
Explanation of Sample Input 1:

The third-smallest node is 7.
Sample Input 2:
2
-2 -4 1 -5 -1 -1 -1 -1 -1
Sample Output 2:
-4
Explanation of Sample Input 2:
The second-smallest node is -4.
Constraints:
1 <= N <= 10000
1 <= K <= N
-10^8 <= data <= 10^8 and data != -1

Where ‘N’ is the total number of nodes in the binary search tree, ‘K’ is the given integer and “data” is the value of the binary search tree node.

Time Limit: 1sec
================ Solution Idea =====================
the inorder traversal of a BST is always sorted, Hence find the 
inorder traversal of the BST and then return the Kth smallest element from the result obtained.
*/


/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/
import java.util.*;
public class Solution {
    public static int kthSmallest(TreeNode root, int k) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return -1;
        }
        inorder(root,result);
        return (int)result.get(k-1);
    }

    public static void inorder(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        inorder(root.left,result);
        result.add(root.data);
        inorder(root.right,result);
    }
}
