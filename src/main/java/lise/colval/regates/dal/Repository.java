/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal;

import java.util.List;
import javax.inject.Singleton;
import lise.colval.regates.bll.model.participant.Ship;
import lise.colval.regates.dal.dao.DataBaseDAO;
import lise.colval.regates.dal.dao.SQL_DAO;

/**
 *
 * @author Vincent Laude
 */
@Singleton
public class Repository {
    
    private static DataBaseDAO db_dao = null;
    
    public static DataBaseDAO getInstance() {
        
        if(db_dao == null) {
            
            db_dao = new SQL_DAO("jdbc:derby://localhost:1527/Test", "test", "test");

        }
        return db_dao;
    }
}
