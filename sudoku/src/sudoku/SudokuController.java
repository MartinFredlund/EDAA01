package sudoku;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import sudoku.*;

public class SudokuController extends Application {
	private int[][] board = new int[9][9];

	Button solve = new Button("Solve");
	Button clear = new Button("Clear");
	HBox btnHb = new HBox(10);
	TilePane field = new TilePane();
	OneLetterTextField[][] numbers = new OneLetterTextField[9][9];

	@Override
	public void start(Stage sudokuSolver) throws Exception {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 310, 310);
		btnHb.getChildren().addAll(solve, clear);
		root.setBottom(btnHb);
		root.setCenter(field);
		sudokuSolver.setTitle("Sudoku Controller");
		sudokuSolver.setScene(scene);
		sudokuSolver.setResizable(false);

		field.setPadding(new Insets(20, 20, 20, 35));
		field.setHgap(1);
		field.setVgap(1);

		TilePane temp;
		for (int i = 0; i < 9; i++) {
			temp = new TilePane();
			temp.setPrefTileWidth(25);
			temp.setHgap(1);
			temp.setVgap(1);

			for (int j = 0; j < 9; j++) {
				OneLetterTextField text = new OneLetterTextField();
				text.setStyle("-fx-background-color: #808080;");
				temp.setPrefColumns(3);

				if (i % 2 == 0) {
					text.setStyle("-fx-background-color: #ff0022;");
				}
				numbers[i][j] = text;
				temp.getChildren().add(text);

			}

			field.getChildren().add(temp);
		}
		// check if solvemöjligt
		solve.setOnAction(event -> {
			int[][] board = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int k = 0; k < 9; k++) {
					if (numbers[i][k].getLength() != 0) {

						board[i][k] = (int) Double.parseDouble(numbers[i][k].getText());
					} else {
						board[i][k] = 0;
					}
				}
			}
			Sudoku sudoku = new Sudoku(board);
				if(sudoku.solver()) {
					
				int[][] tempBoard = sudoku.getBoard();
				for (int i = 0; i < 9; i++) {
					for (int k = 0; k < 9; k++) {
						numbers[i][k].setText(Integer.toString(tempBoard[i][k]));
					}
				}
			}
			else {
				Alert alt = new Alert(Alert.AlertType.WARNING);
				alt.setHeaderText("Warning");
				alt.setContentText("Can not find your word, try again.");
				alt.show();
			}
		});

		clear.setOnAction(event -> {
			for (int i = 0; i < 9; i++) {
				for (int k = 0; k < 9; k++) {
					numbers[i][k].clear();
				}
			}
		});

		Sudoku sudoku = new Sudoku(board);
		sudokuSolver.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
