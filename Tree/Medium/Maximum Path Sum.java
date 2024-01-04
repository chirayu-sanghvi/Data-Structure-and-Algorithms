/*
Coding Ninja: https://www.codingninjas.com/studio/problems/maximum-sum-path-of-a-binary-tree._1214968
Leet Code: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

Problem statement
You are given a binary tree having 'n' nodes. Each node of the tree has an integer value.
Your task is to find the maximum possible sum of a simple path between any two nodes (possibly the same) of the given tree.
A simple path is a path between any two nodes of a tree, such that no edge in the path is repeated twice. The sum of a simple path is defined as the summation of all node values in a path.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
1 2 3 4 -1 -1 -1 -1 -1
Sample Output 1:
10
Explanation For Sample Input 1:
The tree looks as follows:
                        1
                       / \
                      2   3 
                     /
                    4
The path between Node 3 (with value 3) and Node 4 (with value 4) produces the maximum sum, i.e., 10. Hence, the maximum possible sum is 10 in this case.
Sample Input 2:
2 4 -1 3 6 -1 -1 -1 -1 
Sample Output 2:
13
Explanation For Sample Input 2:
The tree looks as follows:
                        2
                       / 
                      4    
                     / \   
                    3   6
The path between Node 3 (with value 3) and Node 4 (with value 6) produces the maximum sum, i.e., 13. Hence, the maximum possible sum is 13 in this case.
Expected time complexity:
 The expected time complexity is O(n).
Constraints:
1 <= 'n' <= 10^6
-10^5 <= 'data' <= 10^5 and 'data' !=-1

Where ‘n’ is the total number of nodes in the binary tree, and 'data' is the value of the binary tree node

Time Limit: 1 sec
*/

/************************************************************

 Following is the BinaryTreeNode class structure
 class BinaryTreeNode<T>
 {
     public:
     T data;
     BinaryTreeNode<T> left;
     BinaryTreeNode<T> right;
    
     BinaryTreeNode(T data)
     {
         this.data = data;
         left = null;
         right = null;
     }
 };
 ************************************************************/
public class Solution {
    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        // Write your code here

        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        height(root, max);
        return max[0];
    }

    public static int height(BinaryTreeNode<Integer> root, int[] max){
        if(root == null){
            return 0;
        }
        int lh = Math.max(0,height(root.left,max));
        int rh = Math.max(0,height(root.right, max));
        max[0] = Math.max(max[0], root.data + lh + rh);
        return root.data + Math.max(lh,rh);
    }
}
