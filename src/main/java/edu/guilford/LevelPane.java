package edu.guilford;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This class is a Pane that holds the level.
 * Draws the background, Takes in a Level
 * Based on what Level it takes in, it draws
 * the required components
 * It also handles the logic of the level
 * to go to the next level... I'll cross that bridge when I get there
 */

public class LevelPane extends Pane {
    // letters above door
    private Text eText = new Text("E");
    private Text sText = new Text("S");
    private Text cText = new Text("C");
    private Text aText = new Text("A");
    private Text pText = new Text("P");
    private Text eText2 = new Text("E");
    // general components (always needed)
    private Label nextLevelText;
    private Button nextLevelButton;
    Color letterGreen = Color.rgb(1, 252, 3, 1.0);
    Color letterGray = Color.rgb(128, 128, 128, 1.0);
    // level 1 components
    private Button lv1Button;
    private int lv1Clicks = 0;

    // constructor
    /**
     * This constructor takes in a Level object
     * 
     * @param level
     *              It always draws the background (elements present in all levels)
     *              Based on what Level it takes in, it draws something different
     */
    public LevelPane(Level level) {
        drawBackground();
        int levelNum = level.getLevelNumber();
        if (levelNum == 1) {
            System.out.println("Welcome to level 1!");
            // component required: one button + next level button
            lv1Button = new Button("    ");
            lv1Button.setLayoutX(360);
            lv1Button.setLayoutY(230);
            // lv1Button.setVisible(true);
            getChildren().add(lv1Button);
            lv1Button.setOnAction(e -> {
                lv1Clicks++;
                switch (lv1Clicks) {
                    case 1:
                        eText.setFill(letterGreen);
                        eText.setOpacity(1.0);
                        break;
                    case 2:
                        sText.setFill(letterGreen);
                        sText.setOpacity(1.0);
                        break;
                    case 3:
                        cText.setFill(letterGreen);
                        cText.setOpacity(1.0);
                        break;
                    case 4:
                        aText.setFill(letterGreen);
                        aText.setOpacity(1.0);
                        break;
                    case 5:
                        pText.setFill(letterGreen);
                        pText.setOpacity(1.0);
                        break;
                    case 6:
                        eText2.setFill(letterGreen);
                        eText2.setOpacity(1.0);
                        nextLevelButton.setVisible(true);
                        nextLevelText.setVisible(true);
                        break;
                    default:
                        break;
                }
            });
            nextLevelButton.setOnAction(e -> {
                // System.out.println("next level button clicked");
                Level levelTwo = new Level(2, "no button");
                getChildren().clear();
                getChildren().add(new LevelPane(levelTwo));
            });
        }
        if (levelNum == 2) {
            System.out.println("Welcome to level 2!");
            // get where the user clicks
            this.setOnMouseClicked(event -> {
                double x = event.getSceneX();
                double y = event.getSceneY();
                if (x >= 50 && x <= 80 && y >= 50 && y <= 100) {
                    if (eText.getFill() == letterGreen) {
                        eText.setFill(letterGray);
                        eText.setOpacity(0.5);
                    } else {
                        eText.setFill(letterGreen);
                        eText.setOpacity(1.0);
                    }
                }

                if (x >= 90 && x <= 120 && y >= 50 && y <= 100) {
                    if (sText.getFill() == letterGreen) {
                        sText.setFill(letterGray);
                        sText.setOpacity(0.5);
                    } else {
                        sText.setFill(letterGreen);
                        sText.setOpacity(1.0);
                    }
                }

                if (x >= 130 && x <= 160 && y >= 50 && y <= 100) {
                    if (cText.getFill() == letterGreen) {
                        cText.setFill(letterGray);
                        cText.setOpacity(0.5);
                    } else {
                        cText.setFill(letterGreen);
                        cText.setOpacity(1.0);
                    }
                }

                if (x >= 170 && x <= 200 && y >= 50 && y <= 100) {
                    if (aText.getFill() == letterGreen) {
                        aText.setFill(letterGray);
                        aText.setOpacity(0.5);
                    } else {
                        aText.setFill(letterGreen);
                        aText.setOpacity(1.0);
                    }
                }

                if (x >= 210 && x <= 240 && y >= 50 && y <= 100) {
                    if (pText.getFill() == letterGreen) {
                        pText.setFill(letterGray);
                        pText.setOpacity(0.5);
                    } else {
                        pText.setFill(letterGreen);
                        pText.setOpacity(1.0);
                    }
                }

                if (x >= 250 && x <= 280 && y >= 50 && y <= 100) {
                    if (eText2.getFill() == letterGreen) {
                        eText2.setFill(letterGray);
                        eText2.setOpacity(0.5);
                    } else {
                        eText2.setFill(letterGreen);
                        eText2.setOpacity(1.0);
                    }
                }
                if (allLettersGreen()) {
                    nextLevelButton.setVisible(true);
                    nextLevelText.setVisible(true);
                }
                nextLevelButton.setOnAction(e -> {
                    // System.out.println("level 3 button clicked");
                    Level levelThree = new Level(3, "knock knock");
                    getChildren().clear();
                    getChildren().add(new LevelPane(levelThree));
                });
                // System.out.println("Clicked at: (" + x + ", " + y + ")");
            });
        }
        if (levelNum==3) {
            System.out.println("Welcome to level 3!");
        }
    }

