/*
Coding Ninja: https://www.codingninjas.com/studio/problems/children-sum-property_8357239

Problem statement
Return true if all non-leaf nodes in a given binary tree have a value that is equal to the sum of their child nodes, otherwise return false..



For Example:

Output: true 
Explanation: Node 2 and 3 are children of Node 1 and (3+1)=4.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
5 3 2 3 -1 -1 -1 -1 -1
Sample Output 1:
true
Explanation Of Sample Input 1:

Node 1: The sum of its child nodes is 3 + 2 = 5, which is equal to its value.
Node 2: The sum of its child nodes is 3, which is equal to its value.
Node 3: It is a leaf node with no child nodes, so the condition is satisfied.
Node 4: It is a leaf node with no child nodes, so the condition is satisfied.
Sample Input 2:
6
7 3 4 3 -1 2 3 -1 -1 -1 -1 -1 -1
Sample Output 2:
false
Explanation Of Sample Input 2:

Node 1: The sum of its child nodes is 3 + 4 = 7, which is equal to its value.
Node 2: The sum of its child nodes is 3, which is equal to its value.
Node 3: The sum of its child nodes is 2 + 3 = 5, which is not equal to its value 4, so the condition is not satisfied. Hence the answer is false.
Constraints:
1 <= N <= 10^3
1 <= data <= 10^5
Time Limit: 1 sec
*/
import java.util.LinkedList;
import java.util.Queue;

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
public class Solution {
    public static boolean isParentSum(Node root) {
        // Write your code here.
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            int data = node.data;
            int x = 0;
            int y = 0;
            if(node.left != null){
                q.add(node.left);
                x = node.left.data;
            }

            if(node.right != null){
                q.add(node.right);
                y = node.right.data;
            }

            if(data != (x+y) && (node.right != null || node.left != null)){
                return false;
            }
        }
        return true;
    }
}
