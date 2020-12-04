/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.MyConnection;
import dto.Calamity;
import dto.Edit;
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
public class RegistrationDAO implements Serializable {
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
    
    public RegistrationDTO checkLogin(String id, String password) throws Exception {
        RegistrationDTO dto = null;
        try {
            String query = "Select ID, Fullname, Image, Description, Phone, Email, Role from Account where ID = ? AND Password = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("Fullname");
                String image = rs.getString("Image");
                String description = rs.getString("Description");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String role = rs.getString("Role");
                dto = new RegistrationDTO(id, fullname, image, description, phone, email, role);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean insertAccount(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            String query = "Insert into Account(ID, Password, Fullname, Image, Description, Phone, Email, Role) values (?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getImage());
            preStm.setString(5, dto.getDescription());
            preStm.setString(6, dto.getPhone());
            preStm.setString(7, dto.getEmail());
            preStm.setString(8, dto.getRole());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<RegistrationDTO> findActorsByLikeName(String search) throws Exception {
        List<RegistrationDTO> list = new ArrayList<>();
        String id = null;
        String fullname = null;
        String image = null;
        String description = null;
        String phone = null;
        String email = null;
        String role = "actor";
        try {
            String query = "Select ID, Fullname, Image, Description, Phone, Email, Role from Account where Fullname LIKE ? AND Role = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, "%" + search + "%");
            preStm.setString(2, role);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID");
                fullname = rs.getString("Fullname");
                image = rs.getString("Image");
                description = rs.getString("Description");
                phone = rs.getString("Phone");
                email = rs.getString("Email");
                RegistrationDTO dto = new RegistrationDTO(id, fullname, image, description, phone, email, role);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean updateActor(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            String query = "Update Account set Password = ?, Fullname = ?, Image = ?, Description = ?, Phone = ?, Email = ? Where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getImage());
            preStm.setString(4, dto.getDescription());
            preStm.setString(5, dto.getPhone());
            preStm.setString(6, dto.getEmail());
            preStm.setString(7, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteActor(String id) throws Exception {
        boolean check = false;
        try {
            String query = "Delete from Account where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public RegistrationDTO findActorById(String id) throws Exception {
        RegistrationDTO dto = null;
        try {
            String query = "Select Fullname, Image, Description, Phone, Email from Account where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("Fullname");
                String image = rs.getString("Image");
                String description = rs.getString("Description");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                dto = new RegistrationDTO(id, fullname, image, description, phone, email, "actor");
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean insertEdit(String id) throws Exception {
        boolean check = false;
        try {
            String query = "Insert into Edit(AID, Time) values(?, getDate())";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteEdit(String id, String time) throws Exception {
        boolean check = false;
        try {
            String query = "Delete from Edit where AID = ? AND Time = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            preStm.setString(2, time);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteAllEdit(String id) throws Exception {
        boolean check = false;
        try {
            String query = "Delete from Edit where AID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<Edit> findEdit(String aid) throws Exception {
        List<Edit> list = new ArrayList<>();
        try {
            String query = "Select AID,Time from Edit where AID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, aid);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("AID");
                String time = rs.getString("Time");
                Edit edit = new Edit(id, time);
                list.add(edit);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
