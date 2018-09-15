package dequeue;

public class Dequeue<E> {
	private Node<E> first;	// reference to the first element
	private Node<E> last;	// reference to the last element
	
	/** Creates an empty dequeue. */
	public Dequeue() {
		first = last = null;
	}
	
	/** Inserts the specified element at the beginning of this dequeue. */
	public void addFirst(E x) {
		// Fyll i egen kod här
	}	
	 
	 /** Inserts the specified element at the end of this dequeue. */
	public void addLast(E x) {
		// Fyll i egen kod här
	}
	
	/** Removes and returns the first element in this dequeue. 
	    Returns null if this dequeue is empty. */
	public E removeFirst() {
		// Fyll i egen kod här
		return null;
	}
		
	/** Removes and returns the last element in this dequeue. 
	    Returns null if this dequeue is empty. */
	public E removeLast() {
		// Fyll i egen kod här
		return null;
	}

	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		private Node(E element) {
			this.element = element;
			next = null;
		}
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		Node<E> n = first;
		while (n != null) {
			b.append(n.element);
			b.append(' ');
			n = n.next;
		}
		return b.toString();
	}

	public static void main(String[] args) {
		Dequeue<Integer> q = new Dequeue<Integer>();
		// Fyll i egen kod här
		System.out.println(q);
	}

}
