/*
Coding Ninja: https://www.codingninjas.com/studio/problems/count-substrings-with-k-ones_3128698
Problem statement
You are given a binary array 'arr' of length 'N' and an integer 'k'. Return the number of subarrays having the count of 1's equal to ‘k’.



Example :
Let the array 'arr' be: [1, 0, 1].
Let ‘k’ be: 1

Then the subarrays having the number of ones equal to ‘k’ will be: [1], [1,0], [0,1], [1].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 2
1 1 0 1
Sample output 1 :
3
Explanation For Sample Output 1 :
The subarrays having the number of ones equal to 2 will be: [1,1], [1,1,0], [1,0,1].

So the count is 3.
Sample Input 2 :
5 1
1 0 0 1 0
Sample output 2 :
9
Constraints :
1 <= 'N' <= 10^4

arr[i] is either 0 or 1.

0 <= 'k' <= 10^6

Time limit: 1 sec

====================== Solution Idea ====================
Approach
First find the prefix sum
store prefix sum and its frequecy in a hashMap
while finding the prefix sum just search for the curr_sum - target in the hashmap and add it to the answer.
Complexity
Time complexity: O(n)
Space complexity: O(n)
*/
import java.util.*;

public class Solution {
    public static int subarrayWithSum(int []nums, int goal) {
        // Write your code here
                HashMap<Integer,Integer> map = new HashMap();

        int currSum =0,res=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            currSum=currSum+nums[i];
            res += map.getOrDefault(currSum-goal,0);
            if(map.containsKey(currSum))
                map.put(currSum,map.get(currSum)+1);
            else
                map.put(currSum,1);
        }
        return res;
    }
}
