/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.control;

import java.util.List;
import lise.colval.regates.bll.model.participant.Ship;
import lise.colval.regates.dal.Repository;

/**
 *
 * @author Vincent Laude
 */
public class ProfileShipController {

    public Ship getShip(int tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  

    public List<Ship> getAllShips() {
        return Repository.getInstance().getAllShips();
    }
}
