/*
Coding Ninja: https://www.codingninjas.com/studio/problems/check-bst_5975
Problem statement
Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree). If yes, return true, return false otherwise.

Note:
Duplicate elements should be kept in the right subtree.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= Number of edges <= 10^5
Time Limit: 1 second
Sample Input 1 :
3 1 5 -1 2 -1 -1 -1 -1

Sample Output 1 :
true
Sample Input 2 :
5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1

Sample Output 2 :
false
=============================== Solution Idea ======================================
Use recursion and logical && and || operations accordingly
*/
/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

 */

public class Solution {

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

	public static boolean checkBST(BinaryTreeNode<Integer> root, long min, long max){
		if(root == null){
			return true;
		}
		if(root.data > max || root.data < min){
			return false;
		}
		return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
	}
	
}
