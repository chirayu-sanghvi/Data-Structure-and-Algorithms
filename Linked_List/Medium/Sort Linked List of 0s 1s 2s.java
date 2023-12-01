/** 
Question
Coding Ninja: https://www.codingninjas.com/studio/problems/sort-linked-list-of-0s-1s-2s_1071937?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem Statement Sample Input 
Sample Input 1:
7
1 0 2 1 0 2 1


Sample Output 1:
0 0 1 1 1 2 2


Explanation Of Sample Input 1:
Input: 1 -> 0 -> 2 -> 1 -> 0 -> 2 -> 1

Output: 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2

Explanation: 
In this example, the original linked list contains two 0s, three 1s, and two 2s. The sorted linked list has all the 0s at the beginning, followed by all the 1s, and finally, all the 2s at the end.


Sample Input 2:
8
2 1 0 2 1 0 0 2


Sample Output 2:
0 0 0 1 1 2 2 2


Follow Up:
Can you solve this without updating the Nodes of the given linked list?


Constraints :
1 <= N <= 10^3
0 <= data <= 2 

Where 'N' is the length of the linked list.

Time Limit: 1 sec
**/ 

import java.util.*;

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
    public static Node sortList(Node head) {
        // Write your code here
        if(head == null || head.next == null){
            return head;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            arr.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(arr);
        int i = 0;
        temp = head;
        while(temp!= null){
            temp.data = arr.get(i++);
            temp = temp.next;
        }
        return head;
    }
}
