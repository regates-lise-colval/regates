/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal;

import javax.inject.Singleton;
import lise.colval.regates.dal.dao.I_DAO;
import lise.colval.regates.dal.dao.SQL_DAO;

/**
 *
 * @author Vincent Laude
 */
@Singleton
public class Repository {
    
    private static I_DAO db_dao = null;
    
    public static I_DAO getInstance() {
        
        if(db_dao == null) {
            db_dao = new SQL_DAO("jdbc:derby://localhost:1527/Test", "org.apache.derby.jdbc.ClientDriver", "test", "test");
        }
        return db_dao;
    }
}
