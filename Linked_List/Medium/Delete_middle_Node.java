/**
Question:
Coding Ninja: https://www.codingninjas.com/studio/problems/delete-middle-node_763267?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
Leet Code: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

Problem Statement
Leet Code : 
2095. Delete the Middle Node of a Linked List
Medium
3.8K
68
Companies
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 

Example 1:


Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node. 
Example 2:


Input: head = [1,2,3,4]
Output: [1,2,4]
Explanation:
The above figure represents the given linked list.
For n = 4, node 2 with value 3 is the middle node, which is marked in red.
Example 3:


Input: head = [2,1]
Output: [2]
Explanation:
The above figure represents the given linked list.
For n = 2, node 1 with value 1 is the middle node, which is marked in red.
Node 0 with value 2 is the only node remaining after removing node 1.
 

Constraints:

The number of nodes in the list is in the range [1, 105].
1 <= Node.val <= 105



=========================================

Coding Ninja Input Sample:
Sample Input 1 :
5
1 2 3 4 5
Sample Output 1 :
1 2 4 5 
Explanation to Sample Input 1 :
We can clearly see that there are 5 nodes in the linked list therefore the middle node is the node with value '3'.
Sample Input 2 :
1
2
Sample Output 2 :
-1
Explanation to Sample Input 1 :
We can clearly see that there is only one node in the linked list.
Therefore, after deleting that one node, the linked list becomes empty, resulting in an output of -1.
Constraints :
1 <= N <= 10^3
0 <= data <= 10^3 

Where 'N' is the length of the linked list.

Time Limit: 1 sec

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
    public static Node deleteMiddle(Node head) {
        // Write your code here.
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        Node ptr = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count ++;
        }
        int middle = (int)Math.ceil(count/2);
        while(middle !=1){
            ptr = ptr.next;
            middle --;
        }
        ptr.next = ptr.next.next;
        return head;

    }
}
