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
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
    
    public TreeNode(int data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
}
