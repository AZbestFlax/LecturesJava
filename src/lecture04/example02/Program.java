package lecture04.example02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Program  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Simple label");
        FlowPane rootNode = new FlowPane();
        Scene myScene = new Scene(rootNode, 300, 200);
        myStage.setScene(myScene);

        Label myLabel = new Label("This is a JavaFX label");
        rootNode.getChildren().add(myLabel);

        myStage.show();
    }
}
