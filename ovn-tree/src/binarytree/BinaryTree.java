package binarytree;

public class BinaryTree<E> {
	private Node<E> root;
	
	/** Skapar ett tomt träd. */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Skapar ett binärt träd med innehållet data i roten och med leftTree som
	 * vänster underträd och rightTree som höger underträd.
	 */
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<E>(data);
		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}
	}


	/** Skriver ut trädets noder i inorder. */
	public void printInorder() {
		printInorder(root);
	}

	private void printInorder(Node<E> n) {
		// Fyll i egen kod
	}

	private static class Node<E> {
		private E element;
		private Node<E> left;
		private Node<E> right;

		public Node(E data) {
			this.element = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		BinaryTree<String> empty = new BinaryTree<String>();
		empty.printInorder();

		BinaryTree<String> tmp = new BinaryTree<String>("d", null, null);
		BinaryTree<String> left = new BinaryTree<String>("b", null, tmp);
		tmp = new BinaryTree<String>("e", null, null);
		BinaryTree<String> right = new BinaryTree<String>("c", tmp, null);
		BinaryTree<String> tree = new BinaryTree<String>("a", left, right);
		tree.printInorder();
	}

}
