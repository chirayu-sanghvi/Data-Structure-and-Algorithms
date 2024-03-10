/*
Coding Ninja: https://www.codingninjas.com/studio/problems/all-root-to-leaf-paths-in-binary-tree._983599
Leet Code: 
Problem statement
You are given an arbitrary binary tree consisting of 'N' nodes numbered from 1 to 'N'. Your task is to print all the root to leaf paths of the binary tree.

A leaf of a binary tree is the node which does not have a left child and a right child.
For Example :
Given a binary tree :

All the root to leaf paths are :
1 2 4
1 2 5 
1 3
Note :

1. Two nodes may have the same value associated with it.
2. The root node will be fixed and will be provided in the function.
3. Note that the nodes in a path will appear in a fixed order. For example, 1 2 3 is not the same as 2 1 3.
4. Each path should be returned as a string consisting of nodes in order and separated by a space.
5. The path length may be as small as ‘1’.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
5
1 2 3 4 5 -1 -1 -1 -1 -1 -1
Sample Output 1 :
1 2 4
1 2 5 
1 3
Explanation for Sample Input 1:

All the root to leaf paths are :
1 2 4
1 2 5 
1 3
Sample Input 2 :
7
1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
Sample Output 2 :
1 3 5
1 3 6
1 2 4 7
Constraints :
1 <= N <= 3*10^3

Time Limit : 1 sec
Java (SE 1.8)
1234567891011121314151617181920212223242526272829303132333435363738394041424344454647484950515253
public class Solution {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        List<String> result = new ArrayList<String>();
        StringBuffer str = new StringBuffer();
        if(root.left == null && root.right == null){
            result.add(String.valueOf(root.data));
            return result;
        }
        treepath(root, result, str);

Last saved at 9:43 PM

*/

/********************************************************************

 Following is the class structure of the Node class:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;

     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 };

 ********************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Solution {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        List<String> result = new ArrayList<String>();
        StringBuffer str = new StringBuffer();
        if(root.left == null && root.right == null){
            result.add(String.valueOf(root.data));
            return result;
        }
        treepath(root, result, str);
        return result;
    }

    public static void treepath(BinaryTreeNode root, List<String> result, StringBuffer str) {
        if(root.left == null && root.right == null){
            String s = "" + root.data;
            str.append(s);
            result.add(str.toString());
            str.delete(str.length() - s.length(), str.length());
            return;
        }
        String s = root.data + " ";
        str.append(s);
        if(root.left != null){
            treepath(root.left, result, str);
        }

        if(root.right != null){
            treepath(root.right, result, str);
        }
        str.delete(str.length()-s.length(), str.length());
    }
}
