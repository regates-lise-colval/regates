/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.model.competition;

import java.util.ArrayList;
import java.util.List;
import lise.colval.regates.dal.dto.Event_DTO;

/**
 *
 * @author Vincent Laude
 */
public class Race {
    
    private int id;
    private String name;
    private Event_DTO eventDTO;
    private List<Participation> participations;
    
    public Race(int id, String name, Event_DTO eventDTO, List<Participation> participations) {
        this.id = id;
        this.name = name;
        this.eventDTO = eventDTO;
        this.participations = null;
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

    public Event_DTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(Event_DTO eventDTO) {
        this.eventDTO = eventDTO;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
    
    @Override
    public String toString() {
        return "Race: " + name + " " + eventDTO;
    }
}
