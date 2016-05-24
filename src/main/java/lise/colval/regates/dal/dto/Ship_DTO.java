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
public class Ship_DTO {
    
    private int id;
    private int tag;
    private String category;
    private int mainDriverId;
    
    public Ship_DTO() {}

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

    public int getMainDriverId() {
        return mainDriverId;
    }

    public void setMainDriverId(int mainDriverId) {
        this.mainDriverId = mainDriverId;
    }
    
    @Override
    public String toString() {
        return "ShipDTO: " + tag + " " + category + " " + mainDriverId;
    }
}
