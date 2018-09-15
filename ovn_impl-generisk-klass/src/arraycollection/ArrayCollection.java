package arraycollection;


import java.util.Collection;
import java.util.Iterator;

public class ArrayCollection<E> implements Collection<E> {
	private E[] theCollection;
	private int size;

	/** Constructs an empty list with an initial capacity of ten. */
	@SuppressWarnings("unchecked")
	public ArrayCollection() {
		theCollection = (E[]) new Object[10];
		size = 0;
	}
	
	/** Appends the specified element to the end of this list.	   
    Returns true if this collection changed as a result of the call. */
	public boolean add(E x) {
		if (size == theCollection.length) {
			doubleArray();
		}
		theCollection[size] = x;
		size++;
		return true;
	}
	
	/** Returns true if this collection contains the specified element. */
	public boolean contains(Object x) {
		// Fyll i egen kod
		return false;
	}
	
	/* Creates an new array that is twice the size of the current array and 
	   copies the content of the current array into the new one. */
	private void doubleArray() {
		// Fyll i egen kod
	}
	
	public Iterator<E> iterator() {
		return null;
	}

	public int size() {
		return size;
	}
	
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub		
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
