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
public class ModelRunner {
    private List<Runner> runners;
    private boolean raceStarted;
    private boolean raceFinished;
    private Runner winner;
    private double raceDistance = 500.0;
    private Runner selectedRunner;

    public ModelRunner() {
        this.runners = new ArrayList();
        this.raceStarted = false;
        this.raceFinished = false;
        this.selectedRunner = runners.get(0);
        initializeRunners();
    }
    

    public void initializeRunners() {
      
    }

    public void  updateRace() {
        if (raceStarted && !raceFinished){
            for (Runner runner : runners) {
              runner.updatePosition();
                if (runner.getPosition()>= raceDistance && winner == null) {
                  winner = runner;
                  raceFinished = true;
                  runner.setIsWinner(true);
                }
            }
        }
    }
    
    public void increaseSpeedRunner() {
        
    }
    
    public void decreaseRunnerSpeed() {
        
    }
    
    /**
     * rest the speed of the runner
     */
    public void resetAllSpeed() {
        for (Runner runner: runners) {
            runner.resetSpeed();
        }
    }
  
    public void startRace() {
      raceStarted = true;
      raceFinished = false;
      winner = null;
       
    }
  
    public void pauseRace() {
      raceStarted = false;
    }
  
    public void resetRace() {
       for (Runner runner : runners) {
            runner.setPosition(0);
            runner.setWinner(false);
            resetAllSpeed();
        }
        raceStarted = false;
        raceFinished = false;
        winner = null;
    }

    public boolean isRaceFinished() {
        return raceFinished;
    }

    public void setRaceFinished(boolean raceFinished) {
        this.raceFinished = raceFinished;
    }

    //getter and setter
    public List<Runner> getRunners() {
        return runners;
    }

    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }

    public Runner getWinner() {
        return winner;
    }

    public void setWinner(Runner winner) {
        this.winner = winner;
    }
  
    
}
