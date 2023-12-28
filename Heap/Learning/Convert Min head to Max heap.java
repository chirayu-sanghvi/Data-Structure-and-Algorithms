/*
Coding Ninja: https://www.codingninjas.com/studio/problems/convert-min-heap-to-max-heap_1381084?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
You are given an array of size ‘N’ which is an array representation of min-heap.



You need to convert this min-heap array representation to a max-heap array representation. Return the max-heap array representation.



For Example
Corresponding to given min heap : [1,2,3,6,7,8]

It can be converted to the following max heap: [8,7,3,6,2,1]

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
1 2 3 4 5 6
Sample Output 1:
true
Explanation to Sample Input 1:
The min-heap representation is:-

One of the possible max heap for a given min-heap 
is [6,5,4,2,3,1]

Sample Input 2:
7
3 5 6 7 9 12 7 
Sample Output 2:
true
Constraints:
1 <= ’N’ <= 5000
1 <= arr[ i ] <= 10^5

where, 'N' denotes the size of the array and arr[i] denotes the elements of the input array.

Time Limit : 1 sec

=========================== Solution Idea ==================================
Convert it using priority queue with Collections.reverseOrder()
*/

import java.util.*;
public class Solution {
    public static int[] MinToMaxHeap(int n, int[] arr){
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        Iterator itr = pq.iterator();
        int j =0;
        while(itr.hasNext()){
            arr[j] = (int)itr.next();
            j++;
        }
        return arr;
    }
}
