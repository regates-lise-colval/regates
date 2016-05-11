/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.dal.dto;

/**
 *
 * @author Vincent Laude
 */
public class ShipDTO {
    
    private int id;
    private int tag;
    private String category;
    private String mainDriver;
    
    public ShipDTO() {}

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

    public String getMainDriver() {
        return mainDriver;
    }

    public void setMainDriver(String mainDriver) {
        this.mainDriver = mainDriver;
    }
  
    @Override
    public String toString() {
        return "ShipDTO: " + tag + " " + category + " " + mainDriver;
    }
}
