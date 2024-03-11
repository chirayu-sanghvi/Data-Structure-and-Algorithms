/*
Coding Ninja: https://www.codingninjas.com/studio/problems/sorting-characters-by-frequency_1263699
Problem statement
You have been given a string ‘S’.



You must return the string ‘S’ sorted in decreasing order based on the frequency of characters.

If there are multiple answers, return any of them.



Example :
Let 'S'= “abAb”. 

Here the characters ‘a’ and ‘A’ have frequency 1 and character ‘b’ has frequency ‘2’.  

Therefore the sorted string is “bbAa”. 
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
abcAbc
Sample Output 1 :
true
Explanation Of Sample Output 1 :
The frequency of characters ‘a’ and ‘A’ are 1. The frequency of characters ‘b’ and ‘c’ are 2. 

Therefore the sorted string is “bbccAa”. 
Sample Input 2 :
7
gggjhhh    
Sample Output 2 :
true
Constraints :
1 <= 'N' <= 10^5

String 'S' consists of both lowercase and uppercase alphabet characters.

Time Limit: 1sec
Follow Up:
Can you solve this in O(N*Log(N)) time?
*/
import java.util.*;

public class Solution {

    public static String sortByFrequency(int n, String s) {

        // Write Your Code here

        HashMap<Character, Integer> h=new HashMap<>();

        for(int i=0;i<n;i++){

            if(h.containsKey(s.charAt(i))){

                h.put(s.charAt(i),h.get(s.charAt(i))+1);

            }

            else{

                h.put(s.charAt(i),1);

            }

        }

        StringBuilder ans = new StringBuilder();

        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->(h.get(b)-h.get(a)));

        pq.addAll(h.keySet());

        while(!pq.isEmpty()){

           char ch=pq.poll();

           for(int i=0; i<h.get(ch); i++){

               ans.append(ch);

           }

        }


        return ans.toString();

            

    }

}
