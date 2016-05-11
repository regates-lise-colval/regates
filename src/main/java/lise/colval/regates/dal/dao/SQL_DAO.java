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
import lise.colval.regates.bll.model.participant.Ship;
import lise.colval.regates.dal.dto.ContestDTO;
import lise.colval.regates.dal.dto.ShipDTO;

/**
 *
 * @author Vincent Laude
 */
public class SQL_DAO extends DataBase_DAO implements I_DAO {
    
    public SQL_DAO(String db_url, String db_driver, String db_user, String db_password) {
        super(db_url, db_driver, db_user, db_password);
    }

    @Override
    public Ship findShipById(int tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ship> getAllShips() {
        return new Ship_DAO(db_url, db_driver, db_user, db_password).getAllShips();
    }

    @Override
    public ShipDTO createShipDTO(Ship ship) {
        return new Ship_DAO(db_url, db_driver, db_user, db_password).createShipDTO(ship);
    }

    @Override
    public Ship createBeanShip(ShipDTO shipDTO) {
        return new Ship_DAO(db_url, db_driver, db_user, db_password).createBeanShip(shipDTO);
    }

    @Override
    public List<Event> getAllEvents() {
       return new Event_DAO(db_url, db_driver, db_user, db_password).getAllEvents();
    }

    @Override
    public ContestDTO createContestDTO(Contest contest) {
       return new Contest_DAO().createContestDTO(contest);
    }
}
