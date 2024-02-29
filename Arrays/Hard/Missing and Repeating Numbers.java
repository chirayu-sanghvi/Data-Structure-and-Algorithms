/*
Coding Ninja: https://www.codingninjas.com/studio/problems/missing-and-repeating-numbers_6828164

Problem statement
You are given an array of ‘N’ integers where each integer value is between ‘1’ and ‘N’.
Each integer appears exactly once except for ‘P’, which appears exactly twice, and ‘Q’, which is missing.
Your task is to find ‘P’ and ‘Q’ and return them respectively.

Example:
Input: ‘N’ = 4
‘A’ = [1, 2, 3, 2]

Output: {2, 4}

Explanation: The integer appearing twice is ‘2’, and the integer missing is ‘4’.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
1 2 3 2
Sample Output 1:
2 4
Explanation Of Sample Input 1:
Input: ‘N’ = 5
‘A’ = [1, 2, 3, 2]

Output: {2, 4}

Explanation: The integer appearing twice is ‘2’, and the integer missing is ‘4’.
Sample Input 2:
3
1 2 1
Sample Output 2:
1 3
Constraints:
2 <= N <= 10^5
1 <= A[i] <= N

Time Limit: 1-sec
*/
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] findMissingRepeatingNumbers(int []a) {
        // Write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = a.length;
        int result[] = new int[2];

        for(int i=0;i<n;i++){
            hm.put(i+1,0);
        }
        for(int i=0;i<n;i++){
            hm.put(a[i], hm.get(a[i])+1);
        }

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(entry.getValue() == 0){
                result[1] = entry.getKey();
            }

            if(entry.getValue() == 2){
                result[0] = entry.getKey();
            }
        }

        return result;
    }
}
