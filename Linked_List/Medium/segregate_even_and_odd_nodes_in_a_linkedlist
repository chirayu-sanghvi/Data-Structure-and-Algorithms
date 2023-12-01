/**
Qustion:
Coding Ninja: https://www.codingninjas.com/studio/problems/segregate-even-and-odd-nodes-in-a-linked-list_1116100?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
LeetCode: https://leetcode.com/problems/odd-even-linked-list/

Problem Statement:

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106

=======================================================================
Coding Ninja Input Sample

Sample Input 1
2 1 3 5 6 4 7 -1
Sample Output 1
2 6 4 1 3 5 7
Explanation of Sample Input 1
Given singly linked list 2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7.

Arrange all the even values in the starting and odd values at the end of the linked list.

So ‘2, 6, 4’ must appear in the starting and ‘1, 3, 5, 7’ must appear at the end of linked list 

So return 2 -> 6 -> 4 -> 1 -> 3 -> 5 -> 7
Sample Input 2
6 5 4 3 2 1 -1
Sample Output 2
6 4 2 5 3 1
Constraints :-
1 <= 'N' <= 5000
0 <= node value <= 10^9  

Where ‘N’ is the number of nodes in the linked list.

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
 }

 *****************************************************************/
public class Solution
{
    public static Node segregateEvenOdd(Node head)
    {
        // Write Your Code Here.
        Node even = new Node(-1);
        Node odd = new Node(-1);
        Node oddstart = odd;
        Node curr = head;
        Node evenstart = even;
        while(curr!= null){
          if(curr.data % 2 == 0){
              even.next = new Node(curr.data);
              even = even.next;
              curr = curr.next;
          }
          else {
              odd.next = new Node(curr.data);
              odd = odd.next;
              curr = curr.next;
          }
        }
        Node answer = evenstart.next;
        while(answer.next !=null){
            answer = answer.next;
        }
        answer.next = oddstart.next;
        return evenstart.next;
}
}
