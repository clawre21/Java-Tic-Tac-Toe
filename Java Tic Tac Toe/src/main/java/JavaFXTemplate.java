import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

// Names: Trish, Val, Sania, Chenille

// mvn clean compile exec:java
public class JavaFXTemplate extends Application {

	private String currentSymbol = "X";

	private MenuBar menu;

	ListView<String> displayInfo;

	ObservableList<String> storeInfo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Extra Credit #3");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		addGrid(grid);

		menu = new MenuBar();

		Menu m = new Menu("Options");

		MenuItem iOne = new MenuItem("Start Over");
		MenuItem iTwo = new MenuItem("Exit");

		// How to get access to the individual children?
		// Why for each loop with buttons not work?
		iOne.setOnAction(e -> {
			grid.getChildren().clear();
			addGrid(grid);
			currentSymbol = "X";

			storeInfo.clear();
			storeInfo.add("New game has started!");
			storeInfo.add("Person " + currentSymbol + "'s turn...");
			displayInfo.setItems(storeInfo);
		});

		iTwo.setOnAction(e -> {
			System.exit(0);
		});

		m.getItems().add(iOne);
		m.getItems().add(iTwo);

		menu.getMenus().addAll(m);

		displayInfo = new ListView<String>();
		storeInfo = FXCollections.observableArrayList();

		storeInfo.add("New game has started!");
		storeInfo.add("Person " + currentSymbol + "'s turn...");
		displayInfo.setItems(storeInfo);

		Scene scene = new Scene(new VBox(menu, grid, displayInfo), 700,700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void addGrid(GridPane grid) {

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Button b = new Button(" ");
				b.setStyle("-fx-background-color: #dda0dd;" +
						"-fx-font-family: 'Comic Sans MS';" +
						"-fx-text-fill: white;" +
						"-fx-font-size: 75;" +
						"-fx-border-size: 20;" +
						"-fx-border-color: purple;");
				b.setPrefSize(200,200);
				b.setOnAction(e -> {

					b.setText(currentSymbol);

					if (currentSymbol == "X") {
						currentSymbol = "O";
					}
					else {
						currentSymbol = "X";
					}

					storeInfo.add("Person " + currentSymbol + "'s turn...");
					displayInfo.setItems(storeInfo);

					b.setDisable(true);
				});
				grid.add(b, i, j);


			}
		}

	}

}

//		 Rectangle rect = new Rectangle (100, 40, 100, 100);
//	     rect.setArcHeight(50);
//	     rect.setArcWidth(50);
//	     rect.setFill(Color.VIOLET);
//
//	     RotateTransition rt = new RotateTransition(Duration.millis(5000), rect);
//	     rt.setByAngle(270);
//	     rt.setCycleCount(4);
//	     rt.setAutoReverse(true);
//	     SequentialTransition seqTransition = new SequentialTransition (
//	         new PauseTransition(Duration.millis(500)),
//	         rt
//	     );
//	     seqTransition.play();
//
//	     FadeTransition ft = new FadeTransition(Duration.millis(5000), rect);
//	     ft.setFromValue(1.0);
//	     ft.setToValue(0.3);
//	     ft.setCycleCount(4);
//	     ft.setAutoReverse(true);
//
//	     ft.play();
//	     BorderPane root = new BorderPane();
//	     root.setCenter(rect);
