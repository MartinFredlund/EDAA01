
package bst;
import bst.BSTVisualizer;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	int size;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		
	}
	
	public static void main(String[] args) {
		BSTVisualizer b = new BSTVisualizer("BinaryTree", 200 ,200);
		BinarySearchTree<Integer> träd = new BinarySearchTree<Integer>();
		träd.add(4);
		träd.add(3);
		träd.add(6);
		träd.add(7);
		träd.add(20);
		träd.add(5);
		träd.add(1);
		b.drawTree(träd);
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x
	 *            element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
			return add(root, x);
	}

	private boolean add(BinaryNode<E> parent, E x) {
		if (root == null) {
			root = new BinaryNode<E>(x);
			size++;
		}
		else if (parent.element == x) {
			return false;
		}
		else if (x.compareTo(parent.element) > 0) {
			if (parent.right != null) {
				add(parent.right, x);
			} else {
				parent.right = new BinaryNode<E>(x);
				size++;
			}
		}
		else if (x.compareTo(parent.element) < 0) {
			if (parent.left != null) {
				add(parent.left, x);
			} else {
				parent.left = new BinaryNode<E>(x);
				size++;
			}
		}
		return true;
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return heightRek(root);
	}

	private int heightRek(BinaryNode<E> n) {
		if(n == null) {
			return 0;
		}
		
		return 1 + Math.max(heightRek(n.left), heightRek(n.right));
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(BinaryNode<E> n) {
		if(n != null) {
			printTree(n.left);
			System.out.println(" " + n.element);
			printTree(n.right);
		}
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index]. Returns the index of the last inserted element + 1 (the
	 * first empty position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		return 0;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in the
	 * array a are assumed to be in ascending order. Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}
}
