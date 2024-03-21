/*
Coding Ninja: https://www.codingninjas.com/studio/problems/print-nodes-at-distance-k-from-a-given-node_842560
Leet Code:
Problem statement
You are given an arbitrary binary tree, a node of the tree, and an integer 'K'. You need to find all such nodes which have a distance K from the given node and return the list of these nodes.



Distance between two nodes in a binary tree is defined as the number of connections/edges in the path between the two nodes.



Note:

1. A binary tree is a tree in which each node has at most two children. 
2. The given tree will be non-empty.
3. The given tree can have multiple nodes with the same value.
4. If there are no nodes in the tree which are at distance = K from the given node, return an empty list.
5. You can return the list of values of valid nodes in any order. For example if the valid nodes have values 1,2,3, then you can return {1,2,3} or {3,1,2} etc.
Example :

Consider this tree above. The target node is 5 and K = 3. The nodes at distance 1 from node 5 are {2}, nodes at distance 2 from node 5 are {1, 4} and nodes at distance 3 from node 5 are {6, 3}.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 5 1 6 2 0 8 -1 -1 7 4 -1 -1 -1 -1 -1 -1 -1 -1
5
2
Sample Output 1 :
7 4 1
Explanation For The Sample Output 1:

Target Node is 5. Nodes at distance 1 from 5 are {6, 2, 3} and nodes at distance 2 are {7, 4, 1}.
Sample Input 2:
7 -1 14 9 -1 13 -1 20 9 -1 8 -1 -1 2 -1 -1 16 -1 -1 
2
6
Sample Output 2:
7
Constraints:
1 <= N <= 3000
0 <= K <= 3000
0 <= nodeValue <= 3000

Where nodeValue donates the value of the node.

Time Limit: 1 sec
*/
/*************************************************************

 Following is the Binary Tree node structure for reference:

 class BinaryTreeNode<T> {

     T data;
     BinaryTreeNode<T> left;
     BinaryTreeNode<T> right;

     BinaryTreeNode(T data) {
         this.data = data;
         left = null; right = null;
     }
 }

 *************************************************************/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

import javax.print.attribute.HashAttributeSet;

public class Solution {
    public static List<BinaryTreeNode<Integer>> printNodesAtDistanceK(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int K) {
        // Write your code here.
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> hm = new HashMap<>();
        Queue<BinaryTreeNode<Integer>> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()){
            BinaryTreeNode node = qu.poll();
            if(node.left != null){
                qu.add(node.left);
                hm.put(node.left,node);
            }

            if(node.right != null){
                qu.add(node.right);
                hm.put(node.right, node);
            }
        }

        HashMap<BinaryTreeNode<Integer>, Boolean> visited = new HashMap<>();
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(target);
        int current_Level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(current_Level++ == K){
                break;
            }

            for(int i =0;i<size;i++){
                BinaryTreeNode current = q.poll();
                if(current.left != null && !visited.containsKey(current.left)){
                    q.add(current.left);
                    visited.put(current.left, true);
                }

                if(current.right != null && !visited.containsKey(current.right)){
                    q.add(current.right);
                    visited.put(current.right, true);
                }

                if(hm.containsKey(current) && !visited.containsKey(hm.get(current))){
                    q.add(hm.get(current));
                    visited.put(hm.get(current), true);
                }

            }
        }

        while(!q.isEmpty()){
            BinaryTreeNode node = q.poll();
            if(node == target && K != 0) continue;
            result.add(node);
        }
        return result;
    }
}
