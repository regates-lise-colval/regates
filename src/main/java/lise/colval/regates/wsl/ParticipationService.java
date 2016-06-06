/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.wsl;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lise.colval.regates.bll.control.AllParticipationsController;
import lise.colval.regates.bll.model.competition.Participation;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dto.Participation_DTO;

/**
 *
 * @author vince
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/participations")
public class ParticipationService {
    
    @GET
    @Path("/{id}")
    public Participation_DTO findParticipationById(@PathParam("id") int id) {
        Participation participation = new AllParticipationsController().findParticipationById(id);
        Participation_DTO participationDTO = Repository.getInstance().createParticipationDTO(participation);
        return participationDTO;
    }
    
    @GET
    public List<Participation_DTO> getAllParticipations() {
        List<Participation> participations = new AllParticipationsController().getAllParticipations();
        List<Participation_DTO> participationsDTO = new ArrayList<>();
        for(Participation participation : participations) {
            participationsDTO.add(Repository.getInstance().createParticipationDTO(participation));
        }
        return participationsDTO;
    }

    @GET
    @Path("/race/{raceId}")
    public List<Participation_DTO> findParticipationsByRace(@PathParam("raceId") int raceId) {
        List<Participation> participations = new AllParticipationsController().findParticipationsByRace(raceId);
        List<Participation_DTO> participationsDTO = new ArrayList<>();
        for(Participation participation : participations) {
            participationsDTO.add(Repository.getInstance().createParticipationDTO(participation));
        }
        return participationsDTO;
    }
    
    @GET
    @Path("/event/{eventId}")
    public List<Participation> findParticipationsByEvent(@PathParam("eventId") int eventId) {
        return new AllParticipationsController().findParticipationsByEvent(eventId);
    }
    
}
