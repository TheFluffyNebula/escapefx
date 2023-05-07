package edu.guilford;

import java.util.Arrays;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * This class is a Pane that holds the level.
 * Draws the background, Takes in a Level
 * Based on what Level it takes in, it draws
 * the required components
 * It also handles the logic of the level
 * to go to the next level getChildren().clear()
 * and add a new LevelPane with the next level
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
    private Label levelLabel; // level number and name
    private Label nextLevelText;
    private Button nextLevelButton;
    Color letterGreen = Color.rgb(1, 252, 3, 1.0);
    Color letterGray = Color.rgb(128, 128, 128, 1.0);
    // level 1 components
    private Button lv1Button;
    private int lv1Clicks = 0;
    // level 2 components
    private Label lv2Label;
    // level 3 components
    private int lv3Clicks = 0;
    private Label lv3Label;
    // level 4 components
    private int lv4Clicks = 0; // progress tracker
    private Label lv4Label;
    // level 5 components
    private int lv5Clicks = 0;
    private Button lv5Button5;
    private Label lv5Label;
    // level 6 components
    private Label lv6Label;
    private TextField lv6TextField;
    private Button lv6SubmitButton;
    // level 7 components
    private Label lv7Label;
    // level 8 components
    private Label lv8Label;
    private int lv8Clicks = 0; // progress tracker
    private Button lv8Button1;
    private Button lv8Button2;
    private Button lv8Button3;
    private Button lv8Button4;
    private Button lv8Button5;
    // level 10 components
    private Label lv10Label;
    private int lv10Clicks = 0; // progress tracker
    private Button lv10Button1;
    private Button lv10Button2;
    private Button lv10Button3;
    private Button lv10Button4;
    private Button lv10Button5;
    private Button lv10Button6;

    // level 11 components
    // constructor
    /**
     * This constructor takes in a Level object
     * 
     * @param level
     *              It always draws the background (elements present in all levels)
     *              Based on what Level it takes in, it draws something different
     */
    public LevelPane(Level level) {
        int levelNum = level.getLevelNumber();
        String levelName = level.getLevelName();
        drawBackground(levelNum, levelName);
        // String levelName = level.getLevelName();
        if (levelNum == 1) {
            System.out.println("Welcome to level 1!"); // user has to click the button 6 times
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
            lv2Label = new Label("no button?"); // user has to click all the letters
            lv2Label.setLayoutX(360);
            lv2Label.setLayoutY(230);
            lv2Label.setTextFill(Color.BLACK);
            lv2Label.setFont(new Font("Arial", 20));
            lv2Label.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), null)));
            getChildren().add(lv2Label);
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
        if (levelNum == 3) {
            lv3Label = new Label("knock\nknock"); // user has to click the door twice
            lv3Label.setLayoutX(360);
            lv3Label.setLayoutY(230);
            lv3Label.setTextFill(Color.BLACK);
            lv3Label.setFont(new Font("Arial", 20));
            lv3Label.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), null)));
            getChildren().add(lv3Label);
            System.out.println("Welcome to level 3!");
            // get the position of a click
            this.setOnMouseClicked(event -> {
                double x = event.getSceneX();
                double y = event.getSceneY();
                // System.out.println("Clicked at: (" + x + ", " + y + ")");
                // if the click is in the door
                if (x >= 30 && x <= 300 && y >= 130 && y <= 400) {
                    lv3Clicks++;
                    if (lv3Clicks >= 2) {
                        makeLettersGreen();
                        nextLevelButton.setVisible(true);
                        nextLevelText.setVisible(true);

                    }
                }
            });
            nextLevelButton.setOnAction(e -> {
                Level levelFour = new Level(4, "Peace");
                getChildren().clear();
                getChildren().add(new LevelPane(levelFour));
            });
        }
        if (levelNum == 4) {
            lv4Label = new Label("PEACE"); // user has to spell peace
            lv4Label.setLayoutX(360);
            lv4Label.setLayoutY(230);
            lv4Label.setTextFill(Color.BLACK);
            lv4Label.setFont(new Font("Arial", 20));
            lv4Label.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), null)));
            getChildren().add(lv4Label);
            System.out.println("Welcome to level 4!");
            this.setOnMouseClicked(event -> {
                double x = event.getSceneX();
                double y = event.getSceneY();
                if (x >= 50 && x <= 80 && y >= 50 && y <= 100) {
                    if (lv4Clicks == 1) {
                        eText.setFill(letterGreen);
                        eText.setOpacity(1.0);
                        lv4Clicks++;
                    } else if (lv4Clicks == 4 && eText2.getFill() == letterGreen) {
                        eText.setFill(letterGreen);
                        eText.setOpacity(1.0);
                        lv4Clicks++;
                    } else {
                        lv4Clicks = 0;
                        makeLettersGray();
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
                    if (lv4Clicks == 3) {
                        cText.setFill(letterGreen);
                        cText.setOpacity(1.0);
                        lv4Clicks++;
                    } else {
                        lv4Clicks = 0;
                        makeLettersGray();
                    }
                }

                if (x >= 170 && x <= 200 && y >= 50 && y <= 100) {
                    if (lv4Clicks == 2) {
                        aText.setFill(letterGreen);
                        aText.setOpacity(1.0);
                        lv4Clicks++;
                    } else {
                        lv4Clicks = 0;
                        makeLettersGray();
                    }
                }

                if (x >= 210 && x <= 240 && y >= 50 && y <= 100) {
                    if (lv4Clicks == 0) {
                        pText.setFill(letterGreen);
                        pText.setOpacity(1.0);
                        lv4Clicks++;
                    } else {
                        makeLettersGray();
                    }
                }

                if (x >= 250 && x <= 280 && y >= 50 && y <= 100) {
                    if (lv4Clicks == 1) {
                        eText2.setFill(letterGreen);
                        eText2.setOpacity(1.0);
                        lv4Clicks++;
                    } else if (lv4Clicks == 4 && eText.getFill() == letterGreen) {
                        eText2.setFill(letterGreen);
                        eText2.setOpacity(1.0);
                        lv4Clicks++;
                    } else {
                        lv4Clicks = 0;
                        makeLettersGray();
                    }
                }
                if (lv4Clicks == 5) {
                    makeLettersGreen();
                    nextLevelButton.setVisible(true);
                    nextLevelText.setVisible(true);
                }
                nextLevelButton.setOnAction(e -> {
                    // System.out.println("level 3 button clicked");
                    Level levelFive = new Level(5, "thisxthis");
                    getChildren().clear();
                    getChildren().add(new LevelPane(levelFive));
                });
            });
        }
        if (levelNum == 5) {
            // user has to click 5th button 5 times
            System.out.println("Welcome to level 5!");
            Button[] lv5Buttons = new Button[] {
                    new Button("    "),
                    new Button("    "),
                    new Button("    "),
                    new Button("    "),
                    lv5Button5 = new Button("    ")
            };

            for (int i = 0; i < lv5Buttons.length; i++) {
                lv5Buttons[i].setLayoutX(360 + i * 40);
                lv5Buttons[i].setLayoutY(280);
                getChildren().add(lv5Buttons[i]);
            }
            // label above the buttons
            lv5Label = new Label("thisxthis");
            lv5Label.setLayoutX(420);
            lv5Label.setLayoutY(230);
            lv5Label.setTextFill(Color.BLACK);
            lv5Label.setFont(new Font("Arial", 20));
            lv5Label.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), null)));
            getChildren().add(lv5Label);
            lv5Button5.setOnAction(e -> {
                lv5Clicks++;
                if (lv5Clicks == 5) {
                    makeLettersGreen();
                    nextLevelButton.setVisible(true);
                    nextLevelText.setVisible(true);
                }
            });
            nextLevelButton.setOnAction(e -> {
                // System.out.println("level 3 button clicked");
                Level levelSix = new Level(6, "wrod");
                getChildren().clear();
                getChildren().add(new LevelPane(levelSix));
            });
        }
        if (levelNum == 6) {
            lv6Label = new Label("nsvee ezor nsvee"); // user has to unscramble enter 707
            lv6Label.setLayoutX(360);
            lv6Label.setLayoutY(230);
            lv6Label.setTextFill(Color.BLACK);
            lv6Label.setFont(new Font("Arial", 20));
            lv6Label.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), null)));
            getChildren().add(lv6Label);
            System.out.println("Welcome to level 6!");
            lv6TextField = new TextField();
            lv6TextField.setLayoutX(385);
            lv6TextField.setLayoutY(280);
            lv6TextField.setPrefWidth(100);
            lv6TextField.setPrefHeight(50);
            lv6TextField.setFont(new Font("Arial", 20));
            getChildren().add(lv6TextField);
            lv6SubmitButton = new Button("submit");
            lv6SubmitButton.setLayoutX(385);
            lv6SubmitButton.setLayoutY(340);
            lv6SubmitButton.setPrefWidth(100);
            lv6SubmitButton.setPrefHeight(50);
            lv6SubmitButton.setFont(new Font("Arial", 20));
            getChildren().add(lv6SubmitButton);
            // listener for submit button
            lv6SubmitButton.setOnAction(e -> {
                String input = lv6TextField.getText();
                if (input.equals("707")) {
                    makeLettersGreen();
                    nextLevelButton.setVisible(true);
                    nextLevelText.setVisible(true);
                } else {
                    lv6TextField.setText("");
                }
            });
            nextLevelButton.setOnAction(e -> {
                // System.out.println("level 3 button clicked");
                Level levelSeven = new Level(7, "don't move");
                getChildren().clear();
                getChildren().add(new LevelPane(levelSeven));
            });
        }
        if (levelNum == 7) {
            System.out.println("Welcome to level 7!");
            lv7Label = new Label("don't\nmove");
            lv7Label.setLayoutX(420);
            lv7Label.setLayoutY(230);
            lv7Label.setTextFill(Color.BLACK);
            lv7Label.setFont(new Font("Arial", 20));
            lv7Label.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), null)));
            getChildren().add(lv7Label);
            Timeline cursorTimer = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
                // Code to execute after five seconds of inactivity
                // System.out.println("Five seconds of inactivity detected!");
                makeLettersGreen();
                nextLevelButton.setVisible(true);
                nextLevelText.setVisible(true);
            }));
            this.setOnMouseMoved(event -> {
                // Reset the timer every time the mouse is moved
                cursorTimer.stop();
                cursorTimer.play();
            });
            nextLevelButton.setOnAction(e -> {
                // System.out.println("level 3 button clicked");
                Level levelEight = new Level(8, "wrod 2");
                getChildren().clear();
                getChildren().add(new LevelPane(levelEight));
            });
        }
        if (levelNum == 8) {
            lv8Label = new Label("this"); // user has to click all the letters
            lv8Label.setLayoutX(360);
            lv8Label.setLayoutY(230);
            lv8Label.setTextFill(Color.BLACK);
            lv8Label.setFont(new Font("Arial", 20));
            lv8Label.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), null)));
            getChildren().add(lv8Label);
            System.out.println("Welcome to level 8!");
            Font buttonFont = new Font("Arial", 12);
            Button[] lv8Buttons = new Button[] {
                    lv8Button1 = new Button("  t  "),
                    lv8Button2 = new Button("  i  "),
                    lv8Button3 = new Button("  h  "),
                    lv8Button4 = new Button("  e  "),
                    lv8Button5 = new Button("  g  ")
            };

            for (int i = 0; i < lv8Buttons.length; i++) {
                lv8Buttons[i].setLayoutX(360 + i * 40);
                lv8Buttons[i].setLayoutY(280);
                lv8Buttons[i].setFont(buttonFont);
                getChildren().add(lv8Buttons[i]);
            }

            // listeners for each button
            lv8Button1.setOnAction(e -> {
                if (lv8Clicks == 4) {
                    makeLettersGreen();
                    nextLevelButton.setVisible(true);
                    nextLevelText.setVisible(true);
                } else {
                    lv8Clicks = 0;
                }
            });
            lv8Button2.setOnAction(e -> {
                if (lv8Clicks == 1) {
                    lv8Clicks++;
                } else {
                    lv8Clicks = 0;
                }
            });
            lv8Button3.setOnAction(e -> {
                if (lv8Clicks == 3) {
                    lv8Clicks++;
                } else {
                    lv8Clicks = 0;
                }
            });
            lv8Button4.setOnAction(e -> {
                if (lv8Clicks == 0) {
                    lv8Clicks++;
                } else {
                    lv8Clicks = 0;
                }
            });
            lv8Button5.setOnAction(e -> {
                if (lv8Clicks == 2) {
                    lv8Clicks++;
                } else {
                    lv8Clicks = 0;
                }
            });
            nextLevelButton.setOnAction(e -> {
                // System.out.println("level 3 button clicked");
                Level levelNine = new Level(9, "no button 2");
                getChildren().clear();
                getChildren().add(new LevelPane(levelNine));
            });
        }
        if (levelNum == 9) {
            System.out.println("Welcome to level 9!");
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
                    if (sText.getFill() == letterGreen) {
                        sText.setFill(letterGray);
                        sText.setOpacity(0.5);
                    } else {
                        sText.setFill(letterGreen);
                        sText.setOpacity(1.0);
                    }
                }

                if (x >= 90 && x <= 120 && y >= 50 && y <= 100) {
                    if (eText.getFill() == letterGreen) {
                        eText.setFill(letterGray);
                        eText.setOpacity(0.5);
                    } else {
                        eText.setFill(letterGreen);
                        eText.setOpacity(1.0);
                    }
                    if (sText.getFill() == letterGreen) {
                        sText.setFill(letterGray);
                        sText.setOpacity(0.5);
                    } else {
                        sText.setFill(letterGreen);
                        sText.setOpacity(1.0);
                    }
                    if (cText.getFill() == letterGreen) {
                        cText.setFill(letterGray);
                        cText.setOpacity(0.5);
                    } else {
                        cText.setFill(letterGreen);
                        cText.setOpacity(1.0);
                    }
                }

                if (x >= 130 && x <= 160 && y >= 50 && y <= 100) {
                    if (sText.getFill() == letterGreen) {
                        sText.setFill(letterGray);
                        sText.setOpacity(0.5);
                    } else {
                        sText.setFill(letterGreen);
                        sText.setOpacity(1.0);
                    }
                    if (cText.getFill() == letterGreen) {
                        cText.setFill(letterGray);
                        cText.setOpacity(0.5);
                    } else {
                        cText.setFill(letterGreen);
                        cText.setOpacity(1.0);
                    }
                    if (aText.getFill() == letterGreen) {
                        aText.setFill(letterGray);
                        aText.setOpacity(0.5);
                    } else {
                        aText.setFill(letterGreen);
                        aText.setOpacity(1.0);
                    }
                }

                if (x >= 170 && x <= 200 && y >= 50 && y <= 100) {
                    if (cText.getFill() == letterGreen) {
                        cText.setFill(letterGray);
                        cText.setOpacity(0.5);
                    } else {
                        cText.setFill(letterGreen);
                        cText.setOpacity(1.0);
                    }
                    if (aText.getFill() == letterGreen) {
                        aText.setFill(letterGray);
                        aText.setOpacity(0.5);
                    } else {
                        aText.setFill(letterGreen);
                        aText.setOpacity(1.0);
                    }
                    if (pText.getFill() == letterGreen) {
                        pText.setFill(letterGray);
                        pText.setOpacity(0.5);
                    } else {
                        pText.setFill(letterGreen);
                        pText.setOpacity(1.0);
                    }
                }

                if (x >= 210 && x <= 240 && y >= 50 && y <= 100) {
                    if (aText.getFill() == letterGreen) {
                        aText.setFill(letterGray);
                        aText.setOpacity(0.5);
                    } else {
                        aText.setFill(letterGreen);
                        aText.setOpacity(1.0);
                    }
                    if (pText.getFill() == letterGreen) {
                        pText.setFill(letterGray);
                        pText.setOpacity(0.5);
                    } else {
                        pText.setFill(letterGreen);
                        pText.setOpacity(1.0);
                    }
                    if (eText2.getFill() == letterGreen) {
                        eText2.setFill(letterGray);
                        eText2.setOpacity(0.5);
                    } else {
                        eText2.setFill(letterGreen);
                        eText2.setOpacity(1.0);
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
                    if (pText.getFill() == letterGreen) {
                        pText.setFill(letterGray);
                        pText.setOpacity(0.5);
                    } else {
                        pText.setFill(letterGreen);
                        pText.setOpacity(1.0);
                    }
                }
                if (allLettersGreen()) {
                    nextLevelButton.setVisible(true);
                    nextLevelText.setVisible(true);
                }
                nextLevelButton.setOnAction(e -> {
                    // System.out.println("level 3 button clicked");
                    Level levelTen = new Level(10, "123...");
                    getChildren().clear();
                    getChildren().add(new LevelPane(levelTen));
                });
                // System.out.println("Clicked at: (" + x + ", " + y + ")");
            });
        }
        if (levelNum == 10) {
            System.out.println("Welcome to level 10!");
            lv10Label = new Label("123..."); // user has to click ottffssent
            lv10Label.setLayoutX(360);
            lv10Label.setLayoutY(230);
            lv10Label.setTextFill(Color.BLACK);
            lv10Label.setFont(new Font("Arial", 20));
            lv10Label.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), null)));
            getChildren().add(lv10Label);
            Font buttonFont = new Font("Arial", 12);
            Button[] lv10Buttons = new Button[] {
                    lv10Button1 = new Button("  o  "),
                    lv10Button2 = new Button("  t  "),
                    lv10Button3 = new Button("  f  "),
                    lv10Button4 = new Button("  s  "),
                    lv10Button5 = new Button("  e  "),
                    lv10Button6 = new Button("  n  ")
            };
            for (int i = 0; i < lv10Buttons.length; i++) {
                lv10Buttons[i].setLayoutX(360 + i * 40);
                lv10Buttons[i].setLayoutY(280);
                lv10Buttons[i].setFont(buttonFont);
                getChildren().add(lv10Buttons[i]);
            }
            // listeners for each button
            lv10Button1.setOnAction(e -> {
                if (lv10Clicks == 0) {
                    lv10Clicks++;
                } else {
                    lv10Clicks = 0;
                }
                System.out.println(lv10Clicks);
            });
            lv10Button2.setOnAction(e -> {
                if (lv10Clicks == 1 || lv10Clicks == 2 || lv10Clicks == 9) {
                    lv10Clicks++;
                    if (lv10Clicks == 10) {
                        makeLettersGreen();
                        nextLevelButton.setVisible(true);
                        nextLevelText.setVisible(true);
                    }
                } else {
                    lv10Clicks = 0;
                }
                System.out.println(lv10Clicks);
            });
            lv10Button3.setOnAction(e -> {
                if (lv10Clicks == 3 | lv10Clicks == 4) {
                    lv10Clicks++;
                } else {
                    lv10Clicks = 0;
                }
                System.out.println(lv10Clicks);
            });
            lv10Button4.setOnAction(e -> {
                if (lv10Clicks == 5 || lv10Clicks == 6) {
                    lv10Clicks++;
                } else {
                    lv10Clicks = 0;
                }
                System.out.println(lv10Clicks);
            });
            lv10Button5.setOnAction(e -> {
                if (lv10Clicks == 7) {
                    lv10Clicks++;
                } else {
                    lv10Clicks = 0;
                }
                System.out.println(lv10Clicks);
            });
            lv10Button6.setOnAction(e -> {
                if (lv10Clicks == 8) {
                    lv10Clicks++;
                } else {
                    lv10Clicks = 0;
                }
                System.out.println(lv10Clicks);
            });
            nextLevelButton.setOnAction(e -> {
                // System.out.println("level 3 button clicked");
                Level levelEleven = new Level(11, "two buttons");
                getChildren().clear();
                getChildren().add(new LevelPane(levelEleven));
            });
        }

    }

    // method to draw the backgrorund
    public void drawBackground(int levelNum, String levelName) {
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
        int i = 0;
        for (Text text : Arrays.asList(eText, sText, cText, aText, pText, eText2)) {
            text.setFont(new Font("Arial", 60));
            text.setFill(Color.GRAY);
            text.setY(100);
            text.setX(50 + i * 40);
            i++;
        }
        getChildren().addAll(eText, sText, cText, aText, pText, eText2);

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

        // draw the level number and name in the bottom right corner
        levelLabel = new Label("Level " + levelNum + ": " + levelName);
        levelLabel.setLayoutX(450);
        levelLabel.setLayoutY(450);
        levelLabel.setTextFill(Color.WHITE);
        levelLabel.setFont(new Font("Arial", 20));
        getChildren().add(levelLabel);
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

    // make all letters green
    public void makeLettersGreen() {
        List<Text> textNodes = Arrays.asList(eText, sText, cText, aText, pText, eText2);
        textNodes.forEach(node -> node.setFill(letterGreen));

    }

    // make all letters gray
    public void makeLettersGray() {
        List<Text> textNodes = Arrays.asList(eText, sText, cText, aText, pText, eText2);
        textNodes.forEach(node -> node.setFill(letterGray));

    }
}
