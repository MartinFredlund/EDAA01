package sudoku;

/**
 * Sudoku solving class.
 * 
 * @author Andreas & Martin
 *
 */
public class Sudoku {
	private int[][] board = new int[9][9];
	private int[][] refBoard = new int[9][9];

	/**
	 * Constructor for Sudoku class.
	 * 
	 * @param newBoard
	 *            The sudoku board to be solved.
	 */
	public Sudoku(int[][] newBoard) {
		this.board = newBoard;
		this.refBoard = newBoard;

	}

	/**
	 * Returns the current sudoku board as an Integer array.
	 * 
	 * @return returns the current board.
	 */
	public int[][] getBoard() {
		int[][] returnBoard = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				returnBoard[i][j] = board[i][j];
			}
		}
		return returnBoard;
	}

	/**
	 * Checks if the current sudoku is solvable. And solves the sudoku if possible.
	 * 
	 * @return true if the current sudoku board is solvable and false if it is not
	 *         solvable.
	 */
	public boolean solver() {
		if (solvAble()) {
			return solve(0, 0);
		}
		return false;
	}

	// Checks if the given starting numbers are ok according to the rules.
	private boolean solvAble() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (refBoard[i][j] != 0) {
					if (!(ruleCheck(refBoard[i][j], i, j, true))) {
						return false;
					}

				}
			}
		}
		return true;
	}

	// // Rekursive method for solving the given sudoku.
	// private boolean solve() {
	// for (int x = 0; x < 9; x++) {
	// for (int y = 0; y < 9; y++) {
	// if (refBoard[x][y] == 0) {
	// for (int i = 1; i < 10; i++) {
	// if (ruleCheck(i, x, y, false)) {
	// board[x][y] = i;
	//
	// if (solve()) {
	// return true;
	// } else {
	// board[x][y] = 0;
	// }
	// }
	// }
	// return false;
	// }
	// }
	// }
	//
	// return true;
	// }

	private boolean solve(int x, int y) {
		int newX = x;
		int newY;
		if (y != 8) {
			newY = y + 1;

		} else {
			newY = 0;
			newX = x + 1;
		}
		if (x == 9) {
			return true;
		}
		if (refBoard[x][y] == 0) {
			for (int i = 1; i < 10; i++) {
				if (ruleCheck(i, x, y, false)) {
					board[x][y] = i;
					if (solve(newX, newY)) {
						return true;
					} else {
						board[x][y] = 0;
					}
				}
			}
			return false;
		} 
		return solve(newX,newY);
//		if(solve(newX,newY)) {
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}

	// Checks if the given value at the given position (x,y) is ok according to the
	// suduoku rules.

	private boolean ruleCheck(int value, int x, int y, boolean start) {

		// row check
		for (int i = 0; i < 9; i++) {
			if (y != i && board[x][i] == value) {
				return false;
			}
		}
		// column check
		for (int i = 0; i < 9; i++) {
			if (x != i && board[i][y] == value) {
				return false;
			}
		}
		// box check
		int x1 = (x) % 3;
		int y1 = (y) % 3;
		for (int i = x + 2; i > x - 1; i--) {
			for (int k = y + 2; k > y - 1; k--) {
				if (!start) {
					if (board[i - x1][k - y1] == value) {
						return false;
					}
				} else if ((x != i - x1 && y != i - y1) && board[i - x1][k - y1] == value) {
					return false;
				}
			}
		}
		return true;
	}
}
