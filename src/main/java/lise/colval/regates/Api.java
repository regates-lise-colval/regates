/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Vincent Laude
 */
@ApplicationPath("/webresources")
public class Api extends ResourceConfig {
    public Api() {
        packages("lise.colval.regates.bll;lise.colval.regates.dal;lise.colval.regates.wsl");
        register(org.glassfish.jersey.filter.LoggingFilter.class);
        property("jersey.config.beanValidation.enableOutputValidationErrorEntity.server", "true");
    }
}
