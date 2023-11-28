// Question
// Coding Ninja : https://www.codingninjas.com/studio/problems/check-if-linked-list-is-palindrome_985248?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
// Leet Code: https://leetcode.com/problems/palindrome-linked-list/

/**
234. Palindrome Linked List
Easy
15.5K
835
Companies
Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
----------------------------------------------------------------------------------

Coding Ninja Sample Inputs: 

Sample Input 1:
1 2 2 1 -1
Sample Output 1:
True
Explanation for Sample Input 1:
The given list is a palindrome.
Sample Input 2:
3 2 1 -1
Sample Output 2:
False
Constraints :
1 <= 'N' <= 5 * 10^4
-10^9 <= 'data' <= 10^9 and 'data' != -1

Where 'N' is the number of nodes in the linked list and ‘data’ represents the value of the list's nodes.

Time Limit: 1sec
------------------------------------------------------------------------------------------
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

public class Solution {
    public static boolean isPalindrome(Node head) {
        // write your code here
        if(head == null || head.next == null){
            return true;
        }

        Node fast = head;
        Node slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast= fast.next.next;
        }

        slow.next = reverseLinkedList(slow.next);

        slow = slow.next;

        while(slow != null){
            if(head.data != slow.data){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static Node reverseLinkedList(Node ptr){
        Node prev = null;
        while(ptr != null){
            Node next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        return prev;
    }
}
