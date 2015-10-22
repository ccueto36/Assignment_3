/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.BST;

/**
 *
 * @author admin
 */


public class BSTree<T> implements Comparable<T>{
    
    public BSTreeNode root;

    private BSTreeNode add(BSTreeNode n, int v)
    {
        if(n == null)
        {
             return new BSTreeNode(v);
        }

        if(v < n.data)
        {
          n.left = add(n.left, v);  
        }

        else if (v > n.data)
        {
            n.right = add(n.right, v);
        }
        else {
            // don't add a duplicate!!
        }
        return n;
    }
    
    public void add(int v)
    {
        this.root = add(root, v);
    }
    
    public void print()
    {
        print(root);
    }
    
    //in-order traversal
    public void print(BSTreeNode n)
    {
      if(n == null) return;
      print(n.left);
      System.out.println(n.data);
      print(n.right);
      
    }
    
    public BSTreeNode getRoot(){
        return root;
    }
    @Override
    public int compareTo(T t) {
       return 0; 
    }
    
    
    public int getLevel(BSTreeNode n, int data, int level){
        
        if (n == null) return 0;
        if (n.data == data) return level;
        
        int downlevel = getLevel(n.left, data, level++);
        if(downlevel != 0) return downlevel;
        
        downlevel = getLevel(n.right, data, level++);
        return downlevel;
    }
    
    
    public int getLevel(BSTreeNode n, int data)
    {
     return getLevel(n, data, 1);   
    }
    
    public int getTreeWidth(){
        return 0;
    }
}
