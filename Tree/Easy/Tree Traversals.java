/*
Coding Ninja: https://www.codingninjas.com/studio/problems/tree-traversal_981269

Problem statement
You have been given a Binary Tree of 'N'

nodes, where the nodes have integer values.



Your task is to return the ln-Order, Pre-Order, and Post-Order traversals of the given binary tree.



For example :
For the given binary tree:

The Inorder traversal will be [5, 3, 2, 1, 7, 4, 6].
The Preorder traversal will be [1, 3, 5, 2, 4, 7, 6].
The Postorder traversal will be [5, 2, 3, 7, 6, 4, 1].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
1 2 3 -1 -1 -1  6 -1 -1
Sample Output 1 :
2 1 3 6 
1 2 3 6 
2 6 3 1
Explanation of Sample Output 1 :
 The given binary tree is shown below:

Inorder traversal of given tree = [2, 1, 3, 6]
Preorder traversal of given tree = [1, 2, 3, 6]
Postorder traversal of given tree = [2, 6, 3, 1]
Sample Input 2 :
1 2 4 5 3 -1 -1 -1 -1 -1 -1
Sample Output 2 :
5 2 3 1 4 
1 2 5 3 4 
5 3 2 4 1
Explanation of Sample Output 2 :
The given binary tree is shown below:

Inorder traversal of given tree = [5, 2, 3, 1, 4]
Preorder traversal of given tree = [1, 2, 5, 3, 4]
Postorder traversal of given tree = [5, 3, 2, 4, 1]
Constraints :
1 <= 'N' <= 10^5
0 <= 'data' <= 10^5     

where 'N' is the number of nodes and 'data' denotes the node value of the binary tree nodes.

Time limit: 1 sec
==================== Solution Idea ==============================
THis is solved using recursion - 
to imporve spce complexity, use Moris traversal 
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

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        TreeNode inRoot = root;
        TreeNode preRoot = root;
        TreeNode postRoot = root;
        inorder(inRoot, in);
        result.add(in);
        preorder(preRoot, pre);
        result.add(pre);
        postorder(postRoot, post);
        result.add(post);
        return result;
    }
    public static void preorder(TreeNode root, List<Integer> pre){
        if(root == null){
            return;
        }
        pre.add(root.data);
        preorder(root.left, pre);
        preorder(root.right, pre);
    }

    public static void inorder(TreeNode root, List<Integer> in){
        if(root == null){
            return;
        }
        inorder(root.left, in);
        in.add(root.data);
        inorder(root.right, in);
    }

    public static void postorder(TreeNode root, List<Integer> post){
        if(root == null){
            return;
        }
        postorder(root.left, post);
        postorder(root.right, post);
        post.add(root.data);
    }
}
