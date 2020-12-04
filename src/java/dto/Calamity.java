/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Long
 */
public class Calamity implements Serializable {
    String id;
    String name;
    String description;
    String location;
    String startTime;
    String endTime;
    int timeShooting;
    String file;
    
    public Calamity() {
    }

    public Calamity(String id, String name, String description, String location, String startTime, String endTime, int timesShooting, String file) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeShooting = timesShooting;
        this.file = file;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getTimeShooting() {
        return timeShooting;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setTimeShooting(int timeShooting) {
        this.timeShooting = timeShooting;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
