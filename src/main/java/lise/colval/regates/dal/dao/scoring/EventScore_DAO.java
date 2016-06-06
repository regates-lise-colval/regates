/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dao.scoring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lise.colval.regates.bll.model.participant.Ship;
import lise.colval.regates.bll.model.scoring.EventScore;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dao.SQL_DAO;

/**
 *
 * @author vince
 */
public class EventScore_DAO extends SQL_DAO {
    
    public EventScore_DAO(String db_url, String db_driver, String db_user, String db_password) {
        super(db_url, db_driver, db_user, db_password);
    }
    
    @Override
    public List<EventScore> getScoreOfEvent(int eventId) {
        List<EventScore> scores;
        scores = new ArrayList<>();
        
        Statement stmt = null;
        
        try {
            
            stmt = connect().createStatement();
            String request = "SELECT * FROM EVENTSCORE WHERE EVENTID = " + eventId;
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int totalScore = rs.getInt("totalscore");
                int rank = rs.getInt("rank");
                int shipid = rs.getInt("shipid");
                
                Ship ship = Repository.getInstance().findShipById(shipid);
                EventScore score = new EventScore(id, totalScore, rank, ship);
               
                scores.add(score);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        
        return scores;  
    }
    
    @Override
    public List<EventScore> getAllEventScores() {
        List<EventScore> scores;
        scores = new ArrayList<>();
        
        Statement stmt = null;
        
        try {
            
            stmt = connect().createStatement();
            String request = "SELECT * FROM EVENTSCORE";
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int totalScore = rs.getInt("totalscore");
                int rank = rs.getInt("rank");
                int shipid = rs.getInt("shipid");
                
                Ship ship = Repository.getInstance().findShipById(shipid);
                System.out.println("SHIIIIIIIIIIIIIIIIIIIIIIP:" + ship);
                EventScore score = new EventScore(id, totalScore, rank, ship);
               
                scores.add(score);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        
        return scores; 
    }
    
}
