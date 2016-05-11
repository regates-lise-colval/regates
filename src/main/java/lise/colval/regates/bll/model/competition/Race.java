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
public class Race {
    
    private int id;
    private String name;
    private Event event;
    private List<Participation> participations;
    
    public Race(int id, String name, Event event, List<Participation> participations) {
        this.id = id;
        this.name = name;
        this.event = event;
        this.participations = new ArrayList<Participation>(participations);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
    
    @Override
    public String toString() {
        return "Race: " + name + " " + event;
    }
}
