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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
    private Rectangle lineRectangle, startRectangle;

    @FXML
    private Button playPauseButton, pauseButton, exitButton;
     
     @FXML
     private ImageView runnerMoving1, runnerMoving2, runnerMoving3, runnerMoving4, runnerMoving5, marathoners, endRace;
      
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
     private ParallelTransition[] runnerAnimations = new ParallelTransition[5];
     private List<PathTransition> pathTransitions;
     PathTransition path1;
     
    @FXML
    public void initialize() {
        // TODO: Initialize model and setup UI components
    }

    public void initializeModel() {
        this.raceRunner = new ModelRunner();
    }
    
    public void initializeRunner() {
        imageViews = new ArrayList();
        imageViews.add(runnerMoving1);
        imageViews.add(runnerMoving2);
        imageViews.add(runnerMoving3);
        imageViews.add(runnerMoving4);
        imageViews.add(runnerMoving5);
        
        //to not see the runners until the user click on play
        for (ImageView image: imageViews) {
            image.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       images1 = new ArrayList();
//       images1.add(new Image(getClass().getResource("/images/1.png").toExternalForm()));
//       images1.add(new Image(getClass().getResource("/images/2.png").toExternalForm()));
//       images1.add(new Image(getClass().getResource("/images/3.png").toExternalForm()));
//       images1.add(new Image(getClass().getResource("/images/4.png").toExternalForm()));
//       images1.add(new Image(getClass().getResource("/images/5.png").toExternalForm()));
//       marathoners.setImage(images1.get(0))
//       
        //initializing
        pathTransitions = new ArrayList();
        
        pause = new PauseTransition(Duration.seconds(1));
      pause.setOnFinished(e -> slideTransition());
       pause.play();
       initializeModel();
       initializeRunner();
       slideTransition();
      // exitButton.toFront();
      
    }
     
    /**
     * to start the race
     * @param event the event happening
     */
     @FXML
     void playRace(ActionEvent event) {
         //end slidetransition
         seq1.stop();
         startRace.setVisible(false);
         
         if (!raceRunner.isRaceFinished()) {
             raceRunner.startRace();
         }
         
         for (ImageView image: imageViews) {
             image.setVisible(true);
         }
       
         for (PathTransition path: pathTransitions) {
             path.playFromStart();
             path1.play();
         }

     }
     
     /**
      * method that make the marathoners move
      * @param line the path that the runner should follow
      * @param runnerNumber the number of the runner
      */
     public void runnerMoving1() {
          path1 = new PathTransition(Duration.millis(4500), firstLine, runnerMoving1);
          path1.play();
      List<ImageView> views = List.of(runnerMoving1, runnerMoving2, runnerMoving3, runnerMoving4, runnerMoving5);
      List<Line> paths = List.of(firstLine, secondLine, thirdLine, fourthLine, fifthLine);
      
      for (int i = 0; i < views.size(); i++) {
          PathTransition path = new PathTransition();
          path.setPath(paths.get(i));
          path.setNode(views.get(i));
            
      Runner r = raceRunner.getRunners().get(i);
      
      double baseDuration = 10000;
     double timeRace = baseDuration / r.getBaseSpeed();
      
      path.setDuration(Duration.millis(timeRace));
      path.setCycleCount(1);
      path.setAutoReverse(false);
      
     int y = i;
      
      path.setOnFinished(e -> {
          Runner runner = raceRunner.getRunners().get(y);
          endRace(runner);
      });
      
      pathTransitions.add(path);
      }
     }
     
     @FXML
    void onPause(ActionEvent event) {
        for (PathTransition path: pathTransitions) {
            path.pause();
            path1.pause();
        }
    }

    /**
     * to exit the application 
     * @param event the event happening
     */
      @FXML
    void exitApplication(ActionEvent event) {
        if (mediaPlayer != null) {
        mediaPlayer.stop();
        }
         for (PathTransition path : pathTransitions) {
            path.stop();
         }
         
         Stage stage = (Stage) exitButton.getScene().getWindow();
         stage.close();
    
    }
    
    
    /**
     * Do the transition between all the marathoners of the simulation
     */
    private void slideTransition() { // might have to change it
        
        List<Image> slideShowImages = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            slideShowImages.add(new Image(getClass().getResource("/images/" + i + ".png").toExternalForm()));
        }
        
        FadeTransition ftrans;
        FadeTransition ftIn;
        
        ftrans = new FadeTransition(new Duration(2000), marathoners);
        ftrans.setFromValue(1.0);
        ftrans.setToValue(0.0);
       ftrans.setOnFinished(e -> {
       index = (index + 1) % slideShowImages.size();
        marathoners.setImage(slideShowImages.get(index));
       });
         
        ftIn = new FadeTransition(new Duration(2000), marathoners);
        ftIn.setFromValue(0.0);
       ftIn.setToValue(1.0);
       
       pause = new PauseTransition(Duration.seconds(2));
       
       seq1 = new SequentialTransition(ftrans, pause, ftIn);
       seq1.setCycleCount(Animation.INDEFINITE);
       
       //sound
       playSound();
       
       seq1.play();
    }
    
    public void playSound() {
        String soundFile = getClass().getResource("/sound/soundRace.wav").toExternalForm();
        Media sound = new Media(soundFile);
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
    
    private double calculateAnimationDuration(double speed) {
        return 15.0 * (2.0 / speed);
    }

    public void endRace(Runner runner) {
    
        raceRunner.setWinner(runner);
        raceRunner.setRaceFinished(true);
        
        displayWinner(runner);
        
        for (PathTransition path: pathTransitions) {
            path.stop();
        }
    }
    
    public void displayWinner(Runner winner) {
         winner = raceRunner.getWinner();
        
        if (winner != null) {
            textArea.setPrefRowCount(5);
            textArea.setPrefColumnCount(15);
                    textArea.setText("""
                             RACE FINISHED!!\n
                             Congradulation to all the marathoners!\n
                             Winner:  """ + winner.getName() + " # " + winner.getNumber()
            +  "\n PathTransiton and fadeTransition have been used for this application." +
                    "\n "); //add something maybe
        }
    }
}    
    