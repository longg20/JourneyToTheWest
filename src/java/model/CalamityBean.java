/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CalamityDAO;
import dto.Calamity;
import dto.Prop;
import dto.RegistrationDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Long
 */
public class CalamityBean implements Serializable {
    String id, search;
    CalamityDAO dao;
    
    public CalamityBean() {
        dao = new CalamityDAO();
    }
    
    public boolean insertCalamity(Calamity calamity) throws Exception {
        return dao.insertCalamity(calamity);
    }
    
    public boolean deleteCalamity() throws Exception {
        return dao.deleteCalamity(id);
    }
    
    public List<Calamity> findCalamitiesByLikeName() throws Exception {
        return dao.findCalamitiesByLikeName(search);
    }
    
    public List<Calamity> findFinishedCalamities() throws Exception {
        return dao.findFinishedCalamities();
    }
    
    public List<Calamity> findOngoingCalamities() throws Exception {
        return dao.findOngoingCalamities();
    }
    
    public List<Calamity> findUpcomingCalamities() throws Exception {
        return dao.findUpcomingCalamities();
    }
    
    public Calamity findCalamityById() throws Exception {
        return dao.findCalamityByid(id);
    }

    public boolean updateCalamity(Calamity calamity) throws Exception {
        return dao.updateCalamity(calamity);
    }
    
    public boolean insertPropUsed(Prop prop) throws Exception {
        return dao.insertPropUsed(prop, id);
    }
    
    public boolean insertActorRole(RegistrationDTO dto) throws Exception {
        return dao.insertActorRole(dto, id);
    }
    
    public boolean checkPropUsedExist() throws Exception {
        return dao.checkPropUsedExist(id);
    }
    
    public boolean checkActorRoleExist() throws Exception {
        return dao.checkActorRoleExist(id);
    }
    
    public List<Prop> findPropsUsed() throws Exception {
        return dao.findPropsUsed(id);
    }
    
    public boolean checkPropUsedExist(String pid) throws Exception {
        return dao.checkPropUsedExist(id, pid);
    }
    
    public boolean updatePropUsed(Prop prop) throws Exception {
        return dao.updatePropUsed(prop, id);
    }
    
    public boolean deletePropUsed(String pid) throws Exception {
        return dao.deletePropUsed(id, pid);
    }
    
    public boolean deleteAllPropUsed() throws Exception {
        return dao.deleteAllPropUsed(id);
    }
    
    public boolean updateActorRole(RegistrationDTO dto) throws Exception {
        return dao.updateActorRole(dto, id);
    }
    
    public boolean deleteActorRole(String aid) throws Exception {
        return dao.deleteActorRole(id, aid);
    }
    
    public boolean deleteAllActorRole() throws Exception {
        return dao.deleteAllActorRole(id);
    }
    
    public List<RegistrationDTO> findActorRole() throws Exception {
        return dao.findActorRole(id);
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
