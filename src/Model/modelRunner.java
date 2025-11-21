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
    private List<Runner> runners = new ArrayList();
    private boolean raceStarted;
    private boolean raceFinished;
    private Runner winner;
    private double raceDistance = 500.0;
    private Runner selectedRunner;

    public ModelRunner() {
        this.runners = new ArrayList();
        this.raceStarted = false;
        this.raceFinished = false;
        initializeRunners();
        
        if (runners.isEmpty()) {
    throw new IllegalStateException("No runners available");
        }
        this.selectedRunner = runners.get(0);
        
    }
    
    public void initializeRunners() {
      runners.add(new Runner("John", 1, 3.5, "/images/1.png"));
      runners.add(new Runner("Alex", 2, 3, "/images/2.png"));
      runners.add(new Runner("Mia", 3, 3.2, "/images/3.png"));
      runners.add(new Runner("Adam", 4, 3.1, "/images/4.png"));
      runners.add(new Runner("Bob", 5, 3.3, "/images/5.png"));
    }

    //no need of this method anymore
//    public void  updateRace() {
//        if (raceStarted && !raceFinished){
//            for (Runner runner : runners) {
//              runner.updatePosition();
//                if (runner.getPosition()>= raceDistance && winner == null) {
//                  winner = runner;
//                  raceFinished = true;
//                  runner.setIsWinner(true);
//                }
//            }
//        }
//    }
    
    public void resumeRace() {
          if (!raceFinished) {
            raceStarted = true;
        }
    }
    
    /**
     * to get the number of the runner
     * @param number the number of the runner
     * @return 
     */
    public Runner getRunnerbyNumber(int number) {
        return (Runner) runners.stream().filter(r -> r.getNumber() == number).findFirst().orElse(null);
    }
    
    /**
     * rest the speed of the runner
     */
    public void resetAllSpeed() {
        for (Runner runner: runners) {
            runner.resetSpeed();
        }
    }
  /**
   * to start the race
   */
    public void startRace() {
      raceStarted = true;
      raceFinished = false;
      winner = null;
       
    }
  
    /**
     * to pause the race
     */
    public void pauseRace() {
      raceStarted = false;
    }
  
    /**
     * to reset the race
     */
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

    /**
     * to know if the race finished
     * @return true if the race finished
     */
    public boolean isRaceFinished() {
        return raceFinished;
    }

    /**
     * to set if the race is finished
     * @param raceFinished true if the race is finished false if not
     */
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
