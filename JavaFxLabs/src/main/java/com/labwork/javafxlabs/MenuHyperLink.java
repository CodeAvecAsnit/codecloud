package com.labwork.javafxlabs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MenuHyperLink extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 10;");

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> stage.close());
        fileMenu.getItems().add(exitItem);
        menuBar.getMenus().add(fileMenu);

        Hyperlink link = new Hyperlink("Visit Website!");
        link.setOnAction(e -> System.out.println("Hyperlink clicked!"));

        Button btn = new Button("Click me");
        Tooltip tooltip = new Tooltip("Click the button to see what happens");
        btn.setTooltip(tooltip);

        root.getChildren().addAll(menuBar, link, btn);

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Menu + Hyperlink + Tooltip Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}