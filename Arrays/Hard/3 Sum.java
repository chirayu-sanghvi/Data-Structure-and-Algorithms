/*
Coding Ninja: https://www.codingninjas.com/studio/problems/three-sum_6922132
Leet Code: https://leetcode.com/problems/3sum/
Problem statement
You are given an array ‘ARR’ containing ‘N’ integers.
Return all the unique triplets [ARR[i], ARR[j], ARR[k]] such that i != j, j != k and k != i and their sum is equal to zero.
Example:
Input: ‘N’ = 5 
'ARR' =  [-1, -1, 2, 0, 1] 

Output: 
-1 -1 2
-1 0 1

Explanation:
(-1 -1 +2) = (-1 +0 +1) = 0.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5 
-1 -1 2 0 1
Sample Output 1 :
-1 -1 2
-1 0 1
Explanation Of Sample Input 1:
(-1 -1 +2) = (-1 +0 +1) = 0.
Sample Input 2:
4 
0 0 0 0
Sample Output 2 :
0 0 0
Constraints:
1  <= N <= 1000
1 <= ARR[i] <= 1000
Time Limit: 1 sec
*/
import java.util.*;
public class Solution {
    public static List< List < Integer > > triplet(int n, int []arr) {
        Arrays.sort(arr);
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<n-2;i++){
            if(i == 0 || arr[i] != arr[i-1]) {
                int left = i+1;
                int right = n-1;
                int sum = -arr[i];
                while(left < right){
                    if(arr[left] + arr[right] == sum){
                        result.add(Arrays.asList(arr[i],arr[left], arr[right]));
                        while(left < right && arr[left] == arr[left+1] ){
                            left++;
                        }

                        while(left < right && arr[right] == arr[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    } 
                    else if(arr[left] + arr[right] < sum){
                        left++;
                    }
                    else {
                        right --;
                    }
                }
            }
        }
        return result;
    }
}
