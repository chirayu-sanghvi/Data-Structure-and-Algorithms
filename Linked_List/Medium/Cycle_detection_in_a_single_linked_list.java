// Quesstion Link
// Coding Ninja: https://www.codingninjas.com/studio/problems/cycle-detection-in-a-singly-linked-list_628974?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
// Leet Code: https://leetcode.com/problems/linked-list-cycle/
/*
Problem Statement
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?


Coding Ninja: 

Sample Input 1 :
1 2 3 4 -1
1


Sample Output 1 :
true


Explanation of Sample Input 1:
The linked list given in the input is as follows:


Sample Input 2 :
1 2 3 4 -1
0


Sample Output 2 :
true


Explanation of Sample Input 2:
The linked list given in the input is as follows:


Sample Input 3 :
5 -1
-1


Sample Output 3 :
false


Explanation of Sample Input 3:
 The linked list given in the input is as follows:


Expected Time Complexity:
Try to solve this problem in O(n).


Expected Space Complexity:
Try to solve this problem in O(1).


Constraints :
0 <= n <= 10^6
-1 <= pos < n
-10^9 <= data <= 10^9 and data != -1

Where 'n' is the size of the singly linked list, 'pos' represents the position (0-indexed) in the linked list where the tail connects to, and 'data' is the Integer data of the singly linked list.

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
 }

 *****************************************************************/

public class Solution {

    public static boolean detectCycle(Node head) {
        //Your code goes here
        if(head == null || head.next == null){
            return false;
        }
        Node fast = head;
        Node slow = head;
        
        while((fast.next != null) && (fast.next.next != null)){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
