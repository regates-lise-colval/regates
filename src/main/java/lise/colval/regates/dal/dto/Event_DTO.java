/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dto;

import java.util.ArrayList;
import java.util.List;
import lise.colval.regates.bll.model.competition.Race;

/**
 *
 * @author Vincent Laude
 */
public class Event_DTO {
    
    private int id;
    private String city;
    private String category;
    private String date;
    private String img;
    
    private List<Integer> racesId;
    private int contestId;
    
    public Event_DTO() {
        this.racesId = new ArrayList<>();
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

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = 1;
    }

    public List<Integer> getRacesId() {
        return racesId;
    }

    public void setRacesId(List<Race> races) {
        for(Race race : races) {
            this.racesId.add(race.getId());
        }
    }
    
    @Override
    public String toString() {
        return "EventDTO: " + id + " " + city + " " + category + " " + date; 
    }
}
