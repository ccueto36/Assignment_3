package com.group.BST;

/**
 * File: BST.java
 */

/*
 * I affirm that this program is entirely our own work and none
 * of it is the work of any other person. 
 */

/**
 * A generic Binary Search Tree class.
 * 
 * This class extends comparable to be able to make key values
 * any type, since the method compareTo can be override for Objects
 * it makes it simple to add anything to this tree. The class is extended to add
 * AVL Tree's insertions and deletions.
 * 
 * @author Miguel Espinal
 * @author Fernando Serrano
 */
public class BST<E extends Comparable<E>>
{
	private BSTNode<E> root; // Root of the BST
	private int nodecount; // Number of nodes in the BST

	/**
	 * A constructor for an empty BST.
	 */
	public BST()
	{
		root = null;
		nodecount = 0;
	}

	/**
	 * Resets the BST as an empty tree
	 */
	public void clear()
	{
		root = null;
		nodecount = 0;
	}

	/**
	 * Gets the root of the BST.
	 * 
	 * @return the root of the BST.
	 */
	public BSTNode<E> getRoot()
	{
		return root;
	}

	/**
	 * Inserts a record into the tree. Records can be anything, but must be
	 * Comparable.
	 * 
	 * Time Complexity: O(n). The cost of inserting a record is the depth
	 * of the node inserted. In the worst case it can take the full height
	 * of the tree thus O(n).
	 * 
	 * @param element
	 *            the record to insert.
	 */
	public void insert( E element )
	{
		root = inserthelp(root, element); // calls the insert helper method
		nodecount++; // increases the tree node count
	}

	/**
	 * Helper method for BST insert.
	 * 
	 * @param root
	 *            the node to be inserted.
	 * @param element
	 *            the data value of the record to insert.
	 * @return the inserted BST Node to the insert method.
	 * 
	 *         Time Complexity: O(n). The cost of inserting a record is the
	 *         depth
	 *         of the node inserted. In the worst case it can take the full
	 *         height
	 *         of the tree thus O(n).
	 */
	private BSTNode<E> inserthelp( BSTNode<E> root, E element )
	{
		// Checks what the root is pointing to.
		if ( root == null )
		{
			return new BSTNode<E>(element);
		}

		if ( root.element.compareTo(element) == 0 )
		{
			// the compared elements in the tree are equal
			// duplicates are not allowed, therefore
			// nothing happens
		}
		else if ( root.element.compareTo(element) > 0 )
		{
			// the element at the root is greater than
			// what we are looking for, so we visit the left side of the tree
			// and we assign the element to its corresponding place as
			// the left child of the current processed root
			root.left = inserthelp(root.left, element);
		}
		else
		{
			// the element at the root is less than
			// what we are looking for, so we visit the right side of the tree
			// and we assign the element to its corresponding place as
			// the right child of the current processed root
			root.right = inserthelp(root.right, element);
		}

		return root; // return the initial root
	}

	/**
	 * Helper method for BST remove.
	 * 
	 * @param key
	 *            the value of the record to remove.
	 * @return the record removed, null if there is none.
	 * 
	 *         Time Complexity: O(n). In the worst case a deletion can take the
	 *         full
	 *         height of a tree, thus O(n). It depends on the depth of the node
	 *         to
	 *         be removed.
	 */
	public E remove( E key )
	{
		E temp = findhelp(root, key); // Find the record first

		// If the record is not null then remove it
		if ( temp != null )
		{
			root = removehelp(root, key); // Now remove it
			nodecount--;
		}

		return temp;
	}

