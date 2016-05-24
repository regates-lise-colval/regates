/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dao.participant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lise.colval.regates.bll.model.participant.Driver;
import lise.colval.regates.bll.model.participant.Ship;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dao.SQL_DAO;
import lise.colval.regates.dal.dto.Driver_DTO;

/**
 *
 * @author vince
 */
public class Driver_DAO extends SQL_DAO {
    
    public Driver_DAO(String db_url, String db_driver, String db_user, String db_password) {
        super(db_url, db_driver, db_user, db_password);
    }
    
    @Override
    public Driver findDriverById(int id) {
        Driver driver = new Driver();
        Statement stmt = null;
        
        try {
            
            stmt = connect().createStatement();
            String request = "SELECT * FROM DRIVER WHERE ID = " + id;
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                int shipId = rs.getInt("shipid");
                
                Ship ship = Repository.getInstance().findShipById(shipId);
                
                driver = new Driver(id, firstname, lastname, ship);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        
        return driver;
    }
    
    @Override
    public Driver_DTO findDriverDTOById(int id) {
        Driver_DTO driverDTO = new Driver_DTO();
        Statement stmt = null;
        
        try {
            
            stmt = connect().createStatement();
            String request = "SELECT * FROM DRIVER WHERE ID = " + id;
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                int shipId = rs.getInt("shipid");
                
                driverDTO.setId(id);
                driverDTO.setFirstname(firstname);
                driverDTO.setLastname(lastname);
                driverDTO.setShipId(shipId);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        
        return driverDTO;
    }
    
    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> drivers;
        drivers = new ArrayList<>();
        
        Statement stmt = null;
     
        try {
            
            stmt = connect().createStatement();   
            String request = "SELECT * FROM DRIVER";
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                int shipId = rs.getInt("shipid");
                
                Ship ship = Repository.getInstance().findShipById(shipId);
                
                Driver driver = new Driver(id, firstname, lastname, ship);
                drivers.add(driver);
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        return drivers;
    }
    
    @Override
    public Driver_DTO createDriverDTO(Driver driver) {
        Driver_DTO driverDTO = new Driver_DTO();
        
        driverDTO.setId(driver.getId());
        driverDTO.setFirstname(driver.getFirstname());
        driverDTO.setLastname(driver.getLastname());
        driverDTO.setShipId(driver.getShip().getId());
    
        return driverDTO;
    }
}
