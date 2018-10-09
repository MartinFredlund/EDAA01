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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import textproc.*;

public class BookReaderController extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,500,500);
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<>();
		scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();
			stopwords.add(word);
		}
		GeneralWordCounter counter = new GeneralWordCounter(stopwords);
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			counter.process(word);
		}
		s.close();
		
		
		
		
		
		
		ObservableList<Entry<String, Integer>> words = FXCollections.observableArrayList(counter.getWords());
		ListView<Entry<String, Integer>> listView = new ListView<>(words);
		root.setCenter(listView);
		
		HBox hbox = new HBox();
		Button alpha = new Button("Alphabetic");
		Button freq = new Button("Frequency");
		Button find = new Button("Find");
		TextField text = new TextField("");
		hbox.getChildren().addAll(alpha, freq, text, find);
		freq.setOnAction(event -> {
			words.sort(new WordCountComparator());
		});
		alpha.setOnAction(event -> {
			words.clear();
			words.addAll(counter.getWords());
		});
		find.setOnAction(event -> {
			String findWord = text.getText();
			int posInList = -1;
		    for(int i = 0; i < words.size(); i++){
		   	if(words.get(i).getKey().equals(findWord))
		   	{
		   		posInList = i;
		   		break;
		   	}
		    }
		 
		    if(posInList != -1){
		    listView.scrollTo(posInList);
		    }
		   
		});
		
		HBox.setHgrow(text, Priority.ALWAYS);
		root.setBottom(hbox);
		
		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
