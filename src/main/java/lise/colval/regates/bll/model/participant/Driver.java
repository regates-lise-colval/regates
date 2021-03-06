/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.model.participant;

/**
 *
 * @author Vincent Laude
 */
public class Driver {

    private int id;
    private String firstname;
    private String lastname;
    private Ship ship;
    
    public Driver() {}
    
    public Driver(int id, String firstname, String lastname, Ship ship) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ship = ship;
    }

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

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    @Override
    public String toString() {
        return "Driver: " + firstname + " " + lastname + " " + ship;
    }
}
