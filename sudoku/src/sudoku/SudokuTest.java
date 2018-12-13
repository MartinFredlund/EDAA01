package sudoku;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sudoku.Sudoku;

public class SudokuTest {
	private int[][] myBoard;
	private Sudoku mySudoko;

	@Before
	public void setUp() throws Exception {
		// myIntQueue = new FifoQueue<Integer>();
		// myStringQueue = new FifoQueue<String>();
		myBoard = new int[8][8];
		mySudoko = new Sudoku(myBoard);
	}

	@After
	public void tearDown() throws Exception {
		myBoard = null;
		mySudoko = null;
	}

	@Test
	public final void testImpossibleSudoko() {

		myBoard = new int[][] { 
				{ 2, 0, 0, 4, 5, 6, 7, 8, 9 },
				{ 4, 5, 7, 0, 8, 0, 2, 3, 6 },
				{ 6, 8, 9, 2, 3, 7, 0, 4, 0 },
				{ 0, 0, 5, 3, 6, 2, 9, 7, 4 }, 
				{ 2, 7, 4, 0, 9, 0, 6, 5, 3 },
				{ 3, 9, 6, 5, 7, 4, 8, 0, 0 },
				{ 0, 4, 0, 6, 1, 8, 3, 9, 7 },
				{ 7, 6, 1, 0, 4, 0, 5, 2, 8 },
				{ 9, 3, 8, 7, 2, 5, 0, 6, 3 } };
		mySudoko = new Sudoku(myBoard);
		assertFalse(mySudoko.solver());
	}
	
	@Test
	public final void testHardSudoko() {

		myBoard = new int[][] { 
				{ 0, 0, 8, 0, 0, 9, 0, 6, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 5 },
				{ 1, 0, 2, 5, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 1, 0, 0, 9, 0 }, 
				{ 0, 5, 0, 0, 0, 0, 6, 0, 0 },
				{ 6, 0, 0, 0, 0, 0, 0, 2, 8 },
				{ 4, 1, 0, 6, 0, 8, 0, 0, 0 },
				{ 8, 6, 0, 0, 3, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 4, 0, 0 } };
		mySudoko = new Sudoku(myBoard);
		assertTrue(mySudoko.solver());
	}
	@Test
	public final void testemptySudoko() {

		myBoard = new int[][] { 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		mySudoko = new Sudoku(myBoard);
		assertTrue(mySudoko.solver());
	}

}