	/**
	 * Helper method for BST remove.
	 * 
	 * @param key
	 *            the value of the record to remove.
	 * @return the record removed, null if there is none.
	 * 
	 *         Time Complexity: O(n). In the worst case a deletion can take the
	 *         full
	 *         height of a tree, thus O(n). It depends on the depth of the node
	 *         to
	 *         be removed.
	 */
	private BSTNode<E> removehelp( BSTNode<E> root, E element )
	{
		if ( root == null )
		{
			return root; // nothing to delete since the root points to null
		}

		if ( root.element.compareTo(element) > 0 )
		{
			// the element is smaller than the root
			// look in the left side until you find it
			root.left = removehelp(root.left, element);
		}
		else if ( root.element.compareTo(element) < 0 )
		{
			// the element is greater than the root
			// look in the right side until you find it
			root.right = removehelp(root.right, element);
		}
		else // the record to be deleted is found
		{
			if ( root.left == null )
			{
				// the value of the left child is null then we return that
				// node's right pointer back to the parent
				return root.right;
			}
			else if ( root.right == null )
			{
				// the value of the right child is null then we return that
				// node's left pointer back to the parent
				return root.left;
			}
			else // it has two children
			{
				// temporary node with the greates value in the left subtree
				BSTNode<E> temp = getmax(root.left);
				// set the root value to what was returned by getmax
				root.element = temp.element;
				// call deletemax to removed the node with the maximum value
				// in the left subtree and set the root node's left pointer
				// to the resulting subtree
				root.left = deletemax(root.left);
			}
		}

		return root; // returns a pointer to this tree
	}

	/**
	 * Returns the value of the record searched.
	 * 
	 * @param key
	 *            the value to be search for.
	 * @return the value searched
	 * 
	 *         Time Complexity: O(n). In the worst case a deletion can take the
	 *         full
	 *         height of a tree, thus O(n). It depends on the depth of the node
	 *         to
	 *         be removed.
	 */
	public E find( E key )
	{
		return findhelp(root, key);
	}

	/**
	 * Helper method for find.
	 * 
	 * @param key
	 *            the value to be search for.
	 * 
	 * @param root
	 *            the root of the tree to be searched.
	 * 
	 * @return the value searched
	 * 
	 *         Time Complexity: O(n). In the worst case a deletion can take the
	 *         full height of a tree, thus O(n). It depends on the depth of
	 *         the node to be removed.
	 */
	private E findhelp( BSTNode<E> root, E key )
	{
		// Checks for the root to not be pointing to null
		if ( root == null )
		{
			return null;
		}

		// Compare the key with the current root element
		// to determine which side whether left or right of the tree
		// to look for
		if ( root.element.compareTo(key) > 0 )
		{
			// the element is smaller than the element of the root
			// look in the left side until you find it
			return findhelp(root.left, key);
		}
		else if ( root.element.compareTo(key) == 0 )
		{
			// the element of the root and the key
			// are equal so just return the element of the root
			return root.element;
		}
		else
			// the element is greater than the element of the root
			// look in the left side until you find it
			return findhelp(root.right, key);

	}

	/**
	 * Utility method to delete the maximum value of the current tree.
	 * 
	 * @param root
	 *            the root to delete the maximum value.
	 * @return a pointer to the new root
	 * 
	 */
	private BSTNode<E> deletemax( BSTNode<E> root )
	{
		// the value of the right child is null then we return that
		// node's left pointer back to the parent
		if ( root.right == null )
		{
			return root.left;
		}

		// We change the current max to the next max
		root.right = deletemax(root.right);
		return root; // return a pointer to the new tree
	}

	/**
	 * Gets the maximum value in the tree
	 * 
	 * @param root
	 *            the root of the tree in which to find the max
	 * @return the maximum value of the tree
	 * 
	 *         Time Complexity: O(log n). Checks half of the tree for the max.
	 */
	public BSTNode<E> getmax( BSTNode<E> root )
	{
		// if the right child is null return a pointer of the current root
		if ( root.right == null )
		{
			return root;
		}

		// Keep looking in the right child until its null then we have the max
		return getmax(root.right);
	}

	/**
	 * Gets the minimum value in the tree
	 * 
	 * @param root
	 *            the root of the tree in which to find the min
	 * @return the minimum value of the tree
	 * 
	 *         Time Complexity: O(log n). Checks half of the tree for the min.
	 */
	public BSTNode<E> getmin( BSTNode<E> root )
	{
		// if the left child is null return a pointer of the current root
		if ( root.left == null )
		{
			return root;
		}

		// Keep looking in the left child until its null then we have the min
		return getmin(root.left);
	}

	/**
	 * Returns the height of this tree.
	 * 
	 * @return the height of the tree.
	 */
	public int height()
	{
		return height(root);
	}

