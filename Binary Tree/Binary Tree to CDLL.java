// Link: https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1/#

// Solution

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
    static void displayCList(Node head)
    {
        Node itr = head;
        do
        {
            System.out.print(itr.data + " ");
            itr = itr.right;
        } while (head!=itr);
        System.out.println();
    	itr=itr.left;
    	do{
    		System.out.print(itr.data + " ");
    		itr=itr.left;
    	}while(head!=itr);
    	System.out.println(itr.data + " ");
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Solution boj = new Solution();
	            Node head = boj.bTreeToClist(root);
	            displayCList(head);
	            
	        }
	    
	}
}


// } Driver Code Ends


//User function Template for Java



//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    {
        //your code here
        root = helper(root);
        return root;
    }
    
    Node helper(Node root) {
        if(root==null) {
            return null;
        }
        
        Node lhead = helper(root.left);
        Node rhead = helper(root.right);
        
        Node oneNodeList = root;
        oneNodeList.left = oneNodeList.right = oneNodeList;
        
        Node step1 = concat(lhead, oneNodeList);
        Node step2 = concat(step1, rhead);
        
        return step2;
    }
    
    Node concat(Node h1, Node h2) {
        if(h1==null) {
            return h2;
        }
        
        if(h2==null) {
            return h1;
        }
        
        Node t1 = h1.left;
        Node t2 = h2.left;
        
        t1.right = h2;
        h2.left = t1;
        
        t2.right = h1;
        h1.left = t2;
        
        return h1;
    }
}
    

