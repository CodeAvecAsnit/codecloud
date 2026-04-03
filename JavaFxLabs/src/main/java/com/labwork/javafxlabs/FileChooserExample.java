package com.labwork.javafxlabs;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileChooserExample extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 15;");

        Label label = new Label("No file selected");
        Button btn = new Button("Choose a File");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );

        btn.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) label.setText("Selected file: " + selectedFile.getAbsolutePath());
            else
                label.setText("No file selected");
        });
        root.getChildren().addAll(btn, label);
        Scene scene = new Scene(root, 400, 150);
        stage.setScene(scene);
        stage.setTitle("Simple FileChooser Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
