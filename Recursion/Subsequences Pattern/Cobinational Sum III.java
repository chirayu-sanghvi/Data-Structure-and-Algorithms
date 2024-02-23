/*
Coding Ninja: https://www.codingninjas.com/studio/problems/combination-sum-iii_5038357
Problem statement
You are given ‘k’ and ‘n’ and you have to do the following:-



Return all possible combinations of arrays whose elements sum is equal to ‘n’, and you can use only elements in the range '1' to '9' inclusive, and you can use each element at most once, and the size of the combination should be exactly ‘k’.



If there is no combination, return an empty array.



It should be noted that the 2-D array should be returned in sorted order, meaning the lexicographically smaller array should come first.



Also, at each index of the 2-D array, the elements present in the array present at that index should be in sorted order.



Note:
Two combinations are called different if an element is in one combination and not in another. 

Also, in the output, you will see the 2-D array returned by you.


Example:
Input: ‘k’ = 2, ‘n’ = ‘5’

Output: [[1, 4], [2, 3]]

Sample Explanation: 1 + 4 = 5 and 2 + 3 = 5. Only these two combinations are there, which sum up to n, so the answer is [[1, 4], [2, 3]].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
2
5
Sample Output 1 :
1 4
2 3
Explanation Of Sample Input 1 :
1 + 4 = 5 and 2 + 3 = 5. Only these two combinations are there which sum upto n so answer is [[1, 4], [2, 3]].
Sample Input 2 :
3
8
Sample Output 2 :
1 2 5
1 3 4
Explanation Of Sample Input 2 :
1 + 2 + 5 = 8 and 1 + 3 + 4 = 8. Only these two combinations are there which sum upto n so answer is [[1, 2, 5], [1, 3, 4]].
Expected Time Complexity :
The expected time complexity is O(2^k), where k is the given integer.
Expected Space Complexity :
The expected space complexity is O(k), where k is the given integer.
Constraints :
2 <= k <= 9
1 <= n <= 60

Time Limit: 1 sec
*/
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    static void rec(int idx,int n,int k, ArrayList<ArrayList<Integer>> al, ArrayList<Integer> dl){  
        if(k==0 && dl.size()==n) al.add(new ArrayList<>(dl));
      for(int i=idx;i<10;i++){
        if(i>k) break;
        dl.add(i);
        rec(i+1,n,k-i,al,dl);
        dl.remove(dl.size()-1);
      }
    }
    static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        // Write your code here.
       ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
       rec(1,k,n,ans,new ArrayList<>());
       return ans;
    }
}
