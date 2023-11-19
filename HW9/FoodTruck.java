import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyCode;

/**
* Used to create a graphics and food truck window.
* @author ssuess3
* @version 11.0.16.1
*/
public class FoodTruck extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new StackPane(), 200, 200);
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case L:
                    System.out.println("L");
                    break;
                case R:
                    System.out.println("R");
                    break;
                default:
                    System.out.println("Not used");
                }
        });
        stage.setScene(scene);
        stage.show();
    }
}