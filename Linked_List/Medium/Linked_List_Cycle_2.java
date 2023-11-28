// Question Link
// Coding Ninja:
// Leet Code:

/**
Problem Statement: (Leet Code)

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?
----------------------------------------------------------------------------
Coding Ninja Sample Inputs:

Sample Input 1 :
1 2 3 4 -1
1


Sample Output 1 :
1


Explanation For Sample Input 1 :
For the first test case,


Sample Input 2 :
1 2 3 4 -1
0


Sample Output 2 :
0


Explanation For Sample Input 2 :
For the first test case,


Follow-Up:
Can you do this in O(n) time and using constant space?


Constraints :
-10^4 <= n <= 10^4
-1 <= pos < n
-10^9 <= data <= 10^9 and data != -1

Time Limit: 1 sec

**/

import java.util.ArrayList;
import java.util.HashMap;

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
 }

 *****************************************************************/

public class Solution {
    public static Node firstNode(Node head) {
        // Write your code here.
        if(head == null || head.next ==null){
            return null;
        }
        Node ptr = head;
    
        ArrayList<Node> hm = new ArrayList<>();
        while(head !=null && !hm.contains(head)){
            hm.add(head);
            if(hm.contains(head.next)){
                return head.next;
            }
            head = head.next;
        }
        return null;
    }
}
