/*
Coding Ninja: https://www.codingninjas.com/studio/problems/k-th-element-of-2-sorted-array_1164159

Problem statement
You're given two sorted arrays 'arr1' and 'arr2' of size 'n' and 'm' respectively and an element 'k'.
Find the element that would be at the 'kth' position of the combined sorted array.
Position 'k' is given according to 1 - based indexing, but arrays 'arr1' and 'arr2' are using 0 - based indexing.

For example :
Input: 'arr1' = [2, 3, 45], 'arr2' = [4, 6, 7, 8] and 'k' = 4
Output: 6
Explanation: The merged array will be [2, 3, 4, 6, 7, 8, 45]. The element at position '4' of this array is 6. Hence we return 6.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
2 3 6 7 9
4
1 4 8 10
4
Sample Output 1:
4
Explanation of sample input 1 :
The merged array will be: [1, 2, 3, 4, 6, 7, 8, 9, 10]

The element at position '4' is 4 so we return 4.
Sample Input 2:
5
1 2 3 5 6
5
4 7 8 9 100  
6
Sample Output 2:
6
Explanation of sample input 2 :
The merged array will be: [1, 2, 3, 4, 5, 6, 7, 8, 9, 100]

The element at position '6'  is 6, so we return 6.
Constraints :
1 <= 'n' <= 5000
1 <= 'm' <= 5000
0 <= 'arr1[i]', 'arr2[i]' <= 10^9
1 <= 'k' <= 'n' + 'm'

'n' and 'm' denote the size of 'arr1' and 'arr2'.

Time limit: 1 second
Expected time complexity :
The expected time complexity is O(log('n') + log('m')). 
*/
import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here
        if(n+m < k){
            return -1;
        }
        int count = 0;
        int i =0,j=0;
        while(i<n || j<m){
            if(arr1.get(i) <= arr2.get(j)){
                i++;
                count++;
                if(count == k){
                    return arr1.get(i-1);
                }
            }
            else{
                j++;
                count++;
                if(count == k){
                    return arr2.get(j-1);
                }
            }
            // System.out.println(i+" "+j+" "+count);
        }

        while(i < n){
            i++;
            count++;
            if(count==k){
                return arr1.get(i-1);
            }
        }

        while(j<m){
            j++;
            count++;
            if(count == k){
                return arr2.get(j-1);
            }
        }
        
        return 0;
    }
}
