/*
Coding Ninja: https://www.codingninjas.com/studio/problems/merge-two-bsts_920474
Leet Code: https://leetcode.com/problems/binary-search-tree-iterator/description/

Problem statement
You are given two binary search trees of integers having ‘N’ and ‘M’ nodes. Return an array that contains elements of both BST in sorted order.

A binary search tree (BST) is a binary tree data structure with the following properties.

• The left subtree of a node contains only nodes with data less than the node’s data.

• The right subtree of a node contains only nodes with data greater than the node’s data.

• Both the left and right subtrees must also be binary search trees.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
2 1 3 -1 -1 -1 -1
4 -1 -1
Sample Output 1:
1 2 3 4 
Explanation For Sample Output 1:
 The given BST are:-


The output will be 1 2 3 4
Sample Input 2:
4 2 7 -1 3 -1 -1 -1 -1  
5 1 7 -1 -1 -1 -1
Sample Output 2:
1 2 3 4 5 7 7 
Constraints:
1 <= 'N', 'M' <= 10^5

Time Limit: 1 sec
=================================== Solution Idea ==================================
Run Level Order traversal on both bsts and save the reult in a universal arraylist
Sort the arrayList and return the arrayslist, that the final result.
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
     TreeNode(int val) {
         this.data = val;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.data = val;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Solution {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // Write your code here.
        List<Integer> lot = new ArrayList<>();
        LevelOrderTraversal(root1, lot);
        LevelOrderTraversal(root2,lot);
        Collections.sort(lot);
        return lot;
    }

    public static void LevelOrderTraversal(TreeNode root, List<Integer> lt){
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            lt.add(current.data);
            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }
        }
    }
}
