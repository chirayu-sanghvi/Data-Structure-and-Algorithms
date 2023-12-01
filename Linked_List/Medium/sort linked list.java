/**
Question
Coding Ninja: https://www.codingninjas.com/studio/problems/sort-linked-list_625193?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
Leet Code: https://leetcode.com/problems/sort-list/
Problem statment: 
148. Sort List
Medium
11K
319
Companies
Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

**/


import java.util.Iterator;
import java.util.*;
import java.util.Collections;
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
    public static Node sortList(Node head) {
        //Write your code here
    List<Integer> ls=new ArrayList<>();
    Node temp=head;
    while(temp!=null){
        ls.add(temp.data);
        temp=temp.next;
    }
    Collections.sort(ls);
    temp=head;
    int i=0;
    while(temp!=null){
        temp.data=ls.get(i++);
        temp=temp.next;
    }
    return head;
    }
}
