/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dao.competition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lise.colval.regates.bll.model.competition.Contest;
import lise.colval.regates.bll.model.competition.Event;
import lise.colval.regates.bll.model.competition.Participation;
import lise.colval.regates.bll.model.competition.Race;
import lise.colval.regates.bll.model.scoring.EventScore;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dao.SQL_DAO;
import lise.colval.regates.dal.dto.Contest_DTO;
import lise.colval.regates.dal.dto.Event_DTO;

/**
 *
 * @author Vincent Laude
 */
public class Event_DAO extends SQL_DAO {
    
    public Event_DAO(String db_url, String db_driver, String db_user, String db_password) {
        super(db_url, db_driver, db_user, db_password);
    }
    
    @Override
    public Event findEventById(int id) {
        
        Event event = new Event();
        Statement stmt = null;
        
        try {
            
            stmt = connect().createStatement();
            String request = "SELECT * FROM EVENT WHERE ID = " + id;
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                String city = rs.getString("city");
                String category = rs.getString("category");
                String date = rs.getString("date");
                String img = rs.getString("img");
                int contestId = rs.getInt("contestid");
                
                Contest_DTO contestDTO = Repository.getInstance().findContestDTOById(contestId);
                event = new Event(id, city, category, date, img, contestDTO);
                
                List<Race> races = Repository.getInstance().getAllRaces();
                for(Race race : races) {
                    if(race.getEventDTO().getId() == event.getId()) {
                        event.addRace(race);
                    }
                }
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        
        return event;
    }
    
    @Override
    public Event_DTO findEventDTOById(int id) {
        Event_DTO eventDTO = new Event_DTO();
        Statement stmt = null;
        
        try {
            
            stmt = connect().createStatement();
            String request = "SELECT * FROM EVENT WHERE ID = " + id;
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                String city = rs.getString("city");
                String category = rs.getString("category");
                String date = rs.getString("date");
                String img = rs.getString("img");
                int contestId = rs.getInt("contestid");
                
                /*List<Race> races = Repository.getInstance().getAllRaces();
                List<Race> racesForDTO = new ArrayList<>();
              
                for(Race race : races) {
                    if(race.getEventDTO().getId() == id) {
                        racesForDTO.add(race);
                    }
                }*/
                
                eventDTO.setId(id);
                eventDTO.setCity(city);
                eventDTO.setCategory(category);
                eventDTO.setDate(date);
                eventDTO.setImg(img);
                eventDTO.setContestId(contestId);
                //eventDTO.setRacesId(racesForDTO);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        
        return eventDTO;
    }
    
    @Override
    public List<Event> getAllEvents() {
        List<Event> events;
        events = new ArrayList<>();
        
        Statement stmt = null;
     
        try {
            
            stmt = connect().createStatement();   
            String request = "SELECT * FROM EVENT";
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String city = rs.getString("city");
                String category = rs.getString("category");
                String date = rs.getString("date");
                String img = rs.getString("img");
                int contestId = rs.getInt("contestid");
                
                Contest_DTO contestDTO = Repository.getInstance().findContestDTOById(contestId);
                
                Event event = new Event(id, city, category, date, img, contestDTO);
                
                List<Race> races = Repository.getInstance().getAllRaces();
                
                for(Race race : races) {
                    if(race.getEventDTO().getId() == event.getId()) {
                        event.addRace(race);
                    }
                }
                
                events.add(event);
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        return events;
    }
    
    @Override
    public List<Event> findEventsByContest(int contestId) {
        List<Event> events;
        events = new ArrayList<>();
        
        Statement stmt = null;
     
        try {
            
            stmt = connect().createStatement();   
            String request = "SELECT * FROM EVENT WHERE CONTESTID = " + contestId;
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String city = rs.getString("city");
                String category = rs.getString("category");
                String date = rs.getString("date");
                String img = rs.getString("img");
                
                Contest_DTO contestDTO = Repository.getInstance().findContestDTOById(contestId);
                List<EventScore> scores = Repository.getInstance().getScoreOfEvent(id);
                
                Event event = new Event(id, city, category, date, img, contestDTO, scores);
                
                List<Race> races = Repository.getInstance().getAllRaces();
               
                
                for(Race race : races) {
                    if(race.getEventDTO().getId() == event.getId()) {
                        event.addRace(race);
                    }
                }
                
                events.add(event);
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        return events;
    }
    
    @Override
    public Event_DTO createEventDTO(Event event) {
        Event_DTO eventDTO = new Event_DTO();
        
        eventDTO.setId(event.getId());
        eventDTO.setCity(event.getCity());
        eventDTO.setCategory(event.getCategory());
        eventDTO.setDate(event.getDate());
        eventDTO.setImg(event.getImg());
        eventDTO.setContestId(event.getContestDTO().getId());
        eventDTO.setRacesId(event.getRaces());
        
        return eventDTO;
    }
    
    @Override
    public Event createBeanEvent(Event_DTO eventDTO) {
        Event event = new Event();
        
        event.setId(eventDTO.getId());
        event.setCity(eventDTO.getCity());
        event.setCategory(eventDTO.getCategory());
        event.setDate(eventDTO.getDate());
        event.setImg(eventDTO.getImg());
        Contest_DTO contestDTO = Repository.getInstance().findContestDTOById(eventDTO.getContestId());
        event.setContestDTO(contestDTO);
        
        return event;
    }
    
}
