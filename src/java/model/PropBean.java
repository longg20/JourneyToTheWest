/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PropDAO;
import dao.RegistrationDAO;
import dto.Prop;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Long
 */
public class PropBean implements Serializable {
    String id, search;
    PropDAO dao;

    public PropBean() {
        dao = new PropDAO();
    }
    
    public boolean insertProp(Prop prop) throws Exception {
        return dao.insertProp(prop);
    }
    
    public List<Prop> findPropsByLikeName() throws Exception {
        return dao.findPropsByLikeName(search);
    }
      
    public Prop findPropById() throws Exception {
        return dao.findPropById(id);
    }

    public boolean updateProp(Prop prop) throws Exception {
        return dao.updateProp(prop);
    }
    
    public boolean deleteProp() throws Exception {
        return dao.deleteProp(id);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
