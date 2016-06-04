/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.model.competition;

import java.util.ArrayList;
import java.util.List;
import lise.colval.regates.bll.model.participant.Driver;
import lise.colval.regates.bll.model.participant.Ship;

/**
 *
 * @author Vincent Laude
 */
public class Participation {
    
    private int id;
    private int score;
    private int rank;
    private int duration;
    private int corridor;
    private Ship ship;
    private Driver participatingDriver;
    
    public Participation() {}
    
    public Participation(int id, int corridor, Ship ship) {
        this.id = id;
        this.corridor = corridor;
        this.ship = ship;
    }
     
    public Participation(int id, int corridor, Ship ship, Driver driver) {
        this.id = id;
        this.corridor = corridor;
        this.ship = ship;
        this.participatingDriver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCorridor() {
        return corridor;
    }

    public void setCorridor(int corridor) {
        this.corridor = corridor;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Driver getParticipatingDriver() {
        return participatingDriver;
    }

    public void setParticipatingDriver(Driver participatingDriver) {
        this.participatingDriver = participatingDriver;
    }
    
    @Override
    public String toString() {
        return "Participation: " + id + " " + ship + " " + participatingDriver + " " + score + " " + rank;
    }
}
