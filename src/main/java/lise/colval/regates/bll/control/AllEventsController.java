/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.control;

import java.util.List;
import lise.colval.regates.bll.model.competition.Event;
import lise.colval.regates.dal.Repository;


/**
 *
 * @author Vincent Laude
 */
public class AllEventsController {
    
     public Event findEventById(int id) {
        return Repository.getInstance().findEventById(id);
    }
    
    public List<Event> getAllEvents() {
        return Repository.getInstance().getAllEvents();
    }  
    
}
