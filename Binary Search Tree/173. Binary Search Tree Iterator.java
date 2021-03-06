// Link: https://leetcode.com/problems/binary-search-tree-iterator/

// Solution: Using Stack

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
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        fillStack(root);
    }

    public int next() {
        TreeNode top = st.pop();
        fillStack(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void fillStack(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */