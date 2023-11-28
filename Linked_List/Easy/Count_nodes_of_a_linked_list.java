/*

Question
Coding Ninja: https://www.codingninjas.com/studio/problems/count-nodes-of-linked-list_5884?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries

Sample Input 1 :
3 4 5 2 6 1 9 -1


Sample Output 1 :
7


Explanation of sample input 1 :
The number of nodes in the given linked list is 7.
Hence we return 7.


Sample Input 2 :
10 76 39 -3 2 9 -23 9 -1

Sample Output 2 :
8


Expected Time Complexity:
Try to do this in O(n).


 Constraints :
0 <= N <= 10^5
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
    public static int length(Node head){
        //Your code goes here
        if(head.next == null){
            return 0;
        }
        int count = 0;
        while(head.next != null){
            count ++;
            head = head.next;
        }
        return count+1;
    }
}
