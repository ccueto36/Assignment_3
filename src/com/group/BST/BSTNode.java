package com.group.BST;

/**
 * File: BSTNode.java
 */

/*
 * I affirm that this program is entirely my own work and none
 * of it is the work of any other person. 
 */

/**
 * A Binary Search Tree Node class.
 * 
 * This node class can be used for an standard BST as well as an AVL tree.
 * 
 * @author Miguel Espinal
 *
 * @param <E>
 *            Generic parameter so the node accepts any type of data.
 *            The data must be comparable.
 */
public class BSTNode<E>
{
	public E element; // Element for this node
	public BSTNode<E> left; // Pointer to left child
	public BSTNode<E> right; // Pointer to right child
	private int height; // height of this node (AVL Tree)

	/**
	 * Constructs a Binary Search Node
	 */
	public BSTNode()
	{
		left = right = null; // initialize variables
	}

	/**
	 * Constructs a Binary Search Node with a given element.
	 * 
	 * @param element
	 *            the data for the node.
	 */
	BSTNode( E element )
	{
		left = right = null; // Initialize child's
		this.element = element; // Set the data into the node

		// A node starts with height 1 as a Leaf
		// In an AVL Tree this node height gets updated.
		height = 1;
	}

	/**
	 * Constructs a Binary Search Node with a given element, as well as
	 * Left and Right child nodes.
	 * 
	 * @param element
	 *            the data for the node.
	 * @param left
	 *            the left child of this tree node.
	 * @param right
	 *            the right child of this tree node.
	 */
	BSTNode( E element, BSTNode<E> left, BSTNode<E> right )
	{
		// Set values
		this.left = left;
		this.right = right;
		this.element = element;

		// A node starts with height 1 as a Leaf
		// In an AVL Tree this node height gets updated.
		height = 1;
	}

	/**
	 * Verifies whether the tree node is a leaf or not.
	 * 
	 * @return true if a Leaf Node, false otherwise.
	 */
	public boolean isLeaf()
	{
		// If the left child and right child are null then is a leaf
		return (left == null) && (right == null);
	}

	/**
	 * Gets the height of this tree node.
	 * 
	 * @return the height of the tree node.
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * Sets the height of this tree node.
	 * 
	 * @param height
	 *            the value for the height.
	 */
	public void setHeight( int height )
	{
		this.height = height; // Set height
	}

}
