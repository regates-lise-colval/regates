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
public class Race_DTO {
    
    private int id;
    private String name;
    private int eventDTOId;
    private List<Integer> participationsIds;
    
    public Race_DTO() {
        this.participationsIds = new ArrayList<>(); 
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

    public int getEventDTOId() {
        return eventDTOId;
    }

    public void setEventDTOId(int eventDTOId) {
        this.eventDTOId = eventDTOId;
    }

    public List<Integer> getParticipationsIds() {
        return participationsIds;
    }

    public void setParticipationsIds(List<Integer> participationsIds) {
        this.participationsIds = participationsIds;
    }
    
    public void addParticipationId(int id) {
        this.participationsIds.add(id);
    }
    
    @Override
    public String toString() {
        return "Race_DTO: " + id + " " + name + " " + eventDTOId;    
    }
    
}
