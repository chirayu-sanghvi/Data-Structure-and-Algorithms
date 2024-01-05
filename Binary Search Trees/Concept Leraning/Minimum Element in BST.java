/*
Coding Ninja: https://www.codingninjas.com/studio/problems/minimum-element-in-bst_8160462
Problem statement
You are given a Binary Search Tree.



Find the minimum value in it.



Note:
All the values in the given binary search tree are unique.


Example:
Input : 6 4 7 2 5 N N

Output: 2

Explanation:
For the given input BST is:

      6
     / \
   4    7
  / \
 2   5

Minimum value in this tree is ‘2’.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
8 5 N 3 6

Sample Output 1:
3   


Explanation of sample output 1:
BST for the given input looks like following:
    8
   / 
  5
 / \
3   6 
Thus the minimum value in this BST is ‘3’.

Sample Input 2:
5 3 6 2 4 N N 

Sample Output 2:
2


Expected Time Complexity:
Try to do this in O(n), where 'n' is the number of nodes in the binary search tree.

Constraints:
0 <= ‘n’ <= 10^5
Time Limit: 1 sec

Where 'n' is the number of nodes in the binary tree.

================================ Solution Idea =============================
Go as left as possible, and return the last element right before root became null.

*/
public class Solution
{
    public static int minValue(Node root) {
        // Write your code here.
        if(root==null) return -1;
        Node curr=root;
        while(curr.left!=null) curr=curr.left;
        return curr.data;
    }
}
