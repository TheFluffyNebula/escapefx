package edu.guilford;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**@author Jason Yin
 * @version 1.0
 * This is an imitation of the game 40x Escape. 
 * The goal of the game is to escape the room by solving the puzzle.
 */
public class Driver extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();

        //instantiate a new Level object
        //toggle this to start at a later level
        Level levelOne = new Level(1, "a button");

        //instantiate levelPane object, add it to the root node
        root.getChildren().add(new LevelPane(levelOne));
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}