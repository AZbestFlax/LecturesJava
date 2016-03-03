package lecture04.example07;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.image.*;

public class Program extends Application {

    Label response;

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Buttons");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 200, 500);
        myStage.setScene(myScene);

        response = new Label("Push a Button");

        Button btnWink = new Button("Wink",
                new ImageView("lecture04/example07/smile01.png"));
        Button btnShock = new Button("Shock",
                new ImageView("lecture04/example07/smile02.png"));

        // Позиція тексту
        btnWink.setContentDisplay(ContentDisplay.TOP);
        btnShock.setContentDisplay(ContentDisplay.TOP);

        btnWink.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("Wink Pressed");
            }
        });

        btnShock.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("Shock Pressed");
            }
        });

        rootNode.getChildren().addAll(btnWink, btnShock, response);
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
