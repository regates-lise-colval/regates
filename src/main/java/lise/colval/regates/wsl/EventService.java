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
import lise.colval.regates.bll.control.AllEventsController;
import lise.colval.regates.bll.model.competition.Event;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dto.Event_DTO;

/**
 *
 * @author Vincent Laude
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/events")
public class EventService {
   
    @GET
    @Path("/{id}")
    public Event_DTO findEventById(@PathParam("id") int id) {
        Event event =  new AllEventsController().findEventById(id);
        Event_DTO eventDTO = Repository.getInstance().createEventDTO(event);
        return eventDTO;
    }
    
    @GET
    public List<Event_DTO> getAllEvents() {
        List<Event> events = new AllEventsController().getAllEvents();
        List<Event_DTO> eventsDTO = new ArrayList<>();
        for(Event event : events) {
            eventsDTO.add(Repository.getInstance().createEventDTO(event));
        }
        return eventsDTO;
    }   
}
