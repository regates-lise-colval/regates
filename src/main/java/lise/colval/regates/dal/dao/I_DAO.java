/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dao;

import java.util.List;
import lise.colval.regates.bll.model.competition.Contest;
import lise.colval.regates.bll.model.competition.Event;
import lise.colval.regates.bll.model.competition.Race;
import lise.colval.regates.bll.model.participant.Ship;
import lise.colval.regates.dal.dto.Contest_DTO;
import lise.colval.regates.dal.dto.Event_DTO;
import lise.colval.regates.dal.dto.Race_DTO;
import lise.colval.regates.dal.dto.Ship_DTO;

/**
 *
 * @author Vincent Laude
 */
public interface I_DAO {
    
    // ------ SHIP ----- //
    public abstract Ship findShipById(int id);
    public abstract List<Ship> getAllShips();
    public abstract Ship_DTO createShipDTO(Ship ship);
    public abstract Ship createBeanShip(Ship_DTO shipDTO);
    
    // ----- EVENT ----- //
    public abstract Event findEventById(int id);
    public abstract List<Event> getAllEvents();
    public abstract Event_DTO createEventDTO(Event event);
    public abstract Event createBeanEvent(Event_DTO eventDTO);
    
    // ----- CONTEST ----- //
    public abstract Contest findContestById(int contestId);
    public abstract List<Contest> getAllContests();
    public abstract Contest_DTO createContestDTO(Contest contest);
    
    // ----- RACE ----- //
    public abstract Race findRaceById(int raceId);
    public abstract List<Race> getAllRaces();
    public abstract Race_DTO createRaceDTO(Race race);
    
}
