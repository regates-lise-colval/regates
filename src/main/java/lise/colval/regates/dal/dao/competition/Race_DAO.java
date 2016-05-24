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
import lise.colval.regates.dal.dao.SQL_DAO;
import lise.colval.regates.bll.model.competition.Race;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dto.Event_DTO;
import lise.colval.regates.dal.dto.Race_DTO;

/**
 *
 * @author vince
 */
public class Race_DAO extends SQL_DAO {
    
    public Race_DAO(String db_url, String db_driver, String db_user, String db_password) {
        super(db_url, db_driver, db_user, db_password);
    }
    
    @Override
    public Race findRaceById(int id) {
        return null;
    }
    
    @Override
    public List<Race> getAllRaces() {
        List<Race> races;
        races = new ArrayList<>();
        
        Statement stmt = null;
     
        try {
            
            stmt = connect().createStatement();   
            String request = "SELECT * FROM RACE";
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int eventId = rs.getInt("event");
                
                Event_DTO eventDTO = Repository.getInstance().findEventDTOById(eventId);
                
                Race race = new Race(id, name, eventDTO, null);
                races.add(race);
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        return races;
    }
    
    
    @Override
    public Race_DTO createRaceDTO(Race race) {
        Race_DTO raceDTO = new Race_DTO();
        raceDTO.setId(race.getId());
        raceDTO.setName(race.getName());
        raceDTO.setEventDTOId(race.getEventDTO().getId());
        raceDTO.setParticipationsIds(null);
        return raceDTO;
    }
}
