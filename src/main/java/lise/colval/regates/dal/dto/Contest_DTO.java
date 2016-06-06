/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vincent Laude
 */
public class Contest_DTO {
    
    private int id;
    private int year;
    private String category;
    private String title;
    private String img;
    
    private List<Integer> eventsIds;
    
    public Contest_DTO() {
        this.eventsIds = new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Integer> getEventsIds() {
        return eventsIds;
    }

    public void setEventsIds(List<Integer> eventsIds) {
        this.eventsIds = eventsIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public void addEventId(int id) {
        this.eventsIds.add(id);
    }
    
    @Override
    public String toString() {
        return "Contest_DTO: " + id;
    }
    
}
