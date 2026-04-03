package com.labwork.javafxlabs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");
        Label l1 = new Label("result");
        FlowPane fp = new FlowPane();
        fp.setHgap(10);
        fp.setVgap(30);
        fp.getChildren().add(b1);
        fp.getChildren().add(b2);
        fp.getChildren().add(b3);
        fp.getChildren().add(b4);
        fp.getChildren().add(l1);
        Scene sc = new Scene(fp,400,400);
        stage.setTitle("Layout Demo");
        stage.setScene(sc);
        stage.show();
    }
}
