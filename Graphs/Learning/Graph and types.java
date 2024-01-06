/*
Coding Ninja: https://www.codingninjas.com/studio/problems/counting-graphs_8357237
*/
public class Solution {
    public static int countingGraphs(int N) {
        // Write your code here.
        return (int)Math.pow(2, (N)*(N-1)/2);
    }
}
