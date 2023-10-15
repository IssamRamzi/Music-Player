package com.ramzi.Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MusicPlayer extends Application {
    private int WINDOW_WIDTH = 1600;
    private int WINDOW_HEIGHT = 900;
    private double ButtonWidth = 80;
    private double ButtonHeight = 30;

    private Group root;
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        root = new Group();
        scene = new Scene(root);
        stage.setTitle("Music Player");
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);
        stage.setResizable(false);

        Music music = new Music( "only-you-slowed.wav");

        Button playButton = createButton("Play", 500, 400);
        playButton.setOnAction(event -> music.play());
        root.getChildren().add(playButton);

        Button pauseButton = createButton("Pause", 550, 400);
        pauseButton.setOnAction(event -> music.pause());
        root.getChildren().add(pauseButton);

        Button resumeButton = createButton("Resume", 600, 400);
        resumeButton.setOnAction(event -> music.resume());
        root.getChildren().add(resumeButton);

        stage.setScene(scene);
        stage.show();
    }
    private Button createButton(String text, double pos_x, double pos_y) {
        Button button = new Button(text);
        button.setTranslateX(pos_x);
        button.setTranslateY(pos_y);
        return button;
    }
}
