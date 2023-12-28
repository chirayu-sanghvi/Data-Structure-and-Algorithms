/*
Coding Ninja: https://www.codingninjas.com/studio/problems/min-heap-implementation_5480527?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
Implement the Min Heap data structure. For information about Heap click here.

Min heap is a tree data structure where the root element is the smallest of all the elements in the heap. Also, the children of every node are smaller than or equal to the root node. 

The insertion and removal of elements from the heap take log('N'), where 'N' is the number of nodes in the tree. 
Implement the “minHeap” class. You will be given the following types of queries:-

0 extractMinElement(): Remove the minimum element present in the heap, and return it.

1 deleteElement( i ): Delete the element present at the 'i' th index.

2 insert( key ): Insert the value 'key' in the heap.

For queries of types 0 and 1, at least one element should be in the heap.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3
2 2
2 1
0
Sample Output 1 :
1
Explanation Of Sample Input 1 :
Insert 2 in the heap, and currently, 2 is the smallest element in the heap.

Insert 1 in the heap and now the smallest element is 1.

Return the smallest element, which is 1.
Sample Input 2 :
5
2 5
2 43
2 15
1 2
0
Sample Output 2 :
15
Explanation Of Sample Input 2 :
Insert 5 in the heap.
Insert 43 in the heap.
Insert 15 in the heap.

Remove element at index 2 i.e. X from the heap.

Return the smallest element, which is 15.
Constraints :
1 <= N <= 10^5
1 <= X <= 50

Time Limit: 1 sec

============= Solution Idea ==================
Using Priority Queue
*/ 
import java.util.PriorityQueue;

public class Solution {

    static class MinHeap {

        // Constructor for the class.
        PriorityQueue<Integer> pq;
        MinHeap(int size) {
            // Write your code here.
            pq = new PriorityQueue<>(size);
        }

        // Implement the function to remove minimum element.
        int extractMinElement() {
            // Write you code here.
            if(pq.size()>0)
            return pq.poll();
            return -1;
        }

        // Implement the function to delete an element.
        void deleteElement(int ind) {
            // Write you code here.
            if(pq.size() > 0){
                pq.remove(ind);
            }
        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            // Write you code here.
            pq.add(val);
        }
    }
};
