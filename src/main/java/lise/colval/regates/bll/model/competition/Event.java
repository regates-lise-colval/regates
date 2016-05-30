/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.model.competition;

import java.util.ArrayList;
import java.util.List;


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
    private Contest contest;
    
    public Event() {}
    
    public Event(int id, String city, String category, String date, String img) {
        this.id = id;
        this.city = city;
        this.category = category;
        this.date = date;
        this.img = img;
    }
    
    public Event(int id, String city, String category, String date, String img, Contest contest) {
        this.id = id;
        this.city = city;
        this.category = category;
        this.date = date;
        this.img = img;
        this.contest = contest;
        this.races = new ArrayList<>();
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

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public List<Race> getRaces() {
        return races;
    }
    
    public void addRace(Race race) {
        this.races.add(race);
    }
    
    @Override
    public String toString() {
        return "Event: " + city + " " + category + " " + date;
    }
}
