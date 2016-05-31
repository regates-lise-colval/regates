/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.control;

import java.util.List;
import lise.colval.regates.bll.model.competition.Race;
import lise.colval.regates.dal.Repository;

/**
 *
 * @author Vincent Laude
 */
public class AllRacesController {

    public Race findRaceById(int id) {
        return Repository.getInstance().findRaceById(id);
    }

    public List<Race> getAllRaces() {
        return Repository.getInstance().getAllRaces();
    }
    
}
