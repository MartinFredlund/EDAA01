
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
		BSTVisualizer b = new BSTVisualizer("BinaryTree", 400, 400);
		BinarySearchTree<Integer> träd = new BinarySearchTree<Integer>();
		träd.add(3);
		träd.add(4);
		träd.add(5);
		träd.add(6);
		träd.add(7);
		träd.add(14);
		träd.add(22);
		träd.add(24);
		träd.add(25);
		träd.add(26);
		träd.add(28);
		träd.add(30);
		träd.add(40);
		träd.add(50);
		träd.add(66);
		träd.rebuild();
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
		} else if (parent.element == x) {
			return false;
		} else if (x.compareTo(parent.element) > 0) {
			if (parent.right != null) {
				add(parent.right, x);
			} else {
				parent.right = new BinaryNode<E>(x);
				size++;
			}
		} else if (x.compareTo(parent.element) < 0) {
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
		if (n == null) {
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
		if (n != null) {
			printTree(n.left);
			System.out.println(" " + n.element);
			printTree(n.right);
		}
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		E[] a = (E[]) new Comparable[size];
		// Går igenom trädet inorder
		// bildar vektor med innehållet i växande ordning
		// Skapa nod som är mittenav vektorn
		// Bygg rekursivt träd utifrån den method
		root = buildTree(a, 0, toArray(root, a, 0));
		// toArray(root, a, 0);
		// for(int i=0; i<a.length;i++) {
		// System.out.println(a[i]);
		// }
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index]. Returns the index of the last inserted element + 1 (the
	 * first empty position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if (n != null) {
			toArray(n.left, a, index - 1);
			a[index] = n.element;
			toArray(n.right, a, index + 1);
		}
		return a.length;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in the
	 * array a are assumed to be in ascending order. Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		if (first > last|| first == a.length) {
			return null;
		} else {
			int pos = (last + first) / 2;
			BinaryNode<E> node = new BinaryNode<E>(a[pos]);
			node.left = buildTree(a, first, pos - 1);
			node.right = buildTree(a, pos + 1, last);
			return node;
		}
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
