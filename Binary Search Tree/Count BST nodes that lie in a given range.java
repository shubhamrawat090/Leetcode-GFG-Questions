// Link: https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1

// Solution: BST property

// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
	            String[] ab = br.readLine().trim().split(" ");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			    System.out.println(g.getCount(root,a,b));
                t--;
            
        }
    }
  
}

// } Driver Code Ends


// A Binary Search Tree node


class Tree
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int low, int high)
    {
        
        if(root == null) {
            return 0;
        }
        
        //initialize count = 0
        int count = 0;
        
        //set count to 1 only if it is inside range
        if(root.data >=low && root.data <= high) {
            count  = 1;
        }
        
        //we can go to left only if low < root.data as there will be values to explore there
        if(low < root.data)
            count += getCount(root.left, low, high);//add the count derived from left subtree
        
        //we can go to right only if high > root.data as there will be values to explore there
        if(high > root.data)
            count += getCount(root.right, low, high);//add the count derived from right subtree
        
        //return final count
        return count;
    }
}
