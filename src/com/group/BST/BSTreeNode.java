/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.BST;
import java.util.Iterator;
/**
 *
 * @author cacueto
 */
public class BSTreeNode {
    int data;
    BSTreeNode left = null;
    BSTreeNode right = null;
    int xpos;
    int ypos;
    
    public BSTreeNode(int data)
    {
        this(data, null, null);
    }
    
    public BSTreeNode(int data, BSTreeNode left, BSTreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public Object getData(){
        return data; }
    public BSTreeNode getLeft()  { 
        return left; }
    public BSTreeNode getRight() { 
        return right; }
    
}
