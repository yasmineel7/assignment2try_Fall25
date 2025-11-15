/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.ModelRunner;
import Model.Runner;
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
    private Label distanceLabel, runnerLabel, greetingLabel;

    @FXML
    private Pane pane, startRace;
    
    @FXML
    private Line firstLine, secondLine, thirdLine, fourthLine, fifthLine;

    @FXML
    private Rectangle lineRectangle;

    @FXML
    private Button playPauseButton, pauseButton, exitButton;

    @FXML
    private Rectangle startRectangle;
    
     @FXML
    private ImageView endRace;
     
     @FXML
     private ImageView runnerMoving1, runnerMoving2, runnerMoving3, runnerMoving4, runnerMoving5, marathoners;
      
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
     private List<ImageView> imageViews;
     private ParallelTransition fullRun;
     private int index = 0;
     private MediaPlayer mediaPlayer;
     private ModelRunner raceRunner;
     private ParallelTransition[] runnerAnimation = new ParallelTransition[5];
     
    @FXML
    public void initialize() {
        // TODO: Initialize model and setup UI components
    }

    public void initializeModel() {
        this.raceRunner = new ModelRunner();
    }

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
       pause.setOnFinished(e -> slideTransition());
       pause.play();
       
       
    }
     
     @FXML
     void runnerMoving(ActionEvent event) {
         
//         runnerMoving1(firstLine);
//         runnerMoving1(secondLine);
//         runnerMoving1(thirdLine);
//         runnerMoving1(fourthLine);
//         runnerMoving1(fifthLine);
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
     public void runnerMoving1(Line line, int runnerNumber) {
         //to not see the marathoners anymore
         
         
         startRace.setVisible(false);
         marathoners.setVisible(false);
         
         Runner runner = raceRunner.getRunnerbyNumber(runnerNumber);
         ImageView imageView = imageViews.get(runnerNumber - 1);
         
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
    private void slideTransition() { // might have to change it
        
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
       
       //sound
       playSound();
       
    }
    
    public void playSound() {
        String soundFile = getClass().getResource("/sound/soundRace.mp3").toString();
        Media sound = new Media(soundFile);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
    
    private double calculateAnimationDuration(double speed) {
        return 15.0 * (2.0 / speed);
    }

    public void runnerAnimation(int runnerNumber) {
        List<Line> lines = List.of(firstLine, secondLine, thirdLine, fourthLine);
        Line line = lines.get(runnerNumber - 1);
        
        runnerMoving1(line, runnerNumber);
    }
}    
    