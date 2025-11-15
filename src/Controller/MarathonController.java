/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.ModelRunner;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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
    private Pane pane;
    
    @FXML
    private Line firstLine;

    @FXML
    private Line fourthLine;

    @FXML
    private Rectangle lineRectangle;

    @FXML
    private Button playPauseButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Label runnerLabel;

    @FXML
    private Line secondLine;

    @FXML
    private Rectangle startRectangle;

    @FXML
    private Line thirdLine;
    
      @FXML
    private Line fifthLine;
    
     @FXML
    private ImageView endRace;
     
     @FXML
     private ImageView runnerMoving1;

    @FXML
    private ImageView runnerMoving2;

    @FXML
    private ImageView runnerMoving3;

    @FXML
    private ImageView runnerMoving4;

    @FXML
    private ImageView runnerMoving5;
    
     @FXML
     private Button exitButton;
     
     @FXML
    private ImageView marathoners;
     
      @FXML
    private Pane startRace;
      
      @FXML
    private Label greetingLabel;
      
      @FXML
    private TextArea textArea;
     
     //other variables
     private Image[] images = new Image[3];
     
     //variables of transitions
     private PathTransition path;
     private SequentialTransition seq;
     private SequentialTransition seq1;
     private PauseTransition pause;
     
     //
     private Label lblImage = new Label();
     private List<Image> images1;
     private ParallelTransition fullRun;
     private int index = 0;
     private MediaPlayer mediaPlayer;
     private ModelRunner raceRunner;
     
     
     
     @FXML
     void runnerMoving(ActionEvent event) {
         
         runnerMoving1(firstLine);
         runnerMoving1(secondLine);
         runnerMoving1(thirdLine);
         runnerMoving1(fourthLine);
         runnerMoving1(fifthLine);
         //to not see the marathoners anymore
         //startRace.setVisible(false);
//         
//        // Load running frames
//        List<Image> runnerFrames = new ArrayList<>();
//        for (int i = 1; i <= 3; i++) {
//        runnerFrames.add(new Image(getClass().getResource("/images/runner" + i + ".png").toExternalForm()));
//           }
//
//        // Create an ImageView for the runner
//        runnerMoving1 = new ImageView(runnerFrames.get(0));
//        runnerMoving1.setFitWidth(50);
//        runnerMoving1.setFitHeight(50);
//        pane.getChildren().add(runnerMoving1);
//
//        // Create path movement
//        PathTransition moveRunner = new PathTransition();
//        moveRunner.setNode(runnerMoving1);
//        moveRunner.setPath(firstLine); 
//        moveRunner.setDuration(Duration.seconds(10));
//        moveRunner.setCycleCount(1);
//
//        // Create animation for changing images
//        final int[] index = {0};
//        Timeline frameAnimation = new Timeline(
//        new KeyFrame(Duration.millis(120), e -> {
//        index[0] = (index[0] + 1) % runnerFrames.size();
//        runnerMoving1.setImage(runnerFrames.get(index[0]));
//        })
//        );
//        frameAnimation.setCycleCount(Animation.INDEFINITE);
//
//        // Combine both animations
//        fullRun = new ParallelTransition(moveRunner, frameAnimation);
//        fullRun.play();


     }
     
     /**
      * method that make the marathoners move
      * @param line the path that the runner should follow
      */
     public void runnerMoving1(Line line) {
         //to not see the marathoners anymore
         startRace.setVisible(false);
         marathoners.setVisible(false);
         
        // Load running frames
        List<Image> runnerFrames = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
        runnerFrames.add(new Image(getClass().getResource("/images/runner" + i + ".png").toExternalForm()));
           }

        // Create an ImageView for the runner
        runnerMoving1 = new ImageView(runnerFrames.get(0));
        runnerMoving1.setFitWidth(50);
        runnerMoving1.setFitHeight(50);
        pane.getChildren().add(runnerMoving1);

        // Create path movement
        PathTransition moveRunner = new PathTransition();
        moveRunner.setNode(runnerMoving1);
        moveRunner.setPath(line); 
        moveRunner.setDuration(Duration.seconds(10));
        moveRunner.setCycleCount(1);

        // Create animation for changing images
        final int[] index1 = {0};
        Timeline frameAnimation = new Timeline(
        new KeyFrame(Duration.millis(120), e -> {
        index1[0] = (index1[0] + 1) % runnerFrames.size();
        runnerMoving1.setImage(runnerFrames.get(index1[0]));
        })
        );
        frameAnimation.setCycleCount(Animation.INDEFINITE);

        // Combine both animations
        fullRun = new ParallelTransition(moveRunner, frameAnimation);
        fullRun.play();

     }
     
     /**
      * to stop the runners after they started the race
      * @param event the event happening
      */
       @FXML
    void runnerStop(ActionEvent event) {
        fullRun.stop();
    }
    
    /**
     * Do the transition between all the marathoners of the simulation
     */
    private void marathonersTransition() {
//        String sound1 = getClass().getResource("/sound/soundRace.mp3").toExternalForm();
//        Media media = new Media(sound1);
//        mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setAutoPlay(true);

        String soundFile = getClass().getResource("/sound/soundRace.mp3").toExternalForm();
        Media sound = new Media(soundFile);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        FadeTransition ftrans;
        FadeTransition ftIn;
        
        ftrans = new FadeTransition(new Duration(2000), marathoners);
        ftrans.setFromValue(1.0);
        ftrans.setToValue(0.0);
        ftrans.setOnFinished(e -> {
        index = (index + 1) % images1.size();
        marathoners.setImage(images1.get(index));
        });
         
        ftIn = new FadeTransition(new Duration(2000), marathoners);
        ftIn.setFromValue(0.0);
       ftIn.setToValue(1.0);
       
       seq1 = new SequentialTransition(ftrans, ftIn);
       seq1.setCycleCount(Animation.INDEFINITE);
       seq1.play();
       
    }

    @FXML
    public void initialize() {
        // TODO: Initialize model and setup UI components
    }

    // TODO: Add methods to handle button actions

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       images1 = new ArrayList();
       images1.add(new Image(getClass().getResource("/images/1.png").toExternalForm()));
       images1.add(new Image(getClass().getResource("/images/2.png").toExternalForm()));
       images1.add(new Image(getClass().getResource("/images/3.png").toExternalForm()));
       images1.add(new Image(getClass().getResource("/images/4.png").toExternalForm()));
       images1.add(new Image(getClass().getResource("/images/5.png").toExternalForm()));
       marathoners.setImage(images1.get(0));
       
       pause = new PauseTransition(Duration.seconds(1));
       pause.setOnFinished(e -> marathonersTransition());
       pause.play();
       
       
    }
}    
    

