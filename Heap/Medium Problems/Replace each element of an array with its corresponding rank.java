/*
Coding Ninja: https://www.codingninjas.com/studio/problems/replace-each-element-of-array-with-its-corresponding-rank_975384?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

Problem statement
Given an array of integers 'ARR’ of size ‘N’. Replace each element of this array with its corresponding rank and return the array.



The rank of an element is an integer between 1 to ‘N’ inclusive that represents how large the element is in comparison to other elements of the array. The following rules can also define the rank of an element:



1. It is an integer starting from 1.

2. The larger the element, the larger the rank. If two elements are equal, their rank must be the same.

3. It should be as small as possible.
For Example:
'ARR' = [4, 7, 2, 90]

Here, 2 is the smallest element, followed by 4, 7, and 90. 

Hence rank of element 2 is 1, element 4 is 2, element 7 is 3, and element 90 is 4.

Hence we return [2, 3, 1, 4].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
2
4 -1
Sample Output 1 :
2 1 
Explanation Of Sample Input 1 :
Here, 4 is the largest element and -1 is the smallest element.

So, the rank of 4 is 2.

The rank of -1 is 1.

Thus after replacing elements with their rank we get [2, 1].
Sample Input 2 :
5
1 2 6 9 2 
Sample Output 2 :
1 2 3 4 2
Explanation Of Sample Input 2 :
Here, 1 is the smallest element, 2 is the second-smallest element and 6 is the third-smallest element and 9 is the largest element.

So, the rank of 1 should be 1.

The rank of 2 should be 2.

The rank of 6 should be 3.

The rank of 9 should be 4.

Thus after replacing elements with their rank we get [1, 2, 3, 4, 2]
Constraints :
1 <= N <= 10^4
-10^9  <= ARR[i] <= 10^9

Where 'ARR[i]' denotes the 'ith' element of the array.

Time limit: 1 sec



============= Solution idea =================
Use priority queue to sort the array in O(nlogn) time, additionally use hashmap to record rank of the particular element, 
In the end iterate through the input array and add the rank as per the hashmap values.
*/
import java.sql.Array;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.*;

public class Solution {
    public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i: arr){
            pq.add(i);
        }
        int rank = 1;
        while(!pq.isEmpty()){
            if(!hm.containsKey(pq.peek())){
                hm.put(pq.poll(),rank);
                rank++;
            }
            else{
                pq.poll();
            }
        }
        for(int i=0;i<n;i++){
            al.add(hm.get(arr.get(i)));
        }

        return al;
        
    }
}
