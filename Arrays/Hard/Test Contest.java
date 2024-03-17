/*
Coding Ninja: https://www.codingninjas.com/studio/problems/team-contest_6840309
Leet Code: https://leetcode.com/problems/reverse-pairs/description/
Problem statement
School is organizing a team contest. You are given an array ‘SKILL’ containing the skill level of ‘N’ candidates.



Two candidates(having index ‘i’ and ‘j’) can pair up to form a team if for index i < j, SKILL[i] > 2*SKILL[j].

Your task is the return the count of all the possible pairs to take part in the contest.



Example:
Input: ‘N’ = 5
‘SKILL’ = [4, 1, 2, 3, 1] 

Output: 3
Explanation:
Possible pairs are (4,1), (4,1), (3,1).
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
4 1 2 3 1
Sample Output 1 :
3
Explanation Of Sample Input 1:
Possible pairs are (4,1), (4,1), and (3,1).
Sample Input 2:
4 
100 49 201 100
Sample Output 2 :
2
Constraints:
1  <= N <= 10^5
1 <= SKILL[i] <= 10^6
Time Limit: 1 sec
*/ 
public class Solution {
    public static int team(int []skill, int n){
        // Write your code here.
        return mergesort(skill, 0, n-1);
    }

    public static int mergesort(int[] skill, int l, int r){
        int count = 0;
        if(l>= r){
            return count;
        }
        int m = (l+r)/2;
        count = count + mergesort(skill, l, m);
        count = count + mergesort(skill, m+1, r);
        count = count + merge(skill, l,m,r);
        return count;
    }

    public static int merge(int[] skill, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int count = 0;
        int rside = 0;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i =0; i<n1;i++){
            left[i] = skill[l+i];
        }

        for(int j=0;j<n2;j++){
            right[j] = skill[m+1+j];
        }

        for(int i = 0;i<n1;i++){
            while(rside < n2 && left[i] > 2*right[rside]){
                rside++;
            }
            count = count + (rside);
        }

        int i=0, j = 0, k= l;
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                skill[k] = left[i];
                i++;
                k++;
            } else {
                skill[k] = right[j];
                j++;
                k++;
            }
        }

        while(i<n1){
            skill[k] = left[i];
            i++;
            k++;
        }

        while(j<n2){
            skill[k] = right[j];
            j++;
            k++;
        }
        return count;
    }
}
