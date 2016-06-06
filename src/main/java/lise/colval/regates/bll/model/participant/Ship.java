/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.model.participant;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lise.colval.regates.dal.dto.Driver_DTO;


/**
 *
 * @author Vincent Laude
 */
@XmlRootElement
public class Ship {
    
    private int id;
    private int tag;
    private String category;
    
    private Driver_DTO mainDriver;
    //private List<Driver> alLDrivers;
    
  
    public Ship() {}
    
    public Ship(int id, int tag, String category) {
        this.id = id;
        this.tag = tag;
        this.category = category;
    }
    
    public Ship(int id, int tag, String category, Driver_DTO mainDriver) {
        this.id = id;
        this.tag = tag;
        this.category = category;
        this.mainDriver = mainDriver;
    }
    
    public Ship(int id, int tag, String category, Driver_DTO mainDriver, List<Driver> allDrivers) {
        this.id = id;
        this.tag = tag;
        this.category = category;
        this.mainDriver = mainDriver;
        //this.alLDrivers = new ArrayList<>(allDrivers);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Driver_DTO getMainDriver() {
        return mainDriver;
    }

    public void setMainDriver(Driver_DTO mainDriver) {
        this.mainDriver = mainDriver;
    }
    
    /*
    public List<Driver> getAlLDrivers() {
        return alLDrivers;
    }

    public void setAlLDrivers(List<Driver> alLDrivers) {
        this.alLDrivers = alLDrivers;
    }
    */
    
    @Override
    public String toString() {
        return "Ship: " + tag + " " + category + " " + mainDriver;
    }
  
}
