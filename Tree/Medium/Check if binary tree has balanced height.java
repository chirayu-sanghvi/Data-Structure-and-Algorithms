/*
Coding Ninja: https://www.codingninjas.com/studio/problems/is-height-balanced-binary-tree_975497
Leet Code: https://leetcode.com/problems/balanced-binary-tree/description/

Problem statement
You are given the root node of a binary tree.
Return 'true' if it is a height balanced binary tree.

Note:
Height of a tree is the maximum number of nodes in a path from the node to the leaf node.

An empty tree is a height-balanced tree. A non-empty binary tree is a height-balanced binary tree if
1. The left subtree of a binary tree is already the height-balanced tree.
2. The right subtree of a binary tree is also the height-balanced tree.
3. The difference between heights of left subtree and right subtree must not more than ‘1’.


Example:

Input: Consider the binary tree given below:

Output: 'true'

Explanation:
Consider subtree at Node ( 7 ) 
Left subtree height is ‘0’ and right subtree height is ‘0’, the absolute height difference is ‘0-0 = 0’ and ‘0’ is not more than ‘1’ so subtree at Node ( 7 ) is a height-balanced binary tree. 
Same for subtrees at Nodes ( 5, 6 ). 

Consider subtree at Node ( 4 ) 
Left subtree height is ‘1’ and right subtree height is ‘0’, the absolute height difference is ‘1-0 = 1’ and ‘1’ is not more than ‘1’ so subtree at Node ( 4 ) is a height-balanced binary tree.
Same for subtree at Node ( 3)

Consider subtree at Node ( 2 ) 
Left subtree height is ‘2’ and right subtree height is ‘1’, the absolute height difference is ‘2-1 = 1’ and ‘1’ is not more than ‘1’ so subtree at Node ( 2 ) is a height-balanced binary tree.

Consider subtree at Node ( 1 ) 
Left subtree height is ‘3’ and right subtree height is ‘2’, the absolute height difference is ‘3-2 = 1’ and ‘1’ is not more than ‘1’ so subtree at Node ( 1 ) is a height-balanced binary tree.

Because the root node ( 1 ) is a height-balanced binary tree, so the complete tree is height-balanced.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
1 2 3 4 -1 -1 -1 -1 5 -1 -1


Expected Answer:
false


Output on console:
false


Explanation of sample input 1:

Consider the root  Node ( 1 ) 
Left subtree height is ‘3’ ( 1->2->4->5) and right subtree height is ‘1’ ( 1->3), the absolute height difference is ‘2-1 = 2’ and ‘2’ is more than ‘1’ so subtree at Node ( 1 ) is not a height-balanced binary tree.
Hence we return ‘false’.


Sample Input 2:
1 2 3 4 -1 -1 5 -1 -1 -1 -1


Expected Answer:
true


Output on console:
true


Explanation of sample input 2:

Consider the subtree at Node ( 4 ) 
Left subtree height is ‘0’ and right subtree height is ‘0’, the absolute height difference is ‘0-0 = 0’ and ‘0’ is not more than ‘1’ so subtree at Node ( 4 ) is a height-balanced binary tree.
Same for subtree at Node ( 5 ).

Consider the subtree at Node ( 2 ) 
Left subtree height is ‘1’ and right subtree height is ‘0’, the absolute height difference is ‘1-0 = 1’ and ‘1’ is not more than ‘1’ so subtree at Node ( 2 ) is a height-balanced binary tree.
Same for subtree at Node ( 3 ).

Consider the subtree at Node ( 1 ) 
Left subtree height is ‘2’ (1->2->4) and right subtree height is ‘2’ (1->3->5), the absolute height difference is ‘2-2 = 0’ and ‘0’ is not more than ‘1’ so subtree at Node ( 1 ) is a height-balanced binary tree.

Hence root node (1) is a height-balanced binary tree that’s why the complete tree is a height-balanced binary tree. 
Hence we return ‘true’.


Expected Time Complexity:
Try to do this in O(n).


Constraints:
0 <= n <= 10000

Where 'n' is the total number of nodes in the binary tree.

Time Limit: 1 sec
*/
/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode
    {
    public:
        T val;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T val)
        {
            this->val = val;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/
int height(TreeNode<int>* root,bool &temp){
    if(root==NULL)
        return 0;
    int left = height(root->left,temp);
    int right = height(root->right,temp);
    int diff = left-right;
    if(diff<-1 || diff>1)
        temp = false;
    return max(left,right)+1;
}
bool isBalancedBT(TreeNode<int>* root){
    bool temp = true;
    height(root,temp);
    return temp;
}
