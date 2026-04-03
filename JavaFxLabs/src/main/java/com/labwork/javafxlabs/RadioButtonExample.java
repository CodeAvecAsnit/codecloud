package com.labwork.javafxlabs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class RadioButtonExample extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        HBox box = new HBox(10);

        Label label = new Label("Select you gender : ");
        RadioButton maleButton = new RadioButton("Male");
        RadioButton femaleButton = new RadioButton("Female");

        ToggleGroup group = new ToggleGroup();
        maleButton.setToggleGroup(group);
        femaleButton.setToggleGroup(group);

        group.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle != null) {
                RadioButton selected = (RadioButton) newToggle;
                label.setText("Selected: " + selected.getText());
            }
        });

        box.getChildren().addAll(label, maleButton,femaleButton);

        Scene scene = new Scene(box, 500,300);
        stage.setTitle("Text Field Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
