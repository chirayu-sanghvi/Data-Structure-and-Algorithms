/*
Coding Ninja: https://www.codingninjas.com/studio/problems/maximum-points-from-cards_8391016
Leet Code: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

Problem statement
Given an array 'arr' of size 'N' representing the points associated with each card, and an integer 'K' representing the number of cards to be taken. We need to return the maximum score that can be obtained.



In each step, we can choose to take one card from either the beginning or the end of the row. We must take exactly ‘K’ cards. The score is calculated as the sum of the points of the cards chosen.



For Example:
Input:
7 4
9 7 5 3 2 1 8

Output: 
29

Explanation:
Line 1: Contains ‘N’=7 and ‘K’=4
Line 2: Contains an array ‘arr’ of size 7.

arr=[9,7,5,3,2,1,8]

First step (K=1): we select 9 from the beginning so sum=9.

Second step (K=2): we select 8 from the end so sum= 9+8.

Third step (K=3): we select 7 from the beginning so sum=9+8+7.

Fourth step (K=4): we select 5 from the beginning so sum=9+8+7+5= 29.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5 3
8 7 5 3 2
Sample Output 1:
20
Explanation Of Sample Input 1:
K=1: we select 8 from the beginning so sum=8.
K=2: we select 7 from the beginning so sum= 8+7.
K=3: we select 5 from the beginning so sum=8+7+5.
Sample Input 2:
5 5
5 4 9 7 8
Sample Output 2:
33
Constraints:
1 <= N <= 10^5
0 <= K <= N
1 <= arr[i] <= 10^4

Time Limit: 1 sec
=================== Solution Idea ===================
Approach:

The approach optimises the solution by using a sliding window technique. We start with a window of size ‘K’ and calculate the initial sum. Then, we simulate moving the window from the end of the row by removing one card and adding another card from the other end. This allows us to find the maximum score without generating all possible combinations.

 

Algorithm:

Initialise ‘ans’  = 0
Initialise ‘sum’  = 0
for i from 0 to k-1:
sum = sum + arr[i]
ans = sum
N= length(arr)
for i from k-1 to 0:
sum = sum - arr[i]
sum = sum + arr[N - k + i]
ans = max(ans, sum)
return ans
Time Complexity
O(K), where ‘K’ is the number of cards to be taken.
 

The initial loop to calculate the sum of the first ‘K’ cards runs in O(K) time. The second loop iterates from ‘K’-1 to 0, performing constant-time operations in each iteration. Hence, it runs in O(K) time. Therefore, the overall time complexity of the algorithm is O(K).

Space Complexity
O(1)

 

The algorithm uses a constant amount of extra space for variables such as ‘sum’ and ‘ans’. Hence, the space complexity is O(1).
*/
public class Solution {
    public static int maxPoints(int []arr , int K){
        // Write your code here.
        int maxpoints = 0;
        int n = arr.length;
        for(int i=0;i<K;i++){
            maxpoints = maxpoints + arr[i];
        }
        int currentScore = maxpoints;
        for(int i=K-1;i>=0;i--){
            currentScore = currentScore - arr[i];
            currentScore = currentScore + arr[n-K+i];
            maxpoints = Math.max(maxpoints, currentScore);
        }
        return maxpoints;
    }
}
