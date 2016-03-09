package lecture05.example99;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Formatter;
import java.util.GregorianCalendar;

public class Main extends Application {

    Image start;
    Image fire;
    ImageView[] im;
    ProgressBar[] pb;
    Button btnThread1, btnThread2, btnThread3;

    public Main() {
        super();
        start = new Image("lecture05/example99/start.png");
        fire = new Image("lecture05/example99/fire.png");

        pb = new ProgressBar[3];
        im = new ImageView[3];
        for (int i = 0; i < 3; i++) {
            pb[i] = new ProgressBar();
            pb[i].setPrefWidth(150.0);
            pb[i].setProgress(0.0);

            im[i] = new ImageView(start);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.addColumn(0);
        root.addColumn(1);
        root.addRow(0);
        root.setAlignment(Pos.CENTER);
        root.setVgap(10.0);
        root.setHgap(10.0);
        root.setPadding(new Insets(10));
        primaryStage.setTitle("Use Threads");
        primaryStage.setScene(new Scene(root, 350, 350));

        TextArea textField = new TextArea();
        Button btnAddTime = new Button("Add time of Click");
        btnAddTime.setOnAction( (ae)-> {
            textField.setText( textField.getText() + "\n" + new Formatter().format("%tT", new GregorianCalendar().getInstance()));
        } );

        btnThread1 = new Button("Start heavy computing1");
        btnThread1.setPrefHeight(50.0);
        btnThread1.setPrefWidth(85.0);
        btnThread1.setWrapText(true);
        btnThread1.setTextAlignment(TextAlignment.CENTER);
        btnThread1.setOnAction( (ae) -> {
            btnThread1.setDisable(true);
            new CalcThread(this, 0);
        });

        btnThread2 = new Button("Start heavy computing2");
        btnThread2.setPrefHeight(50.0);
        btnThread2.setPrefWidth(85.0);
        btnThread2.setWrapText(true);
        btnThread2.setTextAlignment(TextAlignment.CENTER);
        btnThread2.setOnAction( (ae) -> {
            btnThread2.setDisable(true);
            new CalcThread(this, 1);
        });

        btnThread3 = new Button("Start heavy computing3");
        btnThread3.setPrefHeight(50.0);
        btnThread3.setPrefWidth(85.0);
        btnThread3.setWrapText(true);
        btnThread3.setTextAlignment(TextAlignment.CENTER);
        btnThread3.setOnAction( (ae) -> {
            btnThread3.setDisable(true);
            new CalcThread(this, 2);
        });

        FlowPane leftSide = new FlowPane(10, 10);
        leftSide.setPrefWidth(220.0);
        leftSide.setAlignment(Pos.TOP_CENTER);
        leftSide.getChildren().addAll(btnAddTime, btnThread1, im[0], pb[0], btnThread2, im[1], pb[1], btnThread3, im[2], pb[2]);



        root.add(leftSide, 0, 0);


        textField.setPrefWidth(250.0);
        textField.setPadding(new Insets(10));
        root.add(textField, 1, 0);

        primaryStage.show();
    }

    public void setStart(int number) {
        im[number].setImage(start);
    }

    public void setFire(int number) {
        im[number].setImage(fire);
    }

    public void setProgress(int number, double value) {
        pb[number].setProgress(value);
    }

    public void setEnable(int number) {
        switch(number) {
            case 0: btnThread1.setDisable(false); break;
            case 1: btnThread1.setDisable(false); break;
            case 2: btnThread1.setDisable(false); break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
