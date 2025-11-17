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
     private ParallelTransition[] runnerAnimations = new ParallelTransition[5];
     
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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       images1 = new ArrayList();
//       images1.add(new Image(getClass().getResource("/images/1.png").toExternalForm()));
//       images1.add(new Image(getClass().getResource("/images/2.png").toExternalForm()));
//       images1.add(new Image(getClass().getResource("/images/3.png").toExternalForm()));
//       images1.add(new Image(getClass().getResource("/images/4.png").toExternalForm()));
//       images1.add(new Image(getClass().getResource("/images/5.png").toExternalForm()));
//       marathoners.setImage(images1.get(0));
//       
      pause = new PauseTransition(Duration.seconds(1));
      pause.setOnFinished(e -> slideTransition());
       pause.play();
       initializeModel();
       initializeRunner();
       displayWinner();
    }
     
    /**
     * to start the race
     * @param event the event happening
     */
     @FXML
     void playRace(ActionEvent event) {
         if (seq1 != null) {
             seq1.stop();
         }
         
         if (mediaPlayer != null) {
             mediaPlayer.stop();
         }
         
         startRace.setVisible(false);
         marathoners.setVisible(false);
         
         //starting race
         raceRunner.startRace();
         runnerAnimation();
         
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
      * @param runnerNumber the number of the runner
      */
     public void runnerMoving1(Line line, int runnerNumber) {
         //to not see the marathoners anymore
         
         Runner runner = raceRunner.getRunnerbyNumber(runnerNumber);
         ImageView imageView = imageViews.get(runnerNumber - 1);
         
         imageView.setVisible(true);
         imageView.setLayoutX(line.getStartX());
         imageView.setLayoutY(line.getStartY() - 25);
         
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
        double rate = Math.max(80, runner.getCurrentSpeed());
        Timeline frameAnimation = new Timeline(
        new KeyFrame(Duration.millis(rate), e -> {
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
        raceRunner.pauseRace();
        for (ParallelTransition animation : runnerAnimations) {
            if (animation != null) {
                animation.stop();
            }
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
         for (ParallelTransition animation : runnerAnimations) {
            if (animation != null) {
                animation.stop();
               // displayWinner();
            }
         }
    }
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
       
//       seq1.setOnFinished(e -> {
//           index = (index + 1) % slideShowImages.size();
//           marathoners.setImage(slideShowImages.get(index));
//       });
       
       //sound
       playSound("soundRace.wav");
       
       seq1.play();
    }
    
    public void playSound(String fileName) {
    try {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(
            getClass().getResource("/sound/" + fileName)
        );
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    private double calculateAnimationDuration(double speed) {
        return 15.0 * (2.0 / speed);
    }

    public void runnerAnimation() {
        List<Line> lines = List.of(firstLine, secondLine, thirdLine, fourthLine, fifthLine);
        
         for (int i = 0; i < 5; i++) {
            int runnerNumber = i + 1;
            Line track = lines.get(i);
            runnerMoving1(track, runnerNumber);
        }
    }
    
    public void displayWinner() {
        Runner winner = raceRunner.getWinner();
        
        if (winner != null) {
            textArea.setText("""
                             RACE FINISHED!!\n
                             Congradulation to all the marathoners!\n
                             Winner: """ + winner.getName() + " # " + winner.getNumber()
            +  "\n PathTransiton and fadeTransition have been used for this application." +
                    "\n "); //add something maybe
        }
    }
}    
    