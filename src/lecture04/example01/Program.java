package lecture04.example01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Program extends Application {

    public static void main(String[] args) {
        System.out.println("Launching JavaFX application.");
        launch(args);
    }

    @Override
    public void init() {
        System.out.println("Inside the init() method.");
    }

    @Override
    public void start(Stage myStage) {
        System.out.println("Inside the start() method.");

        myStage.setTitle("Title of program");
        FlowPane rootNode = new FlowPane();
        Scene myScene = new Scene(rootNode, 300, 200);
        myStage.setScene(myScene);
        myStage.show();
    }

    @Override
    public void stop() {
        System.out.println("Inside the stop() method.");
    }
}