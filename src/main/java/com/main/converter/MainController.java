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
            int numberToDecimal = 0;
            String original = originalNumberSystem.getValue();
            String second = otherNumberSystem.getValue();
            switch (original){
                case "Dual": {
                    numberToDecimal = Integer.parseInt(String.valueOf(number), 2); break;
                }
                case "Hexadecimal": {
                    numberToDecimal = Integer.parseInt(String.valueOf(number), 16); break;
                }
                case "Octal": {
                    numberToDecimal = Integer.parseInt(String.valueOf(number), 8); break;
                }
                default: {
                    numberToDecimal = number; break;
                }
            }

            switch (second){
                case "Dual": {
                    result.setText(Integer.toBinaryString(numberToDecimal)); break;
                }
                case "Hexadecimal": {
                    result.setText(Integer.toHexString(numberToDecimal)); break;
                }
                case "Octal": {
                    result.setText(Integer.toOctalString(numberToDecimal)); break;
                }
                default: {
                    result.setText(String.valueOf(numberToDecimal)); break;
                }
            }
        } catch (Exception e){
            result.setText("That's not a valid number");
        }
    }

    @FXML
    public void convertNumberCalculation(){
        try {
            String convertedNumber = "";
            String original = originalNumberSystem.getValue();
            String second = otherNumberSystem.getValue();
            switch (original){
                case "Dual": {
                    int number = Integer.parseInt(input.getText());
                    int savedNumber = 0;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(number);
                    String reversedNumber = String.valueOf(stringBuilder.reverse());
                    for (int i = 0; i < reversedNumber.length(); i++){
                        char c = reversedNumber.charAt(i);
                        int eachNumber = Character.getNumericValue(c);
                        savedNumber += eachNumber * Math.pow(2, i);
                    }
                    convertedNumber = String.valueOf(savedNumber);
                    break;
                }
                case "Hexadecimal": {
                    String number = input.getText().toUpperCase();
                    int savedNumber = 0;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(number);
                    String reversedNumber = String.valueOf(stringBuilder.reverse());
                    for (int i = 0; i < reversedNumber.length(); i++) {
                        char c = reversedNumber.charAt(i);
                        switch (c){
                            case 'A': {
                                savedNumber += 10 * Math.pow(16, i);
                                break;
                            }
                            case 'B': {
                                savedNumber += 11 * Math.pow(16, i);
                                break;
                            }
                            case 'C': {
                                savedNumber += 12 * Math.pow(16, i);
                                break;
                            }
                            case 'D': {
                                savedNumber += 13 * Math.pow(16, i);
                                break;
                            }
                            case 'E': {
                                savedNumber += 14 * Math.pow(16, i);
                                break;
                            }
                            case 'F': {
                                savedNumber += 15 * Math.pow(16, i);
                                break;
                            }
                            default: {
                                savedNumber += Character.getNumericValue(c) * Math.pow(16, i);
                            }
                        }
                    }
                    convertedNumber = String.valueOf(savedNumber);
                    break;
                }
                case "Octal": {
                    int number = Integer.parseInt(input.getText());
                    int savedNumber = 0;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(number);
                    String reversedNumber = String.valueOf(stringBuilder.reverse());
                    for (int i = 0; i < reversedNumber.length(); i++){
                        char c = reversedNumber.charAt(i);
                        int eachNumber = Character.getNumericValue(c);
                        savedNumber += eachNumber * Math.pow(8, i);
                    }
                    convertedNumber = String.valueOf(savedNumber);
                    break;
                }
                default: {
                    int number = Integer.parseInt(input.getText());
                    convertedNumber = String.valueOf(number);
                }
            }

            switch (second){
                case "Dual": {
                    int reminder = Integer.parseInt(convertedNumber);
                    convertedNumber = "";
                    while(reminder != 0){
                        if (reminder % 2 == 0){
                            convertedNumber += "0";
                        }else{
                            convertedNumber += "1";
                        }
                        reminder = reminder / 2;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(convertedNumber);
                    result.setText(String.valueOf(stringBuilder.reverse()));
                    break;
                }
                case "Hexadecimal": {
                    int reminder = Integer.parseInt(convertedNumber);
                    convertedNumber = "";
                    while(reminder != 0){
                            System.out.println(reminder);
                            int reminderOfModulo = reminder % 16;
                            switch (reminderOfModulo){
                                case 10: {
                                    convertedNumber += "A"; break;
                                }
                                case 11: {
                                    convertedNumber += "B"; break;
                                }
                                case 12: {
                                    convertedNumber += "C"; break;
                                }
                                case 13: {
                                    convertedNumber += "D"; break;
                                }
                                case 14: {
                                    convertedNumber += "E"; break;
                                }
                                case 15: {
                                    convertedNumber += "F"; break;
                                }
                                default:{
                                    convertedNumber += reminderOfModulo;
                                }
                            }
                        reminder = reminder / 16;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(convertedNumber);
                    result.setText(String.valueOf(stringBuilder.reverse()));
                    break;
                }
                case "Octal": {
                    int reminder = Integer.parseInt(convertedNumber);
                    convertedNumber = "";
                    while(reminder != 0){
                        convertedNumber += reminder % 8;
                        reminder = reminder / 8;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(convertedNumber);
                    result.setText(String.valueOf(stringBuilder.reverse()));
                    break;
                }
                default: {
                    result.setText(convertedNumber);
                }
            }
        } catch (Exception e){
            result.setText("That's not a valid number");
        }
    }
}
