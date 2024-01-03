/*
Coding Ninja: https://www.codingninjas.com/studio/problems/zigzag-binary-tree-traversal_920532

================= Solution Idea =======================
Solved using queue
*/
/*********************************************************

 Following is the TreeNode structure:

 class TreeNode<T>
 {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     TreeNode(T data)
     {
         this.data = data;
         left = null;
         right = null;
     }
 };
 ********************************************************/

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.*;
public class Solution {
    public static List<Integer> levelOrder(TreeNode<Integer> root){
        // Write your code here.
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        if(root == null){
            return result;
        }
        q.add(root);
        while(!q.isEmpty()){
            TreeNode<Integer> temp = q.poll();
            result.add(temp.data);
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
        return result;
    }
}
