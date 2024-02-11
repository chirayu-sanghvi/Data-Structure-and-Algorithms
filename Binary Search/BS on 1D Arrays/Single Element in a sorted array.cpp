/*
Coding Ninja: https://www.codingninjas.com/studio/problems/unique-element-in-sorted-array_1112654
Leet Code: https://leetcode.com/problems/single-element-in-a-sorted-array/description/
Problem statement
You are given a sorted array ‘arr’ of ‘n’ numbers such that every number occurred twice in the array except one, which appears only once.



Return the number that appears once.



Example:
Input: 'arr' = [1,1,2,2,4,5,5]

Output: 4 

Explanation: 
Number 4 only appears once the array.


Note :
Exactly one number in the array 'arr' appears once.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
5 
1 1 3 5 5 


Sample Output 1 :
3 


Explanation of Sample Input 1 :
Given array is [1, 1, 3, 5, 5]    
Here, 3 occurs once in the array. So, the answer is 3.


Sample Input 2 :
5
1 1 4 4 15


Sample Output 2 :
15


Explanation of Sample Input 2 :
The array is [1, 1, 4, 4, 15].    
Here, 15 occurs once in the array. So, the answer is 15.


Expected Time Complexity:
Try to solve this in O(log(n)).


Constraints :
1 <= n <= 10^5
0 <= arr[i] <= 10^9

Time Limit: 1 sec
*/
// This is the solution in c++ because java compiler was not accepting java solution, maybe some bug in the java compiler 
// for this question but yeah the logic is same and can be understood by C++ solution.
int singleNonDuplicate(vector<int>& a)

{

    // Write your code here

    int l = 0, h = a.size()-1,res = 0;

    while (l <= h){

        int mid = (l+h)/2;

        if (mid%2 && a[mid-1] != a[mid]){

            h = mid-1;

        }

        else if (mid%2 && a[mid-1] == a[mid])   l = mid+1;

        else if (mid%2 == 0 && a[mid] != a[mid+1]){

            h = mid-1;

            res = mid;

        }

        else    l = mid+1;

    }

    return a[res];

}
