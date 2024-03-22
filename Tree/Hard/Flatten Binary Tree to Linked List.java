/*
Coding Ninja: https://www.codingninjas.com/studio/problems/flatten-binary-tree-to-linked-list_1112615
Leet Code: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
Problem statement
You are given a binary tree consisting of 'n' nodes.
Convert the given binary tree into a linked list where the linked list nodes follow the same order as the pre-order traversal of the given binary tree.
Use the right pointer of the binary tree as the “next” pointer for the linked list and set the left pointer to NULL.
Use these nodes only. Do not create extra nodes.

Example :
Input: Let the binary be as shown in the figure:

Output: Linked List: 15 -> 40 -> 62 -> 10 -> 20 -> NULL

Explanation: As shown in the figure, the right child of every node points to the next node, while the left node points to null.

Also, the nodes are in the same order as the pre-order traversal of the binary tree.
Detailed explanation ( Input/output format, Notes, Images )
Sample input 1:
15 40 62 -1 -1 10 20 -1 -1 -1 -1


Sample output 1:
15 40 62 10 20


Explanation for Sample Input 1:
The binary tree and the corresponding linked list are given in the following figure:

As shown in the figure, the right child of every node points to the next node, while the left node points to null.
Also, the nodes are in the same order as the pre-order traversal of the binary tree.


Sample Input 2 :
1 2 3 -1 -1 4 -1 5 -1 -1 -1


Sample Output 2 :
1 2 3 4 5


Explanation of sample input 2 :
The binary tree and the corresponding linked list are given in the following figure:

As shown in the figure, the right child of every node points to the next node, while the left node points to null.
Also, the nodes are in the same order as the pre-order traversal of the binary tree, that is [1, 2, 3, 4, 5].


Expected time complexity :
The expected time complexity is O(n).


Constraints:
1 <= 'n' <= 10 ^ 5
1 <= 'data' in any node <= 10^5

Time limit: 1 sec
*/
import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure.

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/

public class Solution 
{
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root)
    {
        // Write your code here.
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		addlist(root,q);
		TreeNode<Integer> source = root;
		root.left = null;
		root.right = q.peek();
		while(!q.isEmpty()){
			TreeNode<Integer> src = q.poll();
			src.left = null;
			src.right = q.peek();
		}
		return source;
    }

	public static void addlist(TreeNode<Integer> root, Queue<TreeNode<Integer>> q){
		if(root == null){
			return;
		}
		if(root.left != null) q.add(root.left);
		addlist(root.left,q);
		if(root.right !=null) q.add(root.right);
		addlist(root.right,q);
	}
}
