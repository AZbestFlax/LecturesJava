package lecture04.example12;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;

public class Program extends Application {

    Label response;

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("ListView");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 120);
        myStage.setScene(myScene);
        response = new Label("Select any Language...");
        //*
        ObservableList<String> language =
                FXCollections.observableArrayList( "Java", "C#", "Python" );
        //*/

        /*
        ObservableList<String> language =
                FXCollections.observableArrayList( "Java", "C#", "Python","Ruby","PHP" );

        //*/

        ListView<String> lvLanguage = new ListView<>(language);
        lvLanguage.setPrefSize(80, 80);
        MultipleSelectionModel<String> lvSelModel =
                lvLanguage.getSelectionModel();

        //*
        lvSelModel.selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> changed,
                                        String oldVal, String newVal) {
                        response.setText("Language selected is " + newVal);
                    }
                });

        //*/

        /*
        lvLanguage.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvSelModel.selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> changed,
                                        String oldVal, String newVal) {

                        String selItems = "";
                        ObservableList<String> selected =
                                lvLanguage.getSelectionModel().getSelectedItems();

                        // Display the selections.
                        for(int i=0; i < selected.size(); i++)
                            selItems += "\n      " + selected.get(i);

                        response.setText("All languages selected: " + selItems);
                    }
                });
        //*/

        rootNode.getChildren().addAll(lvLanguage, response);
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}