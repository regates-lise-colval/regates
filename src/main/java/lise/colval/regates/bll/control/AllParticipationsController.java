/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.control;

import java.util.List;
import lise.colval.regates.bll.model.competition.Participation;
import lise.colval.regates.dal.Repository;

/**
 *
 * @author vince
 */
public class AllParticipationsController {

    public Participation findParticipationById(int id) {
        return Repository.getInstance().findParticipationById(id);
    }
    
    public List<Participation> getAllParticipations() {
        return Repository.getInstance().getAllParticipations();
    }

    public List<Participation> findParticipationsByRace(int raceId) {
        return Repository.getInstance().findParticipationsByRace(raceId);
    }

    public List<Participation> findParticipationsByEvent(int eventId) {
        return Repository.getInstance().findParticipationsByEvent(eventId);
    }
    
}
