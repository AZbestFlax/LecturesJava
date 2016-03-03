package lecture04.example10;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class Program extends Application {

    Label response;
    ToggleGroup tg;

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Language");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 180, 140);
        myStage.setScene(myScene);
        Label choose = new Label("      Select a Language      ");
        response = new Label("No language selected");

        Button btnConfirm = new Button("Confirm Language Selection");

        RadioButton rbJava = new RadioButton("Java");
        RadioButton rbC = new RadioButton("C#");
        RadioButton rbRuby = new RadioButton("Ruby");

        tg = new ToggleGroup();
        rbJava.setToggleGroup(tg);
        rbC.setToggleGroup(tg);
        rbRuby.setToggleGroup(tg);
        rbJava.setSelected(true);

        btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                RadioButton rb = (RadioButton) tg.getSelectedToggle();
                response.setText(rb.getText() + " is confirmed.");
            }
        });

        Separator separator = new Separator();
        separator.setPrefWidth(160);
        rootNode.getChildren().addAll(choose, rbJava, rbC, rbRuby,
                separator, btnConfirm, response);
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}