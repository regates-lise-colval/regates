/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dao;

import lise.colval.regates.dal.dao.competition.Event_DAO;
import lise.colval.regates.dal.dao.competition.Contest_DAO;
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
public class SQL_DAO extends DataBase_DAO implements I_DAO {
    
    public SQL_DAO(String db_url, String db_driver, String db_user, String db_password) {
        super(db_url, db_driver, db_user, db_password);
    }
    
    // ----- SHIP ----- //

    @Override
    public Ship findShipById(int tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ship> getAllShips() {
        return new Ship_DAO(db_url, db_driver, db_user, db_password).getAllShips();
    }

    @Override
    public Ship_DTO createShipDTO(Ship ship) {
        return new Ship_DAO(db_url, db_driver, db_user, db_password).createShipDTO(ship);
    }

    @Override
    public Ship createBeanShip(Ship_DTO shipDTO) {
        return new Ship_DAO(db_url, db_driver, db_user, db_password).createBeanShip(shipDTO);
    }

    // ----- EVENT ----- //
    
    @Override
    public Event findEventById(int id) {
       return new Event_DAO(db_url, db_driver, db_user, db_password).findEventById(id);
    }
    
    @Override
    public List<Event> getAllEvents() {
       return new Event_DAO(db_url, db_driver, db_user, db_password).getAllEvents();
    }
    
    @Override
    public Event_DTO createEventDTO(Event event) {
        return new Event_DAO(db_url, db_driver, db_user, db_password).createEventDTO(event);
    }
    @Override
    public Event createBeanEvent(Event_DTO eventDTO) {
        return new Event_DAO(db_url, db_driver, db_user, db_password).createBeanEvent(eventDTO);
    }
    
    // ----- CONTEST ----- // 
    
    @Override
    public Contest findContestById(int id) {
        return new Contest_DAO(db_url, db_driver, db_user, db_password).findContestById(id);
    }
    
    @Override
    public List<Contest> getAllContests() {
        return new Contest_DAO(db_url, db_driver, db_user, db_password).getAllContests();
    }
    
    @Override
    public Contest_DTO createContestDTO(Contest contest) {
        return new Contest_DAO(db_url, db_driver, db_user, db_password).createContestDTO(contest);
    }    

    @Override
    public Race findRaceById(int raceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Race> getAllRaces() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Race_DTO createRaceDTO(Race race) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
