// Question Link: https://www.codingninjas.com/studio/problems/reverse-linked-list_920513
// Leet Code: https://leetcode.com/problems/reverse-linked-list/
/****************************************************************
Leet code problem statement: 

Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

***********************************************************************************************************
Coding Ninja Problem statement: 

Sample Input 1 :
1 2 4 -1
Sample Output 1 :
4 2 1 -1
Explanation for Sample Input 1 :
1->2->4 is the initial linked list. If we reverse this, we get 4->2->1.
Sample Input 2 :
1
1 1 1 -1
Sample Output 2 :
1 1 1 -1
Constraints :
1 <= 'N' <= 10^4
0 <= 'data' <= 10^9

Where 'N' is the number of nodes in the linked list.

Time Limit: 1 sec

**********************************************************************************
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

public class Solution
{
    public static Node reverseLinkedList(Node head)
    {
        // Write your code here.
        Node prev = null;
        while(head != null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
    return prev;
    }
}
