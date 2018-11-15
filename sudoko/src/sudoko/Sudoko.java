package sudoko;

import java.util.Arrays;

public class Sudoko {
	private int[][] board = new int[8][8];
	private int[][] refBoard = new int[8][8];
	private boolean boardDone = false;
	public Sudoko(int[][] board) {
		this.board = board;
		this.refBoard = board;
		
	}

	public int getValue(int x, int y) {
		return board[x][y];
	}

	public int[][] getBoard() {
		return board;
	}

	public void setValue(int x, int y, int value) {
		board[x][y] = value;
	}

	private int[] next(int x, int y) {
		if (y != 8) {
			return new int[] { x , y + 1 };
		} else {
			return new int[] { x + 1, 0 };
		}
	}

	public boolean solver() {
		return solve(0, 0);
	}

	private boolean solve(int x, int y) {

		if (x == 9) {
			for(int i = 0; i<9 ; i++){
				System.out.println("");
				for(int k = 0; k<9;k++){
					System.out.print(board[i][k]);
				}
			}
			System.out.println("");
			
			boardDone = true;
			return true;
		}
		// check om rutan är tom
		if (refBoard[x][y] != 0) {
			int[] newXY = next(x, y);
			solve(newXY[0], newXY[1]);
		}
		// check om siffra 1-9 kan skrivas
		if(refBoard[x][y] == 0) {
			for (int i = 1; i < 10; i++) {
				if (ruleCheck(i, x, y)) {

					System.out.print(x + ":");
					System.out.print(y);
					System.out.println("  " + i);
					board[x][y] = i;
					int[] newXY = next(x, y);
					solve(newXY[0], newXY[1]);
				}else if(boardDone){
					return true;
				}
				else if(i == 9){
					board[x][y] = 0;
				}
			}
		}
		return false;
	}

	private boolean ruleCheck(int value, int x, int y) {
		
		// row check
		for (int i = 0; i < 9; i++) {
			if (board[x][i] == value) {
				return false;
			}
		}
		// column check
		for (int i = 0; i < 9; i++) {
			if (board[i][y] == value) {
				return false;
			}
		}
		// box check
		int x1 = (x) % 3;
		int y1 = (y) % 3;
		for (int i = x + 2; i > x - 1; i--) {
			for (int k = y + 2; k > y - 1; k--) {
				if (board[i - x1][k - y1] == value) {
					return false;
				}
			}
		}
		return true;
	}

	// public String toString() {
	// StringBuilder sb = new StringBuilder();
	// for (int i = 0; i < 9; i++) {
	// for (int k = 0; k < 9; k++) {
	// sb.append(board[i][k] + " ");
	// }
	// }
	// return sb.toString();
	// }

}
