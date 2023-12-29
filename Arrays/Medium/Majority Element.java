/*
Coding Ninja: https://www.codingninjas.com/studio/problems/majority-element_6783241?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
Leet Code: https://leetcode.com/problems/majority-element/

Problem statement
You are given an array 'a' of 'n' integers.
A majority element in the array ‘a’ is an element that appears more than 'n' / 2 times.
Find the majority element of the array.
It is guaranteed that the array 'a' always has a majority element.

Example:
Input: ‘n’ = 9, ‘a’ = [2, 2, 1, 3, 1, 1, 3, 1, 1]

Output: 1

Explanation: The frequency of ‘1’ is 5, which is greater than 9 / 2.
Hence ‘1’ is the majority element.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
9
2 2 1 3 1 1 3 1 1


Sample Output 1:
1


Explanation Of Sample Input 1:
Input: ‘n’ = 9, ‘a’ = [2, 2, 1, 3, 1, 1, 3, 1, 1]

Output: 1

Explanation: The frequency of ‘1’ is 5, which is greater than 9 / 2.
Hence ‘1’ is the majority element.


Sample Input 2:
1
4


Sample Output 2:
4


Sample Input 3:
5
-53 75 56 56 56 


Sample Output 3:
56


Expected time complexity :
The expected time complexity is O(n).


Constraints :
1 <= 'n' <= 10000
0 <= 'arr[i]' <= 10^9

Time limit: 1 second

========================== Solution Idea ==========================
Use HsshMap and iterate.
Break the loop as soon as you reach an element whose value in the hashmap is greate than or equal to n/2 where n is the length of the input array
*/
import java.util.HashMap;
public class Solution {
    public static int majorityElement(int []v) {
        // Write your code here
        int result = 0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<v.length;i++){
            if(!hm.containsKey(v[i])){
                hm.put(v[i],1);
            }
            else{
                hm.put(v[i],hm.get(v[i])+1);
            }
            if(hm.get(v[i])>= (v.length/2)){
                return v[i];
            }
        }
        return 0;
    }
}
