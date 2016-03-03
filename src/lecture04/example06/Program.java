package lecture04.example06;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;

public class Program extends Application {

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Smile in a Label");
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 200);
        myStage.setScene(myScene);

        ImageView smile = new ImageView("lecture04/example06/smile.png");
        Label smileLabel = new Label("Smile", smile);
        rootNode.getChildren().add(smileLabel);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}