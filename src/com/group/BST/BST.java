package com.group.BST;

import java.util.NoSuchElementException;
/**
 * 
 * @author Miguel Espinal
 *
 */
public class BST<E extends Comparable<E>>
{
	private BSTNode<E> root; // Root of the BST
	private int nodecount; // Number of nodes in the BST

	// Constructor
	//Miguel Espinal
	public BST()
	{
		root = null;
		nodecount = 0;
	}

	// Reset tree
	// Miguel Espinal
	public void clear()
	{
		root = null;
		nodecount = 0;
	}
	
	// Miguel Espinal	
	public BSTNode<E> getRoot()
	{
		return root;
	}

//	 Miguel Espinal
//	 Insert a record into the tree.
//       calls insethelp method with the given parameters         
//	 Records can be anything, but they must be Comparable
//	 e: The record to insert.
        
	public void insert( E element )
	{
                root = insert(root, element);
		nodecount++;
	}

	// Miguel Espinal
        // Fernando Serrano
	private BSTNode<E> insert(BSTNode<E> node, E element)
	{
		if (node == null)
		{
			//empty tree
			return new BSTNode<E>(element);
		}
	
		else if(node.element.compareTo(element) > 0)
		{
			//the root is greater than the element we have
			node.left = insert(node.left, element);
		}
                else if(node.element.compareTo(element) < 0)
			//the root is smaller
			node.right = insert(node.right, element);
		
		return node; //return the initial root
	}

	// Miguel Espinal
	// Remove a record from the tree
        // calls the removehelp method with the given parameters
	// key: The key value of record to remove
	// Returns the record removed, null if there is none.
	public E remove( E key )
	{
		E temp = find(root, key); // First find it
		
		if ( temp != null )
		{
			root = removehelp(root, key); // Now remove it
			nodecount--;
		}
		
		return temp;
	}
	
	// Miguel Espinal
        /*
        executes the remove method inside the tree
        */
	private BSTNode<E> removehelp(BSTNode<E> root, E element)
	{
		if(root == null)
		{
			return null; //nothing to delete
		}
		
		if(root.element.compareTo(element) > 0)
		{
			// the element is smaller than the root
			//look in the left side until you find it
			root.left = removehelp(root.left, element);
		}
		else if(root.element.compareTo(element) < 0)
		{
			root.right = removehelp(root.right, element);
		}
		else   //value found
		{
			if(root.left == null)
			{
				return root.right;
			}
			else if (root.right == null)
			{
				return root.left;
			}
			else //it has two children
			{
				BSTNode<E> temp = getMax(root.left);
				root.element = temp.element;
				root.left = deletemax(root.left);
			}
		}
		
		return root;
	}
	

	/* Miguel Espinal
	   Return the record with key value k, null if none exists
	   key: the key value to find
           executes findhelp method
        */
	public E find( E key )
	{
		return find(root, key);
	}
        
        /*
        finds an element inside the tree
        */
	private E find( BSTNode<E> root, E key )
	{
		if ( root == null )
		{
			return null;
		}

		if ( root.element.compareTo(key) > 0 )
		{
			return find(root.left, key);
		}
		else if ( root.element.compareTo(key) == 0 )
		{
			return root.element;
		}
		else
			return find(root.right, key);

	}
	
	// Miguel Espinal
	private BSTNode<E> deletemax(BSTNode<E> root)
	{
		if(root.right == null)
		{
			return root.left;
		}
		
		root.right = deletemax(root.right);
		return root;
	}
	
            public BSTNode getMax(){
        if(root==null){
            throw new NoSuchElementException();
        }    
        return getMax(root);
    }
        
	// Miguel Espinal
	public BSTNode<E> getMax(BSTNode<E> root)
	{
		if(root.right == null)
		{
			return root;
		}
		
		return getMax(root.right);
	}
	
        public BSTNode getMin(){
            if (root == null){
            throw new NoSuchElementException();
        }
        return getMin(root);
    }
        
	// Miguel Espinal
	public BSTNode<E> getMin(BSTNode<E> root)
	{
		if(root.left == null)
		{
			return root;
		}
		
		return getMin(root.left);
	}
	
	// Miguel Espinal
	//height
	public int height()
	{
		return height(root);
	}
	
	int mmg = 0;
	
	private int height(BSTNode<E> root)
	{
		
		//when a root is null just return -1 it has no effect
		if(root == null)
		{
			return -1;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}

	// Miguel Espinal
	// Return the number of records in the dictionary
	public int size()
	{
		return nodecount;
	}
	
	// Miguel Espinal
	public void inOrderTraversal()
	{
		inOrder(root);
	}
	
	// Miguel Espinal
	public void preOrderTraversal()
	{
		preOrder(root);
	}
	
	// Miguel Espinal
	public void postOrderTraversal()
	{
		postOrder(root);
	}
	
	// Miguel Espinal
	private void inOrder(BSTNode<E> root)
	{
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.element + " ");
		inOrder(root.right);	
	}
	
	// Miguel Espinal
	private void preOrder(BSTNode<E> root)
	{
		if(root == null)
			return;
		
		System.out.print(root.element + " ");
		preOrder(root.left);
		preOrder(root.right);	
	}
	
	// Miguel Espinal
	private void postOrder(BSTNode<E> root)
	{
		if(root == null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.element + " ");
	}
        /*
        retruns level (int)
        Fernando Serrano
        */
        public int getLevel(BSTNode node, E data, int level){
        
        if (node == null) return 0;
        if (node.element == data) return level;
        
        int downlevel = getLevel(node.left, data, level++);
        if(downlevel != 0) return downlevel;
        
        downlevel = getLevel(node.right, data, level++);
        return downlevel;
    }        
	
	

}
