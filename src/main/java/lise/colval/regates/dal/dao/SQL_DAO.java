/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dao;

import lise.colval.regates.dal.dao.participant.Ship_DAO;
import lise.colval.regates.dal.dao.competition.Event_DAO;
import lise.colval.regates.dal.dao.competition.Contest_DAO;
import java.util.List;
import lise.colval.regates.bll.model.competition.Contest;
import lise.colval.regates.bll.model.competition.Event;
import lise.colval.regates.bll.model.competition.Participation;
import lise.colval.regates.bll.model.competition.Race;
import lise.colval.regates.bll.model.participant.Driver;
import lise.colval.regates.bll.model.participant.Ship;
import lise.colval.regates.dal.dao.competition.Participation_DAO;
import lise.colval.regates.dal.dao.competition.Race_DAO;
import lise.colval.regates.dal.dao.participant.Driver_DAO;
import lise.colval.regates.dal.dto.Contest_DTO;
import lise.colval.regates.dal.dto.Driver_DTO;
import lise.colval.regates.dal.dto.Event_DTO;
import lise.colval.regates.dal.dto.Participation_DTO;
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
    public Ship findShipById(int id) {
        return new Ship_DAO(db_url, db_driver, db_user, db_password).findShipById(id);
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

    // ----- DRIVER ----- //
    @Override
    public Driver findDriverById(int id) {
        return new Driver_DAO(db_url, db_driver, db_user, db_password).findDriverById(id);
    }
    
    @Override
    public Driver_DTO findDriverDTOById(int id) {
        return new Driver_DAO(db_url, db_driver, db_user, db_password).findDriverDTOById(id);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return new Driver_DAO(db_url, db_driver, db_user, db_password).getAllDrivers();
    }

    @Override
    public Driver_DTO createDriverDTO(Driver driver) {
        return new Driver_DAO(db_url, db_driver, db_user, db_password).createDriverDTO(driver);
    }

    @Override
    public Driver createBeanDriver(Driver_DTO driverDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // ----- EVENT ----- //
    
    @Override
    public Event findEventById(int id) {
       return new Event_DAO(db_url, db_driver, db_user, db_password).findEventById(id);
    }
    
    @Override
    public Event_DTO findEventDTOById(int id) {
        return new Event_DAO(db_url, db_driver, db_user, db_password).findEventDTOById(id);
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
    
    // ----- RACE ----- //

    @Override
    public Race findRaceById(int raceId) {
        return new Race_DAO(db_url, db_driver, db_user, db_password).findRaceById(raceId);
    }
    
    @Override
    public List<Race> getAllRaces() {
        return new Race_DAO(db_url, db_driver, db_user, db_password).getAllRaces();
    }

    @Override
    public Race_DTO createRaceDTO(Race race) {
        return new Race_DAO(db_url, db_driver, db_user, db_password).createRaceDTO(race);
    }

    // ----- PARTICIPATION ----- //
    
    @Override
    public Participation findParticipationById(int id) {
        return new Participation_DAO(db_url, db_driver, db_user, db_password).findParticipationById(id);
    }
    
    @Override
    public List<Participation> getAllParticipations() {
        return new Participation_DAO(db_url, db_driver, db_user, db_password).getAllParticipations();
    }
    
    @Override
    public Participation_DTO createParticipationDTO(Participation participation) {
        return new Participation_DAO(db_url, db_driver, db_user, db_password).createParticipationDTO(participation);
    }
    
    @Override
    public List<Participation> findParticipationsByRace(int raceId) {
        return new Participation_DAO(db_url, db_driver, db_user, db_password).findParticipationsByRace(raceId);
    }
    
}
