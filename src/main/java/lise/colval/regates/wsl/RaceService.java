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
import lise.colval.regates.bll.control.AllRacesController;
import lise.colval.regates.bll.model.competition.Race;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dto.Race_DTO;

/**
 *
 * @author Vincent Laude
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/races")
public class RaceService {
    
    @GET
    @Path("/{id}")
    public Race_DTO findRaceById(@PathParam("id") int id) {
        Race race =  new AllRacesController().findRaceById(id);
        Race_DTO raceDTO = Repository.getInstance().createRaceDTO(race);
        return raceDTO;
    }
    
    @GET
    public List<Race_DTO> getAllRaces() {
        List<Race> races = new AllRacesController().getAllRaces();
        List<Race_DTO> racesDTO = new ArrayList<>();
        for(Race race : races) {
            racesDTO.add(Repository.getInstance().createRaceDTO(race));
        }
        return racesDTO;
    }  
}
