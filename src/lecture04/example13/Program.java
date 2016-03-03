package lecture04.example13;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.event.*;


public class Program extends Application {

    ComboBox<String> cbLanguage;
    Label response;

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("ComboBox Demo");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 280, 120);
        myStage.setScene(myScene);
        response = new Label();
        ObservableList<String> Languages =
                FXCollections.observableArrayList( "Ukr", "Eng", "Pol" );
        cbLanguage = new ComboBox<>(Languages);
        cbLanguage.setValue("Ukr");
        response.setText("Selected Language is " + cbLanguage.getValue());

        cbLanguage.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("Selected Language is " + cbLanguage.getValue());
            }
        });

        rootNode.getChildren().addAll(cbLanguage, response);
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}