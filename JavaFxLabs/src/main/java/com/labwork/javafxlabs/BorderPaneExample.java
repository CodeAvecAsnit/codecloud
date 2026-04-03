package com.labwork.javafxlabs;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;

public class BorderPaneExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane border = new BorderPane();
        border.setTop(new Button("Top"));
        border.setBottom(new Button("Bottom"));
        border.setLeft(new Button("Left"));
        border.setRight(new Button("Right"));
        border.setCenter(new Button("Center"));
        Scene scene = new Scene(border, 500, 600);
        stage.setTitle("JavaFX Layout Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
