// Problem statement: 
// Given a binary search tree, 
//write a function kth Smallest to find the kth smallest element in it.


//test case 1:
// Input : root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3


package com.techmisal.medium;

/**
 * Definition for a binary tree node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node(int x) { val = x; }
 * }
 */

 public int kthSmallest(Node root, int k) {
     
        int ans  =0 ;
        
        Node curr = root;
        int count = 0;
        
        while(curr  != null)
        {
            if(curr.left != null)
            {
                Node pred = curr.left;
                
                while(pred.right != null && pred.right != curr)
                {
                    pred = pred.right;
                    
                }
                if(pred.right == null)
                {
                    pred.right = curr;
                    curr= curr.left;
                }
                else
                {
                    pred.right = null;
                    count++;
                    if(k == count){
                    ans = curr.val;
                }
                    curr = curr.right;
                }
            }
            else
            {
                count++;
                if(count == k){
                    ans = curr.val;
                }
                curr = curr.right;
            }
        }
     return ans;   
    }