	/**
	 * Helper method of height.
	 * 
	 * @param root
	 *            the tree of which the height will be calculated.
	 * @return the height value
	 * 
	 *         Time Complexity: O(n). Checks the full tree for heights.
	 */
	private int height( BSTNode<E> root )
	{
		// if the root is null, return - 1 to subtract
		// and get an accurate height
		if ( root == null )
		{
			return -1;
		}

		// the height of the tree equals 1 + the maximum of the height
		// of the left and right subtrees
		return 1 + Math.max(height(root.left), height(root.right));
	}

	/**
	 * If the tree is height balance returns true.
	 * 
	 * @param root
	 *            the root of the tree
	 * @return true if the tree is height balance, false otherwise
	 * 
	 *         Time Complexity: O(n^2). Checks the tree twice for the heights of
	 *         each
	 *         side.
	 */
	public boolean isBalanced( BSTNode<E> root )
	{
		int leftHeight; // stores the left subtree height
		int rightHeight; // stores the right subtree height

		// if the root is null there is no height so it is balanced; return true
		if ( root == null )
		{
			return true;
		}

		leftHeight = height(root.left); // calculate left subtree height
		rightHeight = height(root.right); // calculate right subtree height

		// if the difference between the left and right height is less than one
		// and the left and right subtrees are balanced then return true
		if ( Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right) )
		{
			return true;
		}

