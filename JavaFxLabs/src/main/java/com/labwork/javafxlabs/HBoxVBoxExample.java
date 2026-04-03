package com.labwork.javafxlabs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HBoxVBoxExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox box = new HBox(10);
        box.getChildren().addAll(new Button("hello"),new Button("Ola"));

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(box,
                new Button("Vhello"),
                new Button("VOla"));
        Scene scene =new Scene(vbox, 500,400);
        stage.setTitle("HBOX and VBOX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
