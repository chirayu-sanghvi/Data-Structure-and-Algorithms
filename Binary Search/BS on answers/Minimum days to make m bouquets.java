/*
Coding Ninja: https://www.codingninjas.com/studio/problems/rose-garden_2248080
Leet Code: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

Problem statement
You are given 'n' roses and you are also given an array 'arr' where 'arr[i]' denotes that the 'ith' rose will bloom on the 'arr[i]th' day.
You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.

Find the minimum number of days required to make at least 'm' bouquets each containing 'k' roses. Return -1 if it is not possible.

Example :
Input: n = 9,  arr = [ 1, 2, 1, 2, 7, 2, 2, 3, 1 ], k = 3, m = 2

Output: 3. 

Explanation: This is because on the 3rd day: all the roses with 'arr[i]' less than equal to 3 have already bloomed, this means every rose except the 5th rose has bloomed. Now we can form the first bouquet from the first three roses and the second bouquet from the last three roses.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
9
1 2 1 2 7 2 2 3 1
3 2
Sample Output 1 :
3
Explanation For Sample Input 1 :
We will return 3, because:
All the roses with 'arr[i]' less than equal to 3 have already bloomed after 3 days, this means every rose except the 5th rose has bloomed. Now we can form the first bouquet from the first three roses and the second bouquet from the last three roses.
Sample Input 2 :
4
1 1 1 1
1 1
Sample Output 2 :
1
Constraints :
1 <= n <= 10^5
1 <= arr[i] <= 10^9
1 <= k <= n
1 <= m <= 10^6

Time limit: 1 sec
*/
// Linear Search Solution
public class Solution {
    public static int roseGarden(int[] arr, int r, int b) {
        // Write your code here.-
        int n = arr.length;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mini = Math.min(arr[i], mini);
            maxi = Math.max(arr[i], maxi);
        }


        while(mini <= maxi){
            int count = 0;
            int res = 0;
            for(int i=0;i<n;i++){
                // System.out.println(mini+" "+i+" "+count+" "+r+" "+res);
                if(arr[i] <= mini){
                    count ++;
                }
                else{
                    res += (int)Math.floor(count/r);
                    count = 0;             
                }
            }
            res += (int)Math.floor(count/r);
            if(res >= b){
                return mini;
            }
            mini++;
        }
        return -1;
    }
}

//Binary Search Solution
public class Solution {
    public static int roseGarden(int[] arr, int r, int b) {
        // Write your code here.-
        int n = arr.length;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mini = Math.min(arr[i], mini);
            maxi = Math.max(arr[i], maxi);
        }
        int mid = 0;
        int answer = -1;
        while(mini <= maxi){
            mid = (int)(mini+maxi)/2;
            boolean find = findrose(arr, mid,b,r);
            if(find == true){
                answer = mid;
                maxi = mid-1;
            }
            else{
                mini = mid + 1;
            }
        }
        return answer;
    }


    public static boolean findrose(int arr[], int mini, int b, int r){
            int count = 0;
            int res = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i] <= mini){
                    count ++;
                }
                else{
                    res += (int)Math.floor(count/r);
                    count = 0;             
                }
            }
            res += (int)Math.floor(count/r);
            if(res >= b){
                return true;
            }
        return false;
    }
}
