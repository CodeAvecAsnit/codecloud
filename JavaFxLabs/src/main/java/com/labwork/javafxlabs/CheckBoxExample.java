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
        Label label = new Label("Select your Country");
        CheckBox first = new CheckBox("Nepal");
        CheckBox second = new CheckBox("India");
        CheckBox third = new CheckBox("China");
        CheckBox fourth = new CheckBox("USA");
        box.getChildren().add(label);
        box.getChildren().addAll(first,second,third,fourth);
        Scene scene = new Scene(box,400,400);
        stage.setScene(scene);
        stage.setTitle("Babin's Checkbox");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
