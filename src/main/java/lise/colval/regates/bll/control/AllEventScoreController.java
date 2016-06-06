/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.control;

import java.util.List;
import lise.colval.regates.bll.model.scoring.EventScore;
import lise.colval.regates.dal.Repository;

/**
 *
 * @author vince
 */
public class AllEventScoreController {
    
    public List<EventScore> getScoreOfEvent(int eventid) {
        return Repository.getInstance().getScoreOfEvent(eventid);
    }

    public List<EventScore> getAllEventScores() {
        return Repository.getInstance().getAllEventScores();
    }
    
}
