/*
Coding Ninja: https://www.codingninjas.com/studio/problems/inorder-traversal_3839605
*/
/*
    Following is the TreeNode class structure:

    public class TreeNode {
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
*/

import java.util.List;
import java.util.*;
public class Solution {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
	}

    public static void inorder(TreeNode root, List<Integer> result){
        if(root == null){
			return;
		}
        inorder(root.left,result);
		result.add(root.data);
		inorder(root.right,result);
    }
}
