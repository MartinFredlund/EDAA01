package testqueue;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import queue_delegate.FifoQueue;
import queue_singlelinkedlist.FifoQueue;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

public class TestFifoQueue {
	private Queue<Integer> myIntQueue;
	private Queue<String> myStringQueue;

	@Before
	public void setUp() throws Exception {
		myIntQueue = new FifoQueue<Integer>();
		myStringQueue = new FifoQueue<String>();
	}

	@After
	public void tearDown() throws Exception {
		myIntQueue = null;
		myStringQueue = null;
	}

	/**
	 * Test if a newly created queue is empty.
	 */
	@Test
	public final void testNewFifoQueue() {
		assertTrue(myIntQueue.isEmpty());
		assertTrue(myIntQueue.size() == 0);
	}

	/** Test a single offer followed by a single peek. */
	@Test
	public final void testPeek() {
		myIntQueue.offer(1);
		int i = myIntQueue.peek();
		assertEquals("peek on queue of size 1", 1, i);
		assertTrue(myIntQueue.size() == 1);
	}

	/**
	 * Test a single offer followed by a single poll.
	 */
	@Test
	public final void testPoll() {
		myIntQueue.offer(1);
		int i = myIntQueue.poll();
		assertEquals("poll on queue of size 1", 1, i);
		assertTrue("Wrong size after poll", myIntQueue.size() == 0);
	}

	/**
	 * Test peek of empty queue.
	 */
	@Test
	public final void testPeekOfEmpty() {
		assertEquals("Front of empty queue not null", null, myIntQueue.peek());
	}

	/**
	 * Test poll of empty queue.
	 */
	@Test
	public final void testPollOfEmpty() {
		assertEquals("Poll of empty queue should return null", null, myIntQueue.poll());
	}

	/**
	 * Test that implementation works for a queue of strings.
	 */
	@Test
	public final void testStringQueue() {
		myStringQueue.offer("First");
		myStringQueue.offer("Second");
		myStringQueue.offer("Third");
		assertTrue("Wrong size of queue", myStringQueue.size() == 3);
		assertEquals("peek on queue of strings", "First", myStringQueue.peek());
		assertEquals("String First expected", "First", myStringQueue.poll());
		assertEquals("String Second expected", "Second", myStringQueue.poll());
		assertEquals("String Third expected", "Third", myStringQueue.poll());
		assertTrue("Queue of strings should be empty", myStringQueue.isEmpty());
	}

	/**
	 * Test that polling gives elements in right order.
	 */
	@Test
	public final void testOrder() {
		myIntQueue.offer(1);
		myIntQueue.offer(2);
		myIntQueue.offer(3);
		myIntQueue.offer(4);
		myIntQueue.offer(5);
		for (int i = 1; i <= 5; i++) {
			int k = myIntQueue.poll();
			assertEquals("poll returns incorrect element", i, k);
		}
		assertTrue("Queue not empty", myIntQueue.isEmpty());
	}

	/**
	 * Test that polling all elements gives an empty queue.
	 */
	@Test
	public final void testMakeQueueEmpty() {
		myIntQueue.offer(1);
		myIntQueue.offer(2);
		myIntQueue.poll();
		myIntQueue.poll();
		assertTrue("Wrong size after poll", myIntQueue.size() == 0);
		assertTrue("Queue not empty after poll", myIntQueue.isEmpty());
		myIntQueue.offer(3);
		myIntQueue.offer(4);
		assertTrue("Wrong size after offer", myIntQueue.size() == 2);
		for (int i = 3; i <= 4; i++) {
			int k = myIntQueue.poll();
			assertEquals("poll returns incorrect element", i, k);
		}
		assertTrue("Wrong size after poll", myIntQueue.size() == 0);
		assertTrue("Queue not empty after poll", myIntQueue.isEmpty());
	}

	/**
	 * Test iterator on empty queue.
	 */
	@Test
	public void testIteratorEmptyQueue() {
		Iterator<Integer> itr = myIntQueue.iterator();
		assertFalse("Wrong result from next in empty queue", itr.hasNext());
		try {
			itr.next();
			fail("Should raise NoSuchElementException");
		} catch (NoSuchElementException e) {
			// successful test
		}
	}

	/**
	 * Test iterator on non empty queue.
	 */
	@Test
	public void testIteratorNonEmptyQueue() {
		int nbr = 5;
		for (int i = 1; i <= nbr; i++) {
			myIntQueue.offer(i);
		}
		Iterator<Integer> itr = myIntQueue.iterator();
		assertTrue("Wrong result from hasNext", itr.hasNext());
		for (int i = 1; i <= nbr; i++) {
			assertTrue("Wrong result from hasNext", itr.hasNext());
			assertEquals("Wrong result from next", Integer.valueOf(i), itr.next());
		}
		assertFalse("Wrong result from hasNext", itr.hasNext());
		try {
			itr.next();
			fail("Should raise NoSuchElementException");
		} catch (NoSuchElementException e) {
			// successful test
		}
	}

	/**
	 * Test iterator multiple times, to ensure that the iterator does not modify the
	 * queue.
	 */
	@Test
	public void testThreeIterators() {
		int nbr = 5;
		for (int i = 1; i <= nbr; i++) {
			myIntQueue.offer(i);
		}

		// first, set up two iterators at the same time, and check that they both work

		Iterator<Integer> itr1 = myIntQueue.iterator();
		Iterator<Integer> itr2 = myIntQueue.iterator();
		
		for (int i = 1; i <= nbr; i++) {
			assertTrue("Wrong result from itr1.hasNext", itr1.hasNext());
			assertEquals("Wrong result from itr1.next", Integer.valueOf(i), itr1.next());
		}
		
		for (int i = 1; i <= nbr; i++) {
			assertTrue("Wrong result from itr2.hasNext", itr2.hasNext());
			assertEquals("Wrong result from itr2.next", Integer.valueOf(i), itr2.next());
		}

		// then, test a third iterator after the previous iterations
		
		Iterator<Integer> itr3 = myIntQueue.iterator();
		for (int i = 1; i <= nbr; i++) {
			assertTrue("Wrong result from itr3.hasNext", itr3.hasNext());
			assertEquals("Wrong result from itr3.next", Integer.valueOf(i), itr3.next());
		}
	}
}
