/*
Coding Ninja: https://www.codingninjas.com/studio/problems/postorder-traversal_2035933
*/
/*******************************************************
 Following is the TreeNode class structure

 class TreeNode<T> {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     public TreeNode() {
         this.data = null;
         this.left = null;
         this.right = null;
     }

     public TreeNode(T x) {
         this.data = x;
         this.left = null;
         this.right = null;
     }

     public TreeNode(T x, TreeNode<T> left, TreeNode<T> right) {
         this.data = x;
         this.left = left;
         this.right = right;
     }
 };
 *******************************************************/

import java.util.List;
import java.util.*;
public class Solution {
    public static List<Integer> postorderTraversal(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
	}

    public static void inorder(TreeNode<Integer> root, List<Integer> result){
        if(root == null){
			return;
		}
        inorder(root.left,result);
		inorder(root.right,result);
        result.add(root.data);
    }
}
