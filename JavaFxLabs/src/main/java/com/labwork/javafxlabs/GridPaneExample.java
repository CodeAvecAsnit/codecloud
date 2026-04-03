package com.labwork.javafxlabs;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GridPaneExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Button("Grid 0,0"), 0, 0);
        grid.add(new Button("Grid 1,0"), 1, 0);
        grid.add(new Button("Grid 0,1"), 0, 1);
        grid.add(new Button("Grid 1,1"), 1, 1);
        Scene scene = new Scene(grid,500,400);
        stage.setScene(scene);
        stage.setTitle("Grid Layout");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
