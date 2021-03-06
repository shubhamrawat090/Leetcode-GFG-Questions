// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

// Solution : USING NODE TO ROOT PATH

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> rootToP = nodeToRootPath(root, p);
        ArrayList<TreeNode> rootToQ = nodeToRootPath(root, q);
        
        int i=rootToP.size()-1, j=rootToQ.size()-1;
        TreeNode LCA = null;
        
        while(i>=0 && j>=0){
            TreeNode P = rootToP.get(i);
            TreeNode Q = rootToQ.get(j);
            if(Q!=P){
                break;
            }
            LCA = P;
            i--; j--;
        }
        
        return LCA;
    }
    
    private ArrayList<TreeNode> nodeToRootPath(TreeNode root, TreeNode node){
        if(root == null){
            return new ArrayList<>();
        }
        
        if(root.val<node.val){
            //node is present on the right so call right side only
            ArrayList<TreeNode> right = nodeToRootPath(root.right, node);
            //if there is an ans for right subtree then add root to it and return
            if(right.size()>0){
              right.add(root);
              return right;
            }
        } 
        
        else if(node.val<root.val){
            //node is present on the left side 
            ArrayList<TreeNode> left = nodeToRootPath(root.left, node);
            //if there is an ans for left subtree then add root to it and return
            if(left.size()>0){
              left.add(root);
              return left;
            }
        }
        else{
            //node and root are the same
            ArrayList<TreeNode> temp = new ArrayList<>();
            temp.add(root);
            return temp;
        }
            
        //no ans found
        return new ArrayList<>();    
    }
    
}


// USING RECURSION DFS

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //tree doesn't exist
        if(root==null) 
            return null;
        
        //both p and q exist on the right => their LCA will also exist on the right subtree
        if(root.val<p.val && root.val<q.val) 
            return lowestCommonAncestor(root.right,p,q);
        //both p and q exist on the left => their LCA will also exist on the left subtree
        else  if(root.val>p.val && root.val>q.val) 
            return lowestCommonAncestor(root.left,p,q);
        // either of p or q is root which means that is the LCA
        // ROOT IS ALWAYS THE LCA
        else return root;
    }
}