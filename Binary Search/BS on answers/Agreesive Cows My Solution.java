/*
Coding Ninja: https://www.codingninjas.com/studio/problems/aggressive-cows_1082559
Problem statement
You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.



You are also given an integer 'k' which denotes the number of aggressive cows.



You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.



Print the maximum possible minimum distance.



Example:
Input: 'n' = 3, 'k' = 2 and 'arr' = {1, 2, 3}

Output: 2

Explanation: The maximum possible minimum distance will be 2 when 2 cows are placed at positions {1, 3}. Here distance between cows is 2.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6 4
0 3 4 7 10 9


Sample Output 1 :
3


Explanation to Sample Input 1 :
The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here distance between cows are 3, 4 and 3 respectively.


Sample Input 2 :
5 2
4 2 1 3 6


Sample Output 2 :
5


Expected time complexity:
Can you solve this in O(n * log(n)) time complexity?


Constraints :
2 <= 'n' <= 10 ^ 5
2 <= 'k' <= n
0 <= 'arr[i]' <= 10 ^ 9
Time Limit: 1 sec.
*/
import java.util.Arrays;
public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        int n = stalls.length;
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi, stalls[i]);
            mini = Math.min(mini, stalls[i]);
        }
        int maxdis = (maxi-mini)/(k-1);
        int low = 1;
        int high = maxdis;
        int mid = 0;
        int answer = -1;
        while(low <= high){
            mid = (int)(low+high)/2;
            int findk = findcow(stalls, mid);
            if(findk >= k){
                answer = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return answer;
    }

    public static int findcow(int stalls[], int maxdis){
         Arrays.sort(stalls);
            int count = 1;
            int index = 0;
            for(int i=1;i<stalls.length;i++){
                if(stalls[i] - stalls[index] >= maxdis){
                    count ++;
                    index = i;
                }
            }
        return count;
    }
}
