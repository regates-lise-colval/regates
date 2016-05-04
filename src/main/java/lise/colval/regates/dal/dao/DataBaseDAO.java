/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dao;

/**
 *
 * @author Vincent Laude
 */
public abstract class DataBaseDAO implements IDAO {
    
    protected String db_url;
    protected String db_user;
    protected String db_password;
    
    public DataBaseDAO(String db_url, String db_user, String db_password) {
         this.db_url = db_url;
         this.db_user = db_user;
         this.db_password = db_password;
    }

    public String getDb_url() {
        return db_url;
    }

    public String getDb_user() {
        return db_user;
    }

    public String getDb_password() {
        return db_password;
    }
}
