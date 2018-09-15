package singleLinkedList;


public class SingleLinkedList<E> { 
	ListNode<E> first; 

	/** Creates an empty lis.t */ 
	public SingleLinkedList() { 
		first = null; 
	}

	/** Inserts the specified element at the beginning of this list. */
	public void addFirst(E e) {
		ListNode<E> n = new ListNode<E>(e);
		n.next = first;
		first = n;
	}
	
	/** Returns the first element in this list. 
	Throws NoSuchElementException if this list is empty */ 
	E getFirst() {
		// Fyll i egen kod
		return null;
	}
	
	/** Returns the last element in this list. 
	Throws NoSuchElementException if this list is empty */ 
	E getLast() {
		// Fyll i egen kod
		return null;
	}

	/** Returns true if this collection contains the specified element. */ 
	public boolean contains(Object x) {
		// Fyll i egen kod
		return false;
	}
	
	/** Removes the first occurrence of the specified element from this list, 
	if it is present. If this list does not contain the element, it is unchanged. 
	Returns true if this list contained the specified element (or equivalently, 
	if this list changed as a result of the call). */ 
	boolean remove(Object x)  {
		// Fyll i egen kod
		return false;
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		ListNode<E> n = first;
		while (n != null) {
			b.append(n.element);
			b.append(' ');
			n = n.next;
		}
		return b.toString();
	}
	
	
	/* Nested class. Represents a node which contains an element of type E. */ 
	private static class ListNode<E> { 
		private E element; 
		private ListNode<E> next; 
		/* Creates a listnode which contains x. */ 
		private ListNode(E e) { 
			element = e; 
			next = null; 
		} 
	}
	

	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		// Fyll i egen kod
		System.out.println(list);
	}

}
