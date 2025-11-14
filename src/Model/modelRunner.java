/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yasmi
 */
public class modelRunner {
    private final List<Runner> runners;
    private boolean raceStarted;
    private boolean raceFinished;
    private Runner winner;

    public modelRunner(List<Runner> runners) {
        this.runners = runners;
        this.raceStarted = false;
        this.raceFinished = false;
    }
    

  public void initializeRunner() {
      
  }

  public void  updateRace() {
      if (raceStarted && !raceFinished){
          for (Runner runner : runners) {
              runner.updatePosition();
              if (runner.getCurrentPosition>= 400 && winner == null) {
                  winner = runner;
                  raceFinished = true;
                  runner.setIsWinner(true);
              }
          }
      }
  }
  
  public void startRace() {
      raceStarted = true;
      raceFinished = false;
      winner = null;
       
  }
  
  public void pauseRace() {
      
  }

    public boolean isRaceFinished() {
        return raceFinished;
    }

    public void setRaceFinished(boolean raceFinished) {
        this.raceFinished = raceFinished;
    }
  
    
}
