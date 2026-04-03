package com.labwork.javafxlabs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LayoutDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.getChildren().addAll(
                new Button("Flow 1"),
                new Button("Flow 2"),
                new Button("Flow 3")
        );

        // --- HBox ---
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(new Button("HBox 1"), new Button("HBox 2"));

        // --- VBox ---
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(new Button("VBox 1"), new Button("VBox 2"));

        // --- GridPane ---
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Button("Grid 0,0"), 0, 0);
        grid.add(new Button("Grid 1,0"), 1, 0);
        grid.add(new Button("Grid 0,1"), 0, 1);
        grid.add(new Button("Grid 1,1"), 1, 1);

        // --- BorderPane ---
        BorderPane border = new BorderPane();
        border.setTop(new Button("Top"));
        border.setBottom(new Button("Bottom"));
        border.setLeft(new Button("Left"));
        border.setRight(new Button("Right"));
        border.setCenter(new Button("Center"));

        VBox root = new VBox(20);
        root.getChildren().addAll(
                flowPane,
                hbox,
                vbox,
                grid,
                border
        );

        Scene scene = new Scene(root, 500, 600);
        primaryStage.setTitle("JavaFX Layout Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}