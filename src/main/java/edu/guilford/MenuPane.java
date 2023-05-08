package edu.guilford;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MenuPane extends Pane{
    /*  components required:
    title label, startFromBeginning button, startFromLevel button, exit button (later)
    inputLevel text field, level list to help startFromLevel
    */
    //attributes
    private Label titleLabel;
    private ArrayList<Level> levelList;

    //constructor
    public MenuPane() {
        //initialize attributes
        levelList.add(new Level(1, "a button"));
        levelList.add(new Level(2, "no button"));
        levelList.add(new Level(3, "knock knock"));
        levelList.add(new Level(4, "Peace"));
        levelList.add(new Level(5, "thisxthis"));
        levelList.add(new Level(6, "wrod"));
        levelList.add(new Level(7, "don't move"));
        levelList.add(new Level(8, "wrod 2"));
        levelList.add(new Level(9, "no button 2"));
        levelList.add(new Level(10, "123..."));
        titleLabel = new Label("EscapeFX");
        new Label("New Game");
        new Button("    ");
        new Label("Start from level");
        new Button("    ");
        new TextField();
        new Button("Exit");
        //set up the locations
        titleLabel.setLayoutX(320);
        titleLabel.setLayoutY(240);

    }
}
