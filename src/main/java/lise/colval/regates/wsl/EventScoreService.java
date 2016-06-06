/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.wsl;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lise.colval.regates.bll.control.AllEventScoreController;
import lise.colval.regates.bll.model.scoring.EventScore;

/**
 *
 * @author vince
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/escore")
public class EventScoreService {
    
    @GET
    public List<EventScore> getAllEventScores() {
        return new AllEventScoreController().getAllEventScores();
    }
    
    @GET
    @Path("/event/{eventid}")
    public List<EventScore> getScoreOfEvent(@PathParam("eventid") int eventid) {
        return new AllEventScoreController().getScoreOfEvent(eventid);
    }
    
}
