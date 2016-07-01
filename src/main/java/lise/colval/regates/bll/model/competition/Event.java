/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.model.competition;

import java.util.ArrayList;
import java.util.List;
import lise.colval.regates.bll.model.scoring.EventScore;
import lise.colval.regates.dal.dto.Contest_DTO;


/**
 *
 * @author Vincent Laude
 */
public class Event {
    
    private int id;
    private String city;
    private String category;
    private String date;
    private String img;
    
    private List<Race> races;
    private Contest_DTO contestDTO;
    
    private List<EventScore> scores;
    
    public Event() {}
    
    public Event(int id, String city, String category, String date, String img) {
        this.id = id;
        this.city = city;
        this.category = category;
        this.date = date;
        this.img = img;
    }
    
    public Event(int id, String city, String category, String date, String img, Contest_DTO contestDTO) {
        this.id = id;
        this.city = city;
        this.category = category;
        this.date = date;
        this.img = img;
        this.contestDTO = contestDTO;
        this.races = new ArrayList<>();
        this.scores = new ArrayList<>();
    }

    public Event(int id, String city, String category, String date, String img, Contest_DTO contestDTO, List<EventScore> scores) {
        this.id = id;
        this.city = city;
        this.category = category;
        this.date = date;
        this.img = img;
        this.contestDTO = contestDTO;
        this.races = new ArrayList<>();
        this.scores = new ArrayList<>(scores);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Contest_DTO getContestDTO() {
        return contestDTO;
    }

    public void setContestDTO(Contest_DTO contestDTO) {
        this.contestDTO = contestDTO;
    }

    public List<Race> getRaces() {
        return races;
    }
    
    public void addRace(Race race) {
        this.races.add(race);
    }

    public List<EventScore> getScores() {
        return scores;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public void setScores(List<EventScore> scores) {
        this.scores = scores;
    }
    
    @Override
    public String toString() {
        return "Event: " + city + " " + category + " " + date;
    }
}
