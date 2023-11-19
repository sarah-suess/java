import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/** Represents an Animal Sanctuary.
 * @author Amelie Wasserfuhr
 * @version 1.0
 */

public class AnimalSanctuary extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Animal Sanctuary");
        primaryStage.setHeight(850);
        primaryStage.setWidth(1000);
        StackPane pane1 = new StackPane();
        Image image = new Image("animalImage.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        pane1.getChildren().add(imageView);
        HBox paneForInputs = new HBox(10);
        paneForInputs.setSpacing(20);
        TextField theName = new TextField();
        Label name = new Label("Enter Name Here:", theName);
        name.setContentDisplay(ContentDisplay.BOTTOM);
        name.setTextFill(Color.WHITE);
        ChoiceBox<String> animalTypes = new ChoiceBox<>();
        for (Animal i : Animal.values()) {
            animalTypes.getItems().add(i.name());
        }
        Label picking = new Label("Pick Animal Type:", animalTypes);
        picking.setContentDisplay(ContentDisplay.BOTTOM);
        picking.setTextFill(Color.WHITE);
        TextField healthAmount = new TextField();
        Label health = new Label("Enter Health Here:", healthAmount);
        health.setContentDisplay(ContentDisplay.BOTTOM);
        health.setTextFill(Color.WHITE);
        Button addAnimals = new Button("Add Animal");
        addAnimals.setPrefSize(100, 50);
        paneForInputs.getChildren().addAll(name, picking, health, addAnimals);
        paneForInputs.setAlignment(Pos.BOTTOM_CENTER);
        VBox view = new VBox();
        view.setAlignment(Pos.CENTER);
        GridPane sanctuary = new GridPane();
        sanctuary.setAlignment(Pos.TOP_CENTER);
        Button b1 = new Button("Empty");
        b1.setPrefSize(150, 150);
        Button b2 = new Button("Empty");
        b2.setPrefSize(150, 150);
        Button b3 = new Button("Empty");
        b3.setPrefSize(150, 150);
        Button b4 = new Button("Empty");
        b4.setPrefSize(150, 150);
        Button b5 = new Button("Empty");
        b5.setPrefSize(150, 150);
        Button b6 = new Button("Empty");
        b6.setPrefSize(150, 150);
        sanctuary.add(b1, 0, 0);
        sanctuary.add(b2, 1, 0);
        sanctuary.add(b3, 2, 0);
        sanctuary.add(b4, 0, 1);
        sanctuary.add(b5, 1, 1);
        sanctuary.add(b6, 2, 1);
        view.getChildren().addAll(sanctuary, paneForInputs);
        addAnimals.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (theName.getText().isEmpty()) {
                    theName.setText("No Name Yet");
                }
                if (!(healthAmount.getText().equals("1")) && (!(healthAmount.getText().equals("2")))
                    && (!(healthAmount.getText().equals("3")) && (!(healthAmount.getText().equals("4"))
                    && (!(healthAmount.getText().equals("5")))))) {
                    healthAmount.setText("5");
                }
                if (b1.getText().equals("Empty")) {
                    b1.setText("Name: " + theName.getText() + "\nType: " + animalTypes.getValue() + "\nHealth: "
                        +  healthAmount.getText());
                    b1.setStyle("-fx-background-color: #00ff00");
                    theName.clear();
                    animalTypes.getSelectionModel().clearSelection();
                    healthAmount.clear();
                } else if (b2.getText().equals("Empty")) {
                    b2.setText("Name: " + theName.getText() + "\nType: " + animalTypes.getValue() + "\nHealth: "
                        +  healthAmount.getText());
                    b2.setStyle("-fx-background-color: #00ff00");
                    theName.clear();
                    animalTypes.getSelectionModel().clearSelection();
                    healthAmount.clear();
                } else if (b3.getText().equals("Empty")) {
                    b3.setText("Name: " + theName.getText() + "\nType: " + animalTypes.getValue() + "\nHealth: "
                        +  healthAmount.getText());
                    b3.setStyle("-fx-background-color: #00ff00");
                    theName.clear();
                    animalTypes.getSelectionModel().clearSelection();
                    healthAmount.clear();
                } else if (b4.getText().equals("Empty")) {
                    b4.setText("Name: " + theName.getText() + "\nType: " + animalTypes.getValue() + "\nHealth: "
                        +  healthAmount.getText());
                    b4.setStyle("-fx-background-color: #00ff00");
                    theName.clear();
                    animalTypes.getSelectionModel().clearSelection();
                    healthAmount.clear();
                } else if (b5.getText().equals("Empty")) {
                    b5.setText("Name: " + theName.getText() + "\nType: " + animalTypes.getValue() + "\nHealth: "
                        +  healthAmount.getText());
                    b5.setStyle("-fx-background-color: #00ff00");
                    theName.clear();
                    animalTypes.getSelectionModel().clearSelection();
                    healthAmount.clear();
                } else if (b6.getText().equals("Empty")) {
                    b6.setText("Name: " + theName.getText() + "\nType: " + animalTypes.getValue() + "\nHealth: "
                        +  healthAmount.getText());
                    b6.setStyle("-fx-background-color: #00ff00");
                    theName.clear();
                    animalTypes.getSelectionModel().clearSelection();
                    healthAmount.clear();
                } else {
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setTitle("--ALERT--");
                    error.setContentText("There is no more room!");
                    error.showAndWait();
                    theName.clear();
                    animalTypes.getSelectionModel().clearSelection();
                    healthAmount.clear();
                    //.setHgap(), .setvgap(), .setpadding() --> take in new insets
                }
            }
        });
        b1.setOnAction(e -> {
            b1.setText("Empty"); b1.setStyle("-fx-background-color: BackgroundColor.DEFAULT"); });
        b2.setOnAction(e -> {
            b2.setText("Empty"); b2.setStyle("-fx-background-color: BackgroundColor.DEFAULT"); });
        b3.setOnAction(e -> {
            b3.setText("Empty"); b3.setStyle("-fx-background-color: BackgroundColor.DEFAULT"); });
        b4.setOnAction(e -> {
            b4.setText("Empty"); b4.setStyle("-fx-background-color: BackgroundColor.DEFAULT"); });
        b5.setOnAction(e -> {
            b5.setText("Empty"); b5.setStyle("-fx-background-color: BackgroundColor.DEFAULT"); });
        b6.setOnAction(e -> {
            b6.setText("Empty"); b6.setStyle("-fx-background-color: BackgroundColor.DEFAULT"); });
        pane1.getChildren().add(view);
        Scene scene = new Scene(pane1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}