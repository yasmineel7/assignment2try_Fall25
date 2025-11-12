/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    private ImageView endRace;
     
     @FXML
     private ImageView runnerMoving;
     
     //other variables
     Image[] images = new Image[2];
     Timeline animation;
     Timeline runCycleAnimation;
     int index = 0;
     double startX;
     
     @FXML
     void runnerMoving(ActionEvent event) {
         int num = 1;
        for (int i = 0; i < images.length; i++) {
            images[i] = new Image("file:images//runner" + (num + 1) + ".png"); //right code??
            runnerMoving = new ImageView(images[i]);
            KeyFrame frame1 = new KeyFrame(Duration.seconds(5), new KeyValue(runnerMoving.layoutXProperty(), 70));
           KeyFrame frame2 = new KeyFrame(Duration.seconds(2), new KeyValue(runnerMoving.layoutXProperty(), 200));
            animation = new Timeline(frame1, frame2);
           
      
        animation.play();
        }
//         if (animation != null) {
//             animation.stop();
//         }
//         if (runCycleAnimation != null) {
//             runCycleAnimation.stop();
//         }
//         
//         
//         double endX = 500.0;
//         
//         KeyValue keyValue = new KeyValue(runnerMoving.layoutXProperty(), endX);
//         KeyFrame keyframe = new KeyFrame(Duration.seconds(10), keyValue);
//         
//         animation = new Timeline(keyframe);
//         animation.setCycleCount(1);
//         
//         KeyFrame imageKeyFrame = new KeyFrame(Duration.seconds(0.1), e -> {
//             index = (index + 1) % images.length;
//             runnerMoving.setImage(images[index]);
//         });
//         
//         runCycleAnimation = new Timeline(imageKeyFrame);
//         runCycleAnimation.setCycleCount(Timeline.INDEFINITE);
//         
//         animation.setOnFinished(e -> runCycleAnimation.stop());
//         
//         animation.play();
//         runCycleAnimation.play();
//         

     }

    @FXML
    public void initialize() {
        // TODO: Initialize model and setup UI components
    }

    // TODO: Add methods to handle button actions

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            images[0] = new Image("file:images//runner1.png");
//            images[1] = new Image("file:images//runner2.png");
//            
//            if (runnerMoving != null) {
//                startX = runnerMoving.getLayoutX();
//                runnerMoving.setImage(images[0]);
//            }
//        } catch (Exception e) {
//            System.out.println("error" + e.getMessage());
//    }
    }
}    
    

