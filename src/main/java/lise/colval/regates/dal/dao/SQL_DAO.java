/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lise.colval.regates.bll.model.competition.Event;
import lise.colval.regates.bll.model.participant.Driver;
import lise.colval.regates.bll.model.participant.Ship;
import lise.colval.regates.dal.dto.ShipDTO;

/**
 *
 * @author Vincent Laude
 */
public class SQL_DAO extends DataBaseDAO {

    private Connection con;
    
    public SQL_DAO(String db_url, String db_user, String db_password) {
        super(db_url, db_user, db_password);
    }
    
    private Connection connect() {
        con = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(db_url, db_user, db_password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    private void closeConnection() {
        try {
            if(con != null) {
                con.close();
            }
        } catch(Exception e) {
        }
    }

    @Override
    public Ship findShipById(int tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                String mainDriver = rs.getString("mainDriver");
                
                Ship ship = new Ship(id, tag, category, new Driver(mainDriver));
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
    public ShipDTO createShipDTO(Ship ship) {
        ShipDTO shipDTO = new ShipDTO();
        
        shipDTO.setId(ship.getId());
        shipDTO.setTag(ship.getTag());
        shipDTO.setCategory(ship.getCategory());
        shipDTO.setMainDriver(ship.getMainDriver().getName());
        
        return shipDTO;
    }

    @Override
    public Ship createBeanShip(ShipDTO shipDTO) {
        Ship ship = new Ship();
        
        ship.setId(shipDTO.getId());
        ship.setTag(shipDTO.getTag());
        ship.setCategory(shipDTO.getCategory());
        ship.setMainDriver(new Driver(shipDTO.getMainDriver()));
        
        return ship;
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
                
                Event event = new Event(id, city, category, date, img);
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
}
