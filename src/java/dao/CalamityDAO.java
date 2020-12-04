/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.MyConnection;
import dto.Calamity;
import dto.Prop;
import dto.RegistrationDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Long
 */
public class CalamityDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    private void closeConnection() throws Exception {
        if (rs != null)
            rs.close();
        if (preStm != null)
            preStm.close();
        if (conn != null)
            conn.close();
    }

    public boolean insertCalamity(Calamity calamity) throws Exception {
        boolean check = false;
        try {
            String query = "Insert into Calamity(ID, Name, Description, Location, [Start Time], [End Time], [Time Shooting], [File]) values (?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, calamity.getId());
            preStm.setString(2, calamity.getName());
            preStm.setString(3, calamity.getDescription());
            preStm.setString(4, calamity.getLocation());
            preStm.setString(5, calamity.getStartTime());
            preStm.setString(6, calamity.getEndTime());
            preStm.setInt(7, calamity.getTimeShooting());
            preStm.setString(8, calamity.getFile());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }    
    
    public List<Calamity> findCalamitiesByLikeName(String search) throws Exception {
        List<Calamity> list = new ArrayList<>();
        Calamity calamity = null;
        String id = null;
        String name = null;
        String description = null;
        String location = null;
        String startTime = null;
        String endTime = null;
        int timeShooting;
        String file = null;
        try {
            String query = "Select ID, Name, Description, Location, [Start Time], [End Time], [Time Shooting], [File] from Calamity where Name LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                location = rs.getString("Location");
                startTime = rs.getString("Start Time");
                endTime = rs.getString("End Time");
                timeShooting = rs.getInt("Time Shooting");
                file = rs.getString("File");
                calamity = new Calamity(id, name, description, location, startTime, endTime, timeShooting, file);
                list.add(calamity);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean updateCalamity(Calamity calamity) throws Exception {
        boolean check = false;
        try {
            String query = "Update Calamity set Name = ?, Description = ?, Location = ?, [Start Time] = ?, [End Time] = ?, [Time Shooting] = ?, [File] = ? Where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, calamity.getName());
            preStm.setString(2, calamity.getDescription());
            preStm.setString(3, calamity.getLocation());
            preStm.setString(4, calamity.getStartTime());
            preStm.setString(5, calamity.getEndTime());
            preStm.setInt(6, calamity.getTimeShooting());
            preStm.setString(7, calamity.getFile());
            preStm.setString(8, calamity.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteCalamity(String id) throws Exception {
        boolean check = false;
        try {
            String query = "Delete from Calamity Where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<Calamity> findFinishedCalamities() throws Exception {
        List<Calamity> list = new ArrayList<>();
        Calamity calamity = null;
        String id = null;
        String name = null;
        String description = null;
        String location = null;
        String startTime = null;
        String endTime = null;
        int timeShooting;
        String file = null;
        try {
            String query = "Select ID, Name, Description, Location, [Start Time], [End Time], [Time Shooting], [File] from Calamity "
                         + "Where ([End Time] < getDate())";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                location = rs.getString("Location");
                startTime = rs.getString("Start Time");
                endTime = rs.getString("End Time");
                timeShooting = rs.getInt("Time Shooting");
                file = rs.getString("File");
                calamity = new Calamity(id, name, description, location, startTime, endTime, timeShooting, file);
                list.add(calamity);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<Calamity> findOngoingCalamities() throws Exception {
        List<Calamity> list = new ArrayList<>();
        Calamity calamity = null;
        String id = null;
        String name = null;
        String description = null;
        String location = null;
        String startTime = null;
        String endTime = null;
        int timeShooting;
        String file = null;
        try {
            String query = "Select ID, Name, Description, Location, [Start Time], [End Time], [Time Shooting], [File] from Calamity "
                         + "Where (([Start Time] < getDate()) AND ([End Time] > getDate()))";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                location = rs.getString("Location");
                startTime = rs.getString("Start Time");
                endTime = rs.getString("End Time");
                timeShooting = rs.getInt("Time Shooting");
                file = rs.getString("File");
                calamity = new Calamity(id, name, description, location, startTime, endTime, timeShooting, file);
                list.add(calamity);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<Calamity> findUpcomingCalamities() throws Exception {
        List<Calamity> list = new ArrayList<>();
        Calamity calamity = null;
        String id = null;
        String name = null;
        String description = null;
        String location = null;
        String startTime = null;
        String endTime = null;
        int timeShooting;
        String file = null;
        try {
            String query = "Select ID, Name, Description, Location, [Start Time], [End Time], [Time Shooting], [File] from Calamity "
                         + "Where ([Start Time] > getdate())";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                location = rs.getString("Location");
                startTime = rs.getString("Start Time");
                endTime = rs.getString("End Time");
                timeShooting = rs.getInt("Time Shooting");
                file = rs.getString("File");
                calamity = new Calamity(id, name, description, location, startTime, endTime, timeShooting, file);
                list.add(calamity);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean insertPropUsed(Prop prop, String cid) throws Exception {
        boolean check = false;
        try {
            String query = "Insert Into PropsUsed(CID, PID, Quantity) values (?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, cid);
            preStm.setString(2, prop.getId());
            preStm.setInt(3, prop.getQuantity());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updatePropUsed(Prop prop, String cid) throws Exception {
        boolean check = false;
        try {
            String query = "Update PropsUsed set Quantity = ? Where CID = ? AND PID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, prop.getQuantity());
            preStm.setString(2, cid);
            preStm.setString(3, prop.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public Calamity findCalamityByid(String id) throws Exception {
        Calamity calamity = null;
        try {
            String query = "Select Name, Description, Location, [Start Time], [End Time], [Time Shooting], [File] from Calamity where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String startTime = rs.getString("Start Time");
                String endTime = rs.getString("End Time");
                int timeShooting = rs.getInt("Time Shooting");
                String file = rs.getString("File");
                calamity = new Calamity(id, name, description, location, startTime, endTime, timeShooting, file);
            }
        } finally {
            closeConnection();
        }
        return calamity;
    }
    
    public boolean checkPropUsedExist(String cid, String pid) throws Exception {
        boolean check = false;
        try {
            String query = "Select Quantity From PropsUsed Where CID = ? AND PID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, cid);
            preStm.setString(2, pid);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<Prop> findPropsUsed(String id) throws Exception {
        List<Prop> list = new ArrayList<>();
        Prop prop = null;
        String pid = "";
        String name = "";
        String description = "";
        String image = "";
        int amount;
        String status = "";
        int quantity;
        try {
            String query = "Select A.PID, B.[Name], B.[Description], B.[Image], B.Amount, B.[Status] , A.[Quantity] " +
                           "From PropsUsed A, Prop B " +
                           "Where A.CID = ? AND A.PID = B.ID";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            while (rs.next()) {
                pid = rs.getString("PID");
                name= rs.getString("Name");
                description = rs.getString("Description");
                image = rs.getString("Image");
                amount = rs.getInt("Amount");
                status = rs.getString("Status");
                quantity = rs.getInt("Quantity");
                prop = new Prop(pid, name, description, image, amount, status);
                prop.setQuantity(quantity);
                list.add(prop);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean deletePropUsed(String cid, String pid) throws Exception {
        boolean check = false;
        try {
            String query = "Delete from PropsUsed Where CID = ? AND PID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, cid);
            preStm.setString(2, pid);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteAllPropUsed(String cid) throws Exception {
        boolean check = false;
        try {
            String query = "Delete from PropsUsed where CID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, cid);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<RegistrationDTO> findActorRole(String id) throws Exception {
        List<RegistrationDTO> list = new ArrayList<>();
        RegistrationDTO dto = null;
        String aid = "";
        String fullname = "";
        String description = "";
        String image = "";
        String phone = "";
        String email = "";
        String roleName = "";
        String roleDescription = "";
        int quantity;
        try {
            String query = "Select A.AID, B.[Fullname], B.[Description], B.[Image], B.Phone, B.Email , A.[Role Name], A.[Role Description] " +
                           "From [Role] A, Account B " +
                           "Where A.CID = ? AND A.AID = B.ID AND B.[Role] = 'actor'";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            while (rs.next()) {
                aid = rs.getString("AID");
                fullname= rs.getString("Fullname");
                description = rs.getString("Description");
                image = rs.getString("Image");
                phone = rs.getString("Phone");
                email = rs.getString("Email");
                roleName = rs.getString("Role Name");
                roleDescription = rs.getString("Role Description");
                dto = new RegistrationDTO(aid, fullname, image, description, phone, email, phone);
                dto.setRoleName(roleName);
                dto.setRoleDescription(roleDescription);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean deleteActorRole(String cid, String aid) throws Exception {
        boolean check = false;
        try {
            String query = "Delete from Role Where CID = ? AND AID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, cid);
            preStm.setString(2, aid);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteAllActorRole(String cid) throws Exception {
        boolean check = false;
        try {
            String query = "Delete from Role where CID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, cid);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateActorRole(RegistrationDTO dto, String cid) throws Exception {
        boolean check = false;
        try {
            String query = "Update Role set [Role Name] = ?, [Role Description] = ? Where CID = ? AND AID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, dto.getRoleName());
            preStm.setString(2, dto.getRoleDescription());
            preStm.setString(3, cid);
            preStm.setString(4, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean insertActorRole(RegistrationDTO dto, String cid) throws Exception {
        boolean check = false;
        try {
            String query = "Insert Into Role(CID, AID, [Role Name], [Role Description]) values (?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, cid);
            preStm.setString(2, dto.getId());
            preStm.setString(3, dto.getRoleName());
            preStm.setString(4, dto.getRoleDescription());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean checkActorRoleExist(String id) throws Exception {
        boolean check = false;
        try {
            String query = "Select [Role Name] from Role where AID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next())
                check = true;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean checkPropUsedExist(String id) throws Exception {
        boolean check = false;
        try {
            String query = "Select Quantity from PropsUsed where PID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next())
                check = true;
        } finally {
            closeConnection();
        }
        return check;
    }
}
