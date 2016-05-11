/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vincent Laude
 */
public abstract class DataBase_DAO {
    
    protected String db_url;
    protected String db_driver;
    protected String db_user;
    protected String db_password;
    
    private Connection con;
    
    public DataBase_DAO(String db_url, String driver, String db_user, String db_password) {
         this.db_url = db_url;
         this.db_driver = driver;
         this.db_user = db_user;
         this.db_password = db_password;
    }
    
    protected Connection connect() {
        con = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(db_url, db_user, db_password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    protected void closeConnection() {
        try {
            if(con != null) {
                con.close();
            }
        } catch(Exception e) {
        }
    }

    public String getDb_url() {
        return db_url;
    }

    public String getDb_driver() {
        return db_driver;
    }

    public String getDb_user() {
        return db_user;
    }

    public String getDb_password() {
        return db_password;
    }
}
