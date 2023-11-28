/*
Question
COding Ninja: https://www.codingninjas.com/studio/problems/insert-node-at-the-beginning_8144739?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

Sample Input 1:
4 0
4 2 5 1
Sample Output 1 :
0 4 2 5 1
Explanation Of Sample Input 1:
Input: ‘N’ = 4, ‘newValue’ = 0
‘list’ = 4 -> 2 -> 5 -> 1

Output: 0 4 2 5 1

Explanation: Linked List after inserting the newValue is 0 -> 4 -> 2 -> 5 -> 1.
Sample Input 2:
5 5
4 3 2 1 5
Sample Output 2:
5 4 3 2 1 5
Explanation Of Sample Input 2:
Input: ‘N’ = 5, ‘newValue’ = 5
‘list’ = 4 -> 3 -> 2 -> 1 -> 5

Output: 5 4 3 2 1 5

Explanation: Linked List after inserting the newValue is 5 -> 4 -> 3 -> 2 -> 1 -> 5.
Constraints:
1 <= 'N' <= 10^4
0 <= list elements <= 10^5
0 <= 'newValue' <= 10^5

Time Limit: 1-sec


*/

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

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node insertAtFirst(Node list, int newValue) {
        // Write your code here
        Node head = new Node(newValue);
        head.next = list;
        list.prev = head;
        return head;
    }
}
