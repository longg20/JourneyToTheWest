/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.RegistrationDAO;
import dto.Calamity;
import dto.Edit;
import dto.Prop;
import dto.RegistrationDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Long
 */
public class RegistrationBean implements Serializable {
    String id, password, search;
    RegistrationDAO dao;
    
    public RegistrationBean() {
        dao = new RegistrationDAO();
    }
    
    public RegistrationDTO checkLogin() throws Exception {
        return dao.checkLogin(id, password);
    }

    public boolean insertAccount(RegistrationDTO dto) throws Exception {
        return dao.insertAccount(dto);
    }
    
    public List<RegistrationDTO> findActorsByLikeName() throws Exception {
        return dao.findActorsByLikeName(search);
    }
    
    public boolean updateActor(RegistrationDTO dto) throws Exception {
        return dao.updateActor(dto);
    }
    
    public boolean deleteActor() throws Exception {
        return dao.deleteActor(id);
    }
    
    public RegistrationDTO findActorById() throws Exception {
        return dao.findActorById(id);
    }
    
    public boolean insertEdit(String id) throws Exception {
        return dao.insertEdit(id);
    }
    
    public List<Edit> findEdit(String id) throws Exception {
        return dao.findEdit(id);
    }
    
    public boolean deleteEdit(String id, String date) throws Exception {
        return dao.deleteEdit(id, date);
    }
    
    public boolean deleteAllEdit(String id) throws Exception {
        return dao.deleteAllEdit(id);
    }
    
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
