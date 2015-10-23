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

    private BSTreeNode add(BSTreeNode node, int value)
    {
        if(node == null)
        {
             return new BSTreeNode(value);
        }

        if(value < node.data)
        {
          node.left = add(node.left, value);  
        }

        else if (value > node.data)
        {
            node.right = add(node.right, value);
        }
        else {
            // don't add a duplicate!!
        }
        return node;
    }
    
    public void add(int value)
    {
        this.root = add(root, value);
    }
    
    public void print()
    {
        print(root);
    }
    
    //in-order traversal
    public void print(BSTreeNode node)
    {
      if(node == null) return;
      print(node.left);
      System.out.println(node.data);
      print(node.right);
      
    }
    
    @Override
    public int compareTo(T t) {
       return 0; 
    }
    
    
    public int getLevel(BSTreeNode node, int data, int level){
        
        if (node == null) return 0;
        if (node.data == data) return level;
        
        int downlevel = getLevel(node.left, data, level++);
        if(downlevel != 0) return downlevel;
        
        downlevel = getLevel(node.right, data, level++);
        return downlevel;
    }
    
    
    public int getLevel(BSTreeNode node, int data)
    {
     return getLevel(node, data, 1);   
    }
    
    public int getTreeWidth(){
        return 0;
    }
}
