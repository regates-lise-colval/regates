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
import javax.validation.ReportAsSingleViolation;
import lise.colval.regates.bll.model.competition.Contest;
import lise.colval.regates.bll.model.competition.Event;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dao.SQL_DAO;
import lise.colval.regates.dal.dto.Contest_DTO;
import lise.colval.regates.dal.dto.Event_DTO;

/**
 *
 * @author Vincent Laude
 */
public class Contest_DAO extends SQL_DAO {

    public Contest_DAO(String db_url, String db_driver, String db_user, String db_password) {
        super(db_url, db_driver, db_user, db_password);
    }
    
    @Override
    public Contest findContestById(int id) {
        
        Contest contest = new Contest();
        Statement stmt = null;
        
        try {
            
            stmt = connect().createStatement();
            String request = "SELECT * FROM CONTEST WHERE ID = " + id;
            ResultSet rs = stmt.executeQuery(request);
            
            if(rs.next()) {
                int year = rs.getInt("cyear");
                String category = rs.getString("category");
                String title = rs.getString("title");
                String img = rs.getString("img");
                
                List<Event> events = Repository.getInstance().findEventsByContest(id);
                
                contest = new Contest(id, year, category, title, img, events);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        return contest; 
    }
    
    @Override
    public List<Contest> getAllContests() {
        List<Contest> contests;
        contests = new ArrayList<>();
        
        Statement stmt = null;
     
        try {
            
            stmt = connect().createStatement();   
            String request = "SELECT * FROM CONTEST";
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int year = rs.getInt("cyear");
                String category = rs.getString("category");
                String title = rs.getString("title");
                String img = rs.getString("img");
                
                List<Event> events = Repository.getInstance().findEventsByContest(id);
                
                Contest contest = new Contest(id, year, category, title, img, events);
                contests.add(contest);
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        return contests;
    }
    
    @Override
    public Contest_DTO findContestDTOById(int contestId) {
        Contest_DTO contestDTO = new Contest_DTO();
        
        Statement stmt = null;
        
        try {
            
            stmt = connect().createStatement();
            String request = "SELECT * FROM CONTEST WHERE ID = " + contestId;
            ResultSet rs = stmt.executeQuery(request);
            
            if(rs.next()) {
                int year = rs.getInt("cyear");
                String category = rs.getString("category");
                String title = rs.getString("title");
                String img = rs.getString("img");
                
                contestDTO.setId(contestId);
                contestDTO.setCategory(category);
                contestDTO.setTitle(title);
                contestDTO.setYear(year);
                contestDTO.setImg(img);
              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        
        return contestDTO;
    }
    
    @Override
    public Contest_DTO createContestDTO(Contest contest) {
        Contest_DTO contestDTO = new Contest_DTO();
        
        contestDTO.setId(contest.getId());
        contestDTO.setCategory(contest.getCategory());
        contestDTO.setImg(contest.getImg());
        contestDTO.setTitle(contest.getTitle());
        contestDTO.setYear(contest.getYear());
        
        for(Event event : contest.getEvents()) {
            contestDTO.addEventId(event.getId());
        }
        
        return contestDTO;
    }
}
