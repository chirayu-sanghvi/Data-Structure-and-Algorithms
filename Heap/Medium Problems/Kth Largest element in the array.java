/*
Coding Ninja: 

Problem statement
You are given with an integer k and an array of integers that contain numbers in random order. You have to find k largest numbers from given array. You need to save them in an array and return it.

Note:
1. Time complexity should be O(n * logk) and space complexity should not be more than O(k).
2. Order of elements in the output is not important.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 ≤ k ≤ n ≤ 105
1 ≤ arr[i] ≤ 106
Sample Input 1:
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output 1:
12 16 20 25

============== Solution idea =======================
Create Min heap using priority queue and make sure that the size of the heap is not exceeding k
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution {

	public static ArrayList<Integer> kLargest(int n, int[] input, int k) {
		// Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            pq.add(input[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        Iterator itr = pq.iterator();
        while(itr.hasNext()){
            al.add((int)itr.next());
        }
    return al;
	}
}
