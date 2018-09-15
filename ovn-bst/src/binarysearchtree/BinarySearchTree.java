package binarysearchtree;

public class BinarySearchTree<E extends Comparable<? super E>> {
	private Node<E> root;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		return false;
	}

	
	public void printPart(E min, E max) {
		
	}	

	public String toString() { 
		return null;
	} 
		
	private static class Node<E extends Comparable<? super E>> {
		private E element;
		private Node<E> left;
		private Node<E>right;

		private Node(E element) {
			this.element = element;
		}	
	}

}
