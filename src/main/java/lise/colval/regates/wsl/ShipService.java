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
import lise.colval.regates.bll.control.ProfileShipController;
import lise.colval.regates.bll.model.participant.Ship;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dto.ShipDTO;

/**
 *
 * @author Vincent Laude
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/ships")
public class ShipService {
    
    @GET
    @Path("{id}")
    public Ship getShip(@PathParam("id") int id) {
        return null;
    }
    
    @GET
    public List<ShipDTO> getAllShips() {
        List<Ship> ships = new ProfileShipController().getAllShips();
        List<ShipDTO> shipsDTO = new ArrayList<>();
        for(Ship ship : ships) {
            shipsDTO.add(Repository.getInstance().createShipDTO(ship));
        }
        return shipsDTO;
    }
}
