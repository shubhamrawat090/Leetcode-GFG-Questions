// Link: https://leetcode.com/problems/increasing-order-search-tree/

// Solution: DFS -> Changing the tree itself OR Making a new Tree, BOTH SOLUTIONS

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //made tail global as it shouldn't change in recursion calls
    TreeNode tail;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        //make dummy node which traverses the tree inorder and makes the required tree
        TreeNode dummy = new TreeNode(0);
        tail = dummy;
        inorder(root);
        
        //return dummy.right as first node was just a dummy
        return dummy.right;
    }
    
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        //LEFT CALL
        inorder(root.left);
        
        //NODE PROCESSING
        
        //remove cycle
        // root.left = null;
        // tail.right = root;
        // tail = tail.right;
        
        //if you do not want to mess with the tree then just make a new node and join it to tail's right
        //WON'T HAVE TO WORRY ABOUT CYCLE
        tail.right = new TreeNode(root.val);
        tail = tail.right;
        
        //RIGHT CALL
        inorder(root.right);
    }
}