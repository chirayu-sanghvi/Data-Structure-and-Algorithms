/**
Question: 
Coding Ninja: 

Problem Statement:
Input Sample
Sample Input 1:
7
10 4 10 3 5 20 10
10


Sample Output 1:
4 3 5 20


Explanation Of Sample Input 1:
All the nodes having ‘data’ = 10 are removed from the linked list.


Sample Input 2:
7
10 4 10 3 5 20 10
30


Sample Output 2:
10 4 10 3 5 20 10


Explanation Of Sample Input 2:
The linked list does not have any node with ‘data’ = 30. So the linked list is unchanged.


Expected Time Complexity:
The expected time complexity is O(‘n’).


Constraints:
0 <= ‘n’ <= 100000
1 <= ‘data’ in any node <= 10^9
1 <= ‘k’ <= 10^9

**/


import java.util.ArrayList;

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }
     Node(int data, Node next, Node prev)
     {
         this.data = data;
         this.next = next;
         this.prev = prev;
     }
 }

 *****************************************************************/

public class Solution {
    public static Node deleteAllOccurrences(Node head, int k) {
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }
        
        Node temp = head;

        Node dummy = new Node(-1);
        dummy.next = head;
        head.prev= dummy;
        while(temp!=null){
            if(temp.data == k){
                temp.prev.next = temp.next;
                if(temp.next !=null)
                temp.next.prev = temp.prev;
            }
              temp= temp.next;
        }

        return dummy.next;
    }
}
