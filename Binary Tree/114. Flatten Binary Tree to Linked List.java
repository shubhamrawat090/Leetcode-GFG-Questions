// Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// Solution

// PreOrder

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        TreeNode origLeft = root.left;
        TreeNode origRight = root.right;
        
        if(prev!=null) {
            prev.left = null;
            prev.right = root;
        }
        
        prev = root;
            
        flatten(origLeft);
        flatten(origRight);
    }
}

// Reverse Post Order

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }   
        
        flatten(root.right);
        flatten(root.left);
        
        root.left = null;
        root.right = prev;
        
        prev = root;
    }
}

// DFS

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse0(root);
    }
    
    // return end of "linked-list"
    private TreeNode traverse0(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        TreeNode leftEnd = traverse0(left);
        
        if (leftEnd != null) {
            root.right = left;
            leftEnd.right = right;
        }
        
        TreeNode rightEnd = traverse0(right);
        
        if (rightEnd == null) {
            return leftEnd == null ? root : leftEnd;
        } else {
            return rightEnd;
        }
    }
}

// Iterative using Stack

class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        
        while( curr != null ) {
            // Backup the right node in stack
            if( curr.right != null ) 
                stack.push(curr.right);
            
            /* If there is a left node of current node, make it right node, else
            take the right node from the stack's top */
            curr.right = curr.left == null && !stack.isEmpty() ? stack.pop() : curr.left; 
            
            curr.left = null;
            
            curr = curr.right;
        }
    }
}