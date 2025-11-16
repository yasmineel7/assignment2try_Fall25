/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;

public class Runner {
    private String name;
    private double position;
    private int number;
    private double baseSpeed;
    private double currentSpeed;
    private boolean isWinner;
    private boolean isUserSelected;
    private String imagePath;
    

    public Runner(String name, int number, double basespeed, String imagePath) {
        this.name = name;
        this.number = number;
        this.baseSpeed = basespeed;
        this.position = 0;
        this.isWinner = false;
        this.currentSpeed = basespeed;
        this.imagePath = imagePath;
        
    }
    

    // TODO: Add methods (e.g., update position, reset, etc.)
    
    /**
     * to reset the speed to it's first one
     */
    public void resetSpeed() {
        this.currentSpeed = baseSpeed;
    }
    
    /**
     * to reset the race from the beginning
     */
    public void reset() {
        this.position = 0;
        this.isWinner = false;
        resetSpeed();
    }
    
    public void setWinner(boolean isWinner) {
    this.isWinner = isWinner;
    }
    
    /**
     * to update the position of the runner
     */
    public void updatePosition() {
        this.position += this.currentSpeed * (Math.random());
    }
    
    /**
     * to increase the baseSpeed 
     * @param increaseSpeed the incresement used
     */
    public void increaseSpeed(double increaseSpeed) {
        this.currentSpeed += increaseSpeed;
    }
    
    /**
     * to decrease the baseSpeed
     * @param decreaseSpeed the decreasement used
     */
    public void decreaseSpeed(double decreaseSpeed) {
        this.currentSpeed -= decreaseSpeed;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.position) ^ (Double.doubleToLongBits(this.position) >>> 32));
        hash = 71 * hash + this.number;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.baseSpeed) ^ (Double.doubleToLongBits(this.baseSpeed) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Runner other = (Runner) obj;
        if (Double.doubleToLongBits(this.position) != Double.doubleToLongBits(other.position)) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        if (Double.doubleToLongBits(this.baseSpeed) != Double.doubleToLongBits(other.baseSpeed)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
    
    
    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(double baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public boolean isIsWinner() {
        return isWinner;
    }

    public void setIsWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    
    
    
}
