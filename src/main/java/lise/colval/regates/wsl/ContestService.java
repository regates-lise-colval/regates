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
import lise.colval.regates.bll.control.AllContestsController;
import lise.colval.regates.bll.model.competition.Contest;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dto.Contest_DTO;

/**
 *
 * @author Vincent Laude
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/contests")
public class ContestService {
    
    @GET
    @Path("/{id}")
    public Contest_DTO findContestById(@PathParam("id") int id) {
        Contest contest = new AllContestsController().findContestById(id);
        return Repository.getInstance().createContestDTO(contest);
    }
    
    @GET
    public List<Contest_DTO> getAllContests() {
        List<Contest> contests = new AllContestsController().getAllContests();
        List<Contest_DTO> contestsDTO = new ArrayList<>();
        for(Contest contest : contests) {
            contestsDTO.add(Repository.getInstance().createContestDTO(contest));
        }
        return contestsDTO;
    }
}
