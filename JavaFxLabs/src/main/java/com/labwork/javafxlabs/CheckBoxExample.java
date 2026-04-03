package com.labwork.javafxlabs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox(10);
        Label label = new Label("Select your hobbies");
        CheckBox first = new CheckBox("Sports");
        CheckBox second = new CheckBox("Music");
        CheckBox third = new CheckBox("Coding");
        CheckBox fourth = new CheckBox("Designing");
        box.getChildren().add(label);
        box.getChildren().addAll(first,second,third,fourth);
        Scene scene = new Scene(box,400,400);
        stage.setScene(scene);
        stage.setTitle("Label Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
