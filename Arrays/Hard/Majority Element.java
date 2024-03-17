/*
Coding Ninja:
Leet Code: 
Problem statement
Given an array ‘A’ of ‘N’ integers, find the majority elements of the array.

A majority element in an array ‘A’ of size ‘N’ is an element that appears more than floor(N / 3) times.

Note: The floor function returns the number rounded down to the nearest integer.

Note: Return the array of majority elements in sorted order.

Example:
Input: ‘N’ = 9 ‘A’ = [2, 2, 1, 3, 1, 1, 3, 1, 1]

Output: 1

Explanation: The frequency of ‘1’ is 5, which is greater than floor(N / 3), hence ‘1’ is the majority element.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 1e3
-1e9 <= A[i] <= 1e9

Time Limit: 1-sec
Sample Input 1:
6
1 1 1 2 2 2
Sample Output 1:
1 2
Explanation Of Sample Input 1:
Input: ‘N’ = 6, ‘A’ = [1, 1, 1, 2, 2, 2]

Output: [1, 2]

Explanation: The frequency of ‘1’ and ‘2’ is 3, which is greater than floor(N / 3), hence ‘1’ & ‘2’ are the majority elements.
Sample Input 2:
1
4
Sample Output 2:
4

============================= Solution Idea ====================================
1) Create a hashmap and put the key as elements and its frequency as the value of the hashmap
2) Crate a result ArrayList
3) Iterate the hashmap and check for each key that if its value is more than Math.floor(n/3) then add that key in the result ArrayList 
4) Sort the result ArrayList after add all the eligible key and then return result ArrayList as the final answer.
*/
import java.util.*;

// class sortValue implements Comparator<Map.Entry<Integer, Integer>> {
//     @Override
//     public int  compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
//         return entry1.getValue().compareTo(entry2.getValue());
//     }
// }

public class Solution {
    public static List< Integer > majorityElement(int []v) {
        // Write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = v.length;
        for(int i =0;i<n;i++){
            if(!hm.containsKey(v[i])){
                hm.put(v[i],1);
            } else {
                hm.put(v[i], hm.get(v[i])+1);
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            int k = entry.getKey();
            int val = entry.getValue();
            if(val > Math.floor(n/3))
                result.add(k);
        }
        Collections.sort(result);
        return result;
    }
}
