package sudoko;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sudoko.Sudoko;

public class SudokoTest {
	private int[][] myBoard;
	private Sudoko mySudoko;

	@Before
	public void setUp() throws Exception {
		// myIntQueue = new FifoQueue<Integer>();
		// myStringQueue = new FifoQueue<String>();
		myBoard = new int[8][8];
		mySudoko = new Sudoko(myBoard);
	}

	@After
	public void tearDown() throws Exception {
		myBoard = null;
		mySudoko = null;
	}

	@Test
	public final void testEasySudoko() {

		myBoard = new int[][] { 
				{ 2, 2, 0, 4, 5, 6, 7, 8, 9 },
				{ 4, 5, 7, 0, 8, 0, 2, 3, 6 },
				{ 6, 8, 9, 2, 3, 7, 0, 4, 0 },
				{ 0, 0, 5, 3, 6, 2, 9, 7, 4 }, 
				{ 2, 7, 4, 0, 9, 0, 6, 5, 3 },
				{ 3, 9, 6, 5, 7, 4, 8, 0, 0 },
				{ 0, 4, 0, 6, 1, 8, 3, 9, 7 },
				{ 7, 6, 1, 0, 4, 0, 5, 2, 8 },
				{ 9, 3, 8, 7, 2, 5, 0, 6, 0 } };
		mySudoko = new Sudoko(myBoard);
		assertTrue(mySudoko.solver());
	}
	
	@Test
	public final void testHardSudoko() {

		myBoard = new int[][] { 
				{ 6, 0, 0, 1, 0, 8, 2, 0, 3 },
				{ 0, 2, 0, 0, 4, 0, 0, 9, 0 },
				{ 8, 0, 3, 0, 0, 5, 4, 0, 0 },
				{ 5, 0, 4, 6, 0, 7, 0, 0, 9 }, 
				{ 0, 3, 0, 0, 0, 0, 0, 5, 0 },
				{ 7, 0, 0, 8, 0, 3, 1, 0, 2 },
				{ 0, 0, 1, 7, 0, 0, 9, 0, 6 },
				{ 0, 8, 0, 0, 3, 0, 0, 2, 0 },
				{ 3, 0, 2, 9, 0, 4, 0, 0, 5 } };
		mySudoko = new Sudoko(myBoard);
		assertTrue(mySudoko.solver());
	}
	@Test
	public final void testemptySudoko() {

		myBoard = new int[][] { 
				{ 3, 4, 5, 3, 4, 8, 7, 6, 9 },
				{ 0, 0, 0, 8, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 5, 0, 4, 6, 0, 7, 0, 0, 0 }, 
				{ 0, 3, 0, 0, 0, 0, 0, 5, 0 },
				{ 7, 0, 0, 8, 0, 3, 1, 0, 0 },
				{ 0, 0, 1, 7, 0, 0, 9, 0, 0 },
				{ 0, 8, 0, 0, 3, 0, 0, 2, 0 },
				{ 3, 0, 2, 9, 0, 4, 0, 0, 9 } };
		mySudoko = new Sudoko(myBoard);
		assertTrue(mySudoko.solver());
	}

}