    // method to draw the backgrorund
    public void drawBackground() {
        // System.out.println("drawBackground() called");
        // dark blue floor
        Shape floor = new Rectangle(0, 400, 640, 80);
        floor.setFill(Color.rgb(22, 72, 73, 1.0));
        getChildren().add(floor);
        // draw light blue wall
        Shape wall = new Rectangle(0, 0, 640, 400);
        wall.setFill(Color.rgb(73, 157, 159, 1.0));
        getChildren().add(wall);
        // draw the door
        Shape door = new Rectangle(30, 130, 270, 270);
        door.setFill(Color.rgb(0, 0, 0, 1.0));
        getChildren().add(door);

        // draw the letters
        eText.setFont(new Font("Arial", 60));
        eText.setFill(Color.GRAY);
        eText.setX(50);
        eText.setY(100);

        sText.setFont(new Font("Arial", 60));
        sText.setFill(Color.GRAY);
        sText.setX(90);
        sText.setY(100);

        cText.setFont(new Font("Arial", 60));
        cText.setFill(Color.GRAY);
        cText.setX(130);
        cText.setY(100);

        aText.setFont(new Font("Arial", 60));
        aText.setFill(Color.GRAY);
        aText.setX(170);
        aText.setY(100);

        pText.setFont(new Font("Arial", 60));
        pText.setFill(Color.GRAY);
        pText.setX(210);
        pText.setY(100);

        eText2.setFont(new Font("Arial", 60));
        eText2.setFill(Color.GRAY);
        eText2.setX(250);
        eText2.setY(100);
        getChildren().add(eText);
        getChildren().add(sText);
        getChildren().add(cText);
        getChildren().add(aText);
        getChildren().add(pText);
        getChildren().add(eText2);

        // keep nextLevelText and nextLevelButton invisible until the level is solved
        nextLevelButton = new Button("ok");
        nextLevelButton.setLayoutX(110);
        nextLevelButton.setLayoutY(300);
        nextLevelButton.setPrefWidth(100);
        nextLevelButton.setPrefHeight(100);
        nextLevelButton.setFont(new Font("Arial", 40));
        nextLevelButton.setStyle("-fx-background-color: #FFC0CB; -fx-text-fill: #FFFFFF;");
        getChildren().add(nextLevelButton);
        nextLevelButton.setVisible(false);
        nextLevelText = new Label("Ready for the\nnext level?");
        nextLevelText.setLayoutX(110);
        nextLevelText.setLayoutY(200);
        nextLevelText.setTextFill(Color.WHITE);
        nextLevelText.setFont(new Font("Arial", 20));
        getChildren().add(nextLevelText);
        nextLevelText.setVisible(false);
    }

    // check if all letters are green
    public boolean allLettersGreen() {
        if (eText.getFill() != letterGreen) {
            return false;
        }
        if (sText.getFill() != letterGreen) {
            return false;
        }
        if (cText.getFill() != letterGreen) {
            return false;
        }
        if (aText.getFill() != letterGreen) {
            return false;
        }
        if (pText.getFill() != letterGreen) {
            return false;
        }
        if (eText2.getFill() != letterGreen) {
            return false;
        }
        return true;
    }

}
