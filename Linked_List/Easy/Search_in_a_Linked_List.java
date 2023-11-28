/*
Question
Coding Ninja: https://www.codingninjas.com/studio/problems/search-in-a-linked-list_975381?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries

Sample Input 1:
3 6 2 7 9 -1
2
Sample Output 1:
1
Explanation for Sample Input 1:
As value 2 exists in the given linked list. So we will return 1 in this case.

Sample Input 2:
1 2 3 7 -1
7
Sample Output 2:
1
Explanation for Sample Input 2:
As the value 7 exists in the Linked List, our answer is 1.

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


public class Solution
{
    public static int searchInLinkedList(Node head, int k)
    {
        // Write Your Code Here.
        while(head !=null){
            if(head.data == k){
                return 1;
            }
            head = head.next;
        }
        return 0;
    }
}
