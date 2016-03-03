package lecture04.example05;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;


public class Program extends Application {

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Smile");
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 200);
        myStage.setScene(myScene);

        Image image = new Image("lecture04/example05/smile.png");
        ImageView imageIV = new ImageView(image);

        rootNode.getChildren().add(imageIV);
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}