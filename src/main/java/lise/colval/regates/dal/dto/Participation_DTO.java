/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dto;


/**
 *
 * @author vince
 */
public class Participation_DTO {
    
    private int id;
    private int score;
    private int rank;
    private int duration;
    private int corridor;
    private int shipId;
    private int participatingDriverId;
    
    public Participation_DTO() {}

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

    public int getCorridor() {
        return corridor;
    }

    public void setCorridor(int corridor) {
        this.corridor = corridor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public int getParticipatingDriverId() {
        return participatingDriverId;
    }

    public void setParticipatingDriverId(int participatingDriverId) {
        this.participatingDriverId = participatingDriverId;
    }
   
    @Override
    public String toString() {
        return "Participation_DTO: " + id;
    }
}
