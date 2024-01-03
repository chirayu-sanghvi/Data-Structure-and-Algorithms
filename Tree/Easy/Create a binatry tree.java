/*
Coding Ninja: https://www.codingninjas.com/studio/problems/create-binary-tree_8360671
*/
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
    public static Node createTree(int []arr){
        // Write your code here.
        if(arr == null || arr.length == 0){
            return null;
        }

        return createTreeHelper(arr,0);

    }

    public static Node createTreeHelper(int[] arr, int index) {
        if(index < arr.length){
            Node newNode = new Node(arr[index]);
            newNode.left = createTreeHelper(arr,2*index+1);
            newNode.right = createTreeHelper(arr,2*index+2);
            return newNode;
        }
        return null;
    }
}
