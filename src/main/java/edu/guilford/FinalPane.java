package edu.guilford;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class FinalPane extends Pane {
    /* components
     * well done text
     * you did have what it takes to escape 10 times
     * thank you for playing
     */
    private Label wellDone;
    private Label youDidIt;
    private Label thankYou;
    private Label credits;
    public FinalPane() {
        drawFinalBG();
        wellDone = new Label("well done");
        wellDone.setLayoutX(200);
        wellDone.setLayoutY(147);
        wellDone.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: black;");
        youDidIt = new Label("you did have what it takes to escape 10 times");
        youDidIt.setLayoutX(120);
        youDidIt.setLayoutY(205);
        youDidIt.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
        thankYou = new Label("thank you for playing");
        thankYou.setLayoutX(210);
        thankYou.setLayoutY(250);
        thankYou.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
        getChildren().add(wellDone);
        getChildren().add(youDidIt);
        getChildren().add(thankYou);
        credits = new Label("thanks to bart bonte for the original game and\nrob whitnell for teaching me the ropes of maven");
        credits.setLayoutX(110);
        credits.setLayoutY(300);
        credits.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
        getChildren().add(credits);
    }

    private void drawFinalBG() {
        // dark black 
        Shape floor = new Rectangle(0, 200, 640, 280);
        floor.setFill(Color.BLACK);
        getChildren().add(floor);
        // draw light blue sky
        Shape sky = new Rectangle(0, 0, 640, 200);
        sky.setFill(Color.rgb(137, 255, 234, 1.0));
        getChildren().add(sky);
    }
}
