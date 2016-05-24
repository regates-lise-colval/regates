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
import lise.colval.regates.dal.dto.Ship_DTO;

/**
 *
 * @author Vincent Laude
 */
public class Ship_DAO extends SQL_DAO {
    
    public Ship_DAO(String db_url, String db_driver, String db_user, String db_password) {
        super(db_url, db_driver, db_user, db_password);
    }
    
    @Override
    public Ship findShipById(int id) {
        Ship ship = new Ship();
        Statement stmt = null;
        
        try {
            
            stmt = connect().createStatement();
            String request = "SELECT * FROM SHIP WHERE ID = " + id;
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
               
                int tag = rs.getInt("tag");
                String category = rs.getString("category");
                int mainDriverId = rs.getInt("maindriverid");
               
                Driver_DTO mainDriverDTO = Repository.getInstance().findDriverDTOById(mainDriverId);
                
                ship = new Ship(id, tag, category, mainDriverDTO);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        
        return ship;
    }
    
    @Override
    public List<Ship> getAllShips() {
        List<Ship> ships;
        ships = new ArrayList<>();
        
        Statement stmt = null;
     
        try {
            
            stmt = connect().createStatement();   
            String request = "SELECT * FROM SHIP";
            ResultSet rs = stmt.executeQuery(request);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int tag = rs.getInt("tag");
                String category = rs.getString("category");
                int mainDriverId = rs.getInt("maindriverid");
                
                Driver_DTO mainDriverDTO = Repository.getInstance().findDriverDTOById(mainDriverId);
                
                Ship ship = new Ship(id, tag, category, mainDriverDTO);
                ships.add(ship);
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        return ships;
    }
    
    @Override
    public Ship_DTO createShipDTO(Ship ship) {
        Ship_DTO shipDTO = new Ship_DTO();
        
        shipDTO.setId(ship.getId());
        shipDTO.setTag(ship.getTag());
        shipDTO.setCategory(ship.getCategory());
        shipDTO.setMainDriverId(ship.getMainDriver().getId());
        
        return shipDTO;
    }

    @Override
    public Ship createBeanShip(Ship_DTO shipDTO) {
        Ship ship = new Ship();
        
        ship.setId(shipDTO.getId());
        ship.setTag(shipDTO.getTag());
        ship.setCategory(shipDTO.getCategory());
        Driver driver = Repository.getInstance().findDriverById(shipDTO.getMainDriverId());
        ship.setMainDriver(Repository.getInstance().createDriverDTO(driver));
        
        return ship;
    }
}
