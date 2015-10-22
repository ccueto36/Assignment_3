/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3trees;

/**
 *
 * @author fernando
 */
public class Tree {
    private TreeNode overallRoot;
    
    public Tree(TreeNode overallRoot){
        this.overallRoot = overallRoot;
    }
    
    public void print( TreeNode root){
        if(root!=null){
            print(root.left);
            System.out.println(overallRoot.data + " ");
            print(root.right);
        }
    }
    
    public boolean  contains(int value){
        return contains(overallRoot, value);
    }
    
    private boolean contains(TreeNode node, int value){
        if (node==null){
            return false;
        }
        else if(node.data==value){
            return true;
        }
        else{
            return contains(node.left,value) || contains(node.right, value);
        }
    }
    
}
