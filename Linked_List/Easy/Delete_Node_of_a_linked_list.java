/*
Question
Coding Ninja : https://www.codingninjas.com/studio/problems/delete-node-of-linked-list_8160463?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

Sample Input 1:
4
4 2 5 1
Sample Output 1 :
4 2 5
Explanation Of Sample Input 1:
Input: ‘N' = 4, ‘list’ = 4 -> 2 -> 5 -> 1

Output: 4 2 5

Explanation: 
After deleting the last node, the Linked List is 4 -> 2 -> 5.
Sample Input 2:
5
4 3 2 1 5
Sample Output 2:
4 3 2 1
Explanation Of Sample Input 2:
Input: ‘N’ = 5, ‘list’ = 4 -> 3 -> 2 -> 1 -> 5

Output: 4 3 2 1

Explanation: 
After deleting the last node, the Linked List is 4 -> 3 -> 2 -> 1.


Expected Time Complexity:
Try solving this in O(N).


Constraints:
2 <= 'N' <= 10^4
0 <= list elements <= 10^5

Time Limit: 1 sec



*/



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
    public static Node deleteLast(Node list){
        if(list.next == null){
            return null;
        }
        // Write your code here
        Node head = list;
        while (list.next.next != null && list.next !=null){
            list = list.next;
        }
        list.next = null;
        return head;
    }
}
