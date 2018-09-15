package fractal;

import javafx.concurrent.Task;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import koch.Koch;

public class FractalApplication extends Application {
	private Fractal[] fractals;
	private Fractal actFractal;
	private Label labelName, labelStatus;
	private LineCountLabel lineCountLabel;
	private Task<Void> fractalDrawTask;
	private Group canvasWrapper;

	final double fractalWidth = 600;
	final double fractalHeight = 600;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		fractals = new Fractal[1];
		fractals[0] = new Koch(300);	
		actFractal = fractals[0];
		BorderPane root = new BorderPane();
		root.setBottom(addButtonBox());
		root.setTop(makeMenu());
		root.setCenter(addDrawingArea());

		stage.setScene(new Scene(root, fractalWidth, fractalHeight + 200));
		stage.setTitle("Fraktaler");
		stage.show();
	}

	private MenuBar makeMenu() {
		MenuBar menuBar = new MenuBar();
		Menu fractalMenu = new Menu("Fraktaler");
		MenuItem[] menuItems = new MenuItem[fractals.length];
		for (int i = 0; i < fractals.length; i++) {
			menuItems[i]  = new MenuItem(fractals[i].getTitle());
			final int fractalNbr = i;
			menuItems[i].setOnAction((ActionEvent e) -> {
				actFractal = fractals[fractalNbr];
				actFractal.setOrder(0);
				drawFractal();
			});
		}
		fractalMenu.getItems().addAll(menuItems);
		menuBar.getMenus().addAll(fractalMenu);
		return menuBar;
	}

	private Node addDrawingArea() {
		canvasWrapper = new Group();
		drawFractal();
		return canvasWrapper;
	}

	private VBox addButtonBox() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(15, 12, 15, 12));
		vbox.setSpacing(10);
		vbox.setAlignment(Pos.CENTER);

		labelStatus= new Label();

		labelName= new Label();
		labelName.setText(actFractal.toString());

		lineCountLabel = new LineCountLabel();
		//		lineCountLabel.setText("line count: ");

		HBox buttonBox = new HBox();
		buttonBox.setPadding(new Insets(15, 12, 15, 12));
		buttonBox.setSpacing(10);
		buttonBox.setAlignment(Pos.CENTER);

		Button buttonDown = new Button("<");
		buttonDown.setOnAction((ActionEvent e) -> {
			if (actFractal.getOrder() > 0) {
				actFractal.setOrder(actFractal.getOrder() - 1);
			}
			drawFractal();
		});

		Button buttonUp = new Button(">");
		buttonUp.setOnAction((ActionEvent e) -> {
			actFractal.setOrder(actFractal.getOrder() + 1);
			drawFractal();
		});

		buttonBox.getChildren().addAll(buttonDown, buttonUp);
		vbox.getChildren().addAll(labelName, labelStatus, lineCountLabel, buttonBox);

		return vbox;

	}

	private void drawFractal(){
		// stop any ongoing rendering
		if(fractalDrawTask != null && !fractalDrawTask.isDone()){
			fractalDrawTask.cancel(true);
		}

		labelName.setText(actFractal.toString());

		// Create a separate worker thread so the fractal drawing do not freeze the GUI
		fractalDrawTask = new Task<Void>() {
			@Override protected Void call() throws Exception {
				try{
				Platform.runLater(new Runnable() {
					@Override public void run() {
						labelStatus.setText("Ritar fraktalen");
						canvasWrapper.getChildren().clear();
					}
				});
				final Canvas canvas = new Canvas(fractalWidth, fractalHeight);
				GraphicsContext gc = canvas.getGraphicsContext2D();
				gc.setLineWidth(0.5);
				TurtleGraphics tg = new TurtleGraphics(canvas, this);
				lineCountLabel.setTurtleGraphics(tg);
				long timeStart = System.currentTimeMillis();
				actFractal.draw(tg);
				long timeEnd = System.currentTimeMillis();
				// modifying the javafx scene graph must be done from the javafx application thread
				Platform.runLater(new Runnable() {
					@Override public void run() {
						labelStatus.setText("Klar, det tog " + (timeEnd - timeStart) + " milisekunder");
						canvasWrapper.getChildren().add(canvas);
					}
				});
				} catch (ThreadDeath e) { // do nothing
//					System.out.println("beräkningen avbruten");
				} catch(Throwable e){
//					System.err.println(e.getMessage());
					e.printStackTrace(System.err);
				}
				return null;
			}
		};
		// start the worker thread
		Thread th = new Thread(fractalDrawTask);
		th.setDaemon(true);
		th.start();
	}

	/**
	 * A label to show the line count. An animation thread is created to update the label 10 times per second.
	 * @author pera
	 *
	 */
	class LineCountLabel extends Label {
		private TurtleGraphics tg;

		public LineCountLabel() {
			Timeline timeline = new Timeline(
					new KeyFrame(Duration.seconds(0),
							new EventHandler<ActionEvent>() {
						@Override public void handle(ActionEvent actionEvent) {
							if(tg != null){
								setText("antal linjer: " + tg.getLineCount());
							}
						}
					}
							),
							new KeyFrame(Duration.millis(100))
					);
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();
		}

		public void setTurtleGraphics(TurtleGraphics tg){
			this.tg = tg;
		}
	}

}
