/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

public class Runner {
    private String name;
    private double distance;
    private int number;
    private double speed;
    private boolean isWinner;
    private boolean isUserSelected;
    private Runner marathoner1;
    private Runner marathoner2;
    private Runner marathoner3;
    private Runner marathoner4;
    private Runner marathoner5; 

    public Runner(String name, double distance, int number, double speed) {
        this.name = name;
        this.distance = distance;
        this.number = number;
        this.speed = speed;
        
    }
    
    public void initilaizeMarathoners() {
        marathoner1 = new Runner("Sam Smith", 100.0, 10, 5.0);
        marathoner2 = new Runner("Luc Tremblay", 100.0, 1, 5.0);
        marathoner3 = new Runner("Lucie C.", 100.0, 3, 5.0);
        marathoner4 = new Runner("Max G.", 100.0, 7, 5.0);
        marathoner5 = new Runner("Marc F.", 100.0, 5, 5.0);
    }

    // TODO: Add methods (e.g., update distance, reset, etc.)
    
    public void reset() {
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        hash = 71 * hash + this.number;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.speed) ^ (Double.doubleToLongBits(this.speed) >>> 32));
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
        if (Double.doubleToLongBits(this.distance) != Double.doubleToLongBits(other.distance)) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        if (Double.doubleToLongBits(this.speed) != Double.doubleToLongBits(other.speed)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
}