		return false; // at this point the tree is not balanced; return false
	}

	/**
	 * Returns the number of nodes in this tree
	 * 
	 * @return the number of nodes in this tree
	 * 
	 *         Time Complexity: O(1).
	 */
	public int size()
	{
		return nodecount;
	}

	/**
	 * Returns the level of a node in the tree
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	public int getLevel( BSTNode<E> node, E data )
	{
		return getLevelHelp(node, data, 1);
	}

	/**
	 * 
	 * @return the level of the tree
	 */
	private int getLevelHelp( BSTNode<E> node, E data, int level )
	{

		if ( node == null )
		{
			return 0;
		}

		if ( node.element == data )
		{
			return level;
		}

		int downlevel = getLevelHelp(node.left, data, level++);

		if ( downlevel != 0 )
		{
			return downlevel;
		}

		downlevel = getLevelHelp(node.right, data, level++);

		return downlevel;
	}

	/**
	 * Helper method for isSubtree
	 * 
	 * @param rootOfTree
	 *            root of current tree
	 * @param rootOfSubTree
	 *            root of the subtree to be checked
	 * @return true if they are identical i.e. they have the same values
	 *         it does not necessarily means they are the same tree
	 */
	private boolean areIdentical( BSTNode<E> rootOne, BSTNode<E> rootTwo )
	{
		// Bases cases
		// Both roots are null; return true
		if ( rootOne == null && rootTwo == null )
		{
			return true;
		}

		// Either one of the roots is null; returns false
		// they are different
		if ( rootOne == null || rootTwo == null )
		{
			return false;
		}

		// Check if the data is the same in both roots and the data of left and
		// right subtrees are also the same
		return (rootOne.element == rootTwo.element && areIdentical(rootOne.left, rootTwo.left)
				&& areIdentical(rootOne.right, rootTwo.right));

	}

	/**
	 * Returns true if rootTwo is a subtree of rootOne
	 * 
	 * @param rootOne
	 *            a tree
	 * @param rootTwo
	 *            another tree to check if it is a subtree of rootOne
	 * @return true if two is subtree of one
	 * 
	 *         Time Complexity: O(mn). Where m and n are the nodes in the given
	 *         trees.
	 */
	public boolean isSubTree( BSTNode<E> rootOne, BSTNode<E> rootTwo )
	{
		// base cases
		// If the second root is null; return true
		if ( rootTwo == null )
		{
			return true;
		}

		// if the first root is null then the tree itself is null
		// so false, since there is nothing to compare to
		if ( rootOne == null )
		{
			return false;
		}

		// check the tree with root as current node
		if ( areIdentical(rootOne, rootTwo) )
		{
			return true;
		}

		// if the tree with root as current node does not match
		// then try left and right subtrees one by one
		return isSubTree(rootOne.left, rootTwo) || isSubTree(rootOne.right, rootTwo);
	}

	// AVL Rotations
	// Rotations
	// Right Rotate
	public BSTNode<E> rotateWithLeftChild( BSTNode<E> k2 )
	{
		BSTNode<E> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;

		k2.setHeight(Math.max(height(k2.left), height(k2.right)) + 1);
		k1.setHeight(Math.max(height(k1.left), k2.getHeight()) + 1);

		return k1; // return new root
	}

	// Left Rotate
	public BSTNode<E> rotateWithRightChild( BSTNode<E> k1 )
	{
		BSTNode<E> k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;

		k1.setHeight(Math.max(height(k1.left), height(k1.right)) + 1);
		k2.setHeight(Math.max(height(k2.right), k1.getHeight()) + 1);

		return k2; // return new root
	}

	// Double Rotations
	public BSTNode<E> doubleWithLeftChild( BSTNode<E> k3 )
	{
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	public BSTNode<E> doubleWithRightChild( BSTNode<E> k1 )
	{
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	// Get Balance factor
	public int getBalance( BSTNode<E> node )
	{
		if ( node == null )
			return 0;

		return height(node.left) - height(node.right);
	}

	public void AVLinsert( E element )
	{
		root = AVLinserthelp(root, element);
		nodecount++;
	}

	private BSTNode<E> AVLinserthelp( BSTNode<E> root, E element )
	{
		/* BST Rotation */

		if ( root == null )
		{
			// empty tree
			return new BSTNode<E>(element);
		}

		if ( root.element.compareTo(element) == 0 )
		{
			// elements are equal, no duplicates, do nothing
		}
		else if ( root.element.compareTo(element) > 0 )
		{
			// the root is greater than the element we have
			root.left = AVLinserthelp(root.left, element);
		}
		else
			// the root is smaller
			root.right = AVLinserthelp(root.right, element);

		// Update height
		root.setHeight(Math.max(height(root.left), height(root.right)) + 1);

		// Get balance
		int balance = getBalance(root);

		// For an unbalanced node we have 4 cases
		// Left Left
		if ( balance > 1 && element.compareTo(root.left.element) < 0 )
		{
			return rotateWithLeftChild(root);
		}

		// Right Right
		if ( balance < -1 && element.compareTo(root.right.element) > 0 )
		{
			return rotateWithRightChild(root);
		}

		// Left Right
		if ( balance > 1 && element.compareTo(root.left.element) > 0 )
		{
			return doubleWithLeftChild(root);
		}

		// Right Left
		if ( balance < -1 && element.compareTo(root.right.element) < 0 )
		{
			return doubleWithRightChild(root);
		}

		return root; // Return initial root node
	}

	public E AVLremove( E key )
	{
		E temp = findhelp(root, key); // First find it

		if ( temp != null )
		{
			root = AVLremovehelp(root, key); // Now remove it
			nodecount--;
		}

		return temp;
	}

	// Miguel Espinal
	private BSTNode<E> AVLremovehelp( BSTNode<E> root, E element )
	{
		if ( root == null )
		{
			return root; // nothing to delete
		}

		if ( root.element.compareTo(element) > 0 )
		{
			// the element is smaller than the root
			// look in the left side until you find it
			root.left = AVLremovehelp(root.left, element);
		}
		else if ( root.element.compareTo(element) < 0 )
		{
			root.right = AVLremovehelp(root.right, element);
		}
		else // value found
		{
			if ( root.left == null )
			{
				return root.right;
			}
			else if ( root.right == null )
			{
				return root.left;
			}
			else // it has two children
			{
				BSTNode<E> temp = getmax(root.left);
				root.element = temp.element;
				root.left = deletemax(root.left);
			}
		}

		// Update Heights
		root.setHeight(Math.max(height(root.left), height(root.right)) + 1);

		// Get balance of the root
		int balance = getBalance(root);

		// For an unbalanced node we have 4 cases
		// Left Left
		if ( balance > 1 && getBalance(root.left) >= 0 )
		{
			return rotateWithLeftChild(root);
		}

		// Right Right
		if ( balance < -1 && getBalance(root.right) <= 0 )
		{
			return rotateWithRightChild(root);
		}

		// Left Right
		if ( balance > 1 && getBalance(root.left) < 0 )
		{
			return doubleWithLeftChild(root);
		}

		// Right Left
		if ( balance < -1 && getBalance(root.right) > 0 )
		{
			return doubleWithRightChild(root);
		}

		return root; // return initial root node
	}

}
