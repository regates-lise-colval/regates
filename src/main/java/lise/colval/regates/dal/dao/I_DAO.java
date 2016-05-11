/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dao;

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
public interface I_DAO {
    
    public abstract Ship findShipById(int id);
    public abstract List<Ship> getAllShips();
    
    public abstract List<Event> getAllEvents();
    
    public abstract ShipDTO createShipDTO(Ship ship);
    public abstract Ship createBeanShip(ShipDTO shipDTO);

    public ContestDTO createContestDTO(Contest contest);
}
