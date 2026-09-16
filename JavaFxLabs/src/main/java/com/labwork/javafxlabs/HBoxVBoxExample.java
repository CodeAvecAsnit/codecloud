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
        box.getChildren().addAll(new Button("Here Click"),new Button("No here"));

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(box,
                new Button("Click Me"),
                new Button("No Click Me"));
        Scene scene =new Scene(vbox, 500,400);
        stage.setTitle("HBOXVBOX babin");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
