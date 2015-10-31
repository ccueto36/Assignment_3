package com.group.BST;

/**
 * File: TreeTraversal.java
 */

/*
 * I affirm that this program is entirely our own work and none
 * of it is the work of any other person. 
 */

/**
 * Tree Traversal class to traverse and visit tree nodes.
 * 
 * Time Complexity: O(n). Each node in a tree is visited exactly once, and each
 * child pointer is followed exactly once.
 * 
 * @author Miguel Espinal
 *
 */
public class TreeTraversal
{

	/**
	 * In order traversal.
	 * 
	 * Traverse the left subtree, visit the root, then traverse the right
	 * subtree.
	 * 
	 * @param root
	 *            the root of the tree to be traversed.
	 */
	public static <E> void inOrderTraversal( BSTNode<E> root )
	{
		inOrder(root);
	}

	/**
	 * Pre order traversal.
	 * 
	 * Visit the root, traverse the left subtree, then traverse the right
	 * subtree.
	 * 
	 * @param root
	 *            the root of the tree to be traversed.
	 */
	public static <E> void preOrderTraversal( BSTNode<E> root )
	{
		preOrder(root);
	}

	/**
	 * Post order traversal.
	 * 
	 * Traverse the left subtree, traverse the right subtree, then visit the
	 * root.
	 * 
	 * @param root
	 *            the root of the tree to be traversed.
	 */
	public static <E> void postOrderTraversal( BSTNode<E> root )
	{
		postOrder(root);
	}

	/**
	 * In order helper method.
	 * 
	 * @param root
	 *            the root of the tree to be traversed.
	 */
	private static <E> void inOrder( BSTNode<E> root )
	{
		if ( root == null )
			return;

		inOrder(root.left);
		System.out.print(root.element + " ");
		inOrder(root.right);
	}

	/**
	 * Pre order helper method.
	 * 
	 * @param root
	 *            the root of the tree to be traversed.
	 */
	private static <E> void preOrder( BSTNode<E> root )
	{
		if ( root == null )
			return;

		System.out.print(root.element + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	/**
	 * Post order helper method.
	 * 
	 * @param root
	 *            the root of the tree to be traversed.
	 */
	private static <E> void postOrder( BSTNode<E> root )
	{
		if ( root == null )
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.element + " ");
	}
}
