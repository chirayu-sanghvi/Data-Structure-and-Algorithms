/*
Coding Ninja: https://www.codingninjas.com/studio/problems/search-in-bst_1402878

Problem statement
There is a Binary Search Tree (BST) consisting of ‘N’ nodes. Each node of this BST has some integer data.



You are given the root node of this BST, and an integer ‘X’. Return true if there is a node in BST having data equal to ‘X’, otherwise return false.



A binary search tree (BST) is a binary tree data structure that has the following properties:

1. The left subtree of a node contains only nodes with data less than the node’s data.

2. The right subtree of a node contains only nodes with data greater than the node’s data.

3. The left and right subtrees must also be binary search trees.
Note:
It is guaranteed that all nodes have distinct data.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
7 8
4 2 6 1 3 5 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
False
Explanation For Sample Input 1:
There is no node having data 8. See the problem statement for the picture of this BST.
Sample Input 2:
4 1
3 1 5 -1 2 -1 -1 -1 -1
Sample Output 2:
True
Explanation For Sample Input 1:
There is a left node, and it has data 1. Thus, we should print ‘True’. 
Constraints:
1 <= N <= 10000
0 <= X <= 10^9
0 <= DATA <=10^9

Where ‘N’ is the number of nodes in the BST, ‘X’ is a given integer and ‘DATA’ is the data contained in each node of BST.

Time limit: 1 sec
*/
/*********************************************************

 Following is the BinaryTreeNode structure:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;
     BinaryTreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

public class Solution {
    public static boolean searchInBST(BinaryTreeNode root, int x) {
        // Write your code here.
        while(root != null){
            if(root.data == x){
                return true;
            }
            root = root.data <= x ? root.right: root.left;
        }
        return false;
    }
}
