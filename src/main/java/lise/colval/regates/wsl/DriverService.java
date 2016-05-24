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
import lise.colval.regates.bll.control.AllDriversController;
import lise.colval.regates.bll.model.participant.Driver;
import lise.colval.regates.dal.Repository;
import lise.colval.regates.dal.dto.Driver_DTO;

/**
 *
 * @author vince
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/drivers")
public class DriverService {
    
    @GET
    @Path("/{id}")
    public Driver_DTO findDriverById(@PathParam("id") int id) {
        Driver driver =  new AllDriversController().findDriverById(id);
        Driver_DTO driverDTO = Repository.getInstance().createDriverDTO(driver);
        return driverDTO;
    }
    
    @GET
    public List<Driver_DTO> getAllDrivers() {
        List<Driver> drivers = new AllDriversController().getAllDrivers();
        List<Driver_DTO> driversDTO = new ArrayList<>();
        for(Driver driver : drivers) {
            driversDTO.add(Repository.getInstance().createDriverDTO(driver));
        }
        return driversDTO;
    }   
}
