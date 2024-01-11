/*
Coding Ninja: https://www.codingninjas.com/studio/problems/fractional-knapsack_975286
Leet Code: https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

Problem statement
You have been given weights and values of ‘N’ items. You are also given a knapsack of size ‘W’.

Your task is to put the items in the knapsack such that the total value of items in the knapsack is maximum.

Note:
You are allowed to break the items.
Example:
If 'N = 4' and 'W = 10'. The weights and values of items are weights = [6, 1, 5, 3] and values = [3, 6, 1, 4]. 
Then the best way to fill the knapsack is to choose items with weight 6, 1 and  3. The total value of knapsack = 3 + 6 + 4 = 13.00   
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 100
1 <= N <= 5000
1 <= W <= 10^5
1 <= weights[i] <= 10^5
1 <= values[i] <= 10^5

Time limit: 1 sec
Sample Input 1:
1
6 200
50 40 90 120 10 200 
40 50 25 100 30 45
Sample output 1:
204.00
Explanation of Sample output 1:
The most optimal way to fill the knapsack is to choose full items with weight 10 and value 30, weight 40 and value 50, weight 120 and value 100. Then take weight 30 from the item with weight 50 and value 40.

The total value =  30 + 50 + 100 + (30/50)*(40) = 204.00
Sample Input 2:
1
5 100
20 24 36 40 42
12 35 41 25 32
Sample output 2:
106.48
*/

import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/
class itemComparator implements Comparator<Pair>
{
	@Override
	public int compare(Pair a, Pair b){
		double r1 = (double)a.value / (double)a.weight;
		double r2 = (double)b.value / (double)b.weight;
		if(r1 < r2) return 1;
		else if(r1 > r2) return -1;
		else return 0;
	}
}

public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.
			Arrays.sort(items, new itemComparator());
			int currWeight = 0;
			double finalValue = 0.0;

			for(int i=0;i<n;i++){
				if(currWeight + items[i].weight < w){
					currWeight = currWeight + items[i].weight;
					finalValue = finalValue + items[i].value;
				}
				else {
					int remain = w - currWeight;
					finalValue += ((double)items[i].value/ (double)items[i].weight) * (double)remain;
					break;
				}
			}
		return finalValue;

    }
}
