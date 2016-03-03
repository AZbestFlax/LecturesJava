package lecture04.example03;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Program extends Application {

    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Buttons and Events");
        FlowPane rootNode = new FlowPane(10, 10);

        // Відцентрувати елементи на сцені
        rootNode.setAlignment(Pos.CENTER);

        // Створити сцену
        Scene myScene = new Scene(rootNode, 300, 100);

        // Встановити сцену
        myStage.setScene(myScene);

        // Створити мітку
        response = new Label("Push a Button");

        // Створити 2 кнопки
        Button btnAlpha = new Button("Alpha");
        Button btnBeta = new Button("Beta");

        // Додати опрацьовувач подій кнопки
        btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("Alpha was pressed.");
            }
        });
        btnBeta.setOnAction( (ae) ->
                response.setText("Beta was pressed.")
        );

        // Додати елементи на сцену
        rootNode.getChildren().addAll(btnAlpha, btnBeta, response);

        // Показати підмостки
        myStage.show();
    }
}