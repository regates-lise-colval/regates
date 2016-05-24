/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.control;

import java.util.List;
import lise.colval.regates.bll.model.competition.Event;
import lise.colval.regates.bll.model.participant.Driver;
import lise.colval.regates.dal.Repository;

/**
 *
 * @author vince
 */
public class AllDriversController {
    
     public Driver findDriverById(int id) {
        return Repository.getInstance().findDriverById(id);
    }
    
    public List<Driver> getAllDrivers() {
        return Repository.getInstance().getAllDrivers();
    }  
    
}
