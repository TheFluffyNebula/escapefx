package edu.guilford;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

public class MenuPane extends Pane {
    /*
     * components required:
     * title label, startFromBeginning button, startFromLevel button, exit button
     * (later)
     * inputLevel text field, level list to help startFromLevel
     */
    // attributes
    private Label titleLabel;
    private ArrayList<Level> levelList;
    Font labelFont = new Font("Arial", 30);

    // constructor
    public MenuPane() {
        drawMenuBG();
        // initialize attributes
        levelList = new ArrayList<>(Arrays.asList(
            new Level(1, "a button"), new Level(2, "no button"), new Level(3, "knock knock"),
            new Level(4, "Peace"), new Level(5, "thisxthis"), new Level(6, "wrod"),
            new Level(7, "don't move"), new Level(8, "wrod 2"),
            new Level(9, "no button 2"), new Level(10, "123...")));
        titleLabel = new Label("EscapeFX");
        final Label newGameLabel = new Label("New Game");
        final Button newGameButton = new Button("    ");
        final Label startFromLabel = new Label("Start from level");
        final Button startFromButton = new Button("    ");
        final TextField levelSelectField = new TextField();
        final Button exitButton = new Button("Exit");
        // set up the locations
        titleLabel.setLayoutX(230);
        titleLabel.setLayoutY(100);
        titleLabel.setTextFill(Color.WHITE);
        newGameLabel.setLayoutX(80);
        newGameLabel.setLayoutY(200);
        newGameLabel.setTextFill(Color.WHITE);
        newGameButton.setLayoutX(105);
        newGameButton.setLayoutY(250);
        newGameButton.setStyle("-fx-background-color: pink; -fx-text-fill: white;");
        startFromLabel.setLayoutX(360);
        startFromLabel.setLayoutY(200);
        startFromLabel.setTextFill(Color.WHITE);
        startFromButton.setLayoutX(420);
        startFromButton.setLayoutY(250);
        startFromButton.setStyle("-fx-background-color: pink; -fx-text-fill: white;");
        levelSelectField.setLayoutX(440);
        levelSelectField.setLayoutY(310);
        levelSelectField.setPromptText("1 to 10");
        levelSelectField.setPrefWidth(50);
        exitButton.setLayoutX(250);
        exitButton.setLayoutY(300);
        exitButton.setStyle("-fx-background-color: pink; -fx-text-fill: white;");
        // set fonts
        titleLabel.setFont(labelFont);
        newGameLabel.setFont(labelFont);
        startFromLabel.setFont(labelFont);
        // set button sizes
        newGameButton.setPrefSize(100, 50);
        startFromButton.setPrefSize(100, 50);
        exitButton.setPrefSize(100, 50);
        // add components to pane
        getChildren().add(titleLabel);
        getChildren().add(newGameLabel);
        getChildren().add(newGameButton);
        getChildren().add(startFromLabel);
        getChildren().add(startFromButton);
        getChildren().add(levelSelectField);
        getChildren().add(exitButton);
        // listeners
        // new game button
        newGameButton.setOnAction(e -> {
            // start from level 1
            Level levelOne = new Level(1, "a button");
            getChildren().clear();
            getChildren().add(new LevelPane(levelOne));
        });
        // start from level button
        startFromButton.setOnAction(e -> {
            try {
                // get the level number from the text field
                int levelNum = Integer.parseInt(levelSelectField.getText());
                // get the level from the level list
                Level level = levelList.get(levelNum - 1);
                // clear the pane and add the level pane
                getChildren().clear();
                getChildren().add(new LevelPane(level));
            } catch (Exception ex) {
                System.out.println("Invalid level number");
            }
        });
        // exit button
        exitButton.setOnAction(e -> {
            System.exit(0);
        });
    }

    private void drawMenuBG() {
        // dark blue floor
        Shape floor = new Rectangle(0, 400, 640, 80);
        floor.setFill(Color.rgb(22, 72, 73, 1.0));
        getChildren().add(floor);
        // draw light blue wall
        Shape wall = new Rectangle(0, 0, 640, 400);
        wall.setFill(Color.rgb(73, 157, 159, 1.0));
        getChildren().add(wall);
    }

}
