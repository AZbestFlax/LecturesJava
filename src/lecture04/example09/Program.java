package lecture04.example09;
import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class Program extends Application {

    Label response;

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Language");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 220, 120);
        myStage.setScene(myScene);

        response = new Label("");

        RadioButton rbJava = new RadioButton("Java");
        RadioButton rbC = new RadioButton("C#");
        RadioButton rbRuby = new RadioButton("Ruby");

        ToggleGroup tg = new ToggleGroup();
        rbJava.setToggleGroup(tg);
        rbC.setToggleGroup(tg);
        rbRuby.setToggleGroup(tg);

        //*
        rbJava.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("Your language is Java");
            }
        });

        rbC.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("Your language is C#");
            }
        });

        rbRuby.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("Your language is Ruby");
            }
        });
        //*/


        /*
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> changed,
                            Toggle oldVal, Toggle newVal) {
                RadioButton rb = (RadioButton) newVal;
                response.setText("Your language is " + rb.getText());
            }
        });
        //*/

        rbJava.fire();

        rootNode.getChildren().addAll(rbJava, rbC, rbRuby, response);
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}