/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dto;

/**
 *
 * @author vince
 */
public class Driver_DTO {
    
    private int id;
    private String firstname;
    private String lastname;
    private int shipId;
    
    public Driver_DTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    @Override
    public String toString() {
        return "DriverDTO: " + id + " " + firstname + " " + lastname + " " + shipId;
    }
}
