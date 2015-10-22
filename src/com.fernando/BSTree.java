/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3trees;

import java.util.NoSuchElementException;

/**
 *
 * @author fernando
 */
public class BSTree {
    private TreeNode overallRoot;
    
    public BSTree(TreeNode overallRoot){
        this.overallRoot = overallRoot;
    }
    
    public void print( TreeNode root){
        if(root!=null){
            print(root.left);
            System.out.println(overallRoot.data + " ");
            print(root.right);
        }
    }
    
    public int getMin(){
        if (overallRoot == null){
            throw new NoSuchElementException();
        }
        return getMin(overallRoot);
    }
    
    private int getMin(TreeNode root){
        if(root.left == null){
            return root.data;
        }
        else{
            return getMin(root.left);
        }
    }
    public int getMax(){
        if(overallRoot==null){
            throw new NoSuchElementException();
        }    
        return getMax(overallRoot);
    }
    
    private int getMax(TreeNode root){
        if(root.right == null){
            return root.data;
        }
        else{
            return getMin(root.right);
        }
    }
    
    public void remove(int value){
        overallRoot=remove(overallRoot,value);
    }
    
    private TreeNode remove(TreeNode root, int value){
        if (root == null){
            return null;
        }
        else if(root.data>value){
            root.left = remove(root.left, value);
        }
        else if( root.data < value){
            root.right = remove(root.right, value);
        }
        else {
            if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                root.data = getMin(root.right);
                root.right = remove(root.right, root.data);
            }
        }
        return root;
    }
    
}
