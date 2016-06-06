/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.model.scoring;

import lise.colval.regates.bll.model.participant.Ship;

/**
 *
 * @author vince
 */
public class EventScore {
    
    private int id;
    private int totalScore;
    private int rank;
    private Ship ship;
    
    public EventScore() {}
    
    public EventScore(int id, int totalScore, int rank, Ship Ship) {
        this.id = id;
        this.totalScore = totalScore;
        this.rank = rank;
        this.ship = ship;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    public void addPoints(int points) {
        this.totalScore += points;
    }
    
    @Override
    public String toString() {
        return "EventScore: " + this.ship.getTag() + " " + rank + " " + totalScore;
    }
}
