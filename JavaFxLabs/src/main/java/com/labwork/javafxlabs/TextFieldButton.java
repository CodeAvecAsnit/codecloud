package com.labwork.javafxlabs;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextFieldButton extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox box = new HBox(10);

        box.getChildren().addAll(new Label("Enter the text here : "),new TextField());
        Scene scene = new Scene(box, 500,300);
        stage.setTitle("Text Field Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}