/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 6298686
 */
    public class MarathonController implements Initializable {

  @FXML
    private Label distanceLabel;

    @FXML
    private Pane firstLine;

    @FXML
    private Line fourthLine;

    @FXML
    private Rectangle lineRectangle;

    @FXML
    private Button playPauseButton;

    @FXML
    private Button resetButton;

    @FXML
    private Label runnerLabel;

    @FXML
    private Line secondLine;

    @FXML
    private Rectangle startRectangle;

    @FXML
    private Line thirdLine;

    @FXML
    public void initialize() {
        // TODO: Initialize model and setup UI components
    }

    // TODO: Add methods to handle button actions

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}    
    

