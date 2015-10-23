
public class BST<E extends Comparable<E>>
{
	public BSTNode<E> root; // Root of the BST
	private int nodecount; // Number of nodes in the BST

	// Constructor
	public BST()
	{
		root = null;
		nodecount = 0;
	}

	// Reset tree
	public void clear()
	{
		root = null;
		nodecount = 0;
	}

	// Insert a record into the tree.
	// Records can be anything, but they must be Comparable
	// e: The record to insert.
	public void insert( E e )
	{
		root = inserthelp(root, e);
		nodecount++;
	}

	private BSTNode<E> inserthelp(BSTNode<E> root, E element)
	{
		if (root == null)
		{
			//empty tree
			return new BSTNode<E>(element);
		}
		
		if (root.element.compareTo(element) == 0)
		{
			return null;	//elements are equal, no duplicates
		}
		else if(root.element.compareTo(element) > 0)
		{
			//the root is greater than the element we have
			root.left = inserthelp(root.left, element);
		}
		else
			//the root is lesser
			root.right = inserthelp(root.right, element);
		
		return root; //return the initial root
	}

	// Remove a record from the tree
	// key: The key value of record to remove
	// Returns the record removed, null if there is none.
	public E remove( E key )
	{
		E temp = findhelp(root, key); // First find it
		if ( temp != null )
		{
			root = removehelp(root, key); // Now remove it
			nodecount--;
		}
		return temp;
	}
	
	private BSTNode<E> removehelp(BSTNode<E> root, E element)
	{
		if(root == null)
		{
			return null; //nothing to delete
		}
		
		if(root.element.compareTo(element) > 0)
		{
			// the element is smaller thant the root
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
				BSTNode<E> temp = getmax(root.left);
				root.element = temp.element;
				root.left = deletemax(root.left);
			}
		}
		
		return root;
	}
	

	// Return the record with key value k, null if none exists
	// key: the key value to find
	public E find( E key )
	{
		return findhelp(root, key);
	}

	private E findhelp( BSTNode<E> root, E key )
	{
		if ( root == null )
		{
			return null;
		}

		if ( root.element.compareTo(key) > 0 )
		{
			return findhelp(root.left, key);
		}
		else if ( root.element.compareTo(key) == 0 )
		{
			return root.element;
		}
		else
			return findhelp(root.right, key);

	}
	
	private BSTNode<E> deletemax(BSTNode<E> root)
	{
		if(root.right == null)
		{
			return root.left;
		}
		
		root.right = deletemax(root.right);
		return root;
	}
	
	public BSTNode<E> getmax(BSTNode<E> root)
	{
		if(root.right == null)
		{
			return root;
		}
		
		return getmax(root.right);
	}
	
	public BSTNode<E> getmin(BSTNode<E> root)
	{
		if(root.left == null)
		{
			return root;
		}
		
		return getmin(root.left);
	}

	// Return the number of records in the dictionary
	public int size()
	{
		return nodecount;
	}
	
	public void inOrderTraversal()
	{
		inOrder(root);
	}
	
	public void preOrderTraversal()
	{
		preOrder(root);
	}
	
	public void postOrderTraversal()
	{
		postOrder(root);
	}
	
	private void inOrder(BSTNode<E> root)
	{
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.element + " ");
		inOrder(root.right);	
	}
	
	private void preOrder(BSTNode<E> root)
	{
		if(root == null)
			return;
		
		System.out.print(root.element + " ");
		preOrder(root.left);
		preOrder(root.right);	
	}
	
	private void postOrder(BSTNode<E> root)
	{
		if(root == null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.element + " ");
	}
	
	

}
