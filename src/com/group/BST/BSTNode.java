package com.group.BST;
	// Miguel Espinal
public class BSTNode<E>
{
	public E element;				// Element for this node
	public BSTNode<E> left;		// Pointer to left child
	public BSTNode<E> right;		// Pointer to right child
	
	// Miguel Espinal
	public BSTNode()
	{
		left = right = null;
	}
	
	// Miguel Espinal
	BSTNode(E element)
	{
		left = right = null;
		this.element = element;
	}
	
	// Miguel Espinal
	BSTNode(E element, BSTNode<E> left, BSTNode<E> right)
	{
		this.left = left;
		this.right = right;
		this.element = element;
	}
	
	// Miguel Espinal
	//return True if a Leaf Node, false otherwise
	public boolean isLeaf()
	{
		return (left == null) && (right == null);
	}
	
}
