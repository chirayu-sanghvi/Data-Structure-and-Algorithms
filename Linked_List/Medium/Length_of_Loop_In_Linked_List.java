// Question
// Coding Ninja :

/**
Problem Statement: 
You are given a lined list. The last node might point to null, or it might point to a node in the list, this foriming a cycle.
Find out whether the linled list has a cycle or not. and the length of the cycle it it does.
If there is no cycle, return 0. otherwise return the length of the cycle.

Sample Input 1:
4
4 10 3 5
2
Sample Output 1:
3
Explanation Of Sample Input 1 :
The cycle is 10, 3, 5.
Sample Input 2 :
4
4 10 3 5
0
Sample Output 2 :
0
Explanation Of Sample Input 2 :
Since ‘p’ = 0, the last node is pointing to null, so no cycle exists.


Constraints:
1 <= ‘n’ <= 100000
1 <= Data in linked list node <= 10^9
0 <= ‘p’ <= ‘n’

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
import java.util.*;
public class Solution
{
    public static int lengthOfLoop(Node head) {
        // Write your code here
        HashMap<Node, Integer> hm = new HashMap<>();
        Node ptr = head;
        int pos = 0;
        while(head!=null && !hm.containsKey(head)){
            hm.put(head, pos);
            pos++;
            if(hm.containsKey(head.next)){
                return pos - hm.get(head.next);
            }
            head = head.next;
        }
        return 0;

    }
}
