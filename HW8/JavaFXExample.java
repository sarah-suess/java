import java.application.Application;
import java.scene.Scene;
import java.stage.Stage;
import java.scene.layout.StackPane;
import java.scene.image.Image;
import java.scene.image.ImageView;

public class JavaFXExample extends Application {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Testing");
        StackPane elements = new StackPane();
        Image img = new Image("class schedule.png");
        ImageView image = new ImageView();
        image.setImage(img);
        elements.getChildren().add(image);




    }
}