/**
Question:
Coding Ninja: https://www.codingninjas.com/studio/problems/remove-duplicates-from-a-sorted-doubly-linked-list_2420283?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statment input samples:
Sample Input 1 :
5
1 2 2 2 3


Sample Output 1 :
1 2 3


Explanation For Sample Input 1 :
We will delete the duplicate values ‘2’ present in the linked list.


Sample Input 2 :
4
1 2 3 4


Sample Output 2 :
1 2 3 4


Explanation For Sample Input 2 :
The list contains no duplicates, so the final list is unchanged.


Expected time complexity :
The expected time complexity is O('n').


Constraints :
1 <= 'n' <= 10^5
1 <= 'data' in any node <= 10^6

Time limit: 1 sec
**/

/********************************************************

    Following is the class structure of the Node class:
    
    class Node
    {
        public:
            int data;
            Node next;
            Node(int data)
            {
                this.data = data;
                this.next = null;
            }
    };

********************************************************/
import java.util.*;
public class Solution {
    public static Node uniqueSortedList(Node head) {
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }

        Node temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while(temp!=null){
            if(!arr.contains(temp.data))
            arr.add(temp.data);
            temp = temp.next;
        }

        
        Node answer = new Node(-1);
        Node finale = answer;
        for(int i=0;i<arr.size();i++){
            Node ptr = new Node(arr.get(i));
            answer.next = ptr;
            answer = ptr;
        }
        return finale.next;
    }
}
