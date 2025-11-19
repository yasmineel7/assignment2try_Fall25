/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.ModelRunner;
import Model.Runner;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
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
    private Line firstLine, secondLine, thirdLine, fourthLine, fifthLine, sixthLine, seventhLine, eightLine, ninthLine, tenthLine;

    @FXML
    private Rectangle lineRectangle, startRectangle;

    @FXML
    private Button playPauseButton, pauseButton, exitButton, startButton;
     
     @FXML
     private ImageView runnerMoving1, runnerMoving2, runnerMoving3, runnerMoving4, runnerMoving5, marathoners, endRace;
      
      @FXML
    private TextArea textArea;
      
      
    //variables of transitions
     private SequentialTransition seq1;
     private PauseTransition pause;
     
    //other variables
     private List<ImageView> imageViews;
     private int index = 0;
     private MediaPlayer mediaPlayer;
     private ModelRunner raceRunner;
     private List<PathTransition> pathTransitions;
     PathTransition path1;
     PathTransition path2;
     PathTransition path3, path4, path5;
     

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
        //initializing
        pathTransitions = new ArrayList();
        
        pause = new PauseTransition(Duration.seconds(1));
      pause.setOnFinished(e -> slideTransition());
       pause.play();
       initializeModel();
       initializeRunner();
       runnerMoving1();
       runnerMoving2();
       runnerMoving3();
       runnerMoving4();
       runnerMoving5();
       finishLine();
      
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
         mediaPlayer.stop();
         
         if (!raceRunner.isRaceFinished()) {
             raceRunner.startRace();
         }
         
         for (ImageView image: imageViews) {
             image.setVisible(true);
         }
       
         for (PathTransition path: pathTransitions) {
             if (path.getStatus() == Animation.Status.PAUSED) {
                 path.play();
                 playPauseButton.setText("Play");
             }
             
             if (path.getStatus() == Animation.Status.STOPPED) {
                 path.playFromStart();
                 playPauseButton.setText("Play");
             }
         }

     }

     
     /**
      * the path transition for the runner 1
      */
     public void runnerMoving1() {
        path1 = new PathTransition(Duration.millis(5000), firstLine, runnerMoving1); //good
        pathTransitions.add(path1);
     }
     
     /**
      * the path transition for the runner 2
      */
     public void runnerMoving2() {
         path2 = new PathTransition(Duration.millis(8000), seventhLine, runnerMoving2); //good
         pathTransitions.add(path2);
     }
     
     /**
      * the path transition for the runner 3
      */
     public void runnerMoving3() {
         path3 = new PathTransition(Duration.millis(4500), thirdLine, runnerMoving3); //good
         pathTransitions.add(path3);
     }
     
     /**
      * the path transition for the runner 4
      */
     public void runnerMoving4() {
         path4 = new PathTransition(Duration.millis(4000), tenthLine, runnerMoving4);
         pathTransitions.add(path4);
     }
     
     /**
      * the path transition for the runner 5
      */
     public void runnerMoving5() {
         path5 = new PathTransition(Duration.millis(6000), tenthLine, runnerMoving5); 
         pathTransitions.add(path5);
     }
     
     /**
      * to pause the race
      * @param event the event happening
      */
     @FXML
    void onPause(ActionEvent event) {
        for (PathTransition path: pathTransitions) {
            path.pause();
            playPauseButton.setText("Paused");
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
     * to start the race
     * @param event the event happening
     */
     @FXML
    void start(ActionEvent event) {
        seq1.stop();
        mediaPlayer.stop();
        startRace.setVisible(false);
    }
    
    
    /**
     * Do the transition between all the marathoners of the simulation
     */
    private void slideTransition() { 
        
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
    
    /**
     * to play the sound during the slide show
     */
    public void playSound() {
        String soundFile = getClass().getResource("/sound/soundRace.wav").toExternalForm();
        Media sound = new Media(soundFile);
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void endRace(Runner runner) {
    
        raceRunner.setWinner(runner);
        raceRunner.setRaceFinished(true);

        for (PathTransition path: pathTransitions) {
            path.stop();
        }
    }
    
    /**
     * to display the text when the race is finished
     */
    public void finishLine() {
        path2.setOnFinished(e ->{
            textArea.setPrefColumnCount(15);
            textArea.setPrefRowCount(5);
            textArea.setDisable(false);
            textArea.appendText("Race Finished!!\n" +
                    "Congradulation to all Runners! \n"  +
                    "Winner: " + raceRunner.getRunnerbyNumber(3).getName() + " #" + raceRunner.getRunnerbyNumber(3).getNumber() +
                    "\n PathTransition and fadeTransition have been used for this application.");
        });
    }
}    
    