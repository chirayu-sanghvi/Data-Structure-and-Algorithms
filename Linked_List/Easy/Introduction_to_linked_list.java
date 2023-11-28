// Question
// Coding Ninja : https://www.codingninjas.com/studio/problems/introduction-to-linked-list_8144737?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=PROBLEM

/**

Sample Input 1:
4
4 2 5 1


Sample Output 1 :
4 2 5 1


Explanation Of Sample Input 1:
Linked List for the array ‘Arr’ = [4, 2, 5, 1] is 4 -> 2 -> 5 -> 1.


Sample Input 2:
5
4 3 2 1 5


Sample Output 2:
4 3 2 1 5

**/

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };

 *****************************************************************/

public class Solution {
    public static Node constructLL(int []arr) {
        // Write your code here
        Node head = new Node(arr[0]);
        Node curr = head;
        for(int i=1;i<arr.length;i++){
            Node NewNode = new Node(arr[i]);
            curr.next = NewNode;
            curr = curr.next;
        }
        return head;
        
    }
}
