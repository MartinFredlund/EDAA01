package testqueue;

import static org.junit.Assert.*;

import java.util.Queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue_singlelinkedlist.FifoQueue;

public class TestAppendFifoQueue {

	private FifoQueue<Integer> myIntQueue;
	private FifoQueue<Integer> myInt2Queue;

	@Before
	public void setUp() throws Exception {
		myIntQueue = new FifoQueue<Integer>();
		myInt2Queue = new FifoQueue<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		myIntQueue = null;
		myInt2Queue = null;
	}

	/**
	 * Test if two empty queues can append.
	 */
	@Test
	public void twoEmpty() {
		assertTrue("Queue should be empty", myIntQueue.isEmpty());
		assertTrue("Queue should be empty", myInt2Queue.isEmpty());
		myIntQueue.append(myInt2Queue);
	}

	/**
	 * Test if one empty and a non-empty queue can append.
	 */
	@Test
	public void emptyQueueAppendNoneEmptyQueue() {
		myInt2Queue.add(1);
		myInt2Queue.add(4);
		myIntQueue.append(myInt2Queue);
		assertEquals("Size should be 2", (int) myIntQueue.size(), 2);
		assertEquals("first element should have been 1", (int) myIntQueue.poll(), 1);
		assertEquals("second element should have been 4", (int) myIntQueue.peek(), 4);
		assertTrue("The queue to append should be empty", myInt2Queue.isEmpty());
	}

	/**
	 * Test if one non-empty and a empty queue can append.
	 */
	@Test
	public void noneEmptyQueueAppendEmptyQueue() {
		myIntQueue.add(1);
		myIntQueue.add(3);
		myIntQueue.append(myInt2Queue);
		assertEquals("Size should be 2", (int) myIntQueue.size(), 2);
		assertEquals("first element should have been 1", (int) myIntQueue.poll(), 1);
		assertEquals("second element should have been 3", (int) myIntQueue.peek(), 3);
		assertTrue("The queue to append should be empty", myInt2Queue.isEmpty());
	}

	/**
	 * Test if two non-empty queues can append.
	 */
	@Test
	public void appendTwoQueue() {
		myIntQueue.add(1);
		myIntQueue.add(2);
		myInt2Queue.add(3);
		myInt2Queue.add(4);
		myIntQueue.append(myInt2Queue);
		assertEquals("Size should be 4", (int) myIntQueue.size(), 4);
		assertEquals("First element should have been 1", (int) myIntQueue.poll(), 1);
		assertEquals("Second element should have been 2", (int) myIntQueue.poll(), 2);
		assertEquals("Third element should have been 3", (int) myIntQueue.poll(), 3);
		assertEquals("Fourth element should have been 3", (int) myIntQueue.poll(), 4);
		assertTrue("The queue to append should be empty", myInt2Queue.isEmpty());
	}

	/**
	 * Test if queue can append itself.
	 */
	@Test
	public void appendQueuewithitself() {
		{
			try {
				myIntQueue.add(1);
				myIntQueue.add(2);
				myIntQueue.add(3);
				myIntQueue.add(4);
				myIntQueue.append(myIntQueue);
				fail("");
			} catch (IllegalArgumentException e) {
				// successful test
			}
		}
	}
}
