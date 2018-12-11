package sudoku;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import sudoku.*;

public class SudokuController extends Application {
	private int[][] board = new int[8][8];
	
	Button solve = new Button("Solve");
	Button clear = new Button("Clear");
	HBox btnHb = new HBox(10);
	TilePane field = new TilePane();

	@Override
	public void start(Stage sudokuSolver) throws Exception {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 500, 500);
		
		btnHb.getChildren().addAll(solve, clear);
		root.setBottom(btnHb);
		sudokuSolver.setTitle("Sudoku Controller");
		sudokuSolver.setScene(scene);
		sudokuSolver.show();
		
		
		field.setStyle("-fx-background-color: rgba(255, 215, 0, 0.1);");
		field.setHgap(5);
		field.setVgap(5);
		createElements();
	    
		Sudoku sudoku = new Sudoku(board);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	private void createElements() {
        field.getChildren().clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            	
//            	if(check vilken färg)
                field.getChildren().add(createText());
            }
        }
    }
	
	private TextField createText() {
		
		return null;
		
	}

}
