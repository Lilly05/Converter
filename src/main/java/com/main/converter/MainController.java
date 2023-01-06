package com.main.converter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ComboBox<String> originalNumberSystem;

    @FXML
    private ComboBox<String> otherNumberSystem;

    @FXML
    private Button button;

    @FXML
    private Label result;

    @FXML
    private TextField input;

    @FXML
    private AnchorPane background;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] numberSystems = {"Decimal", "Dual", "Hexadecimal", "Octal"};
        originalNumberSystem.getItems().addAll(numberSystems);
        otherNumberSystem.getItems().addAll(numberSystems);
        originalNumberSystem.setStyle("-fx-background-color: #AEBDCA");
        otherNumberSystem.setStyle("-fx-background-color: #AEBDCA");
        background.setStyle("-fx-background-color: #F5EFE6");
        button.setStyle("-fx-background-color: #AEBDCA");
        input.setStyle("-fx-background-color: #E8DFCA");
    }

    @FXML
    public void convertNumber(){
        try {
            int number = Integer.parseInt(input.getText());
            result.setText(Integer.toString(number));
        } catch (Exception e){
            result.setText("That's not a valid number");
        }
    }
}