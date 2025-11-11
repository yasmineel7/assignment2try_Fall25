/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author 6298686
 */
public class StartMarathonController implements Initializable {
    
    //the FXML variables 
     @FXML
    private Label marathonerChosenLabel;

    @FXML
    private ImageView marathoners;
    
        @FXML
    private MediaView soundRace;


    @FXML
    private Label meassageLabel;

    @FXML
    private Button startButton;
    
    //other variables
    int index = 0;
    private Image[] images = new Image[5];
    private Label lblImage;
    private FadeTransition ftrans;
    
    public void imageTransition() {
        for (int i = 0; i < images.length; i++) {
            images[i] = new Image("file:images//" + i + ".jpeg");
        }
        
        lblImage.setGraphic(new ImageView(images[0]));
        
        ftrans = new FadeTransition(new Duration (2000));
        ftrans.setOnFinished(e -> {
            index = (index + 1) % 5;
            lblImage.setGraphic(new ImageView(images[index]));
        });
        
        ftrans.setFromValue(1.0);
        ftrans.setToValue(0.25);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       imageTransition();
    }

}


    

