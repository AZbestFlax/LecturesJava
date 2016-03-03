package lecture04.example99;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.transform.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;

public class Program extends Application {

    double angle = 0.0;
    double glowVal = 0.0;
    boolean shadow = false;
    double scaleFactor = 1.0;

    Glow glow = new Glow(0.0);
    InnerShadow innerShadow = new InnerShadow(10.0, Color.RED);
    Rotate rotate = new Rotate();
    Scale scale = new Scale(scaleFactor, scaleFactor);

    Button btnRotate = new Button("Rotate");
    Button btnGlow = new Button("Glow");
    Button btnShadow = new Button("Shadow off");
    Button btnScale = new Button("Scale");

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Effects and Transforms Demo");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 100);
        myStage.setScene(myScene);
        btnGlow.setEffect(glow);
        btnRotate.getTransforms().add(rotate);
        btnScale.getTransforms().add(scale);
        btnRotate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                angle += 30.0;

                rotate.setAngle(angle);
                rotate.setPivotX(btnRotate.getWidth()/2);
                rotate.setPivotY(btnRotate.getHeight()/2);
            }
        });

        btnScale.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                // Each time button is pressed, the button's scale is changed.
                scaleFactor += 0.1;
                if(scaleFactor > 1.0) scaleFactor = 0.4;

                scale.setX(scaleFactor);
                scale.setY(scaleFactor);
            }
        });

        btnGlow.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                glowVal += 0.1;
                if(glowVal > 1.0) glowVal = 0.0;
                glow.setLevel(glowVal);
            }
        });

        btnShadow.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                shadow = !shadow;
                if(shadow) {
                    btnShadow.setEffect(innerShadow);
                    btnShadow.setText("Shadow on");
                } else {
                    btnShadow.setEffect(null);
                    btnShadow.setText("Shadow off");
                }
            }
        });

        rootNode.getChildren().addAll(btnRotate, btnScale, btnGlow, btnShadow);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}