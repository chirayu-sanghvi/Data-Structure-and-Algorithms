/*
Coding Ninja: https://www.codingninjas.com/studio/problems/floor-from-bst_625868

Problem statement
Given a binary search tree and an integer.Find the floor value of a key in a binary search tree .

(If k lies in BST then is floor equal to k,else floor is equal to previous greater value) Note: k would never be less than the minimum element of tree.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1:
2
Sample Input 2:
7
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 2:
6
*/
import java.util.*;

public class solution {
	public static int Floor(BinaryTreeNode<Integer> node, int input) {
        int floor = -1;
        while(node != null){
            if(node.data == input){
                floor = node.data;
                return floor;
            }
            if(input > node.data){
                floor = node.data;
                node = node.right;
            }
            else{
                node = node.left;
            }   
        }
        return floor;
	}

}
