/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Long
 */
public class Role implements Serializable {
    String cid, aid;
    String name;
    String description;

    public Role() {
    }

    public Role(String cid, String aid, String name, String description) {
        this.cid = cid;
        this.aid = aid;
        this.name = name;
        this.description = description;
    }

    public String getCid() {
        return cid;
    }

    public String getAid() {
        return aid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
