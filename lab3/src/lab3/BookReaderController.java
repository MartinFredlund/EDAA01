package lab3;

import java.io.File;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import textproc.*;

public class BookReaderController extends Application {
	ObservableList<Entry<String, Integer>> words;
	ListView<Entry<String, Integer>> listView;
	Button alpha = new Button("Alphabetic");
	Button freq = new Button("Frequency");
	Button find = new Button("Find");
	TextField text = new TextField("");
	HBox hbox = new HBox();

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 500, 500);

		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<>();
		scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|´|'|\\\")+");
		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();
			stopwords.add(word);
		}
		GeneralWordCounter counter = new GeneralWordCounter(stopwords);
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|´|'|\\\")+");
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			counter.process(word);
		}
		s.close();
		scan.close();

		words = FXCollections.observableArrayList(counter.getWords());
		listView = new ListView<>(words);
		root.setCenter(listView);

		hbox.getChildren().addAll(alpha, freq, text, find);
//		HBox.setHgrow(text, Priority.ALWAYS);
		root.setBottom(hbox);

		freq.setOnAction(event -> {
			words.sort((e1, e2) -> e2.getValue() - e1.getValue());
			listView.scrollTo(0);
		});
		alpha.setOnAction(event -> {
			words.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
			listView.scrollTo(0);
		});
		find.setOnAction(event -> {
			search();

		});
		text.setOnAction(event -> {
			search();
		}

		);

		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void search() {
		String findWord = text.getText().trim().toLowerCase();
		int posInList = -1;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getKey().equals(findWord)) {
				posInList = i;
				break;
			}
		}

		if (posInList != -1) {
			listView.scrollTo(posInList);
			listView.getSelectionModel().select(posInList);
		} else {
			Alert alt = new Alert(Alert.AlertType.WARNING);
			alt.setHeaderText("Warning");
			alt.setContentText("Can not find your word, try again.");
			alt.show();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
