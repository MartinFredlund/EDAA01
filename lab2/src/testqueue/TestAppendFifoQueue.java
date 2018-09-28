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

	@Test
	public void twoEmpty() {
		try {
			myIntQueue.append(myInt2Queue);
			fail("...");
		}
		catch(IllegalArgumentException e) {
			
		}
	}

}
