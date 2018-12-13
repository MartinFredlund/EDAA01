package sudoku;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class SudokuController extends Application {

	private Button solve = new Button("Solve");
	private Button clear = new Button("Clear");
	private HBox btnHb = new HBox(10);
	private TilePane field = new TilePane();
	private OneLetterTextField[][] textFields = new OneLetterTextField[9][9];

	@Override
	public void start(Stage sudokuSolver) throws Exception {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 310, 310);

		btnHb.getChildren().addAll(solve, clear);
		root.setBottom(btnHb);
		root.setCenter(field);
		sudokuSolver.setTitle("Sudoku Solver");
		sudokuSolver.setScene(scene);
		sudokuSolver.setResizable(false);

		field.setPadding(new Insets(20, 20, 20, 35));
		field.setHgap(1);
		field.setVgap(1);
		boardCreator();

		solve.setOnAction(event -> solveButtonAction());

		clear.setOnAction(event -> {
			for (int i = 0; i < 9; i++) {
				for (int k = 0; k < 9; k++) {
					textFields[i][k].clear();
				}
			}
		});
		sudokuSolver.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	// Method for the solve button.
	private void solveButtonAction() {
		int[][] board = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				if (textFields[i][k].getLength() != 0) {

					board[i][k] = (int) Double.parseDouble(textFields[i][k].getText());
				} else {
					board[i][k] = 0;
				}
			}
		}
		Sudoku sudoku = new Sudoku(board);
		if (sudoku.solver()) {

			int[][] tempBoard = sudoku.getBoard();
			for (int i = 0; i < 9; i++) {
				for (int k = 0; k < 9; k++) {
					textFields[i][k].setText(Integer.toString(tempBoard[i][k]));
				}
			}
		} else {
			Alert alt = new Alert(Alert.AlertType.INFORMATION);
			alt.setHeaderText("Unsolvable sudoku");
			alt.setContentText("Please, try again.");
			alt.show();
		}
	}

	// Creates 9 OneLetterTextFields for each of the 9 TilePanes on the board.
	private void boardCreator() {
		TilePane pane;
		for (int i = 0; i < 9; i++) {
			pane = new TilePane();
			pane.setPrefTileWidth(25);
			pane.setHgap(1);
			pane.setVgap(1);

			int column = 0;
			int row = 0;
			if (i % 3 == 0) {
				column = 0;
			}
			if (i % 3 == 1) {
				column = 3;
			}
			if (i % 3 == 2) {
				column = 6;
			}
			if (i / 3 == 0) {
				row = 0;
			}
			if (i / 3 == 1) {
				row = 3;
			}
			if (i / 3 == 2) {
				row = 6;
			}

			int counter = 0;

			for (int j = 0; j < 9; j++) {
				OneLetterTextField newTextField = new OneLetterTextField();
				newTextField.setStyle("-fx-background-color: #808080;");
				pane.setPrefColumns(3);
				if (i % 2 == 0) {
					newTextField.setStyle("-fx-background-color: #ff0022;");
				}

				if (counter == 3) {
					counter = 0;
					column = column - 3;
					row++;
				}
				textFields[row][column] = newTextField;
				pane.getChildren().add(newTextField);
				column++;
				counter++;
			}
			field.getChildren().add(pane);
		}
	}
}
