package com.labwork.javafxlabs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabelExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox(10);
        Label label = new Label("Hello Welcome to JavaFx");
        box.getChildren().add(label);
        Scene scene = new Scene(box,400,400);
        stage.setScene(scene);
        stage.setTitle("Label Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
