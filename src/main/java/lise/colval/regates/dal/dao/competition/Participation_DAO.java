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
import lise.colval.regates.bll.model.competition.Participation;
import lise.colval.regates.bll.model.competition.Race;
import lise.colval.regates.bll.model.participant.Driver;
import lise.colval.regates.bll.model.participant.Ship;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dao.SQL_DAO;
import lise.colval.regates.dal.dto.Participation_DTO;

/**
 *
 * @author vince
 */
public class Participation_DAO extends SQL_DAO {
    
    public Participation_DAO(String db_url, String db_driver, String db_user, String db_password) {
        super(db_url, db_driver, db_user, db_password);
    }
    
    @Override
    public Participation findParticipationById(int id) {
        Participation participation;
        participation = new Participation();
        
        Statement stmt = null;
        
        try {
            
            stmt = connect().createStatement();   
            String request = "SELECT * FROM PARTICIPATION WHERE ID = " + id;
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int shipid = rs.getInt("shipid");
                int score = rs.getInt("score");
                int rank = rs.getInt("rank");
                int duration = rs.getInt("duration");
                int corridor = rs.getInt("corridor");
                int raceId = rs.getInt("raceid");
                int driverId = rs.getInt("driverid");
                
                Ship ship = Repository.getInstance().findShipById(shipid);
                Driver driver = Repository.getInstance().findDriverById(driverId);
                
                participation = new Participation(id, corridor, ship, driver);
                participation.setDuration(duration);
                participation.setRank(rank);
                participation.setScore(score);
                
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();  
        
        return participation;
    }
    
    @Override
    public List<Participation> getAllParticipations() {
        List<Participation> participations;
        participations = new ArrayList<>();
        
        Statement stmt = null;
     
        try {
            
            stmt = connect().createStatement();   
            String request = "SELECT * FROM PARTICIPATION";
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int shipid = rs.getInt("shipid");
                int score = rs.getInt("score");
                int rank = rs.getInt("rank");
                int duration = rs.getInt("duration");
                int corridor = rs.getInt("corridor");
                int raceId = rs.getInt("raceid");
                int driverid = rs.getInt("driverid");
                
                Ship ship = Repository.getInstance().findShipById(shipid);
                Driver driver = Repository.getInstance().findDriverById(driverid);
                //Race race = Repository.getInstance().findRaceById(raceId);
                
                Participation participation = new Participation(id, corridor, ship, driver);
                participation.setDuration(duration);
                participation.setRank(rank);
                participation.setScore(score);
                
                participations.add(participation);
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        return participations;
    }
    
    @Override
    public Participation_DTO createParticipationDTO(Participation participation) {
        Participation_DTO participationDTO = new Participation_DTO();
        participationDTO.setId(participation.getId());
        participationDTO.setShipId(participation.getShip().getId());
        participationDTO.setParticipatingDriverId(participation.getParticipatingDriver().getId());
        participationDTO.setCorridor(participation.getCorridor());
        participationDTO.setDuration(participation.getDuration());
        participationDTO.setRank(participation.getRank());
        participationDTO.setScore(participation.getScore());
        return participationDTO;
    }
    
    @Override
    public List<Participation> findParticipationsByRace(int raceId) {
        List<Participation> participations;
        participations = new ArrayList<>();
        
        Statement stmt = null;
     
        try {
            
            stmt = connect().createStatement();   
            String request = "SELECT * FROM PARTICIPATION WHERE RACEID = " + raceId;
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int shipid = rs.getInt("shipid");
                int score = rs.getInt("score");
                int rank = rs.getInt("rank");
                int duration = rs.getInt("duration");
                int corridor = rs.getInt("corridor");
                int raceid = rs.getInt("raceid");
                int driverid = rs.getInt("driverid");
                
                Ship ship = Repository.getInstance().findShipById(shipid);
                Driver driver = Repository.getInstance().findDriverById(driverid);
                //Race race = Repository.getInstance().findRaceById(raceid);
                
                Participation participation = new Participation(id, corridor, ship, driver);
                participation.setDuration(duration);
                participation.setRank(rank);
                participation.setScore(score);
                
                //System.out.println("PARTICIPATION: " + participation);
                
                participations.add(participation);
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        return participations;
    }
}