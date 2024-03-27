/*
Coding Ninja: https://www.naukri.com/code360/problems/construct-binary-tree-from-inorder-and-postorder-traversal_1266106
Leet Code: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Problem statement
You are given arrays 'inOrder' and 'postOrder', which represent 'inorder' traversal and 'postorder' traversal of a 'Binary Tree' respectively.
Construct a 'Binary Tree' represented by the given arrays and return it's head.
Note:
Assume that the Binary Tree contains only unique elements.


Example:
Input: 'inOrder' = [9, 3, 15, 20, 7], 'postOrder' = [9, 15, 7, 20, 3]

Output:
We get the following binary tree from Inorder and Postorder traversal:


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
7
4 5 2 6 7 3 1
4 2 5 1 6 3 7


Output on console:
1 2 3 4 5 6 7


Explanation for Sample Output 1:
We get the following Binary Tree from the given Inorder and Postorder traversal:


Sample Input 2:
6
2 9 3 6 10 5
2 6 3 9 5 10


Sample Output 2:
5 6 10 2 3 9


Explanation for Sample Output 2:
We get the following Binary Tree from the given Inorder and Postorder traversal:


Expected Time Complexity:
Try to solve this in O(n).


Constraints :
1 <= 'n' <= 10000
1 <=  'inOrder[i]' , ‘postOrder[i]’ <= 100000  

Time Limit: 1 second
*/
/*******************************************************
 Following is the TreeNode class structure

 class TreeNode<T> {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     public TreeNode(T x) {
         this.data = x;
         this.left = null;
         this.right = null;
     }
 };
 *******************************************************/
import java.util.*;
public class Solution {
    public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
        // Write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i =0;i< inOrder.length;i++){
            hm.put(inOrder[i], i);
        }
        TreeNode root = buildTree(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1,hm);
        return root;
    }

    public static TreeNode buildTree(int[] postOrder, int poststart, int postend, int[] inOrder, int instart, int inend, HashMap<Integer, Integer> hm){
        if(poststart > postend || instart > inend) return null;

        TreeNode root = new TreeNode(postOrder[postend]);
        int inRoot = hm.get(root.data);
        int numsLeft = inRoot - instart;

        root.left = buildTree(postOrder, poststart, poststart + numsLeft - 1, inOrder, instart, inRoot - 1, hm);
        root.right = buildTree(postOrder, poststart + numsLeft, postend - 1, inOrder, inRoot + 1, inend, hm);
        return root;
    }
}
