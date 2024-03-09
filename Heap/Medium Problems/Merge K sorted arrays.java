/*
Coding Ninja: https://www.codingninjas.com/studio/problems/merge-k-sorted-lists_992772
Leet Code: https://leetcode.com/problems/merge-k-sorted-lists/description/
Problem statement
Given 'k' sorted linked lists, each list is sorted in increasing order. You need to merge all these lists into one single sorted list. You need to return the head of the final linked list.
For example:
Input:
3
3
4 6 8
3
2 5 7 
2
1 9

Output:
1 2 4 5 6 7 8 9 

Explanation:
First list is: 4 -> 6 -> 8 -> NULL
Second list is: 2 -> 5 -> 7 -> NULL
Third list is: 1 -> 9 -> NULL
The final list would be: 1 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> NULL
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
2
2
2 6 
2
-5 7 
Sample Output 1:
-5 2 6 7
Explanation for input 1:
First list is: 2 -> 6 -> NULL
Second list is: -5 -> 7 -> NULL
The final list would be: -5 -> 2 -> 6 -> 7 -> NULL
Sample Input 2:
2
3
8 9 11 
2
1 2 
Sample output 2:
1 2 8 9 11 
Constraints:
1 <= 'k' <= 10 ^ 3
1 <= 'n' <= 100
-10 ^ 9  <= 'data' <=  10 ^ 9 

where 'n' is the size of the list.
Time limit: 1 sec.
*/
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/****************************************************
	Following is the Node class for the Singly Linked List

		class LinkedListNode<Integer> {
			int data;
			LinkedListNode<Integer> next;

			public LinkedListNode(int data) {
				this.data = data;
			}
		}

****************************************************/

public class Solution {
    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        // Write your code here.
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < listArray.length; i++) {
            LinkedListNode<Integer> head = listArray[i];
            while (head != null) {
                pq.add(head.data);
                head = head.next;
            }
        }
        
        if (pq.isEmpty()) {
            return null; // Return null if the priority queue is empty
        }
        
        LinkedListNode<Integer> result = new LinkedListNode<>(pq.poll()); // Create the head of the result list
        LinkedListNode<Integer> current = result;
        while (!pq.isEmpty()) {
            current.next = new LinkedListNode<>(pq.poll()); // Poll the smallest element and add it to the result list
            current = current.next; // Move to the newly added node
        }
        return result;
    }
}
