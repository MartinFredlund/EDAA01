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
			fail("Could append to equal lists.");
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	@Test
	public void emptyQueueAppendNoneEmptyQueue(){
		myInt2Queue.add(1);
		myIntQueue.append(myInt2Queue);
		assertEquals((int) myIntQueue.peek(), 1);
	}
	@Test
	public void noneEmptyQueueAppendEmptyQueue() {
		myIntQueue.add(1);
		myIntQueue.append(myInt2Queue);
		assertEquals((int) myIntQueue.peek(), 1);
	}
	@Test
	public void appendTwoQueue(){
		myIntQueue.add(1);
		myIntQueue.add(2);
		myInt2Queue.add(3);
		myInt2Queue.add(4);
		myIntQueue.append(myInt2Queue);
		assertEquals((int)myIntQueue.poll(), 1);
		assertEquals((int)myIntQueue.poll(), 2);
		assertEquals((int)myIntQueue.poll(), 3);
		assertEquals((int)myIntQueue.poll(), 4);
	}
	@Test
	public void appendQueuewithitself(){
		{
			try{
			myIntQueue.add(1);
			myIntQueue.add(2);
			myIntQueue.add(3);
			myIntQueue.add(4);
			myIntQueue.append(myIntQueue);
			}catch (IllegalArgumentException e){
				
			}
		}
	}
}
