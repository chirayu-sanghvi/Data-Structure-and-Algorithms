/*
Coding Ninja: https://www.naukri.com/code360/problems/construct-binary-tree-from-inorder-and-preorder-traversal_920539
Leet Code: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Problem statement
You have been given the preorder and inorder traversal of a binary tree. Your task is to construct a binary tree using the given inorder and preorder traversals.
Note:
You may assume that duplicates do not exist in the given traversals.
For example :
For the preorder sequence = [1, 2, 4, 7, 3] and the inorder sequence = [4, 2, 7, 1, 3], we get the following binary tree.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
1 2 4 7 3
4 2 7 1 3
Sample Output 1:
1 2 3 4 7

1 2 3
Explanation of Sample Input 1:
The tree after the construction is shown below.

Sample Input 2:
2
1 2
2 1
Sample Output 2:
1 2
Constraints:
1 <= N <= 3000
1 <= data <= 10^4

Where ‘N’ is the total number of nodes in the binary tree, and “data” is the value of the binary tree node.
Time Limit: 1sec
Follow-up:
Can you solve this in O(N) time complexity?
*/
import java.util.HashMap;

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

public class Solution {
    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        // Write your code here.
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i< inorder.length;i++){
            hm.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length - 1, hm);
        return root;
    }

    public static TreeNode buildTree(int [] preorder, int prestart, int preend, int[] inorder, int instart, int inend, HashMap<Integer, Integer> hm){
        if(prestart > preend || instart > inend ) return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int inRoot = hm.get(root.data);
        int numsLeft = inRoot - instart; // Number of nodes in left subtree
        root.left = buildTree(postOrder, poststart, poststart + numsLeft - 1, inOrder, instart, inRoot - 1, hm);
        root.right = buildTree(postOrder, poststart + numsLeft, postend - 1, inOrder, inRoot + 1, inend, hm);
        // int nodesLeft = inRoot - instart;
        // root.left = buildTree(preorder, prestart+1,prestart + nodesLeft, inorder, instart, inRoot - 1, hm);
        // root.right = buildTree(preorder, prestart + nodesLeft + 1, preend, inorder, inRoot + 1, inend, hm);
        return root;
    }
}
