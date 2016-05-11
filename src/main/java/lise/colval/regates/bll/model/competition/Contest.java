/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.model.competition;

import java.util.List;

/**
 *
 * @author Vincent Laude
 */
public class Contest {

    private int id;
    private int year;
    private String category;
    private String title;
    
    //private List<Event> events;
    
    public Contest(int id, int year, String category, String title) {
        this.id = id;
        this.year = year;
        this.category = category;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public String toString() {
        return "Contest: " + title + " " + category + " " + year;
    }
}
